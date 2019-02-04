package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    public AlertsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "[data-menu='107']")
    public WebElement checkListAllButton;



}
