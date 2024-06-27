package winchester.osmium.logic;

public class Token {
    private final TokenType type;
    private final String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Token(Token token) {
        this.type = token.getType();
        this.value = token.getValue();
    }

    public TokenType getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

}
