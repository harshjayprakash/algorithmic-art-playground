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

    private String appTitle;
    private String appVersion;
    private boolean appDarkTheme;

    public String getAppTitle() {
        return this.appTitle;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public boolean appInDarkTheme() {
        return this.appDarkTheme;
    }

    public void toggleDarkTheme() {
        this.appDarkTheme = !this.appDarkTheme;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

}
