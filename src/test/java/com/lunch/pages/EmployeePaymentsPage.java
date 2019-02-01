package com.lunch.pages;

import com.lunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePaymentsPage {

    public EmployeePaymentsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".o_list_buttons [type='button']:nth-of-type(1)")
    public WebElement createButton;
    @FindBy(css = "[name='amount']")
    public WebElement newAmount;
    @FindBy(css = "[name='description']")
    public WebElement description;
    @FindBy(css = ".o_form_buttons_edit [type='button']:nth-of-type(1)")
    public WebElement save;

    public void clickCreate() {
        createButton.click();
    }

    public void addAmount(String amount) {
        newAmount.sendKeys(amount);

    }

    public void addDescription(String newNote) {
        description.sendKeys(newNote);
    }

    public void clickSave() {
        save.click();
    }

}
