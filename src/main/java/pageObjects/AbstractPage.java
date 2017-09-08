package pageObjects;

import com.codeborne.selenide.SelenideElement;

public abstract class AbstractPage {

    protected void logIn(SelenideElement logInButton, SelenideElement userNameInput, String username, SelenideElement passwordInput, String password, SelenideElement submitButton) {
        logInButton.click();
        userNameInput.setValue(username);
        passwordInput.setValue(password);
        submitButton.click();
    }
}
