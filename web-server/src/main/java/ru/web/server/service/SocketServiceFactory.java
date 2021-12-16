package ru.web.server.service;

import java.net.Socket;

public class SocketServiceFactory {
    public static SocketServiceImpl createSocketService(Socket socket) {
        return new SocketServiceImpl(socket);
    }
}
