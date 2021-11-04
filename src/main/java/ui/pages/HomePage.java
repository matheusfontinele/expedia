package ui.pages;

import org.openqa.selenium.*;

import java.time.LocalDate;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By staysSpan = By.xpath("//span[text()='Stays']");
    private By goingToButton = By.cssSelector("#location-field-destination-menu > div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder > button");
    private By goingToInput = By.id("location-field-destination");
    private By resultOptionButtons = By.xpath("//li[@class='uitk-typeahead-result-item']/button");
    private By checkInButton = By.xpath("//button[@data-stid='open-date-picker' and @data-name='d1']");
    private By checkOutError = By.id("d2-error");
    private By searchButton = By.xpath("//button[text()='Search' and @type='submit']");

    public void dismiss() {
        driver.findElement(staysSpan).click();
    }

    public void typeInputGoingTo(String text) {
        driver.findElement(goingToButton).click();
        driver.findElement(goingToInput).sendKeys(text);
        List<WebElement> listOptions = driver.findElements(resultOptionButtons);
        WebElement lastOption = listOptions.get(listOptions.size() - 1);
        lastOption.click();
    }

    public DatePicker clickCheckInButton() {
        driver.findElement(checkInButton).click();

        return new DatePicker(driver);
    }

    public SearchResultPage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }

    public String getCheckoutError() {
        return driver.findElement(checkOutError).getText();
    }

    public SearchResultPage searchStay(String goingTo, LocalDate checkIn, LocalDate checkOut) {
        dismiss();

        typeInputGoingTo(goingTo);

        DatePicker datePicker = clickCheckInButton();
        datePicker.chooseDays(checkIn, checkOut);

        clickSearchButton();
        return new SearchResultPage(driver);
    }

}
