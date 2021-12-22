package ru.web.server.handler.methodHandlers;

import ru.web.server.config.Config;
import ru.web.server.domain.HttpRequest;
import ru.web.server.domain.HttpResponse;
import ru.web.server.domain.Method;
import ru.web.server.domain.ResponseCode;
import ru.web.server.service.ResponseSerializer;
import ru.web.server.service.SocketService;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;

@Handler(order = 2)
class PutMethodHandler extends MethodHandler {
    PutMethodHandler(Method method, MethodHandler next, SocketService socketService,
                     ResponseSerializer responseSerializer, Config config) {
        super(method, next, socketService, responseSerializer, config);
    }

    @Override
    protected HttpResponse internalHandler(HttpRequest request) {
        HttpResponse.HttpResponseBuilder response = HttpResponse.createBuilder()
                .withHeader("Content-Type", "text/html; charset=utf-8");
        Path path = Path.of(config.getPath(), request.getUrl());
        if (!Files.exists(path)) {
            return response.withStatus(ResponseCode.NOT_FOUND)
                    .withBody("<h1>File not found</h1>").build();
        } else if (Files.isDirectory(path)) {
            return response.withStatus(ResponseCode.BAD_REQUEST)
                    .withBody("<h1>Is a directory</h1>").build();
        }
        try {
            Files.createFile(path);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path.toString(), true)));
            writer.write(request.getBody());
            return response.withStatus(ResponseCode.OK)
                    .withBody("<h1>Ok</h1>").build();
        } catch (IOException e) {
            return response.withStatus(ResponseCode.INTERNAL_SERVER_ERROR)
                    .withBody("<h1>" + e.getMessage() + "</h1>").build();
        }
    }
}
