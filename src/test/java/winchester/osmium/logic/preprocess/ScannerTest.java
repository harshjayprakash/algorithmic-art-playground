package winchester.osmium.logic.preprocess;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {
    private final static Scanner scanner = new Scanner("Test Code");

    @Test
    void testAdvanceAndGet() {
        scanner.advance();
        Optional<Character> char1 = scanner.getCharacter();
        scanner.advance();
        Optional<Character> char2 = scanner.getCharacter();

        if (char1.isEmpty() || char2.isEmpty()) {
            fail();
        }

        assertNotEquals(char1.get(), char2.get());
    }


}