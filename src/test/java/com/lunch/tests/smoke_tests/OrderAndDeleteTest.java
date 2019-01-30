package com.lunch.tests.smoke_tests;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class OrderAndDeleteTest extends TestBase {

    @Test
    public void orderAndDeleteTest(){
        extentLogger = report.createTest("Order and then Delete Test ");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Clicking on Lunch Button");
        pages.login().clickLunchButton();



    }


}
