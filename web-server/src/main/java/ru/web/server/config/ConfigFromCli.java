package ru.web.server.config;

public class ConfigFromCli implements Config {
    private final String path;
    private final int port;

    public ConfigFromCli(String[] args) {
        this.path = args[0];
        this.port = Integer.parseInt(args[1]);
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public int getPort() {
        return port;
    }
}
