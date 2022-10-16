package AllureReports;

import org.junit.jupiter.api.Test;

public class WebStepTest {
    public static final String REPOSITORY = "luminorena/Automation_JAVA_hw";
    public static final String CHECKEDTABNAME = "Issues";

    @Test
    public void webStepTest() {
        SteppedTest steppedTest = new SteppedTest();
        steppedTest.openMainPage()
                .findRepository(REPOSITORY)
                .goToRepository(REPOSITORY)
                .checkRepoName(CHECKEDTABNAME);
    }

}
