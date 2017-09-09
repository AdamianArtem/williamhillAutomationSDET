package steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class CommonStepDefinitions {
    @Given("^Navigate to \"([^\"]*)\"$")
    public void navigateTo(String page) throws Throwable {
        open(page);
    }
}
