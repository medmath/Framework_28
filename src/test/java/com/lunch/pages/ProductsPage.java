package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.security.Key;

public class ProductsPage {
    public ProductsPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".o_list_buttons [type='button']:nth-of-type(1)")
    private WebElement createButton;

    @FindBy(css = ".o_list_buttons [type='button']:nth-of-type(2)")
    private WebElement importButton;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(2) [data-toggle]")
    public WebElement actionButton;

    @FindBy(css = "[name='name']")
    public WebElement newProductName;

    @FindBy(css = "[name='category_id'] input")
    public WebElement newProductCategory;

    @FindBy(css = "[name='supplier'] input")
    public WebElement newProductVendor;

    @FindBy(css = "[name='price']")
    public WebElement newProductPrice;

    @FindBy(css = "[name='description']")
    public WebElement newProductDescription;

    @FindBy(css = ".o_form_buttons_edit [type='button']:nth-of-type(1)")
    public WebElement newProductSave;

    @FindBy(css = ".o_web_client [tabindex='0']:nth-child(5) [tabindex='-1']:nth-of-type(1) a")
    public WebElement categorySandwich;

    public void clickCreateButton(){
        createButton.click();
    }

    public void clickImportButton(){
        importButton.click();
    }

    public void clickActionButton(){
        actionButton.click();
    }

    public void clickSaveButton(){
        newProductSave.click();
    }

    //Allows for creating a new product
    public void createNewProduct(String name, String price, String description, String vendor){
        newProductName.sendKeys(name);
        newProductPrice.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        newProductPrice.sendKeys(price);
        newProductDescription.sendKeys(description);
        newProductVendor.sendKeys(vendor, Keys.ENTER);
        newProductCategory.click();
        categorySandwich.click();

    }

}
