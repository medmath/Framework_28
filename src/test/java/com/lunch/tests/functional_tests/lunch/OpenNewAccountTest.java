package com.lunch.tests.functional_tests.lunch;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends TestBase {

    @Test
    public void openNewAccount() throws InterruptedException {
        extentLogger = report.createTest("Add function when exporting at Control Accounts Tab");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

//        extentLogger.info("Getting past error");
//        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Control Accounts section.");
        pages.lunchHomePage().controlAccountsButton.click();

        extentLogger.info("Creating New Account section.");
        pages.getControlAccountsPage().createNewAccount.click();

        extentLogger.info("Entering the values");
        pages.getControlAccountsPage().getUsers.click();
        Thread.sleep(2000);
        pages.getControlAccountsPage().selectingUser();


        pages.getControlAccountsPage().selectingDate();
        pages.getControlAccountsPage().setCreateNewAccount("65.00","New Account opened");

        extentLogger.info("Saving new account details");
        pages.getControlAccountsPage().saveButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("65.00",pages.getControlAccountsPage().amount1.getText());

        extentLogger.pass("Succesfull opening a new account");

    }

    @Test
    public void verifyingNewAccount() throws InterruptedException {
        extentLogger = report.createTest("Add function when exporting at Control Accounts Tab");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

//        extentLogger.info("Getting past error");
//        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Control Accounts section.");
        pages.lunchHomePage().controlAccountsButton.click();

        extentLogger.info("Getting the account count");
        int a=pages.getControlAccountsPage().findAddedAccount();

        extentLogger.info("Creating New Account section.");
        pages.getControlAccountsPage().createNewAccount.click();

        extentLogger.info("Entering the values");
        pages.getControlAccountsPage().getUsers.click();
        Thread.sleep(2000);
        pages.getControlAccountsPage().selectingUser();


        pages.getControlAccountsPage().selectingDate();
        pages.getControlAccountsPage().setCreateNewAccount("88.88","New Account opened");

        extentLogger.info("Saving new account details");
        pages.getControlAccountsPage().saveButton.click();
        Thread.sleep(2000);

        extentLogger.info("Going to Control Accounts ");
        pages.lunchHomePage().controlAccountsButton.click();

        extentLogger.info(("Getting the account count"));
        int b=pages.getControlAccountsPage().findAddedAccount();

        extentLogger.info("Verifying number of account");
        Assert.assertEquals(b-a,1);

        extentLogger.pass("Succesfull verifying of new account");

    }


    @Test
    public void verifyingNewAccountAmount() throws InterruptedException {
        extentLogger = report.createTest("Add function when exporting at Control Accounts Tab");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

//        extentLogger.info("Getting past error");
//        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Control Accounts section.");
        pages.lunchHomePage().controlAccountsButton.click();

        extentLogger.info("Creating New Account section.");
        pages.getControlAccountsPage().createNewAccount.click();

        extentLogger.info("Entering the values");
        pages.getControlAccountsPage().getUsers.click();
        Thread.sleep(2000);
        pages.getControlAccountsPage().selectingUser();

        pages.getControlAccountsPage().selectingDate();
        pages.getControlAccountsPage().setCreateNewAccount("61.00","New Account opened");

        extentLogger.info("Saving new account details");
        pages.getControlAccountsPage().saveButton.click();
        Thread.sleep(2000);

        extentLogger.info("Going to Control Accounts ");
        pages.lunchHomePage().controlAccountsButton.click();

        extentLogger.info(("Getting the account count"));
        int b=pages.getControlAccountsPage().findAddedAccount();
        System.out.println("b: "+ b);
        pages.getControlAccountsPage().CRM_ManagerText.click();

        Thread.sleep(2000);
        extentLogger.info("Getting the added amount");
        String amount = pages.getControlAccountsPage().addedAmount(b);
        System.out.println(amount);
        extentLogger.info("Verifying equality of amounts");
        Assert.assertEquals("61.00", amount);

        extentLogger.pass("Succesfull verifying new account");
    }

}
