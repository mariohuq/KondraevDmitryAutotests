package edu.hsai.homework3;

import edu.hsai.homework3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DriverSetup {
    protected static WebDriver driver;

    protected static HomePage homePage;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Path.of("src/test/resources/data.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open test site by URL
        homePage = HomePage.navigateTo(driver, properties.getProperty("site.url"));

        // 3. Perform login
        homePage.performLogin(properties.getProperty("user.name"), properties.getProperty("user.password"));
    }

    @AfterTest
    public static void exit() {
        //10. Close Browser
        driver.close();
    }
}