package winchester.osmium.core;

public class Metadata {

    public static Metadata getInstance() {
        if (instance == null) {
            instance = new Metadata();
        }
        return instance;
    }

    private static Metadata instance;

    private Metadata() { }
}
