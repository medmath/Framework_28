package com.lunch.tests.functional_tests.lunch;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.testng.annotations.Test;

public class PreviousOrderExportDeleteTests extends TestBase {

    @Test
    public void receivedOrderPrice(){

        extentLogger = report.createTest("Verifying order price is same as received order price");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Clicking on Lunch Button");
        pages.login().clickLunchButton();

        pages.login().popUpOkButton.click();


    }


}
