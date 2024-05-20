package core;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WaitService {
    private WebDriver driver;
    private Duration timeout;
    private WebDriverWait wait;

    public WaitService(WebDriver driver, Duration timeout) {
        this.timeout = timeout;
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public WaitService(WebDriver driver) {
        this.timeout = Duration.ofSeconds(ReadProperties.getTimeout());
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForExists(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public WebElement waitForVisibilityLocatedBy(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public Boolean waitForElementInvisible(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}

