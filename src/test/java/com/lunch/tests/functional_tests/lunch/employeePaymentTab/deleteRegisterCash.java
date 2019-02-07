package com.lunch.tests.functional_tests.lunch.employeePaymentTab;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class deleteRegisterCash extends TestBase {
    @Test
    public void exportCvs() {
        extentLogger = report.createTest("Export already created register cash moves.");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

//        extentLogger.info("Getting past error");
//        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Employee Payments");
        pages.lunchHomePage().employeePaymentsButton.click();

        extentLogger.info("Going to Employee Payments");
        pages.lunchHomePage().employeePaymentsButton.click();

        extentLogger.info("Select checkbox on 01/21/2019");
        pages.getEmployeePaymentsPage().selectCheckBox();

        extentLogger.info("Going to Action");
        pages.getEmployeePaymentsPage().clickActionButton();

        extentLogger.info("Going to delete");
        pages.getEmployeePaymentsPage().clickDelete();

        extentLogger.info("Clicking Ok");
        driver.findElement(By.cssSelector(".modal-footer [type='button']:nth-of-type(1) span"));

        extentLogger.pass("Successful Delete Test");

    }
}
