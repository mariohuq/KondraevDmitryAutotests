package edu.hsai.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverSetup {
    protected static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open test site by URL
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 3. Perform login
        driver.findElement(By.cssSelector("a.dropdown-toggle:has(.profile-photo)")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
    }

    @AfterClass
    public static void exit() {
        //10. Close Browser
        driver.close();
    }
}
