package runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pageObjects.SportsHomePage;

import static com.codeborne.selenide.Selenide.open;
import static org.bouncycastle.cms.RecipientId.password;

@CucumberOptions(
		features = "src/main/java/features",
		glue = "steps",
		tags={"@smokeTest"}
		)

@Listeners({ScreenshotListener.class})
public class CucumberRunner extends AbstractTestNGCucumberTests {

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
		Configuration.browser = "chrome";
		Configuration.screenshots = false;
	}
}
