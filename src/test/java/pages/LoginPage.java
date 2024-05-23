package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final String pagePath = "/";

    private static final By emailInputLocator = By.id(":r0:");
    private final By passwordInputLocator = By.id(":r2:");
    private final By loginButtonLocator = By.xpath("//*[@data-testid='button-login']");


    public SelenideElement getEmailInput() {
       return $(emailInputLocator);
    }

    public LoginPage setEmail(String value){
        getEmailInput().sendKeys(value);
        return this;
    }

    public SelenideElement getPasswordInput(){
        return $(passwordInputLocator);
    }
    public LoginPage setPassword(String value){
        getPasswordInput().sendKeys(value);
        return this;
    }

    public SelenideElement getLoginButton() {
        return $(loginButtonLocator);
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

    public void login() {
        this
                .setEmail(ReadProperties.getUserName())
                .setPassword(ReadProperties.getPassword())
                .clickLoginButton();
    }

    public DashboardPage successfulLogin(String username, String password) {
        login(username, password);
        return new DashboardPage();
    }

    public LoginPage incorrectLogin(String username, String password) {
        login(username, password);
        return this;
    }


}
