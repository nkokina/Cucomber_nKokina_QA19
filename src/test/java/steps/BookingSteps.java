package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BookingSearchPage;
import pages.BookingSearchResultsPage;


import java.util.concurrent.TimeUnit;


public class BookingSteps {
    private WebDriver driver;
    private BookingSearchPage bookingSearchPage;
    private BookingSearchResultsPage bookingSearchResultsPage;
    private String searchWord;

    @Before
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        bookingSearchPage = new BookingSearchPage(driver);
        bookingSearchResultsPage = new BookingSearchResultsPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("Hotel for search is {string}")
    public void hotelForSearchIs(String arg0) {
        this.searchWord = arg0;
    }
    @And("I enter a search name")
    public void iEnterASearchName() {
        bookingSearchPage.setSearchInputValue(searchWord);
    }
    @And("I press search button hotel")
    public void iPressSearchButtonHotel() {
        bookingSearchPage.clickSearchButton();
    }
    @When("I navigate to www.booking.com")
    public void iNavigateToWwwBookingCom() {
        bookingSearchPage.open();
    }
    @Then("There is a hotel with this name")
    public void thereIsAHotelWithThisName() {
        String firstResultText = bookingSearchResultsPage.getSearchResultTitleByIndex(1);
        boolean doesContains = firstResultText.toLowerCase().trim().contains(searchWord.toLowerCase().trim());
        Assert.assertTrue(doesContains);
    }
    @Then("There are {string} results are present")
    public void thereAreResultsArePresent(String arg0) {
        String firstResultText = bookingSearchResultsPage.getRatingResultTitleByIndex(1);
        boolean doesContains = firstResultText.toLowerCase().trim().contains(arg0.toLowerCase().trim());
        Assert.assertTrue(doesContains);
    }
}
