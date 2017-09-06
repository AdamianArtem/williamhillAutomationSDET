package steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class StepDefinitions {

    @Given("^open page with url \"([^\"]*)\"$")
    public void openPageWithUrl(String arg0) throws Throwable {
        open(arg0);
    }
}
