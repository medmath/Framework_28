package com.lunch.tests.functional_tests.lunch;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.testng.annotations.Test;

public class AlertsTest extends TestBase {
    @Test
    public void checkAllButton(){
        extentLogger = report.createTest("Alerts Page check list check ");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

//        extentLogger.info("Getting past error");
//        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Alerts section.");
        pages.lunchHomePage().alertsPageButton.click();


        pages.getAlertsPage().checkListAllButton.click();
    }
}
