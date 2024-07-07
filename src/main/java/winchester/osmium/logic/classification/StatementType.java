package winchester.osmium.logic.classification;

public enum StatementType {
    UNCLASSIFIED("Unclassified", new TokenType[0]),
    VARIABLE_ASSIGNMENT("Variable Assignment", new TokenType[]{
            TokenType.SYMBOL, TokenType.COLON, TokenType.EQUALS, TokenType.NUMBER, TokenType.SEMICOLON
    }),
    FUNCTION_CALL("Function Call", new TokenType[]{
            TokenType.SYMBOL, TokenType.OPEN_PAREN, TokenType.CLOSE_PAREN, TokenType.SEMICOLON
    }),
    BEGIN_CLAUSE("Begin Clause", new TokenType[]{
            TokenType.BEGIN
    }),
    END_CLAUSE("End Clause", new TokenType[]{
            TokenType.END, TokenType.SEMICOLON
    }),
    FOR_LOOP_ITERATE_UP("For Loop Iterate Up", new TokenType[]{
            TokenType.FOR, TokenType.SYMBOL, TokenType.COLON, TokenType.EQUALS, TokenType.NUMBER, TokenType.TO,
            TokenType.NUMBER, TokenType.DO
    }),
    FOR_LOOP_ITERATE_DOWN("For Loop Iterate Up", new TokenType[]{
            TokenType.FOR, TokenType.SYMBOL, TokenType.COLON, TokenType.EQUALS, TokenType.NUMBER, TokenType.DOWNTO,
            TokenType.NUMBER, TokenType.DO
    }),
    IF_EQUALS("If Equals", new TokenType[] {
            TokenType.IF, TokenType.SYMBOL, TokenType.EQUALS, TokenType.NUMBER, TokenType.THEN
    }),
    IF_NOT_EQUALS("If Not Equals", new TokenType[] {
            TokenType.IF, TokenType.SYMBOL, TokenType.LESS_THAN, TokenType.GREATER_THAN, TokenType.NUMBER,
            TokenType.THEN
    }),
    IF_NOT_GREATER_THAN("If Not Equals", new TokenType[] {
            TokenType.IF, TokenType.SYMBOL, TokenType.GREATER_THAN, TokenType.NUMBER, TokenType.THEN
    }),
    IF_NOT_LESS_THAN("If Not Equals", new TokenType[] {
            TokenType.IF, TokenType.SYMBOL, TokenType.LESS_THAN, TokenType.NUMBER, TokenType.THEN
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
