package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LunchHomePage {
    public LunchHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(css = "[data-menu='99'] .oe_menu_text")
    public WebElement previousOrderButton;


    @FindBy(linkText = "Employee Payments")
    public WebElement employeePaymentsButton;

    @FindBy(linkText = "Products")
    public WebElement productsButton;

    @FindBy(linkText = "Product Categories")
    public WebElement productCategoriesButton;

    @FindBy(css = ".modal-footer span")
    public WebElement errorOkButton;

    @FindBy(css = "[data-menu='103'] .oe_menu_text")
    public WebElement controlAccountsButton;

    public void clickOkError(){
        errorOkButton.click();
    }

    public void clickEmployeePayments(){
        employeePaymentsButton.click();
    }

    public void clickProducts(){
        productsButton.click();
    }

    public void clickProductCategories(){
        productCategoriesButton.click();
    }

    public void clickPreviousOrder() {
        previousOrderButton.click();
    }

    public void clickControlAccounts() {
        controlAccountsButton.click();
    }

}
