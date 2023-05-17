package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoviePage extends BasePage {
  @FindBy(xpath = "//*[@data-testid=\"plot\"]")
  private WebElement movieDescription;

  public MoviePage(WebDriver driver) {
    super(driver);
  }

  public String getDescription() {
    return movieDescription.getText();
  }

  public void waitVisibilityOfDescription() {
    WAIT.until(
            ExpectedConditions.visibilityOf(movieDescription));

  }
}
