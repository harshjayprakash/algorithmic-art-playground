package winchester.osmium.logic.env;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RuntimeEnvironmentTest {
    private static RuntimeEnvironment env;

    @BeforeAll
    static void beforeAllTest() {
        env = new RuntimeEnvironment();
    }

    @Test
    void testAddVariable() {
        env.addOrUpdateVariable("I", 3);
        Optional<Integer> optionalValue = env.getVariableValue("I");
        if (optionalValue.isEmpty()) { fail(); }
        assertEquals(3, optionalValue.get());
    }

    @Test
    void testUpdateVariable() {
        env.addOrUpdateVariable("I", 5);
        env.addOrUpdateVariable("I", 7);
        Optional<Integer> optionalValue = env.getVariableValue("I");
        if (optionalValue.isEmpty()) { fail(); }
        assertEquals(7, optionalValue.get());
    }

    @Test
    void testVariableAccessorUndefined() {
        Optional<Integer> optionalValue = env.getVariableValue("K");
        assertTrue(optionalValue.isEmpty());
    }


}