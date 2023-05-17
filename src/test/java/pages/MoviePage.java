package pages;

import base.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
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
