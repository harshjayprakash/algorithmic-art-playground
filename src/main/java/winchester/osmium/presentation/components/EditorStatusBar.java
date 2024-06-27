package winchester.osmium.presentation.components;

import javax.swing.*;
import java.awt.*;

public class EditorStatusBar extends JPanel {
    private FlowLayout flowLayout;
    private JLabel statusLabel;

    public EditorStatusBar() {
        super();

        this.initialiseComponents();
    }

    private void initialiseComponents() {
        this.flowLayout = new FlowLayout(FlowLayout.LEFT);
        this.setLayout(flowLayout);

        this.statusLabel = new JLabel();
        this.statusLabel.setText("Started Application");

        this.add(this.statusLabel);
    }

    public JLabel getStatusLabel() {
        return this.statusLabel;
    }

}
