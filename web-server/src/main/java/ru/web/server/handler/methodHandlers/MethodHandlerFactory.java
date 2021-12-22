package ru.web.server.handler.methodHandlers;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import ru.web.server.config.Config;
import ru.web.server.domain.Method;
import ru.web.server.service.ResponseSerializer;
import ru.web.server.service.SocketService;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class MethodHandlerFactory {
    private MethodHandlerFactory() {

    }

    public static MethodHandler create(SocketService socketService,
                                       ResponseSerializer responseSerializer, Config config) {
        Reflections reflections = new Reflections(MethodHandler.class.getPackageName(), new SubTypesScanner());
        Set<Class<? extends MethodHandler>> subClasses = new HashSet<>();
        for (String className : reflections.getStore().get(SubTypesScanner.class.getSimpleName()).values()) {
            try {
                Class<? extends MethodHandler> subType = (Class<? extends MethodHandler>) Class.forName(className);
                if (MethodHandler.class.isAssignableFrom(subType)) {
                    subClasses.add(subType);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        Class<?>[] classes = new Class[subClasses.size()];
        for (Class<? extends MethodHandler> clazz : subClasses) {
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Handler.class)) {
                    classes[((Handler) annotation).order()] = clazz;
                }
            }
        }
        try {
            Method method = Method.valueOf(classes[0].getSimpleName().split("(?=\\p{Upper})")[0].toUpperCase(Locale.ROOT));
            MethodHandler methodHandler = (MethodHandler) Class.forName(classes[0].getName()).getDeclaredConstructors()[0]
                    .newInstance(method, null, socketService, responseSerializer, config);
            for (int i = 1; i < classes.length; i++) {
                MethodHandler tmp = methodHandler;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                Field f = MethodHandler.class.getDeclaredField("next");
                f.setAccessible(true);
                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);
                method = Method.valueOf(classes[i].getSimpleName().split("(?=\\p{Upper})")[0].toUpperCase(Locale.ROOT));
                f.set(tmp, Class.forName(classes[i].getName()).getDeclaredConstructors()[0]
                        .newInstance(method, null, socketService, responseSerializer, config));
                modifiersField.setInt(f, f.getModifiers() & Modifier.FINAL);
            }
            return methodHandler;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
