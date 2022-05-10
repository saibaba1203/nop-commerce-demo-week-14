package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuildYourOwnComputerPage extends Utility {
    public BuildYourOwnComputerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement buildYourOwnComputerText;

    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement processorDropdown;

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ramDropdown;

    @FindBy(xpath = "//input[@name='product_attribute_3']")
    WebElement selectHdd;

    @FindBy(xpath = "//input[@name='product_attribute_4']")
    WebElement selectOperatingSystem;

    @FindBy(xpath = "//input[@name='product_attribute_5']")
    WebElement selectSoftware;

    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartButton;

    @FindBy(xpath = "//p[contains(.,'The product has been added to your shopping cart')]")
    WebElement productAddedToCartMessage;


    public void verifyBuildYourComputerText(String text) {
        verifyThatTextIsDisplayed(buildYourOwnComputerText, text);
        CustomListeners.test.log(Status.PASS,"Verify 'Build your own computer' message " + text);
    }

    public void selectProcessorFromDropdown(String processor) {
        selectByVisibleTextFromDropDown(processorDropdown, processor);
        CustomListeners.test.log(Status.PASS,"Select processor from dropdown: " + processor);
    }

    public void selectRamFromDropdown(String ram) {
        selectByVisibleTextFromDropDown(ramDropdown, ram);
        CustomListeners.test.log(Status.PASS,"Select RAM from dropdown: " + ram);
    }

    public void selectHdd(String hdd) {
        clickOnElement(selectHdd);
        CustomListeners.test.log(Status.PASS,"Selct HDD: " + hdd);
    }

    public void selectOperatingSystem(String os){
        clickOnElement(selectOperatingSystem);
        CustomListeners.test.log(Status.PASS,"Select operating system " + os);
    }

    public void selectSoftware(String software){
        clickOnElement(selectSoftware);
        CustomListeners.test.log(Status.PASS,"Select Software " + software);

    }

    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS,"Click on Add to cart button ");
    }

    public void verifyProductAddedToCartMessage(String text){
        verifyThatTextIsDisplayed(productAddedToCartMessage, text);
        CustomListeners.test.log(Status.PASS,"Verify product added top cart message " + text);
    }


    public void buildConfigurationFromList(String processor, String ram, String hdd, String os, String software){
        selectByVisibleTextFromDropDown(processorDropdown, processor);
        CustomListeners.test.log(Status.PASS,"Select processor from dropdown: " + processor);

        selectByVisibleTextFromDropDown(ramDropdown, ram);
        CustomListeners.test.log(Status.PASS,"Select RAM from dropdown: " + ram);

        clickOnElement(selectHdd);
        CustomListeners.test.log(Status.PASS,"Selct HDD: " + hdd);

        clickOnElement(selectOperatingSystem);
        CustomListeners.test.log(Status.PASS,"Select operating system " + os);

        clickOnElement(selectSoftware);
        CustomListeners.test.log(Status.PASS,"Select Software " + software);
    }


}
