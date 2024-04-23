package edu.hsai.homework4.steps;

import edu.hsai.homework3.pages.DifferentElementsPage;
import edu.hsai.homework3.pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class StepsSetup {
    protected static WebDriver driver;
    protected static Properties properties;

    public static HomePage homePage; // is public due to usage in BadTest class :(
    protected static DifferentElementsPage differentElements;

    public StepsSetup(WebDriver driver, Properties properties) {
        StepsSetup.driver = driver;
        StepsSetup.properties = properties;
    }
}
