package winchester.osmium.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetadataTest {
    private Metadata instance;

    @BeforeEach
    void beforeTestingEach() {
        instance = Metadata.getInstance();
    }

    @Test
    void testInstance() {
        Assertions.assertInstanceOf(Metadata.class, instance);
    }

    @Test
    void testAppTitle() {
        instance.setAppTitle("Generative Art Playground");
        assertEquals("Generative Art Playground", instance.getAppTitle());
    }

    @Test
    void testAppVersion() {
        instance.setAppVersion("1.0");
        assertEquals("1.0", instance.getAppVersion());
    }

    @Test
    void testThemeToggle() {
        assertFalse(instance.appInDarkTheme());
        instance.toggleDarkTheme();
        assertTrue(instance.appInDarkTheme());
    }

}