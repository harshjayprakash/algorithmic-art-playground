package winchester.osmium.presentation.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class OutputCanvas extends JPanel {
    private final String code;

    public OutputCanvas(String code) {
        this.code = code;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
