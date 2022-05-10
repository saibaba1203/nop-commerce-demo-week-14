package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void initialize(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test (groups = {"smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully(){
        homePage.clickOnLoginLink();
        loginPage.verifyWelcomeText("Welcome, Please Sign In!");
    }

    @Test (groups = {"sanity", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("abc@gmail.com");
        loginPage.enterPassword("abc123654");
        loginPage.clickOnLoginButton();
        loginPage.verifyInvalidCredentialsErrorMessage("Login was unsuccessful. " +
                "Please correct the errors and try again.");
    }

    @Test (groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("harry.potter21@hotmail.com");
        loginPage.enterPassword("Password123");
        loginPage.clickOnLoginButton();
        homePage.verifyLogoutlinkVisible();
    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldLogOutSuccessFully(){
        verifyThatUserShouldLogInSuccessFullyWithValidCredentials();
        homePage.clickOnLogoutLink();
        homePage.verifyLoginLinkVisible();
    }

}
