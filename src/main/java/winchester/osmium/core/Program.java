package winchester.osmium.core;

import java.io.InputStream;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import winchester.osmium.presentation.windows.EditorFrame;

public abstract class Program {
    private static boolean initialised = false;

    public static void initialise() {
        if (initialised) { return; }

        Metadata.getInstance().setAppTitle("Generative Art Playground");
        Metadata.getInstance().setAppVersion("1.0");

        FlatDarkLaf.setup();
        FlatLightLaf.setup();

        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        }
        catch (Exception error) {
            System.err.println("Failed to initialise Laf: " + error.getMessage());
        }

        System.setProperty("apple.laf.useScreenMenuBar", "true");

        initialised = true;
    }

    public static boolean isInitialised() {
        return initialised;
    }

    public static void start() {
        if (!initialised) { return; }

        EditorFrame window = new EditorFrame();
        window.setVisible(true);
    }
}
