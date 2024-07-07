package winchester.osmium.logic.preprocess;

import winchester.osmium.logic.classification.Statement;
import winchester.osmium.logic.classification.StatementType;
import winchester.osmium.logic.classification.Token;
import winchester.osmium.logic.classification.TokenType;

import java.util.ArrayList;

public class Parser {
    private final Token[] tokens;
    private final ArrayList<Statement> statements;

    public Parser(Token[] tokens) {
        this.tokens = tokens;
        this.statements = new ArrayList<>();
    }

    public void tokensToStatements() {
        Statement statement = new Statement();
        for (Token token : tokens) {

            statement.addToken(token);

            if (token.getTokenType() == TokenType.SEMICOLON
                    || token.getTokenType() == TokenType.DO
                    || token.getTokenType() == TokenType.THEN
                    || token.getTokenType() == TokenType.BEGIN) {
                statements.add(statement);
                statement = new Statement();
            }
        }
    }

    public void classifyStatements() {
        for (Statement statement : statements) {
            for (StatementType statementType : StatementType.values()) {
                if (statement.matchTokenStructure(statementType.getTokenTypesList())) {
                    statement.setStatementType(statementType);
                }
            }
        }
    }

    public Statement[] getParsedStatements() {
        return this.statements.toArray(new Statement[0]);
    }

}
