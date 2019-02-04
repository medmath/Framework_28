package com.lunch.tests.functional_tests.lunch;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class UploadCvsTest extends TestBase {

    @Test
    public void UpLoadTest(){
        extentLogger = report.createTest("Add function when exporting at Control Accounts Tab");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

//        extentLogger.info("Getting past error");
//        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Control Accounts section.");
        pages.lunchHomePage().controlAccountsButton.click();


        extentLogger.info("Going to import");
        pages.getControlAccountsPage().importButton.click();

        extentLogger.info("Sending path and uploading");
        String path= "/Users/vedat/Documents/lunch.cashmove 1.csv";
        pages.getControlAccountsPage().uploadFilePath.sendKeys(path);
        pages.getControlAccountsPage().loadFileButton.click();

        extentLogger.pass("Succesfull upload test");


    }


}
