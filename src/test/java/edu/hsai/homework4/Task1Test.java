package edu.hsai.homework4;

import edu.hsai.homework3.ExpectedData;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("First task using Steps")
class Task1Test extends DriverSetup {
    @Test
    @Story("Testing the Home Page")
    public void testTask1() {
        // 2. Assert browser title
        assertion.assertHomePageTitle(ExpectedData.SITE_TITLE);

        // 4. Assert Username is loggined
        assertion.assertUsernameIsLoggined(ExpectedData.LOGGED_USER_NAME);

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        assertion.assertHeaderSectionItemsProperties(ExpectedData.HEADER_SECTION_ITEMS_NAMES.size(),
                ExpectedData.HEADER_SECTION_ITEMS_NAMES);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        assertion.assertIndexPageImages(ExpectedData.BENEFIT_IMAGES_COUNT);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        assertion.assertIndexPageTexts(ExpectedData.BENEFIT_ICON_TEXT_STRINGS.size(), ExpectedData.BENEFIT_ICON_TEXT_STRINGS);

        // 8. Assert that there is the iframe with “Frame Button” exist
        assertion.assertFrameExistence();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertion.assertFrameButtonExistence();

        // 10. Switch to original window back
        action.switchToOriginalWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        assertion.assertLeftSectionProperties(ExpectedData.LEFT_SECTION_ITEM_NAMES.size(),
                ExpectedData.LEFT_SECTION_ITEM_NAMES);
    }
}