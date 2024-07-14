package winchester.osmium.presentation.components;

import javax.swing.*;

import winchester.osmium.logic.Interpreter;

import java.awt.*;

public class OutputCanvas extends JPanel {
    private final Interpreter interpreter;

    public OutputCanvas(String code) {
        this.interpreter = new Interpreter(code);
        this.interpreter.runLexer();
        this.interpreter.runParser();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            this.interpreter.execute(g);
        }
        catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Failure to create art: " + exception.getMessage());
        }
    }
}
