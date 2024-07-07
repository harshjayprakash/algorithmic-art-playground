package winchester.osmium.logic;

import winchester.osmium.logic.classification.Statement;
import winchester.osmium.logic.classification.Token;
import winchester.osmium.logic.classification.TokenType;
import winchester.osmium.logic.env.RuntimeEnvironment;
import winchester.osmium.logic.preprocess.Lexer;
import winchester.osmium.logic.preprocess.Parser;

public class Interpreter {
    private final RuntimeEnvironment runtimeEnvironment;
    private final String originalInput;
    private String[] input;
    private Token[] tokens;
    private Statement[] statements;
    
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

    public void execute() {
        for (Statement statement : statements) {
            switch (statement.getStatementType()) {
                case VARIABLE_ASSIGNMENT -> this.executeVariableAssignment(statement);
                default -> System.err.println("Error executing.");
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
