package runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import listeners.ScreenshotListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Attachment;

import static com.codeborne.selenide.Selenide.open;

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
//		open("http://automated-testing.info/t/gde-v-otchete-allure-dolzhen-poyavitsya-skrinshot/5924");
//        saveAllureScreenshot();

	}

//    @Attachment(value = "Page screenshot", type = "image/png")
//    private byte[] saveAllureScreenshot() {
//        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
//    }
}
