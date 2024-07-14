package winchester.osmium.logic;

import winchester.osmium.logic.classification.Statement;
import winchester.osmium.logic.classification.Token;
import winchester.osmium.logic.exec.Executer;
import winchester.osmium.logic.preprocess.Lexer;
import winchester.osmium.logic.preprocess.Parser;

import java.awt.*;

public class Interpreter {
    private final String originalInput;
    private Token[] tokens;
    private Statement[] statements;
    
    public Interpreter(String inputCode) {
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

    public void execute(Graphics output) throws Exception {
        Executer executer = new Executer(output);
        for (Statement statement : statements) {
            switch (statement.getStatementType()) {
                case VARIABLE_ASSIGNMENT -> executer.executeVariableAssignment(statement);
                case FUNCTION_CALL -> executer.executeFunctionCall(statement);
                default -> throw new Exception("Error Executing");
            }
        }
    }



}
