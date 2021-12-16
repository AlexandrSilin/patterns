package ru.web.server.service;

import ru.web.server.domain.HttpResponse;

class ResponseSerializerImpl implements ResponseSerializer {
    @Override
    public String serialize(HttpResponse response) {
        StringBuilder rawHeaders = new StringBuilder();
        response.getHeaders().forEach((key, value) -> rawHeaders.append(key).append(": ").append(value));
        return "HTTP/1.1 " + response.getCode() + " " + response.getMessage() + "\n" + rawHeaders +
                (response.getBody() == null ? "" : response.getBody());
    }
}
