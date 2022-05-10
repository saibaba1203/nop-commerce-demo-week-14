package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Utility {
    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;

    @FindBy(xpath = "//input[@name='Gender']")
    WebElement gender;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dateOfBirthDay;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement dateOfBirthMonth;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement dateOfBirthYear;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(id = "FirstName-error")
    WebElement firstNameErrorText;

    @FindBy(id = "LastName-error")
    WebElement lastNameErrorText;

    @FindBy(id = "Email-error")
    WebElement emailErrorText;

    @FindBy(id = "Password-error")
    WebElement passwordErrorText;

    @FindBy(id = "ConfirmPassword-error")
    WebElement confirmPasswordErrorText;

    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationCompleted;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement contineBtn;


    public void verifyRegisterText(String text) throws InterruptedException {
        verifyThatTextIsDisplayed(registerText, text);
        CustomListeners.test.log(Status.PASS,"Verify Register Text " + text);
    }

    public void selectGender(String text) {
        clickOnElement(gender);
        CustomListeners.test.log(Status.PASS,"Click on Gender " + text);
    }

    public void inputFirstName(String name) {
        sendTextToElement(firstName, name);
        CustomListeners.test.log(Status.PASS,"Enter First name: " + name);
    }

    public void inputLastName(String lname) {
        sendTextToElement(lastName, lname);
        CustomListeners.test.log(Status.PASS,"Enter Last name: " + lname);
    }

    public void inputEmail(String text) {
        sendTextToElement(email, text);
        CustomListeners.test.log(Status.PASS,"Enter Email: " + text);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        selectByVisibleTextFromDropDown(dateOfBirthDay, day);
        CustomListeners.test.log(Status.PASS,"Select day from dropdown for DOB: " + day);

        selectByVisibleTextFromDropDown(dateOfBirthMonth, month);
        CustomListeners.test.log(Status.PASS,"Select month from dropdown for DOB: " + month);

        selectByVisibleTextFromDropDown(dateOfBirthYear, year);
        CustomListeners.test.log(Status.PASS,"Selct year from dropdown for DOB " + year);
    }

    public void inputPassword(String pswd) {
        sendTextToElement(password, pswd);
        CustomListeners.test.log(Status.PASS, "Enter Password: " + pswd);
    }

    public void inputConfirmPassword(String cpassword) {
        sendTextToElement(confirmPassword, cpassword);
        CustomListeners.test.log(Status.PASS, "Enter confirm password " + cpassword);
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
        CustomListeners.test.log(Status.PASS, "Click on Register Button ");

    }

    public void verifyFirstNameReqiredErrorText(String text) {
        verifyThatTextIsDisplayed(firstNameErrorText, text);
        CustomListeners.test.log(Status.PASS, "Verify First name required error is displayed " + text);
    }

    public void verifyLastNameReqiredErrorText(String text) {
        verifyThatTextIsDisplayed(lastNameErrorText, text);
        CustomListeners.test.log(Status.PASS, "Verify Last name required error is displayed " + text);
    }

    public void verifyEmailReqiredErrorText(String text) {
        verifyThatTextIsDisplayed(emailErrorText, text);
        CustomListeners.test.log(Status.PASS, "Verify Email required error is displayed " + text);
    }

    public void verifyPasswordReqiredErrorText(String text) {
        verifyThatTextIsDisplayed(passwordErrorText, text);
        CustomListeners.test.log(Status.PASS, "Verify Password required error is displayed " + text);
    }

    public void verifyConfirmPasswordReqiredErrorText(String text) {
        verifyThatTextIsDisplayed(confirmPasswordErrorText, text);
        CustomListeners.test.log(Status.PASS, "Verify Confirm Password required error is displayed " + text);
    }

    public void verifyRegistrationCompletedText(String text) {
        verifyThatTextIsDisplayed(registrationCompleted, text);
        CustomListeners.test.log(Status.PASS, "Verify registration completed is displayed " + text);
    }

    public void clickOnContinueButton() {
        clickOnElement(contineBtn);
        CustomListeners.test.log(Status.PASS, "Click on continue button ");
    }
}
