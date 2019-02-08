package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrderPage {
    public NewOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".o_lunch_vignette:nth-child(3) [type]")
    public WebElement simpleAddCheeseburger;

    @FindBy(css = ".o_form_buttons_edit [type='button']:nth-of-type(1)")
    public WebElement saveButton;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(3) [data-toggle]")
    public WebElement newOrderAction;

    @FindBy(css = ".o_cp_sidebar li:nth-of-type(1) [href]")
    public WebElement deleteItem;

    @FindBy(css = ".modal-footer [type='button']:nth-of-type(1) span")
    public WebElement areYouSureOK;

    public void clickAddCheeseburger(){
        simpleAddCheeseburger.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteJustMadeItem(){
        clickAction();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickDelete();

        areYouSureOK.click();
    }

    public void clickSave(){
        saveButton.click();
    }

    public void clickAction(){
        newOrderAction.click();
    }

    public void clickDelete(){
        deleteItem.click();
    }

    public void clickOKAreYouSure(){
        areYouSureOK.click();
    }

}
