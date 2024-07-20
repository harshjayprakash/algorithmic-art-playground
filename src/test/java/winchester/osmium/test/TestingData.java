package winchester.osmium.test;

import winchester.osmium.logic.classification.Statement;
import winchester.osmium.logic.classification.StatementType;
import winchester.osmium.logic.classification.Token;
import winchester.osmium.logic.classification.TokenType;

public class TestingData {
    private final static TestingData instance = new TestingData();

    private final String testCode = """
            X := 4;
            
            Position(0, 0);
            Move(X, 6);
            Move(34, 433);
            Move(-5, 2);
            """;

    private final Token[] testCodeTokens = new Token[] {
            new Token(TokenType.SYMBOL, "X"), new Token(TokenType.COLON, ":"), new Token(TokenType.EQUALS, "="),
            new Token(TokenType.NUMBER, "4"), new Token(TokenType.SEMICOLON, ";"),
            new Token(TokenType.SYMBOL, "Position"), new Token(TokenType.OPEN_PAREN, "("),
            new Token(TokenType.NUMBER, "0"), new Token(TokenType.COMMA, ","), new Token(TokenType.NUMBER, "0"),
            new Token(TokenType.CLOSE_PAREN, ")"), new Token(TokenType.SEMICOLON, ";"),
            new Token(TokenType.SYMBOL, "Move"), new Token(TokenType.OPEN_PAREN, "("), new Token(TokenType.SYMBOL, "X"),
            new Token(TokenType.COMMA, ","), new Token(TokenType.NUMBER, "6"), new Token(TokenType.CLOSE_PAREN, ")"),
            new Token(TokenType.SEMICOLON, ";"), new Token(TokenType.SYMBOL, "Move"),
            new Token(TokenType.OPEN_PAREN, "("), new Token(TokenType.NUMBER, "34"), new Token(TokenType.COMMA, ","),
            new Token(TokenType.NUMBER, "433"), new Token(TokenType.CLOSE_PAREN, ")"),
            new Token(TokenType.SEMICOLON, ";"), new Token(TokenType.SYMBOL, "Move"),
            new Token(TokenType.OPEN_PAREN, "("), new Token(TokenType.MINUS, "-"), new Token(TokenType.NUMBER, "5"),
            new Token(TokenType.COMMA, ","), new Token(TokenType.NUMBER, "2"), new Token(TokenType.CLOSE_PAREN, ")"),
            new Token(TokenType.SEMICOLON, ";"),
    };

    private final Statement[] testCodeStatements = new Statement[] {
            new Statement() {{
                addToken(new Token(TokenType.SYMBOL, "X")); addToken(new Token(TokenType.COLON, ":"));
                addToken(new Token(TokenType.EQUALS, "=")); addToken(new Token(TokenType.NUMBER, "4"));
                addToken(new Token(TokenType.SEMICOLON, ";")); setStatementType(StatementType.VARIABLE_ASSIGNMENT);
            }},
            new Statement() {{
                addToken(new Token(TokenType.SYMBOL, "Position")); addToken(new Token(TokenType.OPEN_PAREN, "("));
                addToken(new Token(TokenType.NUMBER, "0")); addToken(new Token(TokenType.COMMA, ","));
                addToken(new Token(TokenType.NUMBER, "0")); addToken(new Token(TokenType.CLOSE_PAREN, ")"));
                addToken(new Token(TokenType.SEMICOLON, ";")); setStatementType(StatementType.FUNCTION_CALL);
            }},
            new Statement() {{
                addToken(new Token(TokenType.SYMBOL, "Move")); addToken(new Token(TokenType.OPEN_PAREN, "("));
                addToken(new Token(TokenType.SYMBOL, "X")); addToken(new Token(TokenType.COMMA, ","));
                addToken(new Token(TokenType.NUMBER, "6")); addToken(new Token(TokenType.CLOSE_PAREN, ")"));
                addToken(new Token(TokenType.SEMICOLON, ";")); setStatementType(StatementType.FUNCTION_CALL);
            }},
            new Statement() {{
                addToken(new Token(TokenType.SYMBOL, "Move")); addToken(new Token(TokenType.OPEN_PAREN, "("));
                addToken(new Token(TokenType.NUMBER, "34")); addToken(new Token(TokenType.COMMA, ","));
                addToken(new Token(TokenType.NUMBER, "433")); addToken(new Token(TokenType.CLOSE_PAREN, ")"));
                addToken(new Token(TokenType.SEMICOLON, ";")); setStatementType(StatementType.FUNCTION_CALL);
            }},
            new Statement() {{
                addToken(new Token(TokenType.SYMBOL, "Move")); addToken(new Token(TokenType.OPEN_PAREN, "("));
                addToken(new Token(TokenType.MINUS, "-")); addToken(new Token(TokenType.NUMBER, "5"));
                addToken(new Token(TokenType.COMMA, ",")); addToken(new Token(TokenType.NUMBER, "2"));
                addToken(new Token(TokenType.CLOSE_PAREN, ")")); addToken(new Token(TokenType.SEMICOLON, ";"));
                setStatementType(StatementType.FUNCTION_CALL);
            }}
    };

    private TestingData() {}

    public static TestingData getInstance() {
        return instance;
    }

    public String getTestCode() {
        return this.testCode;
    }

    public Token[] getTestCodeTokens() {
        return this.testCodeTokens;
    }

    public Statement[] getTestCodeStatements() {
        return this.testCodeStatements;
    }

}
