package ru.web.server.service;

import ru.web.server.domain.HttpRequest;

import java.util.Deque;

public interface RequestParser {
    HttpRequest parseRequest(Deque<String> rawRequest);
}
