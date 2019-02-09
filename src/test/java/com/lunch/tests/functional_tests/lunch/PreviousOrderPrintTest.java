package com.lunch.tests.functional_tests.lunch;

import com.lunch.utilities.BrowserUtils;
import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.Driver;
import com.lunch.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PreviousOrderPrintTest extends TestBase {

    @Test
    public void previousOrderPrintCompare() throws InterruptedException {
        extentLogger = report.createTest("Add function when exporting at Control Accounts Tab");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Getting past error");
        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Previous Orders section.");
        pages.lunchHomePage().clickPreviousOrder();

        extentLogger.info("Selecting orders and returning total price ");
        double addedTotalPrice=pages.getPreviousOrdersPage().setSelectPrint(2);


        pages.getPreviousOrdersPage().printButton.click();
        pages.getPreviousOrdersPage().lunchOrderPrintButton.click();

        extentLogger.info("Canceling report pop-up");
        pages.getPreviousOrdersPage().cancelReportPopUp.click();

        Driver.getDriver().switchTo().frame(pages.getPreviousOrdersPage().iFrame);

        extentLogger.info("Getting total price from invoice print document");
        double invoiceTotalPrice=Double.parseDouble(pages.getPreviousOrdersPage().totalPriceOnInvoice.getText());
        Assert.assertEquals(invoiceTotalPrice,addedTotalPrice);


        extentLogger.info("Verifying user name");
        Assert.assertEquals("Lunch_InvoicingManager",pages.getPreviousOrdersPage().invoiceUser.getText());

        extentLogger.pass("Succesfully compared print fields");


    }

}
