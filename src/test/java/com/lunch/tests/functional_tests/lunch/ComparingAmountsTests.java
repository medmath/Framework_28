package com.lunch.tests.functional_tests.lunch;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparingAmountsTests extends TestBase {

    @Test
    public void compareAmountsTest() throws InterruptedException {
        extentLogger = report.createTest("Compare the total amounts of the accounts");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Getting past error");
        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Control Accounts section.");
        pages.lunchHomePage().controlAccountsButton.click();


        extentLogger.info("Getting total amount");
        Double amount = pages.getControlAccountsPage().sumAccountsDisplayedAccount();
        String totalAmount1=pages.getControlAccountsPage().totalAmount.getText();
        String str=totalAmount1.replaceFirst(",","");
        Double totalAmount=Double.parseDouble(str);

        extentLogger.info("Verifying the total amounts equal");
        Assert.assertEquals(amount,totalAmount);

        extentLogger.pass("Succesfull compare amount test");
    }
}
