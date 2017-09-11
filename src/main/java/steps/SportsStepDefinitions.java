package steps;

import cucumber.api.java.en.And;
import io.qameta.allure.Step;
import pageObjects.SportsPage;

import java.util.Random;

import static helper.Helper.*;
import static helper.WaitHelper.waitFor;

public class SportsStepDefinitions {

    private SportsPage sportsPage = new SportsPage();

    @And("^Select event for the \"([^\"]*)\" team to Win$")
    @Step("Select event")
    public void selectEventForTheTeamToWin(String team) throws Throwable {
        Random generator = new Random();
        //get random nums because i want to shows you that test can select a random event from event list
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

    @And("^Place \"([^\"]*)\" bet and assert the odds and returns offered$")
    @Step("Place bet and assert the odds and returns offered")
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
