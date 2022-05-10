package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Log in")
    WebElement getLoginLink;

    @FindBy(linkText = "Register")
    WebElement getRegisterLink;

    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement getNopCommerceLogo;

    @FindBy(xpath = "//a[contains(text(),'My account')]")
    WebElement getmyAccountLink;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement getlogoutLink;



    public void clickOnLoginLink() {
//        Reporter.log("Clicking on login link " + getLoginLink.toString() + "<br>");
        clickOnElement(getLoginLink);
        CustomListeners.test.log(Status.PASS,"Click on Login In link ");
    }

    public void clickOnRegisterLink() {
//        Reporter.log("Clicking on register link " + getRegisterLink.toString() + "<br>");
        clickOnElement(getRegisterLink);
        CustomListeners.test.log(Status.PASS,"Click on Register link ");
    }

    public void verifyNopCommerceLogoVisible(){
        verifyLogoVisible(getNopCommerceLogo);
        CustomListeners.test.log(Status.PASS,"Verify Nop Commerce logo is visible ");
    }

    public void clickOnLogoutLink(){
        clickOnElement(getlogoutLink);
        CustomListeners.test.log(Status.PASS,"Click on Logout link ");
    }

    public void verifyLogoutlinkVisible(){
        verifyThatElementIsDisplayed(getlogoutLink);
        CustomListeners.test.log(Status.PASS,"Verify that Logout link is visible ");
    }

    public void verifyLoginLinkVisible(){
        verifyThatElementIsDisplayed(getLoginLink);
        CustomListeners.test.log(Status.PASS,"Verify Login Link Visible ");
    }


    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@class='header-menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }
}
