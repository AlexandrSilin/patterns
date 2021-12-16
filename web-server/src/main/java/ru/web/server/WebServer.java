package ru.web.server;

import ru.web.server.config.Config;
import ru.web.server.config.ConfigFactory;
import ru.web.server.service.RequestParserFactory;
import ru.web.server.service.SocketServiceFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        Config config = ConfigFactory.createConfig(args);
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");
                new Thread(new RequestHandler(SocketServiceFactory.createSocketService(socket),
                        RequestParserFactory.createRequestParser(), config)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
