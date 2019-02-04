package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ControlAccountsPage {
    public ControlAccountsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "tbody .o_group_has_content:nth-of-type(2) .o_group_name")
    public WebElement invoicingManager;

    @FindBy(css = ".o_data_row:nth-of-type(1) [type]")
    public WebElement selectingAnOrder;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(2) [data-toggle]")
    public WebElement actionButton;

    @FindBy(css = ".o_cp_sidebar li:nth-of-type(1) [href]")
    public WebElement exportButton;

    @FindBy(css = ".o_import_compat div:nth-of-type(2) [name]")
    public WebElement exportAllData;

    @FindBy(css = ".modal-footer [type='button']:nth-of-type(1) span")
    public WebElement exportToFile;

    @FindBy(css = ".o_field_tree_structure [tabindex='-1']:nth-of-type(2) .o_tree_column")
    public WebElement createdByField;

    @FindBy(css = ".o_field_tree_structure [tabindex='-1']:nth-of-type(12) .o_tree_column")
    public  WebElement orderField;

    @FindBy(css = ".o_field_tree_structure [tabindex='-1']:nth-of-type(13) .o_tree_column")
    public WebElement userField;

    @FindBy(css = ".o_center_panel [type='button']:nth-of-type(1)")
    public WebElement addButton;

    @FindBy(css = "[value='user_id\\/id']")
    public WebElement getUserFieldWhenAdded;

    @FindBy(css = "[value='create_uid\\/id']")
    public WebElement getCreatedByFieldWhenAdded;

    @FindBy(css = ".o_list_buttons [type='button']:nth-of-type(2)")
    public WebElement importButton;

    @FindBy(css = "[placeholder='No file chosen\\.\\.\\.']")
    public WebElement uploadFilePath;

    @FindBy(css = "[for='my-file-selector']")
    public WebElement loadFileButton;







}
