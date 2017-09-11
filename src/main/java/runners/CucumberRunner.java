package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import listeners.ScreenshotListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@CucumberOptions(
		features = "src/main/java/features",
		glue = "steps",
		tags={"@smokeTest"}
		)

@Listeners({ScreenshotListener.class})
public class CucumberRunner extends AbstractTestNGCucumberTests {

	/**
	 *method which before suite setup chrome web driver and switch off screenshots
	 */
	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
		Configuration.browser = "chrome";
		// switch off screenshots because all screenshots save to build folder, this is unnecessary.
		// The best way to make screenshots at that time what you need
		Configuration.screenshots = false;
	}
}
