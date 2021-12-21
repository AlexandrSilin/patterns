package ru.web.server.domain;

public enum ResponseCode {
    OK(200, "OK"),
    BAD_REQUEST(400, "BAD REQUEST"),
    NOT_FOUND(404, "NOT FOUND"),
    METHOD_NOT_ALLOWED(405, "METHOD NOT ALLOWED"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL SERVER ERROR");

    final int status;

    final String name;

    ResponseCode(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }
}
