package ru.web.server.service;

import ru.web.server.domain.HttpResponse;

public interface ResponseSerializer {
    String serialize(HttpResponse response);
}
