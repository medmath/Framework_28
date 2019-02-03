package com.lunch.tests.functional_tests.lunch;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PreviousOrderExportDeleteTests extends TestBase {

    @Test
    public void receivedOrderPrice(){

        extentLogger = report.createTest("Trying to delete a previous order");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Getting past error");
        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to previous order section.");
        pages.lunchHomePage().clickPreviousOrder();

        extentLogger.info("Going to previous order details.");
        pages.getPreviousOrdersPage().orderAtTheTop.click();

        extentLogger.info("Going to action details.");
        pages.getPreviousOrdersPage().actionButton.click();

        extentLogger.info("Verifying delete displayed");
        Assert.assertEquals("Delete",pages.getPreviousOrdersPage().deleteButtonUnderAction.getText());

        extentLogger.info("Deleting the selected product");
        pages.getPreviousOrdersPage().deleteButtonUnderAction.click();

        extentLogger.info("Verifying confirmation message");
        Assert.assertEquals("Are you sure you want to delete this record ?",pages.getPreviousOrdersPage().deleteConfirmationMessage.getText());

        extentLogger.info("Confirmating the delete");
        pages.getPreviousOrdersPage().okConfirmationButton.click();

        extentLogger.info("Verifying the delete is not possible");
        System.out.println(pages.getPreviousOrdersPage().warningMessage.getText());
        Assert.assertEquals("Confirmation",pages.getPreviousOrdersPage().warningMessage.getText());

        extentLogger.pass("Unsuccessful previous order delete test");


    }

    @Test
    public void addExportFilesAtControlAccounts(){
        extentLogger = report.createTest("Add function when exporting at Control Accounts Tab");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Getting past error");
        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Control Accounts section.");
        pages.lunchHomePage().controlAccountsButton.click();

        pages.getControlAccountsPage().invoicingManager.click();

        extentLogger.info("Selecting an order");
        pages.getControlAccountsPage().selectingAnOrder.click();

        pages.getControlAccountsPage().actionButton.click();

        extentLogger.info("Verifying export is displayed");
        Assert.assertEquals("Export",pages.getControlAccountsPage().exportButton.getText());

        pages.getControlAccountsPage().exportButton.click();


        extentLogger.info("Adding information");
        pages.getControlAccountsPage().createdByField.click();
        pages.getControlAccountsPage().addButton.click();
        String crea=pages.getControlAccountsPage().createdByField.getText();




        extentLogger.info("Verifying matching the words");
        Assert.assertEquals(crea,pages.getControlAccountsPage().getCreatedByFieldWhenAdded.getText());



        extentLogger.pass("Add functionality during export files");






    }


}
