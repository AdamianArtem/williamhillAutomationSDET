package helper;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static helper.WaitHelper.waitFor;
import static org.testng.Assert.fail;

public class Helper {

    private static ElementsCollection successNotificationCollection() {
        return $$(By.xpath("//*[contains(@class, 'betslip-notification--success')]")).filter(visible);
    }

    /**
     * method which scroll to top of the page
     */
    public static void scrollTop() {
        executeJavaScript("scroll(0,0)");
    }

    /**
     * method which wait for success message on the page
     */
    public static void findSuccessMessageOnPage() {
        boolean success = false;
        for (int i = 0; i < 20; i++) {
            waitFor("return jQuery.active=0");
            if (successNotificationCollection().size() > 0) {
                success = true;
                break;
            } else {
                sleep(1000);
            }
        }
        if (!success) {
            fail("Success notification is not found!");
        }
    }
}
