package framework;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class Waiters {

  public static final int DEFAULT_TIMEOUT = 5;

  private static WebDriverWait getWebDriverWait(int... seconds) {
    int secondsToWait = seconds.length > 0 ? seconds[0] : DEFAULT_TIMEOUT;
    return new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(secondsToWait));
  }

  public static WebElement waitForPresenceOfElement(By locator, int... seconds) {
    return getWebDriverWait(seconds).until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public static WebElement waitForVisibility(By locator, int... seconds) {
    return getWebDriverWait(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static WebElement waitForClickable(By locator, int... seconds) {
    return getWebDriverWait(seconds).until(ExpectedConditions.elementToBeClickable(locator));
  }

}
