package winchester.osmium.logic.classification;

import java.util.ArrayList;

public class Statement {
    private final ArrayList<Token> tokens;
    private StatementType type;

    public Statement() {
        this.tokens = new ArrayList<>();
        this.type = StatementType.UNCLASSIFIED;
    }

    public Token[] getTokens() {
        return tokens.toArray(new Token[0]);
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public void setStatementType(StatementType type) {
        this.type = type;
    }

    public StatementType getStatementType() {
        return this.type;
    }

    public boolean matchTokenStructure(TokenType[] compareTokens) {
        if (compareTokens.length != tokens.size()) { return false; }
        for (int index = 0; index < tokens.size(); index++) {
            if (compareTokens[index] != tokens.get(index).getTokenType()) {
                return false;
            }
        }
        return true;
    }

    public boolean matchFunctionalTokenStructure() {
        if (tokens.size() < 4) { return false; }
        try {
            if (tokens.get(0).getTokenType() == TokenType.SYMBOL
                    && tokens.get(1).getTokenType() == TokenType.OPEN_PAREN
                    && tokens.get(tokens.size() - 1).getTokenType() == TokenType.SEMICOLON
                    && tokens.get(tokens.size() - 2).getTokenType() == TokenType.CLOSE_PAREN) {
                this.setStatementType(StatementType.FUNCTION_CALL);
                return true;
            }
        }
        catch (Exception exception) {
            System.err.println("Failure to match functional structure");
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Statement Type : %s ", this.type.toString()));
        sb.append("[ \n");
        for (Token token : tokens) {
            sb.append(token.toString()).append("\n");
        }
        sb.append("]\n");

        return sb.toString();
    }
}
