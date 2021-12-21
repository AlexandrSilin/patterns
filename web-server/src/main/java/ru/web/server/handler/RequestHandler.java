package ru.web.server.handler;

import ru.web.server.config.Config;
import ru.web.server.domain.HttpRequest;
import ru.web.server.handler.methodHandlers.MethodHandlerFactory;
import ru.web.server.service.RequestParser;
import ru.web.server.service.ResponseSerializer;
import ru.web.server.service.SocketService;

public class RequestHandler implements Runnable {
    private final SocketService socketService;
    private final RequestParser parser;
    private final ResponseSerializer serializer;
    private final Config config;

    public RequestHandler(SocketService socketService, RequestParser parser,
                          ResponseSerializer serializer, Config config) {
        this.socketService = socketService;
        this.parser = parser;
        this.serializer = serializer;
        this.config = config;
    }

    @Override
    public void run() {
        try {
            HttpRequest httpRequest = parser.parseRequest(socketService.readRequest());
            MethodHandlerFactory.create(socketService, serializer, config).handle(httpRequest);
            socketService.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Client disconnected!");
    }
}
