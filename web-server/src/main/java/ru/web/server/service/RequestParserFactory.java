package ru.web.server.service;

public class RequestParserFactory {
    public static RequestParserImpl createRequestParser() {
        return new RequestParserImpl();
    }
}
