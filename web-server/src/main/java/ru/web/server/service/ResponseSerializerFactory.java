package ru.web.server.service;

public class ResponseSerializerFactory {
    public static ResponseSerializer createResponseSerializer() {
        return new ResponseSerializerImpl();
    }
}
