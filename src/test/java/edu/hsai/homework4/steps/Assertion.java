package edu.hsai.homework4.steps;

import edu.hsai.homework3.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

import java.util.List;
import java.util.Properties;

public class Assertion extends StepsSetup {
    public Assertion(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    @Step("Asserting Home Page's title")
    public void assertHomePageTitle(String expectedTitle) {
        assertEquals(homePage.getTitle(), expectedTitle);
    }

    @Step("Asserting Username is loggined")
    public void assertUsernameIsLoggined(String expectedUserName) {
        assertEquals(homePage.getLoggedName(), expectedUserName);
    }

    @Step("Asserting Header Section items properties")
    public void assertHeaderSectionItemsProperties(int expectedItemsSize, List<String> expectedItemsNames) {
        SoftAssert soft = new SoftAssert();

        soft.assertEquals(homePage.headerSection.items.size(), expectedItemsSize);
        homePage.headerSection.items.forEach(item -> soft.assertTrue(item.isDisplayed()));
        soft.assertEquals(homePage.headerSection.itemNames(), expectedItemsNames);

        soft.assertAll();
    }

    @Step("Asserting Index Page images properties")
    public void assertIndexPageImages(int expectedImagesSize) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(homePage.benefitImages.size(), expectedImagesSize);
        homePage.benefitIconTexts.forEach(image -> softAssert.assertTrue(image.isDisplayed()));

        softAssert.assertAll();
    }

    @Step("Asserting Index Page texts properties")
    public void assertIndexPageTexts(int expectedTextsSize, List<String> expectedTextsStrings) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(homePage.benefitImages.size(), expectedTextsSize);
        softAssert.assertEquals(homePage.getBenefitIconsTextsStrings(), expectedTextsStrings);

        softAssert.assertAll();
    }

    @Step("Asserting iframe existence")
    public void assertFrameExistence() {
        assertTrue(homePage.frame.isDisplayed());
    }

    @Step("Asserting Frame Button existence")
    public void assertFrameButtonExistence() {
        HomePage.IFrame frame = homePage.switchToFrame();
        assertTrue(frame.frameButton.isDisplayed());
    }

    @Step("Asserting Left Section properties")
    public void assertLeftSectionProperties(int expectedItemsSize, List<String> expectedItemsNames) {
        SoftAssert soft = new SoftAssert();

        soft.assertEquals(homePage.leftSection.items.size(), expectedItemsSize);
        homePage.leftSection.items.forEach(item -> soft.assertTrue(item.isDisplayed()));
        soft.assertEquals(homePage.leftSection.getItemNames(), expectedItemsNames);

        soft.assertAll();
    }

    @Step("Asserting logs")
    public void assertLogs(List<String> logs) {
        assertEquals(differentElements.getLogs(), logs);
    }
}
