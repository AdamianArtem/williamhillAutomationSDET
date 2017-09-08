package steps;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.SportsHomePage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.getElement;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

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
        int i = generator.nextInt(sportsHomePage.selectFootballEventsSize());

        sportsHomePage.selectFootballEvents(i,1).click();
//        switch (team) {
//            case "":
//        }
    }
}
