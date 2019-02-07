package com.lunch.tests.functional_tests.lunch.FeelingLucky;

import com.lunch.pages.EmployeePaymentsPage;
import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.Driver;
import com.lunch.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class displayedTest extends TestBase {
       @Test
    public void feelingLuckTest(){
           extentLogger=report.createTest("Feeling Lucky Link Test");

           extentLogger.info("Logging to application");
           pages.login().login(ConfigurationReader.getProperty("mailManager"),ConfigurationReader.getProperty("passwordManager"));

           extentLogger.info("Going to lunch page");
           pages.login().clickLunchButton();

           extentLogger.info("Verify Feeling Lucky displayed");
           Assert.assertEquals("Feeling Lucky",pages.getEmployeePaymentsPage().feelingLucky.getText());
           extentLogger.pass("Success displayed Test");

       }
}
