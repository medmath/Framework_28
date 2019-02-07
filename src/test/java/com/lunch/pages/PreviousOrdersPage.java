package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreviousOrdersPage {
    public PreviousOrdersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".ui-sortable .o_data_row:nth-of-type(1) .o_readonly_modifier:nth-of-type(5)")
    public WebElement orderAtTheTop;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(3) [data-toggle]")
    public WebElement actionButton;

    @FindBy(css = ".o_cp_sidebar div:nth-of-type(3) li:nth-of-type(1) [href]")
    public WebElement deleteButtonUnderAction;

    @FindBy(css = ".modal-body")
    public WebElement deleteConfirmationMessage;

    @FindBy(css = ".modal-footer [type='button']:nth-of-type(1) span")
    public WebElement okConfirmationButton;

    @FindBy(css = ".modal-title")
    public WebElement warningMessage;

    @FindBy(css = ".ui-sortable .o_data_row:nth-of-type(1) input")
    public WebElement selectPreviousFirstOrder;

    @FindBy(css = ".o_cp_sidebar .o_dropdown:nth-of-type(1) [data-toggle]")
    public WebElement printButton;

    @FindBy(css = ".o_cp_sidebar .btn-group:nth-of-type(1) div:nth-of-type(1) [href]")
    public WebElement lunchOrderPrintButton;

    @FindBy(xpath = "//*[@id=\"wrapwrap\"]/main/div[2]/div/table/tbody/tr[1]/td[1]/strong")
    public WebElement invoiceUser;

    @FindBy(css = ".fa-times")
    public WebElement cancelReportPopUp;

    @FindBy(css = ".border-black .text-right span:nth-of-type(1)")
    public WebElement totalPriceOnInvoice;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/iframe")
    public WebElement iFrame;

    @FindBy(css = ".ui-sortable .o_data_row:nth-of-type(1) .o_list_number")
    public WebElement unitPrice;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/ol/li")
    public WebElement yourOrderText;

    @FindBy(css=".ui-sortable .o_data_row:nth-of-type(7) input")
    public WebElement lastOrderCheckBox;

    public double setSelectPrint(int a){
       double price=0.0;
        for (int i = 1; i <=a; i++) {
            WebElement element=Driver.getDriver().findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type("+i+") input"));
            WebElement priceOfElement=Driver.getDriver().findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type("+i+") .o_list_number"));
            element.click();
              price+=Double.parseDouble(priceOfElement.getText());
        }
    return price;
    }


}
