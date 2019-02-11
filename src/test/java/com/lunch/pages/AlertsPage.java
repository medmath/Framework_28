package com.lunch.pages;

import com.lunch.utilities.Driver;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends TestBase {
    public AlertsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "thead [type]")
    public WebElement checkListAllButton;

    @FindBy(css = ".ui-sortable .o_data_row:nth-of-type(1) [type]")
    public WebElement firstCheckButton;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(2) [data-toggle]")
    public WebElement ActionButton;

    @FindBy(css = ".o_cp_sidebar li:nth-of-type(1) [href]")
    public WebElement exportButton;

    @FindBy(css = ".o_field_tree_structure [tabindex='-1']:nth-of-type(1) .o_tree_column")
    public WebElement activeField;
    
    @FindBy(css = ".o_center_panel [type='button']:nth-of-type(1)")
    public WebElement addField;

    @FindBy(css = ".modal-footer [type='button']:nth-of-type(1) span")
    public WebElement exportToFileButton;

    @FindBy(css = ".modal-footer [type='button']:nth-of-type(2) span")
    public WebElement closeButton;

    @FindBy(css = ".o_list_buttons [type='button']:nth-of-type(1)")
    public WebElement createButton;

    @FindBy(css = "[name='message']")
    public  WebElement descriptionBox;

    @FindBy(css = ".o_form_buttons_edit [type='button']:nth-of-type(1)")
    public WebElement saveButton;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(2) [data-toggle]")
    public WebElement actionButton;

    @FindBy(linkText = "Delete")
    public WebElement deleteButton;

    @FindBy(css = ".modal-footer [type='button']:nth-of-type(1)")
    public WebElement okDelete;

    @FindBy(css = ".modal-footer [type='button']:nth-of-type(1)")
    public WebElement differentView;


    public void clickCreate(){
        createButton.click();
    }

    public void clickDescriptionBox(){
        descriptionBox.click();
    }

    public void clickSaveButton(){
        saveButton.click();
    }

    public void deleteFromAction(){
        actionButton.click();
        deleteButton.click();
        okDelete.click();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){}

    }

    public void clickDifferentView(){
        differentView.click();
    }



    public boolean checkAllSelected(){
        for (int i = 1; i <=5 ; i++) {
            if(!Driver.getDriver().findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type("+i+") [type]")).isSelected())
                return false;

        }
        return true;
    }

    public void setAddField(){
        for (int i = 1; i < 10; i++) {
            Driver.getDriver().findElement(By.cssSelector(".o_field_tree_structure [tabindex='-1']:nth-of-type("+i+") .o_tree_column")).click();
            addField.click();
            
        }
    }

}
