package com.lunch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LunchHomePage {

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[13]/ul[1]/li[2]/a/span")
    public WebElement previousOrderButton;

}
