package ru.web.server.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private ResponseCode status;
    private Map<String, String> headers;
    private String body;

    private HttpResponse() {
        headers = new HashMap<>();
    }

    public static HttpResponseBuilder createBuilder() {
        return new HttpResponseBuilder();
    }

    public ResponseCode getStatus() {
        return status;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public static class HttpResponseBuilder {
        HttpResponse response = new HttpResponse();

        public HttpResponseBuilder withStatus(ResponseCode status) {
            response.status = status;
            return this;
        }

        public HttpResponseBuilder withHeader(String key, String value) {
            response.headers.put(key, value);
            return this;
        }

        public HttpResponseBuilder withHeaders(Map<String, String> headers) {
            response.headers.putAll(headers);
            return this;
        }

        public HttpResponseBuilder withBody(String body) {
            response.body = body;
            return this;
        }

        public HttpResponse build() {
            if (response.headers == null || response.status == null) {
                throw new IllegalStateException();
            }
            return response;
        }
    }
}
