package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

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

    public SelenideElement selectFootballEvents(int event, int btmarketActions) {
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
       depositHeaderButtonLink().shouldBe(Condition.enabled);
       Assert.assertEquals(depositHeaderButtonLink().getText(), "Deposit");
    }
}
