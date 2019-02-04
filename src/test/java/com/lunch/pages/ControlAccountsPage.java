package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(css = ".o_list_buttons [type='button']:nth-of-type(1)")
    public WebElement createNewAccount;

    @FindBy(css = ".o_input_dropdown [type]")
    public WebElement getUsers;

    @FindBy(css = ".o_web_client [tabindex='-1']:nth-of-type(5) a")
    public WebElement CRMManager;

    @FindBy(css = ".datepicker-days tr:nth-of-type(6) .new:nth-of-type(6)")
    public WebElement selectDate;

    @FindBy(css = "tr:nth-of-type(2) [type]")
    public WebElement clickDate;

    @FindBy(css = "[name='amount']")
    public WebElement amount1;

    @FindBy(css="[name='description']")
    public WebElement description1;

    @FindBy(css = ".o_form_buttons_edit [type='button']:nth-of-type(1)")
    public WebElement saveButton;

    @FindBy(css = "tbody .o_group_has_content:nth-of-type(2) .o_group_name")
    public WebElement CRM_ManagerText;

    @FindBy(css = "tbody .o_group_has_content:nth-of-type(2) .o_list_number")
    public WebElement secondAmount;

    @FindBy(css = "[title='Total']")
    public WebElement totalAmount;

    public void setCreateNewAccount(String amount, String decription){
        amount1.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        amount1.sendKeys(amount);

        description1.sendKeys(decription);

    }

    public void selectingUser(){
       new Actions(Driver.getDriver()).moveToElement(CRMManager).perform();
       CRMManager.click();
    }

    public void selectingDate(){
        clickDate.click();
        new Actions(Driver.getDriver()).moveToElement(selectDate).perform();
        selectDate.click();
    }

    public int findAddedAccount(){
        String CrmLinkText = CRM_ManagerText.getText();
        String number = CrmLinkText.substring(19);
        number= number.substring(0, number.length()-1);
        int a=Integer.parseInt(number);

        return a;

    }

    public String addedAmount(int x){
       return Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody[2]/tr['+x+']/td[6]")).getText();
    }

    public double sumAccountsDisplayedAccount() throws InterruptedException {
        double totalAccounts=0.0;
        for (int i = 1; i <=6 ; i++) {
            WebElement account = Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr["+i+"]/td[5]"));
           //Thread.sleep(1000);
            totalAccounts+=Double.parseDouble(account.getText().replaceFirst(",",""));
        }
        return totalAccounts;
    }

}
