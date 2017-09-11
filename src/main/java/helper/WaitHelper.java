package helper;

import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;

public class WaitHelper {

    /**
     * method which wait for some script has executed
     */
    public static void waitFor(String script) {
        try {
            for (int i = 0; i < 20; i++) {
                if (WebDriverRunner.hasWebDriverStarted()) {
                    if (executeJavaScript(script)) {
                        sleep(1000);
                        break;
                    } else {
                        sleep(1000);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
