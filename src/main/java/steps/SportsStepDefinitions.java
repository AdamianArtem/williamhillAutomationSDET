package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pageObjects.SportsHomePage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static helper.Helper.*;
import static helper.WaitHelper.waitFor;

public class SportsStepDefinitions {

    private SportsHomePage sportsHomePage = new SportsHomePage();

    @Given("^Navigate to \"([^\"]*)\"$")
    public void navigateTo(String page) throws Throwable {
        open(page);
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

    @And("^Log in with user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void logInWithUserAndPassword(String username, String password) throws Throwable {
        sportsHomePage.logIn(username, password);
    }

    @And("^Place \"([^\"]*)\" bet and assert the odds and returns offered$")
    public void placeBetAndAssertTheOddsAndReturnsOffered(String bet) throws Throwable {
        sportsHomePage.placeBet(bet);
        sportsHomePage.placeBetButton().click();
        findSuccessMessageOnPage();
        waitFor("return jQuery.active=0");
        scrollTop();
        sportsHomePage.openBetsTab();
        waitFor("return jQuery.active=0");
        if (sportsHomePage.showMyBetsButton().isEnabled()) {
            sportsHomePage.showMyBetsButton().click();
            sportsHomePage.betslipCashinButton().click();
        } else {
            sportsHomePage.betslipCashinButton().click();
        }
        sportsHomePage.confirmButton().click();
    }
}
