package edu.hsai.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class Task1Test extends DriverSetup {

    @Test
    public void testTask1() {
        final SoftAssert soft = new SoftAssert();

        // 2. Assert browser title
        soft.assertEquals(driver.getTitle(), "Home Page");

        // 4. Assert Username is logged in
        soft.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        var headerItems = driver.findElements(By.cssSelector("nav ul.nav > li"));
        final String[] EXPECTED_HEADER_TEXTS = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        soft.assertEquals(headerItems.size(), EXPECTED_HEADER_TEXTS.length);
        headerItems.stream().map(WebElement::isDisplayed).forEach(soft::assertTrue);
        soft.assertEquals(headerItems.stream().map(WebElement::getText).toArray(), EXPECTED_HEADER_TEXTS);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        var benefitImages = driver.findElements(By.className("benefit-icon"));
        final int EXPECTED_BENEFIT_IMAGES_COUNT = 4;
        soft.assertEquals(benefitImages.size(), EXPECTED_BENEFIT_IMAGES_COUNT);
        benefitImages.stream().map(WebElement::isDisplayed).forEach(soft::assertTrue);

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        var benefitTexts = driver.findElements(By.className("benefit-txt"));

        final String[] EXPECTED_BENEFIT_TEXTS = {
                """
                To include good practices
                and ideas from successful
                EPAM project""",
                """
                To be flexible and
                customizable""",
                "To be multiplatform",
                """
                Already have good base
                (about 20 internal and
                some external projects),
                wish to get more…"""};
        soft.assertEquals(benefitTexts.size(), EXPECTED_BENEFIT_TEXTS.length);
        benefitTexts.stream().map(WebElement::isDisplayed).forEach(soft::assertTrue);
        soft.assertEquals(benefitTexts.stream().map(WebElement::getText).toArray(), EXPECTED_BENEFIT_TEXTS);

        // 8. Assert that there is the iframe with “Frame Button” exist
        var frame = driver.findElement(By.id("frame"));
        soft.assertEquals(frame.getAttribute("src"), "https://jdi-testing.github.io/jdi-light/frame-button.html");

        // 9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(frame);
        assertEquals(driver.findElement(By.id("frame-button")).getAttribute("value"), "Frame Button");

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        var leftSectionItems = driver.findElements(By.cssSelector("ul.sidebar-menu.left > li"));
        final String[] EXPECTED_LEFT_MENU_TEXTS = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        soft.assertEquals(leftSectionItems.size(), EXPECTED_LEFT_MENU_TEXTS.length);
        leftSectionItems.stream().map(WebElement::isDisplayed).forEach(soft::assertTrue);
        soft.assertEquals(leftSectionItems.stream().map(WebElement::getText).toArray(),
                EXPECTED_LEFT_MENU_TEXTS);

        soft.assertAll();
    }
}
