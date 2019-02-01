package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePaymentsPage {

    public EmployeePaymentsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".o_list_buttons [type='button']:nth-of-type(1)")
    public WebElement createButton;
    @FindBy(css = "[name='amount']")
    public WebElement newAmount;
    @FindBy(css = "[name='description']")
    public WebElement description;
    @FindBy(css = ".o_form_buttons_edit [type='button']:nth-of-type(1)")
    public WebElement save;

    @FindBy(css = ".ui-sortable .o_data_row:nth-of-type(10) [type]")
    public WebElement newCheckBox;
    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(2) [data-toggle]")
    public WebElement actionButton;
    @FindBy(css=".o_cp_sidebar li:nth-of-type(1) [href]")
    public WebElement newExport;
    @FindBy(css=".o_field_tree_structure [tabindex='-1']:nth-of-type(10) .o_tree_column")
    public WebElement newUser;
    @FindBy(css=".o_field_tree_structure [tabindex='-1']:nth-of-type(4) .o_tree_column")
    public WebElement newDate;
    @FindBy(css = ".o_field_tree_structure [tabindex='-1']:nth-of-type(1) .o_tree_column")
    public WebElement newExportAmount;
    @FindBy(css=".o_center_panel [type='button']:nth-of-type(1)")
    public WebElement newAdd;
    @FindBy(css = ".o_center_panel [type='button']:nth-of-type(3)")
    public WebElement newRemoveAll;




    public void clickCreate() {
        createButton.click();
    }

    public void addAmount(String amount) {
        newAmount.sendKeys(amount);

    }

    public void addDescription(String newNote) {
        description.sendKeys(newNote);
    }

    public void clickSave() {
        save.click();
    }

    public void selectCheckBox(){
        newCheckBox.click();
    }

    public void clickActionButton(){
        actionButton.click();
    }
    public void clickExport(){
        newExport.click();
    }
    public void clickNewUser(){
        newUser.click();
        newAdd.click();
    }
    public void clickNewDate(){
        newDate.click();
        newAdd.click();
    }
    public void clickNewExportAmount(){
        newExportAmount.click();
        newAdd.click();
    }

    public void clickNewRemoveAll(){
        newRemoveAll.click();
    }
}
