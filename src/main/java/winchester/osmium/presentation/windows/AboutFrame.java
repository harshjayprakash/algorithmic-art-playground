package winchester.osmium.presentation.windows;

import winchester.osmium.core.Metadata;

import javax.swing.*;
import java.awt.*;

public class AboutFrame extends JFrame {
    private FlowLayout flowLayout;
    private JLabel programLabel;
    private JLabel programInformation;

    public AboutFrame() {
        super();
        this.setSize(400, 200);
        this.setTitle("About");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.initialiseComponents();
    }

    private void initialiseComponents() {
        this.flowLayout = new FlowLayout();
        this.flowLayout.setAlignment(FlowLayout.LEFT);
        this.setLayout(this.flowLayout);

        this.programLabel = new JLabel();
        this.programLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.programLabel.setText(
                        String.format("""
                        <html>
                        <h1>%s %s</h1>
                        </html>
                        """, Metadata.getInstance().getAppTitle(), Metadata.getInstance().getAppVersion()));
        this.programInformation = new JLabel();
        this.programInformation.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.programInformation.setText(
                """
                <html>
                Written in Java.<br>
                Developed with BellSoft OpenJDK 21 and JetBrains IntelliJ IDEA.<br>
                Compiled and packaged with Apache Maven.<br>
                Program written by Harsh Jayprakash in 2024 (for Capstone Project).
                </html>
                """);

        this.add(programLabel);
        this.add(programInformation);
    }

}
