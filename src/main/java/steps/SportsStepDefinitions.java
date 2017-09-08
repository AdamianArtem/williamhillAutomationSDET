package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pageObjects.SportsHomePage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class SportsStepDefinitions {

    private SportsHomePage sportsHomePage = new SportsHomePage();

    @Given("^Navigate to \"([^\"]*)\"$")
    public void navigateTo(String page) throws Throwable {
        open(page);
    }

    @And("^Log in with \"([^\"]*)\" , \"([^\"]*)\" user$")
    public void logInWithUser(String username, String password) throws Throwable {
        sportsHomePage.logIn(username, password);
    }

    @And("^Select event for the \"([^\"]*)\" team to Win$")
    public void selectEventForTheTeamToWin(String team) throws Throwable {
        Random generator = new Random();
        int event = generator.nextInt(sportsHomePage.selectFootballEventsSize());
        int btmarketActionsIndex = 0;
        switch (team) {
            case "Draw":
                btmarketActionsIndex = 1;
                break;
            case "Away":
                btmarketActionsIndex = 2;
                break;
        }
        sportsHomePage.selectFootballEvents(event,btmarketActionsIndex).click();
    }
}
