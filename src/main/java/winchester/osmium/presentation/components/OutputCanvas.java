package winchester.osmium.presentation.components;

import javax.swing.*;

import winchester.osmium.logic.Interpreter;

import java.awt.*;

public class OutputCanvas extends JPanel {
    private final String code;
    private final Interpreter interpreter;

    public OutputCanvas(String code) {
        this.code = code;
        this.interpreter = new Interpreter(code);
        this.interpreter.runLexer();
        this.interpreter.runParser();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
