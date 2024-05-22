package winchester.osmium.core;

public abstract class Program {
    private static boolean initialised = false;

    public static void initialise() {
        if (initialised) { return; }

        Metadata.getInstance().setAppTitle("Generative Art Playground");
        Metadata.getInstance().setAppVersion("1.0");

        initialised = true;
    }

    public static boolean isInitialised() {
        return initialised;
    }

    public static void start() {
        if (!initialised) { return; }
    }
}
