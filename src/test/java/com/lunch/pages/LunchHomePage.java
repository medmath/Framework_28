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



}
