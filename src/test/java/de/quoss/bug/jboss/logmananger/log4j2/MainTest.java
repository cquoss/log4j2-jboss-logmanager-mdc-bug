package de.quoss.bug.jboss.logmananger.log4j2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testRun() {
        new Main().run();
        Assertions.assertTrue(true);
    }

}
