package winchester.osmium.logic.classification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatementTest {
    private Statement statement;

    @BeforeEach
    void beforeTestingEach() {
        this.statement = new Statement();
    }

    @Test
    void testAddToken() {
        Token tokenToAdd = new Token(TokenType.SYMBOL, "X");
        this.statement.addToken(tokenToAdd);
        assertEquals(tokenToAdd, this.statement.getTokens()[0]);
    }

    @Test
    void testStatementTypeAssignment() {
        this.statement.setStatementType(StatementType.VARIABLE_ASSIGNMENT);
        assertEquals(StatementType.VARIABLE_ASSIGNMENT, this.statement.getStatementType());
    }

    @Test
    void testTokenStructureVariableAssignment() {
        this.statement.addToken(new Token(TokenType.SYMBOL, "Y"));
        this.statement.addToken(new Token(TokenType.COLON, ":"));
        this.statement.addToken(new Token(TokenType.EQUALS, "="));
        this.statement.addToken(new Token(TokenType.NUMBER, "54"));
        this.statement.addToken(new Token(TokenType.SEMICOLON, ";"));
        assertTrue(this.statement.matchTokenStructure(StatementType.VARIABLE_ASSIGNMENT.getTokenTypesList()));
    }

    @Test
    void testTokenStructureBeginClause() {
        this.statement.addToken(new Token(TokenType.BEGIN, "Begin"));
        assertTrue(this.statement.matchTokenStructure(StatementType.BEGIN_CLAUSE.getTokenTypesList()));
    }

    @Test
    void testTokenStructureEndClause() {
        this.statement.addToken(new Token(TokenType.END, "End"));
        this.statement.addToken(new Token(TokenType.SEMICOLON, ";"));
        assertTrue(this.statement.matchTokenStructure(StatementType.END_CLAUSE.getTokenTypesList()));
    }

    @Test
    void testTokenStructureIteration() {
        this.statement.addToken(new Token(TokenType.FOR, "for"));
        this.statement.addToken(new Token(TokenType.SYMBOL, "I"));
        this.statement.addToken(new Token(TokenType.COLON, ":"));
        this.statement.addToken(new Token(TokenType.EQUALS, "="));
        this.statement.addToken(new Token(TokenType.NUMBER, "1"));
        this.statement.addToken(new Token(TokenType.TO, "to"));
        this.statement.addToken(new Token(TokenType.NUMBER, "5"));
        this.statement.addToken(new Token(TokenType.DO, "do"));
        assertTrue(this.statement.matchTokenStructure(StatementType.FOR_LOOP_ITERATE_UP.getTokenTypesList()));
    }

    @Test
    void testTokenStructureIfStatement() {
        this.statement.addToken(new Token(TokenType.IF, "if"));
        this.statement.addToken(new Token(TokenType.SYMBOL, "I"));
        this.statement.addToken(new Token(TokenType.EQUALS, "="));
        this.statement.addToken(new Token(TokenType.NUMBER, "4"));
        this.statement.addToken(new Token(TokenType.THEN, "then"));
        assertTrue(this.statement.matchTokenStructure(StatementType.IF_EQUALS.getTokenTypesList()));
    }

    @Test
    void testFunctionalTokenStructure() {
        this.statement.addToken(new Token(TokenType.SYMBOL ,"Move"));
        this.statement.addToken(new Token(TokenType.OPEN_PAREN, "("));
        this.statement.addToken(new Token(TokenType.NUMBER, "12"));
        this.statement.addToken(new Token(TokenType.COMMA, ","));
        this.statement.addToken(new Token(TokenType.NUMBER, "42"));
        this.statement.addToken(new Token(TokenType.CLOSE_PAREN, ")"));
        this.statement.addToken(new Token(TokenType.SEMICOLON, ";"));

        assertTrue(this.statement.matchFunctionalTokenStructure());
    }

    @Test
    void testFunctionalTokenStructureWithNoArguments() {
        this.statement.addToken(new Token(TokenType.SYMBOL ,"fn"));
        this.statement.addToken(new Token(TokenType.OPEN_PAREN, "("));
        this.statement.addToken(new Token(TokenType.CLOSE_PAREN, ")"));
        this.statement.addToken(new Token(TokenType.SEMICOLON, ";"));

        assertTrue(this.statement.matchFunctionalTokenStructure());
    }

    @Test
    void testFunctionalTokenStructureWithOneArgument() {
        this.statement.addToken(new Token(TokenType.SYMBOL ,"CompassClock"));
        this.statement.addToken(new Token(TokenType.OPEN_PAREN, "("));
        this.statement.addToken(new Token(TokenType.NUMBER, "12"));
        this.statement.addToken(new Token(TokenType.CLOSE_PAREN, ")"));
        this.statement.addToken(new Token(TokenType.SEMICOLON, ";"));

        assertTrue(this.statement.matchFunctionalTokenStructure());
    }

}