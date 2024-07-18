package winchester.osmium.logic.preprocess;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import winchester.osmium.logic.classification.Token;
import winchester.osmium.logic.classification.TokenType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {
    private static Lexer lexer;
    private Token[] tokens;
    private final Token[] tokensToCompare = new Token[] {
            new Token(TokenType.SYMBOL, "X"),
            new Token(TokenType.COLON, ":"),
            new Token(TokenType.EQUALS, "="),
            new Token(TokenType.NUMBER, "4"),
            new Token(TokenType.SYMBOL, "Position"),
            new Token(TokenType.OPEN_PAREN, "("),
            new Token(TokenType.NUMBER, "0"),
            new Token(TokenType.COMMA, ","),
            new Token(TokenType.NUMBER, "0"),
            new Token(TokenType.CLOSE_PAREN, ")"),
            new Token(TokenType.SEMICOLON, ";"),
            new Token(TokenType.SYMBOL, "Move"),
            new Token(TokenType.OPEN_PAREN, "("),
            new Token(TokenType.NUMBER, "34"),
            new Token(TokenType.COMMA, ","),
            new Token(TokenType.NUMBER, "433"),
            new Token(TokenType.CLOSE_PAREN, ")"),
            new Token(TokenType.SEMICOLON, ";"),
            new Token(TokenType.SYMBOL, "Move"),
            new Token(TokenType.OPEN_PAREN, "("),
            new Token(TokenType.NUMBER, "-5"),
            new Token(TokenType.COMMA, ","),
            new Token(TokenType.NUMBER, "2"),
            new Token(TokenType.CLOSE_PAREN, ")"),
            new Token(TokenType.SEMICOLON, ";"),
    };

    @BeforeAll
    static void beforeEachTest() {
        lexer = new Lexer(
                """
                X := 4;
                
                Position(0, 0);
                Move(34, 433);
                Move(-5, 2);
                """
        );
    }

    @Test
    void testAfterTokenization() {
        try { lexer.convertToTokens(); }
        catch (Exception exception) { fail(); }
        this.tokens = lexer.getTokens();
        assertNotNull(this.tokens);
    }

    @Test
    void testIndividualTokens() {
        assertArrayEquals(tokensToCompare, tokens);
    }

}