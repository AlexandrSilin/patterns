package ru.web.server.domain;

import java.util.Map;

public class HttpResponse {
    private String message;
    private int code;
    private Map<String, String> headers;
    private String body;

    private HttpResponse() {

    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        StringBuilder rawHeaders = new StringBuilder();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            rawHeaders.append(entry.getKey()).append(": ").append(entry.getValue());
        }
        return "HTTP/1.1 " + code + " " + message + "\n" + rawHeaders + (body == null ? "" : body);
    }

    public static class HttpResponseBuilder {
        HttpResponse response = new HttpResponse();

        public HttpResponseBuilder withMessage(String message) {
            response.message = message;
            return this;
        }

        public HttpResponseBuilder withCode(int code) {
            response.code = code;
            return this;
        }

        public HttpResponseBuilder withHeaders(Map<String, String> headers) {
            response.headers = headers;
            return this;
        }

        public HttpResponseBuilder withBody(String body) {
            response.body = body;
            return this;
        }

        public HttpResponse build() {
            if (response.headers == null) {
                throw new IllegalStateException();
            }
            return response;
        }
    }
}
