package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
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
