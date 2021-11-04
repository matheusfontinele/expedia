package ui;

import ui.listener.TestListener;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.SearchResultPage;

import java.time.LocalDate;

@Listeners(TestListener.class)
public class HomePageTests {

    private final String webSite = "https://www.expedia.com";

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver  = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(webSite);
    }

    @AfterMethod
    public void endBrowser() {
        driver.close();
    }

    @Test
    public void searchForStaysWithTwentyEightDays() {
        HomePage homePage = new HomePage(driver);

        LocalDate localDate = LocalDate.now();

        SearchResultPage searchResultPage = homePage.searchStay("Walt Disney World", localDate, localDate.plusDays(28));

        //How the expedia check if the user it is a robot or not, the assertition it is not possible
    }

    @Test
    public void searchForStaysHigherThanTwentyEightDays() {
        String expectedMessage = "Dates must be no more than 28 days apart";

        HomePage homePage = new HomePage(driver);

        LocalDate localDate = LocalDate.now();

        SearchResultPage searchResultPage = homePage.searchStay("Walt Disney World", localDate, localDate.plusDays(29));

        Assertions.assertThat(homePage.getCheckoutError()).isEqualTo(expectedMessage);
    }

    @Test
    public void searchForStaysWithInputGoingToBlank() {
        String expectedMessage = "Please select a destination";
    	
    	HomePage homePage = new HomePage(driver);

        LocalDate localDate = LocalDate.now();

        SearchResultPage searchResultPage = homePage.searchStay("", localDate, localDate.plusDays(28));

        Assertions.assertThat(homePage.getGointToInputError()).isEqualTo(expectedMessage);
    }
}
