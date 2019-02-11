package com.lunch.tests.functional_tests.lunch.Alerts;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateAlertsTest extends TestBase {

    @Test
    public void newAlertTest() {
        extentLogger = report.createTest("Alerts Page check list check ");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Getting past error");
        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Alerts section.");
        pages.lunchHomePage().alertsPageButton.click();

        pages.getAlertsPage().clickCreate();

        driver.findElement(By.cssSelector("[name='message']")).sendKeys("This is a test alert.");

        pages.getAlertsPage().clickSaveButton();

    }

}