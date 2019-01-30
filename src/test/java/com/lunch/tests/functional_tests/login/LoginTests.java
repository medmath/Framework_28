package com.lunch.tests.functional_tests.login;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class LoginTests extends TestBase {

    @Test
    public void test1(){

        extentLogger = report.createTest("Positive Login Test as a Manager");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));


        extentLogger.info("Verifying title of pages");
        Assert.assertEquals(driver.getTitle(),"Odoo");

        extentLogger.pass("Positive Login Test as a Manager");
    }

    @Test
    public void test2(){
        extentLogger = report.createTest("Positive Login Test as a User");

        extentLogger.info("Logging to the application");

        pages.login().login(ConfigurationReader.getProperty("mailUser"), ConfigurationReader.getProperty("passwordUser"));

        extentLogger.pass("Positive Login Test as a User");
    }

}

