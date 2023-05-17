package cucumber.setUp;

import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.MoviePage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
public class CucumberContext {
  public final String BASE_URL = "https://www.imdb.com/";
  public WebDriver driver;
  public HomePage homePage;
  public MoviePage moviePage;

  public void setUp() {
    configureBrowser();
    configurePages();
  }

  public void configureBrowser() {
    chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  public void configurePages() {
    homePage = new PageFactoryManager(driver).getPage(HomePage.class);
    moviePage = new PageFactoryManager(driver).getPage(MoviePage.class);
  }
}
