package pages;

import static framework.Waiters.waitForClickable;
import static framework.Waiters.waitForVisibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

  private static final String BASE_URL = "https://www.saucedemo.com/";
  private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

  public static ThreadLocal<WebDriver> getDriverThreadLocal() {
    return DRIVER_THREAD_LOCAL;
  }

  public static void setDriverThreadLocal(WebDriver driver) {
    DRIVER_THREAD_LOCAL.set(driver);
  }

  public static WebDriver getDriver() {
    return DRIVER_THREAD_LOCAL.get();
  }

  public LoginPage openLoginPage() {
    getDriver().get(BASE_URL);
    return new LoginPage();
  }

  public static void type(By locator, String text) {
    waitForVisibility(locator).sendKeys(text);
  }

  public static void click(By locator) {
    waitForClickable(locator).click();
  }
}
