package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatePicker {


    private WebDriver driver;

    public DatePicker(WebDriver driver) {
        this.driver = driver;
    }

    private String previousMonth = "//button[@aria-label='%s']";
    private By buttonApplyDatePicker = By.xpath("//button[@data-stid='apply-date-picker']");

    public void chooseDays(LocalDate initialDay, LocalDate endDay) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy").withLocale(Locale.US);
        String initial = initialDay.format(formatter);
        String end = endDay.format(formatter);

        driver.findElement(By.xpath(previousMonth.formatted(initial))).click();
        driver.findElement(By.xpath(previousMonth.formatted(end))).click();

        driver.findElement(buttonApplyDatePicker).click();
    }
}
