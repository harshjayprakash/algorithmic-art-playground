package winchester.osmium.logic.exec;

import winchester.osmium.logic.classification.Statement;
import winchester.osmium.logic.classification.Token;
import winchester.osmium.logic.classification.TokenType;
import winchester.osmium.logic.env.RuntimeEnvironment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

public class Executer {
    private final Graphics outputGraphics;
    private final RuntimeEnvironment env;
    private int currentXPosition;
    private int currentYPosition;


    public Executer(Graphics graphics) {
        env = new RuntimeEnvironment();
        outputGraphics = graphics;
    }

    public void executeFunctionCall(Statement statement) {
        String symbolName = statement.getTokens()[0].getValue();

        Integer[] intArgs = detectParametersInFunctionCall(statement).clone();
        for (Integer i : intArgs) {
            System.out.println(i);
        }

        switch (symbolName.toLowerCase()) {
            case "move", "position" -> {
                if (intArgs.length != 2) {
                    JOptionPane.showMessageDialog(null, String.format(
                            "Invalid number of arguments provided in function '%s'. 2 arguments are required. Please refer to the help guide.",
                            symbolName)
                    );
                }

                if (symbolName.equalsIgnoreCase("position")) {
                    currentXPosition = intArgs[0];
                    currentYPosition = intArgs[1];
                }
                else {
                    int projectedXPosition = intArgs[0] + currentXPosition;
                    int projectedYPosition = intArgs[1] + currentYPosition;

                    outputGraphics.drawLine(currentXPosition, currentYPosition, projectedXPosition, projectedYPosition);
                    currentXPosition = projectedXPosition;
                    currentYPosition = projectedYPosition;
                }
            }
            case "rect" -> {
                if (intArgs.length != 4) {
                    JOptionPane.showMessageDialog(null, String.format(
                            "Invalid number of arguments provided in function '%s'. 4 arguments are required. Please refer to the help guide.",
                            symbolName)
                    );
                }

                int rectX = intArgs[0];
                int rectY = intArgs[1];
                int rectWidth = intArgs[2];
                int rectHeight = intArgs[3];

                outputGraphics.drawRect(rectX, rectY, rectWidth, rectHeight);
            }
        }
    }

    private Integer[] detectParametersInFunctionCall(Statement statement) {
        ArrayList<Integer> args = new ArrayList<>();
        boolean saveNegativeNumber = false;
        boolean parameterArea = false;
        for (Token token : statement.getTokens()) {
            if (token.getTokenType() == TokenType.OPEN_PAREN) {
                parameterArea = true;
                continue;
            }
            if (token.getTokenType() == TokenType.CLOSE_PAREN) {
                parameterArea = false;
                break;
            }
            if (parameterArea && token.getTokenType() != TokenType.COMMA) {
                if (token.getTokenType() == TokenType.SYMBOL) {
                    Optional<Integer> optInt = env.getVariableValue(token.getValue());
                    if (optInt.isEmpty()) { return new Integer[0]; }
                    args.add(optInt.get());
                    continue;
                }
                if (token.getTokenType() == TokenType.MINUS) {
                    saveNegativeNumber = true;
                    continue;
                }
                int numberToSave = 0;
                try {
                    numberToSave = Integer.parseInt(token.getValue());
                }
                catch (Exception exception) {
                    System.err.println("Failure to parse integer argument.");
                    return new Integer[0];
                }

                if (saveNegativeNumber) {
                    args.add(numberToSave * (-1));
                }
                else {
                    args.add(numberToSave);
                }
                saveNegativeNumber = false;
            }

        }

        return args.toArray(new Integer[0]);
    }

    public void executeVariableAssignment(Statement statement) {
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
            env.addOrUpdateVariable(symbolName, Integer.parseInt(value));
        }
        catch (Exception exception) {
            System.err.println("Failure to convert string to integer");
        }
    }


}
