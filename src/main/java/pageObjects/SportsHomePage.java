package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

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

    public SelenideElement loginButton() {
        return $(By.xpath(".//button[@data-automation-id='loginButton']"));
    }

    public int selectFootballEventsSize() {
        return $(By.xpath(".//section[@data-toggle-receive='1-pre_match']")).$$("div.event").size();
    }

    public SelenideElement selectFootballEvents(int event, int btmarketActions) {
        return $(By.xpath(".//section[@data-toggle-receive='1-pre_match']")).$$("div.event").get(event).$("div.btmarket__actions").$$("div.btmarket__selection").get(btmarketActions);
    }

    public void logIn(String username, String password) {
       super.logIn(accountTabButton(),loginUsernameInput(),username,loginPasswordInput(),password,loginButton());

       depositHeaderButtonLink().waitUntil(Condition.appears, 5000);
       Assert.assertEquals(depositHeaderButtonLink().getText(), "Deposit");
    }
}
