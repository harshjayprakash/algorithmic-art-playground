package winchester.osmium.logic;

import java.util.ArrayList;

public class Parser {

    public Parser() { }

    public Statement[] separateStatements(Token[] tokens) {
        ArrayList<Token> tokens_ = new ArrayList<>();
        ArrayList<Statement> statements = new ArrayList<>();

        for (Token token : tokens) {

            tokens_.add(new Token(token));

            if (token.getType() == TokenType.SEMI_COLON) {
                statements.add(new Statement(tokens_.toArray(new Token[0]), StatementType.UNCLASSIFIED));
            }
        }

        return statements.toArray(new Statement[0]);
    }

}
