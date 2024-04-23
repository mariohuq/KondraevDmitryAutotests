package edu.hsai.homework3;

import edu.hsai.homework3.pages.DifferentElementsPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Task2Test extends DriverSetup {
    @Test
    public void testBrowserTitle() {
        // 2. Assert browser title
        assertEquals(homePage.getTitle(), ExpectedData.SITE_TITLE);
    }

    @Test
    public void testLogin() {
        // 4. Assert Username is loggined
        assertEquals(homePage.getLoggedName(), ExpectedData.LOGGED_USER_NAME);
    }

    @Test
    public void testElements() {
        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage page = homePage.navigateDifferentElements();

        // 6. Select checkboxes
        page.selectCheckboxes(List.of("Water", "Wind"));

        // 7. Select radio
        page.selectRadio("Selen");

        // 8. Select in dropdown
        page.selectDropdownOption("Yellow");

        // 9. Assert logs
        assertEquals(page.getLogs(), ExpectedData.DIFFERENT_ELEMENTS_LOGS);
    }
}