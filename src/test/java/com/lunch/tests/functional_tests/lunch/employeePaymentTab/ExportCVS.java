package com.lunch.tests.functional_tests.lunch.employeePaymentTab;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExportCVS extends TestBase {

    @Test
    public void exportCvs(){
        extentLogger=report.createTest("Export already created register cash moves.");
        pages.login().login(ConfigurationReader.getProperty("mailManager"),ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Getting past error");
        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Employee Payments");
        pages.lunchHomePage().employeePaymentsButton.click();

        extentLogger.info("Select checkbox on 01/21/2019");
        pages.getEmployeePaymentsPage().selectCheckBox();

        extentLogger.info("Going to Action");
        pages.getEmployeePaymentsPage().clickActionButton();

        extentLogger.info("Going to Export");
        pages.getEmployeePaymentsPage().clickExport();

        extentLogger.info("Adding User,Date,Amount");
        pages.getEmployeePaymentsPage().clickNewUser();
        pages.getEmployeePaymentsPage().clickNewDate();
        pages.getEmployeePaymentsPage().clickNewExportAmount();

       extentLogger.info("Remove all");
       pages.getEmployeePaymentsPage().clickNewRemoveAll();

       extentLogger.info("Close");
       driver.findElement(By.cssSelector(".modal-footer [type='button']:nth-of-type(2) span")).click();

       String registerCM=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/ol/li")).getText();
        Assert.assertEquals(registerCM,"Register Cash Moves");

    }
}
