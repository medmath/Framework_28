package com.lunch.pages;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

   @FindBy(xpath = "/html/body/div[1]/div/div[2]/a[2]")
   public WebElement britDemo;


    @FindBy(id = "db")
    public WebElement database;

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"wrapwrap\"]/main/div/form/div[4]/button")
    public WebElement loginButton;

    @FindBy( xpath = "//*[@id='oe_main_menu_navbar']/div[2]/ul[1]/li[13]/a/span")
    public WebElement lunchButton;

    public void login(String mail, String pass){
        britDemo.click();
        email.sendKeys(mail);
        password.sendKeys(pass);
        loginButton.click();

    }

    public void clickLunchButton(){
        lunchButton.click();
    }

    public void open(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


}
