package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void initialize(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test (groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        homePage.clickOnRegisterLink();
        registerPage.verifyRegisterText("Register");
    }

    @Test (groups = {"sanity", "regression"})
    public void verifyThatFirstNameLastNameEmailOasswordAndConfirmPasswordFieldsAreMandetory() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        registerPage.verifyFirstNameReqiredErrorText("First name is required.");
        registerPage.verifyLastNameReqiredErrorText("Last name is required.");
        registerPage.verifyEmailReqiredErrorText("Email is required.");
        registerPage.verifyPasswordReqiredErrorText("Password is required.");
        registerPage.verifyConfirmPasswordReqiredErrorText("Password is required.");
    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldCreateAccountSuccessfully(){
        homePage.clickOnRegisterLink();
        registerPage.selectGender("Male");
        registerPage.inputFirstName("Harry");
        registerPage.inputLastName("Potter");
        registerPage.selectDateOfBirth("1", "January", "1980");
        registerPage.inputEmail(getRandomEmail());
        registerPage.inputPassword("Harry987");
        registerPage.inputConfirmPassword("Harry987");
        registerPage.clickOnRegisterButton();
        registerPage.verifyRegistrationCompletedText("Your registration completed");
    }
}
