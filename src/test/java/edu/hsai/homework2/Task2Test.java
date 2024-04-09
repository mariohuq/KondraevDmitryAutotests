package edu.hsai.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task2Test extends DriverSetup {
    @Test
    public void testBrowserTitle() {
        // 2. Assert browser title
        assertEquals(driver.getTitle(), "Home Page");
    }

    @Test
    public void testLogin() {
        // 4. Assert Username is loggined
        assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");
    }

    @Test
    public void testElements() {
        // 5. Open through the header menu Service -> Different Elements Page
        var serviceMenu = driver.findElement(By.xpath("//ul[contains(@class, 'sidebar-menu')]/li[contains(.,'Service')]"));
        serviceMenu.click();
        serviceMenu.findElement(By.xpath(".//a[descendant::text()='Different elements']")).click();

        // 6. Select checkboxes
        final var CHECKBOXES_TO_SELECT = List.of("Water", "Wind");
        driver.findElements(By.cssSelector("label:has(input[type=checkbox])"))
                .stream()
                .filter(checkbox -> CHECKBOXES_TO_SELECT.contains(checkbox.getText()))
                .forEach(WebElement::click);

        // 7. Select radio
        final var RADIO_TO_SELECT = "Selen";
        driver.findElements(By.cssSelector("label:has(input[type=radio])"))
                .stream()
                .filter(radio -> radio.getText().equals(RADIO_TO_SELECT))
                .forEach(WebElement::click);

        // 8. Select in dropdown
        new Select(driver.findElement(By.cssSelector(".colors select")))
                .selectByVisibleText("Yellow");

        // 9. Assert logs
        final var LOG_LINE_REGEX = Pattern.compile("(?<=^\\d{2}:\\d{2}:\\d{2} ).*$");
        var logs = driver.findElements(By.cssSelector("ul.logs li")).stream().map(WebElement::getText).toArray(String[]::new);
        for (int i = 0; i < logs.length; i++) {
            Matcher matcher = LOG_LINE_REGEX.matcher(logs[i]);
            assertTrue(matcher.find(), "["+i+"] log line doesn't match regex");
            logs[i] = matcher.group();
        }
        String[] EXPECTED_LOGS_ENTRIES = {"Colors: value changed to Yellow", "metal: value changed to Selen",
                "Wind: condition changed to true", "Water: condition changed to true"};
        assertEquals(logs, EXPECTED_LOGS_ENTRIES);
    }
}
