package pages;

import static framework.Waiters.waitForVisibility;

import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

  private static final By pageTitle = By.xpath("//span[text()='Products']");

  public DashboardPage() {
    waitForVisibility(pageTitle);
  }
}
