package winchester.osmium.logic.classification;

public class Token {
    private TokenType type;
    private final String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getTokenType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setTokenType(TokenType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
            "Token [%s : %s]", this.type, this.value
        );
    }

}
