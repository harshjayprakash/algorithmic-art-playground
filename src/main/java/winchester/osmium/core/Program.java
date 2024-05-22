package winchester.osmium.core;

public abstract class Program {
    private static boolean initialised = false;

    public static boolean isInitialised() {
        return initialised;
    }
}
