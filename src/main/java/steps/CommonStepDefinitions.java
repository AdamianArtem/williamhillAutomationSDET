package steps;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.qameta.allure.Step;
import pageObjects.SportsPage;
import pageObjects.VegasPage;

import static com.codeborne.selenide.Selenide.open;

public class CommonStepDefinitions {

    private SportsPage sportsPage = new SportsPage();
    private VegasPage vegasPage = new VegasPage();

    @Given("^Navigate to \"([^\"]*)\"$")
    @Step("Navigate to")
    public void navigateTo(String page) throws Throwable {
        open(page);
    }

    @And("^Log in with user \"([^\"]*)\" and password \"([^\"]*)\"$")
    @Step("Log in ")
    public void logInWithUserAndPassword(String username, String password) throws Throwable {
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();

        if(url.contains("sports.")) {
            sportsPage.logIn(username, password);
        } else {
            vegasPage.logIn(username, password);
        }
    }
}
