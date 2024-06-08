package pages;

import baseEntities.BasePage;
import baseEntities.User;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements BasePage {
    private static final By EMAIL_INPUT_LOCATOR = By.id(":r0:");
    private static final By PASSWORD_INPUT_LOCATOR = By.id(":r2:");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//*[@data-testid='button-login']");
    private static final By ERROR_LOGIN_MESSAGE = By.xpath("//span[contains(text(),'Either your email')]");


    public SelenideElement getEmailInput() {
        return $(EMAIL_INPUT_LOCATOR).shouldBe(visible);
    }

    public LoginPage setEmail(String value) {
        getEmailInput().sendKeys(value);
        return this;
    }

    public SelenideElement getPasswordInput() {
        return $(PASSWORD_INPUT_LOCATOR).shouldBe(visible);
    }

    public LoginPage setPassword(String value) {
        getPasswordInput().sendKeys(value);
        return this;
    }

    public SelenideElement getLoginButton() {
        return $(LOGIN_BUTTON_LOCATOR).shouldBe(clickable);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    private void login(String username, String password) {
        this
                .setEmail(username)
                .setPassword(password)
                .clickLoginButton();
    }

    public DashboardPage successfulLogin(String username, String password) {
        login(username, password);
        return new DashboardPage();
    }

    public LoginPage unsuccessfulLogin() {
        login("username@box.neverni", "password");
        return new LoginPage();
    }

    public void checkWrongEmailMessage(){
        $(ERROR_LOGIN_MESSAGE).shouldBe(visible);
    }

    @Override
    public By getPageIdentifier() {
        return LOGIN_BUTTON_LOCATOR;
    }
}
