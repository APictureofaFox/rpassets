package rpassets.ui.view;

import rpassets.ui.Config;

import java.io.IOException;
import java.util.Properties;

public enum JsonPathsConfig implements Config {
    INSTANCE("paths.properties");

    private final Properties config;

    JsonPathsConfig(String path) {
        config = new Properties();
        try {
            config.load(this.getClass().getResourceAsStream(path));
        } catch (IOException | NullPointerException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public String get(Config.Key key){
        return config.getProperty(key.toString());
    }

    @Override
    public String get(Config.Key key, String defaultValue) {
        return config.getProperty(key.toString(), defaultValue);
    }

    public enum Key implements Config.Key {
        NUMENERA_ARTIFACT("numenera_artifact"),
        NUMENERA_CREATURE("numenera_creature"),
        NUMENERA_CYPHER("numenera_cypher"),
        NUMENERA_ODDITY("numenera_oddity");
        private final String name;

        Key(String name) { this.name = name; }
        @Override
        public String toString() { return name; }
    }
}
