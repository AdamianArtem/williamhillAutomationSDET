package steps;

import cucumber.api.java.en.And;
import pageObjects.SportsPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static helper.Helper.*;
import static helper.WaitHelper.waitFor;

public class SportsStepDefinitions {

    private SportsPage sportsPage = new SportsPage();

    @And("^Select event for the \"([^\"]*)\" team to Win$")
    public void selectEventForTheTeamToWin(String team) throws Throwable {
        Random generator = new Random();
        int event = generator.nextInt(sportsPage.selectFootballEventsSize());
        int btmarketActionsIndex = 0;
        switch (team) {
            case "Draw":
                btmarketActionsIndex = 1;
                break;
            case "Away":
                btmarketActionsIndex = 2;
                break;
        }
        sportsPage.selectFootballEvents(event,btmarketActionsIndex).click();
    }

    @And("^Log in with user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void logInWithUserAndPassword(String username, String password) throws Throwable {
        sportsPage.logIn(username, password);
    }

    @And("^Place \"([^\"]*)\" bet and assert the odds and returns offered$")
    public void placeBetAndAssertTheOddsAndReturnsOffered(String bet) throws Throwable {
        sportsPage.placeBet(bet);
        sportsPage.placeBetButton().click();
        findSuccessMessageOnPage();
        waitFor("return jQuery.active=0");
        scrollTop();
        sportsPage.openBetsTab();
        waitFor("return jQuery.active=0");
        if (sportsPage.showMyBetsButton().isEnabled()) {
            sportsPage.showMyBetsButton().click();
            sportsPage.betslipCashinButton().click();
        } else {
            sportsPage.betslipCashinButton().click();
        }
        sportsPage.confirmButton().click();
    }
}
