package com.lunch.pages;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.DriverManager;

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

    @FindBy( css = "[data-menu='94'] .oe_menu_text")
    public WebElement lunchButton;

    //@FindBy(xpath = "//*[@id='modal_9']/div/div/div[3]/button/span")
    @FindBy(xpath = "//*[.='Ok']")
    public WebElement popUpOkButton;


    public void login(String mail, String pass){
        britDemo.click();
        email.sendKeys(mail);
        password.sendKeys(pass);
        loginButton.click();

    }

    /* FIXME
    * Figure out a way to make this explicit wait or at least something that's not Thread.sleep
    * The problem is that there is a loading button overlay that gets in the way of the lunch button,
    * so selenium can't fix it. Its not that important now but it might become a problem in the future
    * if we add a lot of stuff to this site.
    */

    public void clickLunchButton(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lunchButton.click();
    }

    public void open(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


}
