package ru.web.server.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigFromFile implements Config {
    private final String path;
    private final int port;

    public ConfigFromFile(String filename) {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream(filename));
            path = properties.getProperty("base.path");
            port = Integer.parseInt(properties.getProperty("server.port"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
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
