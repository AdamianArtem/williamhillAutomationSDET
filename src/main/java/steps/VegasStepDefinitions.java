package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageObjects.VegasPage;

import static com.codeborne.selenide.Selenide.sleep;

public class VegasStepDefinitions {
    private VegasPage vegasPage = new VegasPage();

    @And("^In the top-right corner click magnifier button$")
    public void inTheTopRightCornerClickMagnifierButton() throws Throwable {
        vegasPage.searchMagnifier().click();
    }

    @Then("^Search for \"([^\"]*)\" game$")
    public void searchForGame(String search) throws Throwable {
        vegasPage.searchInputField().setValue(search);
    }

    @And("^Hover over the \"([^\"]*)\" game tile and click \"([^\"]*)\" button$")
    public void hoverOverTheGameTileAndClickButton(String game, String button) throws Throwable {
        vegasPage.identifyGame(game).hover();
        sleep(10);
        switch (button) {
            case "More":
                vegasPage.moreButton().click();
                break;
            case "Play now":
                vegasPage.playNowButton().click();
                break;
        }
    }

    @Then("^Click \"([^\"]*)\" and validate Login window is displayed$")
    public void clickAndValidateLoginWindowIsDisplayed(String text) throws Throwable {
        vegasPage.findButtonByText(text).click();
        vegasPage.loginModalWindow().shouldBe(Condition.appears);
    }
}
