package winchester.osmium.logic.preprocess;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import winchester.osmium.logic.classification.Token;
import winchester.osmium.logic.classification.TokenType;
import winchester.osmium.test.TestingData;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {
    private static Lexer lexer;
    private static Token[] tokens;

    @BeforeAll
    static void beforeEachTest() {
        lexer = new Lexer(TestingData.getInstance().getTestCode());
    }

    @Test
    void testAfterTokenization() {
        try { lexer.convertToTokens(); }
        catch (Exception exception) { fail(); }
        tokens = lexer.getTokens();
        assertNotNull(tokens);
    }

    @Test
    void testIndividualTokens() {
        if (tokens.length != TestingData.getInstance().getTestCodeTokens().length) {
            fail();
        }

        for (int index = 0; index < tokens.length; index++) {
            assertEquals(TestingData.getInstance().getTestCodeTokens()[index].getValue(), tokens[index].getValue());
            assertEquals(TestingData.getInstance().getTestCodeTokens()[index].getTokenType(), tokens[index].getTokenType());
        }
    }

}