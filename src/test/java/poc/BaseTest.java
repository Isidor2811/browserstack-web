package poc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTest {

  public static final String AUTOMATE_USERNAME = "bsuser_egrfsp";
  public static final String AUTOMATE_ACCESS_KEY = "Z4Qf1PKGA9L7MUxY2bcr";
  public static final String URL =
      "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

  @BeforeMethod(alwaysRun = true)
  public void startBrowser() throws MalformedURLException {

    //set capabilities
    MutableCapabilities capabilities = new MutableCapabilities();
    capabilities.setCapability("browserName", System.getProperty("browserName"));
    capabilities.setCapability("browserVersion", System.getProperty("browserVersion"));
    HashMap<String, Object> browserstackOptions = new HashMap<>();
    browserstackOptions.put("os", System.getProperty("os"));
    browserstackOptions.put("osVersion", System.getProperty("osVersion"));
    capabilities.setCapability("bstack:options", browserstackOptions);

    WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
    driver.manage().window().maximize();
    BasePage.setDriverThreadLocal(driver);
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    if (BasePage.getDriver() != null) {
      BasePage.getDriver().quit();
    }
    if (BasePage.getDriverThreadLocal() != null) {
      BasePage.getDriverThreadLocal().remove();
    }
  }

}
