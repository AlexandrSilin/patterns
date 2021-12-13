package ru.web.server.config;

public class ConfigFactory {
    private ConfigFactory() {
    }

    public static Config createConfig(String[] args) {
        if (args.length == 2) {
            return new ConfigFromCli(args);
        } else {
            return new ConfigFromFile("./../../../../server.properties");
        }
    }
}
