package edu.hsai.homework3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private final WebDriver driver;

    public final HeaderSection headerSection;
    public final LeftSection leftSection;

    @FindBy(id = "name")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "a.dropdown-toggle:has(.profile-photo)")
    private WebElement loginDropDownButton;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "benefit-icon")
    public List<WebElement> benefitImages;

    @FindBy(className = "benefit-txt")
    public List<WebElement> benefitIconTexts;

    @FindBy(id = "frame")
    public WebElement frame;

    public static HomePage navigateTo(WebDriver driver, String url) {
        driver.navigate().to(url);
        return new HomePage(driver);
    }

    private HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        headerSection = new HeaderSection(driver);
        leftSection = new LeftSection(driver);
    }

    public void performLogin(String login, String password) {
        loginDropDownButton.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public DifferentElementsPage navigateDifferentElements() {
        headerSection.serviceDropDown.click();
        headerSection.differentElements.click();
        return new DifferentElementsPage(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getLoggedName() {
        return userName.getText();
    }


    public List<String> getBenefitIconsTextsStrings() {
        return benefitIconTexts.stream().map(WebElement::getText).toList();
    }

    public IFrame switchToFrame() {
        driver.switchTo().frame("frame");
        return new IFrame();
    }

    public void switchTo() {
        driver.switchTo().defaultContent();
    }


    public static class HeaderSection {
        @FindBy(css = "nav ul.nav > li")
        public List<WebElement> items;

        @FindBy(xpath = "//ul[contains(@class, 'sidebar-menu')]/li[contains(.,'Service')]")
        public WebElement serviceDropDown;

        public WebElement differentElements;

        private HeaderSection(WebDriver driver) {
            PageFactory.initElements(driver, this);
            differentElements = serviceDropDown.findElement(By.xpath(".//a[descendant::text()='Different elements']"));
        }

        public List<String> itemNames() {
            return items.stream().map(WebElement::getText).toList();
        }

    }

    public static class LeftSection {
        @FindBy(css = "ul.sidebar-menu.left > li")
        public List<WebElement> items;

        private LeftSection(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public List<String> getItemNames() {
            return items.stream().map(WebElement::getText).toList();
        }
    }

    public class IFrame {
        @FindBy(id = "frame-button")
        public WebElement frameButton;

        private IFrame() {
            PageFactory.initElements(driver, this);
        }
    }
}
