package winchester.osmium.logic.exec;

import winchester.osmium.logic.classification.Statement;
import winchester.osmium.logic.classification.Token;
import winchester.osmium.logic.classification.TokenType;
import winchester.osmium.logic.env.RuntimeEnvironment;

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
        ArrayList<String> args = new ArrayList<>();

        Integer[] intArgs = detectParametersInFunctionCall(statement).clone();
        for (Integer i : intArgs) {
            System.out.println(i);
        }

        switch (symbolName) {
            case "Move", "Position" -> {
                if (intArgs.length != 2) {
                    System.err.println("Invalid number of arguments provided in function");
                }

                if (symbolName.equalsIgnoreCase("Position")) {
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
            case "Rect" -> {
                args.add(statement.getTokens()[2].getValue());
                args.add(statement.getTokens()[4].getValue());
                args.add(statement.getTokens()[6].getValue());
                args.add(statement.getTokens()[8].getValue());

                int x_ = Integer.parseInt(args.get(0));
                int y_ = Integer.parseInt(args.get(1));
                int width_ = Integer.parseInt(args.get(2));
                int height_ = Integer.parseInt(args.get(3));

                outputGraphics.drawRect(x_, y_, width_, height_);
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
