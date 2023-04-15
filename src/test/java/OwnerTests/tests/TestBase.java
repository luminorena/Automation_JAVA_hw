package OwnerTests.tests;

import OwnerTests.config.ProjectConfiguration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        ProjectConfiguration.configure();
    }

}
