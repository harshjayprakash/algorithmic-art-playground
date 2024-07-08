package winchester.osmium.presentation.windows;

import winchester.osmium.presentation.events.EditorMenuBarHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class FontChangerFrame extends JFrame {
    private FlowLayout flowLayout;
    private JLabel changeFontLabel;
    private JTextField newFontTextField;
    private JButton acceptButton;
    private final String currentFontFamily;

    public FontChangerFrame(String currentFontFamily) {
        super();
        this.setSize(400, 75);
        this.setTitle("Change Font");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.currentFontFamily = currentFontFamily;

        this.initialiseComponents();
        this.initialiseHandlers();
    }

    private void initialiseComponents() {
        this.flowLayout = new FlowLayout();
        this.setLayout(flowLayout);

        this.changeFontLabel = new JLabel();
        this.changeFontLabel.setText("Enter font to use: ");

        this.newFontTextField = new JTextField();
        this.newFontTextField.setText(this.currentFontFamily);
        this.acceptButton = new JButton();
        this.acceptButton.setText("Accept");

        this.add(this.changeFontLabel);
        this.add(this.newFontTextField);
        this.add(this.acceptButton);
    }

    private void initialiseHandlers() {
        this.acceptButton.addActionListener((e) -> {
            this.dispose();
        });
    }

    public String getFontFamily() {
        return this.newFontTextField.getText();
    }

}
