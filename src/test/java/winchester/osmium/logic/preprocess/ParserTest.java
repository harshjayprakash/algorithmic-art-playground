package winchester.osmium.logic.preprocess;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import winchester.osmium.logic.classification.Statement;
import winchester.osmium.test.TestingData;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private final static Parser parser = new Parser(TestingData.getInstance().getTestCodeTokens());
    private static Statement[] statements;

    @Test
    void testIndividualStatements() {
        parser.tokensToStatements();
        parser.classifyStatements();
        statements = parser.getParsedStatements().clone();
        assertNotNull(statements);
        Statement[] statementsToTest = TestingData.getInstance().getTestCodeStatements();
        if (statements.length != statementsToTest.length) {
            fail();
        }

        for (int index = 0; index < statements.length; index++) {
            assertEquals(statementsToTest[index].getStatementType(), statements[index].getStatementType());
        }
    }

}