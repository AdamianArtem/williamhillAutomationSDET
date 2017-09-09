package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static helper.WaitHelper.waitFor;

public class SportsHomePage extends AbstractPage{

    public SelenideElement accountTabButton() {
        return $("#accountTabButton");
    }

    public SelenideElement depositHeaderButtonLink() {
        return $("#depositHeaderButtonLink");
    }

    public SelenideElement loginUsernameInput() {
        return $("#loginUsernameInput");
    }

    public SelenideElement loginPasswordInput() {
        return $("#loginPasswordInput");
    }

    public SelenideElement betslipCashinButton() {
        return $(".betslip-cashin__button");
    }

    public SelenideElement loginButton() {
        return $(By.xpath(".//button[@data-automation-id='loginButton']"));
    }

    public SelenideElement confirmButton() {
        return $(By.xpath(".//input[@value='Confirm']"));
    }

    public SelenideElement showMyBetsButton() {
        return $(By.xpath(".//input[@value='I understand, show my bets']"));
    }

    public int selectFootballEventsSize() {
        return $(By.xpath(".//section[@data-toggle-receive='1-pre_match']")).$$("div.event").size();
    }

    public SelenideElement selectFootballEvents(int event, int btmarketActions) {
        return $(By.xpath(".//section[@data-toggle-receive='1-pre_match']")).$$("div.event").get(event).$("div.btmarket__actions").$$("div.btmarket__selection").get(btmarketActions);
    }

    public SelenideElement betslipSelectionStakeInput() {
        return $(".betslip-selection__stake-input");
    }

    public SelenideElement placeBetButton() {
        return $(By.xpath(".//input[@data-ng-click='placeBet()']"));
    }

    public void openBetsTab() {
        $("#openbets-tab").click();
    }

    public void placeBet(String bet) {
        betslipSelectionStakeInput().setValue(bet);
    }

    public void logIn(String username, String password) {
       super.logIn(accountTabButton(),loginUsernameInput(),username,loginPasswordInput(),password,loginButton());
        waitFor("return document.readyState === 'complete'");
        waitFor("return jQuery.active=0");
       depositHeaderButtonLink().shouldBe(Condition.enabled);
       Assert.assertEquals(depositHeaderButtonLink().getText(), "Deposit");
    }
}
