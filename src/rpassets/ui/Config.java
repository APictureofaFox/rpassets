package rpassets.ui;

public interface Config {
    interface Key {}
    String get(Key key);
    String get(Key key, String defaultValue);
}
