package edu.hsai.homework4.steps;

import edu.hsai.homework3.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Properties;

public class Action extends StepsSetup {
    public Action(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    @Step("Navigating to Home Page")
    public void navigateToHomePage() {
        homePage = HomePage.navigateTo(driver, properties.getProperty("site.url"));
    }

    @Step("Logging in")
    public void performLogin() {
        homePage.performLogin(properties.getProperty("user.name"), properties.getProperty("user.password"));
    }

    @Step("Switching to the original window")
    public void switchToOriginalWindow() {
        homePage.switchTo();
    }

    @Step("Navigating to Different Elements page")
    public void navigateToDifferentElementsPage() {
        differentElements = homePage.navigateDifferentElements();
    }

    @Step("Selecting checkboxes")
    public void selectCheckboxes(String... names) {
        differentElements.selectCheckboxes(List.of(names));
    }

    @Step("Selecting radio")
    public void selectRadio(String name) {
        differentElements.selectRadio(name);
    }

    @Step("Selecting dropdown option")
    public void selectDropdownOption(String name) {
        differentElements.selectDropdownOption(name);
    }
}
