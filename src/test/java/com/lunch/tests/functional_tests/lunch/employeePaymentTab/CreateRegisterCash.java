package com.lunch.tests.functional_tests.lunch.employeePaymentTab;

import com.lunch.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.testng.annotations.Test;

    public class CreateRegisterCash extends TestBase {
        @Test
        public void CreateRegister(){
            extentLogger=report.createTest("Create Register Test");
            pages.login().login(ConfigurationReader.getProperty("mailManager"),ConfigurationReader.getProperty("passwordManager"));

            extentLogger.info("Going to lunch page");
            pages.login().clickLunchButton();

            extentLogger.info("Getting past error");
            pages.lunchHomePage().clickOkError();

            extentLogger.info("Going to Employee Payments");
            pages.lunchHomePage().employeePaymentsButton.click();

            extentLogger.info("Going to Create ");
            pages.getEmployeePaymentsPage().clickCreate();

            extentLogger.info("Adding amount:$50");
            pages.getEmployeePaymentsPage().newAmount.clear();
            pages.getEmployeePaymentsPage().addAmount("50.00");

            extentLogger.info("Description note");
            pages.getEmployeePaymentsPage().addDescription("Payment for lunch");

            extentLogger.info("Going to Save");
            pages.getEmployeePaymentsPage().clickSave();

            //waiting to visible on page
            WebElement noteOnPge=driver.findElement(By.xpath("//span[@class='o_field_text o_field_widget']"));
            BrowserUtils.waitForVisibility(noteOnPge,10);
            //verify to matches
            extentLogger.info("Verify note is display on page");
            String note=driver.findElement(By.cssSelector("[name='description']")).getText();
            Assert.assertEquals(note,"Payment for lunch");

            extentLogger.pass("Successful save register cash");





        }

    }

