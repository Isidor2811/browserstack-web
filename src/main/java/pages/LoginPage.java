package pages;

import static framework.Waiters.waitForVisibility;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  private static final By loginField = By.id("user-name");
  private static final By passwordField = By.id("password");
  private static final By loginButton = By.name("login-button");
  private static final By errorMessage = By.xpath("//h3[@data-test='error']");

  public LoginPage setLogin(String login) {
    type(loginField, login);
    return this;
  }

  public LoginPage setPassword(String password) {
    type(passwordField, password);
    return this;
  }

  public DashboardPage clickLoginButtonWithValidUser() {
    click(loginButton);
    return new DashboardPage();
  }

  public LoginPage clickLoginButtonWithLockedUser() {
    click(loginButton);
    return this;
  }

  public String getErrorMessage() {
    return waitForVisibility(errorMessage).getAttribute("innerText");
  }
}
