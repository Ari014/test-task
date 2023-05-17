package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
  @FindBy(css = "#home_img")
  private WebElement homePageIcon;
  @FindBy(css = "#suggestion-search")
  private WebElement searchPlaceholder;
  @FindBy(xpath = "//*[contains(@class, \"searchResult__metadata\")]")
  private List<WebElement> listOfMetadata;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void openHomePage(String baseUrl) {
    driver.get(baseUrl);
  }

  public void waitVisibilityOfHomePageIcon() {
    WAIT.until(
            ExpectedConditions.visibilityOf(homePageIcon));

  }

  public void waitVisibilityOfMetadata() {
    WAIT.until(
            ExpectedConditions.visibilityOfAllElements(listOfMetadata));

  }

  public void searchByTitle(String title) {
    searchPlaceholder.sendKeys(title);
  }

  public void clickOnMovieByYear(String year) {
    listOfMetadata.stream()
            .filter(metadata -> metadata.getText().equals(year))
            .findFirst()
            .ifPresent(WebElement::click);
  }
}
