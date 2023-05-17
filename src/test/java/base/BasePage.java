package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  protected static final long TIMEOUT = 15;
  protected final WebDriverWait WAIT;
  protected WebDriver driver;

  protected BasePage(WebDriver driver) {
    this.driver = driver;
    WAIT = new WebDriverWait(driver, TIMEOUT);
    PageFactory.initElements(driver, this);
  }
}
