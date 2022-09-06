package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSearchResultsPage extends BasePage{
    private final static By SEARCH_RESULTS_LOCATOR = By.cssSelector("[data-testid='title']");
    private final static By RATING_RESULTS_LOCATOR = By.cssSelector("[data-testid='review-score-link']");

    public BookingSearchResultsPage(WebDriver driver) { super(driver);
    }
    public String getSearchResultTitleByIndex(int index) {
        return driver.findElements(SEARCH_RESULTS_LOCATOR).get(index - 1).getText();
    }
    public String getRatingResultTitleByIndex(int index) {
        return driver.findElements(RATING_RESULTS_LOCATOR).get(index - 1).getText();
    }
}
