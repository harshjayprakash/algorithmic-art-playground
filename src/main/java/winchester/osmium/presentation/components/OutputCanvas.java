package winchester.osmium.presentation.components;

import javax.swing.*;

import winchester.osmium.logic.Interpreter;

import java.awt.*;

public class OutputCanvas extends JPanel {
    private final Interpreter interpreter;
    private boolean errorOccurred;

    public OutputCanvas(String code) {
        this.errorOccurred = false;
        this.interpreter = new Interpreter(code);
        this.interpreter.runLexer();
        this.interpreter.runParser();
    }

    public boolean errorOccurred() {
        return this.errorOccurred;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            this.interpreter.execute(g);
        }
        catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Failure to create art: " + exception.getMessage());
            this.errorOccurred = true;
        }
    }
}
