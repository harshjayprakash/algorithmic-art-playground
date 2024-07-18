package winchester.osmium.test;

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

}
