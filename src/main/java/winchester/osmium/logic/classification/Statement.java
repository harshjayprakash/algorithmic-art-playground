package winchester.osmium.logic.classification;

import java.util.ArrayList;

public class Statement {
    private final ArrayList<Token> tokens = new ArrayList<>();
    private StatementType type = StatementType.UNCLASSIFIED;

    public Statement() {

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

    public boolean matchTokenStructure(TokenType[] compareTokens) {
        if (compareTokens.length != tokens.size()) { return false; }
        for (int idx = 0; idx < tokens.size(); idx++) {
            if (compareTokens[idx] != tokens.get(idx).getTokenType()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Statement Type : %s", this.type.toString()));
        sb.append("[ \n");
        for (Token token : tokens) {
            sb.append(token.toString()).append("\n");
        }
        sb.append("]\n");

        return sb.toString();
    }
}
