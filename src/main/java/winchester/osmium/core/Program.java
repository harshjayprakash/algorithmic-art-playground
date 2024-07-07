package winchester.osmium.core;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import winchester.osmium.presentation.windows.EditorFrame;

import javax.swing.*;

public abstract class Program {

    public static void initialise() {
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
    }

    public static void start() {
        EditorFrame window = new EditorFrame();
        window.setVisible(true);
    }
}
