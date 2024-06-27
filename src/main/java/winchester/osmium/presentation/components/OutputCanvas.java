package winchester.osmium.presentation.components;

import winchester.osmium.logic.Parser;
import winchester.osmium.logic.Statement;
import winchester.osmium.logic.Token;
import winchester.osmium.logic.Tokeniser;

import javax.swing.*;
import java.awt.*;

public class OutputCanvas extends JPanel {
    private final String code;

    public OutputCanvas(String code) {
        this.code = code;

        this.runLexericalAnalysis();
    }

    public void runLexericalAnalysis() {
        Tokeniser tokeniser = new Tokeniser();
        Token[] tokens =  tokeniser.convertToTokensList(code);

        Parser parser = new Parser();
        Statement[] statements = parser.separateStatements(tokens);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
