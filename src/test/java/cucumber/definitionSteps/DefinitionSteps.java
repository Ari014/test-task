package cucumber.definitionSteps;

import cucumber.setUp.CucumberContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MoviePage;
import pages.HomePage;

public class DefinitionSteps {
  private final CucumberContext context;
  private MoviePage moviePage;
  private HomePage homePage;


  public DefinitionSteps(CucumberContext cucumberContext) {
    this.context = cucumberContext;
  }

  @Before
  public void setUp() {
    context.setUp();
    homePage = context.homePage;
    moviePage = context.moviePage;
  }

  @After
  public void tearDown() {
    context.driver.quit();
  }

  @Given("User opens Home page")
  public void openHomePage() {
    homePage.openHomePage(context.BASE_URL);
  }

  @And("User verifies page is opened")
  public void userVerifiesPageIsOpened() {
    homePage.waitVisibilityOfHomePageIcon();
  }

  @When("User searches the movie by title {string}")
  public void searchTheMovieByTitle(String titleName) {
    homePage.searchByTitle(titleName);
  }

  @When("User clicks on the movie which is released in year {string}")
  public void clicksOnMovieReleasedInYear(String year) {
    homePage.waitVisibilityOfMetadata();
    homePage.clickOnMovieByYear(year);
  }

  @Then("User verifies that the movie description matches the following {string}")
  public void checkDescription(String expectedResult) {
    moviePage.waitVisibilityOfDescription();
    Assert.assertEquals(moviePage.getDescription(), expectedResult);
  }
}
