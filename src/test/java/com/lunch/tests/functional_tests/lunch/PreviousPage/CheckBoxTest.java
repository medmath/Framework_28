package com.lunch.tests.functional_tests.lunch.PreviousPage;

import com.lunch.utilities.BrowserUtils;
import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends TestBase {

    @Test
    public void checkBoxTest(){
        extentLogger=report.createTest("Checkbox Test");

        extentLogger.info("Logging to application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"),ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Going to Previous Orders section.");
        pages.lunchHomePage().clickPreviousOrder();

        BrowserUtils.wait(10);

        extentLogger.info("Verify Last Order not selected=False");
        Assert.assertTrue(pages.getPreviousOrdersPage().lastOrderCheckBox.isSelected());

        extentLogger.fail("Negative Test");
    }
}
