package listeners;

import com.codeborne.selenide.WebDriverRunner;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenshotListener extends TestListenerAdapter {

    /**
     *method which on test failure make a screenshot and quit web driver
     */
    @Override
    public void onTestFailure(ITestResult tr){
        saveAllureScreenshot();
        WebDriverRunner.getWebDriver().quit();
    }

    /**
     *method which on test success quit web driver
     */
    @Override
    public void onTestSuccess(ITestResult var1) {
        WebDriverRunner.getWebDriver().quit();
    }

    /**
     *method which make a screenshot and attach to allure report
     */
    @Attachment(value = "Failure Screenshot", type = "image/png")
    private byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
