package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerPage extends Utility {
    public ComputerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computersText;

    @FindBy(xpath = "//img[@title='Show products in category Desktops']")
    WebElement desktopLink;

    @FindBy(xpath = "//img[@title='Show products in category Notebooks']")
    WebElement notebooksLink;

    @FindBy(xpath = "//img[@title='Show products in category Software']")
    WebElement softwareLink;



    public void verifyComputerText(String text){
        verifyThatTextIsDisplayed(computersText, "Computers");
        CustomListeners.test.log(Status.PASS,"Verify Computer text " + text);
    }

    public void clickOnDesktopLink(){
        clickOnElement(desktopLink);
        CustomListeners.test.log(Status.PASS,"Click on desktop link ");
    }

    public void clickOnNotebooksLink(){
        clickOnElement(notebooksLink);
        CustomListeners.test.log(Status.PASS,"Click on notebooks link ");
    }

    public void clickOnSoftwareLink(){
        clickOnElement(softwareLink);
        CustomListeners.test.log(Status.PASS,"Click on software link ");
    }

}
