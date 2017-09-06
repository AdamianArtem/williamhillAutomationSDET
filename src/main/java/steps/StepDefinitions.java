package steps;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.getElement;
import static com.codeborne.selenide.Selenide.open;

public class StepDefinitions {

//    @Step("Open page {0}")
    @Given("^open page with url \"([^\"]*)\"$")
    public void openPageWithUrl(String arg0) throws Throwable {
        open(arg0);
        SelenideElement element;
        element = getElement(By.name("dfh"));
        element.click();
    }
}
