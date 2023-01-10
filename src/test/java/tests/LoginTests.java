package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import poc.BaseTest;

public class LoginTests extends BaseTest {

  @Test
  public void loginWithStandardUserTest() {
    LoginPage loginPage = new LoginPage();
    loginPage
        .openLoginPage()
        .setLogin("standard_user")
        .setPassword("secret_sauce")
        .clickLoginButtonWithValidUser();
  }

  @Test
  public void loginWithLockedUserTest() {
    LoginPage loginPage = new LoginPage();
    loginPage
        .openLoginPage()
        .setLogin("locked_out_user")
        .setPassword("secret_sauce")
        .clickLoginButtonWithLockedUser();

    String actualErrorMessage = loginPage.getErrorMessage();
    Assert.assertEquals(actualErrorMessage,
        "Epic sadface: Sorry, this user has been locked out.");
  }

}
