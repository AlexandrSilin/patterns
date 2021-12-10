package ru.web.server;

import ru.web.server.domain.HttpRequest;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RequestHandler implements Runnable {
    private final SocketService socketService;
    private final RequestParser parser;
    private Path path;

    public RequestHandler(SocketService socketService, RequestParser parser) {
        this.socketService = socketService;
        this.parser = parser;
    }

    private void sendResponse(int code, String message) {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 ").append(code).append(" ").append(message).append("\n");
        response.append("Content-Type: text/html; charset=utf-8\n\n");
        switch (code) {
            case 404:
                response.append("<h1>Файл не найден!</h1>");
                break;
            case 400:
                response.append("<h1>BAD REQUEST</h1>");
                break;
            case 200:
                try {
                    Files.readAllLines(path).forEach(response::append);
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
                break;
        }
        socketService.writeResponse(response.toString());
    }

    private void deleteFile() throws IOException {
        if (!Files.exists(path)) {
            sendResponse(404, "NOT_FOUND");
            return;
        }
        Files.delete(path);
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 ").append(200).append(" ").append("OK").append("\n");
        response.append("Content-Type: text/html; charset=utf-8\n\n");
        response.append("<h1>Файл удален</h1>");
        socketService.writeResponse(response.toString());
    }

    private void createFile(HttpRequest httpRequest, boolean append) throws IOException {
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
            path = Paths.get(Config.WWW, httpRequest.getUrl());
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
