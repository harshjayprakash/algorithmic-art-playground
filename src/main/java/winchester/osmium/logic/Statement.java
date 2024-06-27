package winchester.osmium.logic;

public class Statement {
    private final Token[] tokens;
    private final StatementType type;

    public Statement(Token[] tokens, StatementType type) {
        this.tokens = tokens;
        this.type = type;
    }

    public Token[] getTokens() {
        return this.tokens;
    }

    public StatementType getType() {
        return this.type;
    }
}
