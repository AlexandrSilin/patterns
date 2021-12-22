package ru.web.server.domain;

import java.util.Map;

public class HttpRequest {
    private Method method;
    private String url;
    private Map<String, String> headers;
    private String body;

    private HttpRequest() {

    }

    public Method getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method.toString() + '\'' +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }

    public static class HttpRequestBuilder {
        HttpRequest request = new HttpRequest();

        public HttpRequestBuilder withMethod(String method) {
            request.method = Method.valueOf(method);
            return this;
        }

        public HttpRequestBuilder withUrl(String url) {
            request.url = url;
            return this;
        }

        public HttpRequestBuilder withHeaders(Map<String, String> headers) {
            request.headers = headers;
            return this;
        }

        public HttpRequestBuilder withBody(String body) {
            request.body = body;
            return this;
        }

        public HttpRequest build() {
            if (request.method == null || request.url == null || request.headers == null) {
                throw new IllegalStateException();
            }
            return request;
        }
    }
}
