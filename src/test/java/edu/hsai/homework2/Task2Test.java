package edu.hsai.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Task2Test extends DriverSetup {
    @Test
    public void testBrowserTitle() {
        // 2. Assert browser title

    }

    @Test
    public void testLogin() {
        // 4. Assert Username is loggined

    }

    @Test
    public void testElements() {
        // 5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.cssSelector("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li > a > span")).click();
        driver.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[3]/ul/li[8]/a")).click();

        // 6. Select checkboxes


        // 7. Select radio


        // 8. Select in dropdown


        // 9. Assert logs

    }
}
