package edu.hsai.homework4;

import edu.hsai.homework3.ExpectedData;
import org.testng.annotations.Test;

public class BadTest extends DriverSetup {
    @Test
    public void shouldNotWork() {
        assertion.assertHomePageTitle(ExpectedData.LOGGED_USER_NAME);
    }
}
