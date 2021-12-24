package ru.web.server.handler.methodHandlers;

import ru.web.server.config.Config;
import ru.web.server.domain.HttpRequest;
import ru.web.server.domain.HttpResponse;
import ru.web.server.domain.Method;
import ru.web.server.domain.ResponseCode;
import ru.web.server.service.ResponseSerializer;
import ru.web.server.service.SocketService;

public abstract class MethodHandler {
    protected final Method method;
    protected final MethodHandler next;
    protected final SocketService socketService;
    protected final ResponseSerializer responseSerializer;
    protected final Config config;

    MethodHandler(Method method, MethodHandler next, SocketService socketService,
                  ResponseSerializer responseSerializer, Config config) {
        this.method = method;
        this.next = next;
        this.socketService = socketService;
        this.responseSerializer = responseSerializer;
        this.config = config;
    }

    public void handle(HttpRequest request) {
        HttpResponse response;
        if (method.equals(request.getMethod())) {
            response = internalHandler(request);
        } else if (next != null) {
            next.handle(request);
            return;
        } else {
            response = HttpResponse.createBuilder()
                    .withStatus(ResponseCode.METHOD_NOT_ALLOWED)
                    .withHeader("Content-Type", "text/html; charset=utf-8")
                    .withBody("<h1>Method not allowed<h1>").build();
        }
        socketService.writeResponse(responseSerializer.serialize(response));
    }

    protected abstract HttpResponse internalHandler(HttpRequest request);
}
