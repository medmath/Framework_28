package com.lunch.tests.functional_tests.lunch;

import com.lunch.utilities.BrowserUtils;
import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.Driver;
import com.lunch.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsTest extends TestBase {
    @Test
    public void checkAllButton() throws InterruptedException {
        extentLogger = report.createTest("Alerts Page check list check ");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

//        extentLogger.info("Getting past error");
//        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Alerts section.");
        pages.lunchHomePage().alertsPageButton.click();

        extentLogger.info("checking all buttons");
        pages.getAlertsPage().checkListAllButton.click();

        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        extentLogger.info("Verifying all checklists selected");
        Assert.assertEquals(pages.getAlertsPage().checkAllSelected(),true);

        extentLogger.pass("Succesfully all checked");


    }

    @Test
    public void exportFunctionality()  {
        extentLogger = report.createTest("Alerts Page check list check ");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

//        extentLogger.info("Getting past error");
//        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Alerts section.");
        pages.lunchHomePage().alertsPageButton.click();

        extentLogger.info("checking all buttons");
        pages.getAlertsPage().checkListAllButton.click();

        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        extentLogger.info("export");
        pages.getAlertsPage().ActionButton.click();
        pages.getAlertsPage().exportButton.click();

        pages.getAlertsPage().activeField.click();
        pages.getAlertsPage().addField.click();
        pages.getAlertsPage().setAddField();



        extentLogger.info("Exporting to file");
        pages.getAlertsPage().exportToFileButton.click();

        extentLogger.info("Closing the export section");

        extentLogger.pass("Succesfully all checked");


    }


}
