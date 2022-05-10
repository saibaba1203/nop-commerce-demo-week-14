package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsPage extends Utility {
    public DesktopsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Desktops')]")
    WebElement desktopText;

    @FindBy(id = "products-orderby")
    WebElement sortBy;

    @FindBy(id = "products-pagesize")
    WebElement displayBy;

    @FindBy(xpath = "//a[contains(text(),'List')]")
    WebElement selectProductList;

    @FindBy(xpath = "//div[@class='picture']")
    WebElement selectProduct;


    public void verifyDesktopText(){
        verifyThatTextIsDisplayed(desktopText, "Desktops");
        CustomListeners.test.log(Status.PASS,"Verify desktop text is displayed ");
    }

    public void clickOnSortBy(){
        clickOnElement(sortBy);
        CustomListeners.test.log(Status.PASS,"Click on Sort By dropdown");
    }

    public void clickOnDisplayBy(){
        clickOnElement(displayBy);
        CustomListeners.test.log(Status.PASS,"Click on display by dropdown");
    }

    public void clickOnProductList(){
        clickOnElement(displayBy);
        CustomListeners.test.log(Status.PASS,"Click on product list ");
    }

    public void selectProductFromDesptopPage(String product){
        clickOnElement(selectProduct);
        CustomListeners.test.log(Status.PASS,"Select product from desktop page " + product);
    }

}
