package winchester.osmium.logic;

import winchester.osmium.logic.classification.Statement;
import winchester.osmium.logic.classification.Token;
import winchester.osmium.logic.classification.TokenType;
import winchester.osmium.logic.env.RuntimeEnvironment;
import winchester.osmium.logic.preprocess.Lexer;
import winchester.osmium.logic.preprocess.Parser;

import java.awt.*;
import java.util.ArrayList;

public class Interpreter {
    private final RuntimeEnvironment runtimeEnvironment;
    private final String originalInput;
    private String[] input;
    private Token[] tokens;
    private Statement[] statements;
    private Graphics output;
    private int xPos = 0;
    private int yPos = 0;
    
    public Interpreter(String inputCode) {
        this.runtimeEnvironment = new RuntimeEnvironment();
        this.originalInput = inputCode;
    }

    public void runLexer() {
        Lexer lexer = new Lexer(this.originalInput);
        try {
            lexer.convertToTokens();
        }
        catch (Exception err) {
            System.err.println(err.getMessage());
            return;
        }
        this.tokens = lexer.getTokens().clone();
    }

    public void runParser() {
        Parser parser = new Parser(this.tokens);
        parser.tokensToStatements();
        parser.classifyStatements();
        this.statements = parser.getParsedStatements().clone();
        for (Statement statement : statements) {
            System.out.println(statement.toString());
        }
    }

    public void execute(Graphics output) {
        this.output = output;
        for (Statement statement : statements) {
            switch (statement.getStatementType()) {
                case VARIABLE_ASSIGNMENT -> this.executeVariableAssignment(statement);
                case FUNCTION_CALL -> this.executeFunctionCall(statement);
                default -> System.err.println("Error executing.");
            }
        }
    }

    private void executeFunctionCall(Statement statement) {
        String symbolName = statement.getTokens()[0].getValue();
        ArrayList<String> args = new ArrayList<>();

        switch (symbolName) {
            case "Move", "Position" -> {
                args.add(statement.getTokens()[2].getValue());
                args.add(statement.getTokens()[4].getValue());

                if (symbolName.equalsIgnoreCase("Position")) {
                    xPos = Integer.parseInt(args.get(0));
                    yPos = Integer.parseInt(args.get(1));
                }
                else {
                    int x_ = Integer.parseInt(args.get(0)) + xPos;
                    int y_ = Integer.parseInt(args.get(1)) + yPos;

                    output.drawLine(xPos, yPos, x_, y_);
                    xPos = x_;
                    yPos = y_;
                }
            }
            case "Rect" -> {
                args.add(statement.getTokens()[2].getValue());
                args.add(statement.getTokens()[4].getValue());
                args.add(statement.getTokens()[6].getValue());
                args.add(statement.getTokens()[8].getValue());

                int x_ = Integer.parseInt(args.get(0));
                int y_ = Integer.parseInt(args.get(1));
                int width_ = Integer.parseInt(args.get(2));
                int height_ = Integer.parseInt(args.get(3));

                output.drawRect(x_, y_, width_, height_);
            }
        }
    }

    private void executeVariableAssignment(Statement statement) {
        String symbolName = "";
        String value = "";

        for (Token token : statement.getTokens()) {
            if (token.getTokenType() == TokenType.SYMBOL) {
                symbolName = token.getValue();
            }

            if (token.getTokenType() == TokenType.NUMBER) {
                value = token.getValue();
            }
        }

        try {
            runtimeEnvironment.addOrUpdateVariable(symbolName, Integer.parseInt(value));
        }
        catch (Exception exception) {
            System.err.println("Failure to convert string to integer");
        }
    }

}
