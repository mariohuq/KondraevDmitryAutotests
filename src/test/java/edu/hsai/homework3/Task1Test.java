package edu.hsai.homework3;

import edu.hsai.homework3.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task1Test extends DriverSetup {
    @Test
    public void testTask1() {
        SoftAssert soft = new SoftAssert();

        // 2. Assert browser title
        soft.assertEquals(homePage.getTitle(), ExpectedData.SITE_TITLE);

        // 4. Assert Username is logged in
        soft.assertEquals(homePage.getLoggedName(), ExpectedData.LOGGED_USER_NAME);

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        soft.assertEquals(homePage.headerSection.items.size(), ExpectedData.HEADER_SECTION_ITEMS_NAMES.size());
        homePage.headerSection.items.forEach(item -> soft.assertTrue(item.isDisplayed()));
        soft.assertEquals(homePage.headerSection.itemNames(), ExpectedData.HEADER_SECTION_ITEMS_NAMES);


        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        soft.assertEquals(homePage.benefitImages.size(), ExpectedData.BENEFIT_IMAGES_COUNT);
        homePage.benefitImages.forEach(image -> soft.assertTrue(image.isDisplayed()));

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        soft.assertEquals(homePage.benefitIconTexts.size(), ExpectedData.BENEFIT_ICON_TEXT_STRINGS.size());
        soft.assertEquals(homePage.getBenefitIconsTextsStrings(), ExpectedData.BENEFIT_ICON_TEXT_STRINGS);

        // 8. Assert that there is the iframe with “Frame Button” exist
        soft.assertTrue(homePage.frame.isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        HomePage.IFrame frame = homePage.switchToFrame();
        soft.assertTrue(frame.frameButton.isDisplayed());

        // 10. Switch to original window back
        homePage.switchTo();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        soft.assertEquals(homePage.leftSection.items.size(), ExpectedData.LEFT_SECTION_ITEM_NAMES.size());
        homePage.leftSection.items.forEach(item -> soft.assertTrue(item.isDisplayed()));
        soft.assertEquals(homePage.leftSection.getItemNames(), ExpectedData.LEFT_SECTION_ITEM_NAMES);

        soft.assertAll();
    }
}