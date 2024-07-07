package winchester.osmium.logic.classification;

public enum StatementType {
    UNCLASSIFIED("Unclassified", new TokenType[0]),
    VARIABLE_ASSIGNMENT("Variable Assignment", new TokenType[]{
            TokenType.SYMBOL, TokenType.COLON, TokenType.EQUALS, TokenType.NUMBER, TokenType.SEMICOLON
    }),
    FUNCTION_CALL("Function Call", new TokenType[]{
            TokenType.SYMBOL, TokenType.OPEN_PAREN, TokenType.CLOSE_PAREN, TokenType.SEMICOLON
    });

    private final TokenType[] tokenTypesList;
    private final String asString;

    StatementType(String asString, TokenType[] tokenTypesList) {
        this.asString = asString;
        this.tokenTypesList = tokenTypesList;
    }

    public TokenType[] getTokenTypesList() {
        return tokenTypesList;
    }

    @Override
    public String toString() {
        return this.asString;
    }
}
