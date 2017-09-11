package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static helper.WaitHelper.waitFor;

public class SportsPage extends AbstractPage{

    private SelenideElement accountTabButton() {
        return $("#accountTabButton");
    }

    private SelenideElement depositHeaderButtonLink() {
        return $("#depositHeaderButtonLink");
    }

    private SelenideElement loginUsernameInput() {
        return $("#loginUsernameInput");
    }

    private SelenideElement loginPasswordInput() {
        return $("#loginPasswordInput");
    }

    public SelenideElement betslipCashinButton() {
        return $(".betslip-cashin__button");
    }

    private SelenideElement loginButton() {
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

    /**
     *
     * @param event enter a index of event collection
     * @param btmarketActions enter a index (0 = "Home"), index (1 = "Draw"), index (2 = "Away")
     * @return one of the event collection
     */
    public SelenideElement selectFootballEvents(int event, int btmarketActions) {
        //get collection of events and get collections of btmarket Actions
        return $(By.xpath(".//section[@data-toggle-receive='1-pre_match']")).$$("div.event").get(event).$("div.btmarket__actions").$$("div.btmarket__selection").get(btmarketActions);
    }

    private SelenideElement betslipSelectionStakeInput() {
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
