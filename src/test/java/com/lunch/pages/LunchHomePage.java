package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LunchHomePage {
    public LunchHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


   @FindBy(linkText = "Previous Orders")
    public WebElement previousOrderButton;

    @FindBy(linkText = "Employee Payments")
    public WebElement employeePaymentsButton;

    @FindBy(linkText = "Products")
    public WebElement productsButton;

    @FindBy(linkText = "Product Categories")
    public WebElement productCategoriesButton;

}
