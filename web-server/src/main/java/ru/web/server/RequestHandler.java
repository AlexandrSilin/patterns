package ru.web.server;

import ru.web.server.config.Config;
import ru.web.server.domain.HttpRequest;
import ru.web.server.domain.HttpResponse;
import ru.web.server.service.RequestParser;
import ru.web.server.service.SocketService;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements Runnable {
    private final SocketService socketService;
    private final RequestParser parser;
    private final Config config;
    private Path path;

    public RequestHandler(SocketService socketService, RequestParser parser, Config config) {
        this.socketService = socketService;
        this.parser = parser;
        this.config = config;
    }

    private void sendResponse(int code, String message) {
        HttpResponse.HttpResponseBuilder responseBuilder = new HttpResponse.HttpResponseBuilder();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "text/html; charset=utf-8\n\n");
        responseBuilder.withHeaders(headers).withMessage(message);
        switch (code) {
            case 404:
                responseBuilder.withBody("<h1>Файл не найден!</h1>");
                break;
            case 400:
                responseBuilder.withBody("<h1>BAD REQUEST</h1>");
                break;
            case 200:
                try {
                    StringBuilder body = new StringBuilder();
                    Files.readAllLines(path).forEach(body::append);
                    responseBuilder.withBody(body.toString());
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
                break;
        }
        socketService.writeResponse(responseBuilder.build().toString());
    }

    private void deleteFile() throws IOException {
        if (!Files.exists(path)) {
            sendResponse(404, "NOT_FOUND");
            return;
        }
        Files.delete(path);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "text/html; charset=utf-8\n\n");
        HttpResponse.HttpResponseBuilder responseBuilder = new HttpResponse.HttpResponseBuilder();
        responseBuilder.withHeaders(headers)
                .withCode(200)
                .withMessage("OK")
                .withBody("<h1>Файл удален</h1>");
        socketService.writeResponse(responseBuilder.build().toString());
    }

    private void createFile(HttpRequest httpRequest, boolean append)
            throws IOException {
        Files.createFile(path);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path.toString(), append)));
        writer.write(httpRequest.getBody());
        sendResponse(200, "OK");
    }

    private boolean isCorrectRequest() {
        if (!Files.exists(path)) {
            sendResponse(404, "NOT_FOUND");
            return false;
        } else if (Files.isDirectory(path)) {
            sendResponse(400, "BAD_REQUEST");
            return false;
        }
        return true;
    }

    @Override
    public void run() {
        try {
            HttpRequest httpRequest = parser.parseRequest(socketService.readRequest());
            path = Paths.get(config.getPath(), httpRequest.getUrl());
            switch (httpRequest.getMethod()) {
                case GET:
                    if (isCorrectRequest()) {
                        sendResponse(200, "OK");
                    }
                    break;
                case DELETE:
                    if (isCorrectRequest()) {
                        deleteFile();
                    }
                    break;
                case UPDATE:
                case POST:
                    if (Files.exists(path)) {
                        sendResponse(400, "BAD_REQUEST");
                        return;
                    } else {
                        createFile(httpRequest, false);
                    }
                    break;
                case PUT:
                    if (!Files.exists(path)) {
                        sendResponse(400, "BAD_REQUEST");
                        return;
                    } else {
                        createFile(httpRequest, true);
                    }
                    break;
                default:
                    sendResponse(405, "METHOD_NOT_ALLOWED");
            }
            socketService.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Client disconnected!");
    }
}
