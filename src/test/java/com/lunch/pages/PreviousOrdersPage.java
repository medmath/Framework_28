package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreviousOrdersPage {
    public PreviousOrdersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".ui-sortable .o_data_row:nth-of-type(1) .o_readonly_modifier:nth-of-type(5)")
    public WebElement orderAtTheTop;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(3) [data-toggle]")
    public WebElement actionButton;

    @FindBy(css = ".o_cp_sidebar div:nth-of-type(3) li:nth-of-type(1) [href]")
    public WebElement deleteButtonUnderAction;

    @FindBy(css = ".modal-body")
    public WebElement deleteConfirmationMessage;

    @FindBy(css = ".modal-footer [type='button']:nth-of-type(1) span")
    public WebElement okConfirmationButton;

    @FindBy(css = ".modal-title")
    public WebElement warningMessage;

}
