package winchester.osmium.logic.classification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {
    private Token token;

    @BeforeEach
    void beforeEachTest() {
        this.token = new Token(TokenType.SYMBOL, "SYMB");
    }

    @Test
    void testAccessors() {
        assertEquals(TokenType.SYMBOL, this.token.getTokenType());
        assertEquals("SYMB", this.token.getValue());
    }

}