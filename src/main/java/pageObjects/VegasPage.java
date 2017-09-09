package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static helper.WaitHelper.waitFor;

public class VegasPage extends AbstractPage{

    public SelenideElement searchMagnifier() {
        return $(".btn-search-magnifier");
    }

    public SelenideElement searchInputField() {
        return $(By.xpath(".//input[@placeholder='Search for games...']"));
    }

    public SelenideElement identifyGame(String game) {
        return $(By.xpath(".//img[@alt='"+game+"']"));
    }

    public SelenideElement moreButton() {
        return $(".tile-menu__button--more");
    }

    public SelenideElement playNowButton() {
        return $(".tile-menu__button--play");
    }

    public SelenideElement findButtonByText(String text) {
        return $(By.xpath(".//button[text()='"+text+"']"));
    }

    public SelenideElement loginModalWindow() {
        return $(By.xpath(".//div[@data-ng-controller='wfQuickLoginController']"));
    }
}
