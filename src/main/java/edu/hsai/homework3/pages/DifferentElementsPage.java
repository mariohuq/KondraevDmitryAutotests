package edu.hsai.homework3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DifferentElementsPage {
    public final Pattern LOG_LINE_REGEX = Pattern.compile("(?<=^\\d{2}:\\d{2}:\\d{2} ).*$");

    @FindBy(css = "label:has(input[type=checkbox])")
    private List<WebElement> checkboxes;

    @FindBy(css = "label:has(input[type=radio])")
    private List<WebElement> radios;

    @FindBy(css = ".colors select")
    private WebElement dropdown;

    @FindBy(css = "ul.logs li")
    private List<WebElement> logs;

    DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectCheckboxes(List<String> names) {
        checkboxes.stream().filter(checkbox -> names.contains(checkbox.getText())).forEach(WebElement::click);
    }

    public void selectRadio(String name) {
        radios.stream().filter(radio -> radio.getText().equals(name)).forEach(WebElement::click);
    }

    public void selectDropdownOption(String name) {
        new Select(dropdown).selectByVisibleText(name);
    }

    public List<String> getLogs() {
        return logs.stream().map(WebElement::getText).map(x -> {
            Matcher matcher = LOG_LINE_REGEX.matcher(x);
            matcher.find();
            return matcher.group();
        }).toList();
    }
}
