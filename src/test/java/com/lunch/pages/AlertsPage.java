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

    public boolean checkAllSelected(){
        for (int i = 1; i <=5 ; i++) {
            if(!Driver.getDriver().findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type("+i+") [type]")).isSelected())
                return false;

        }
        return true;
    }

}
