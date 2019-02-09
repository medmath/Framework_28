package com.lunch.tests.functional_tests.lunch.NewOrder;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewOrder extends TestBase {

    @Test
    public void NewOrderTest(){
        extentLogger = report.createTest("New Order Smoke Test");

        extentLogger.info("Signing in..");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));


        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Ordering CheeseBurger");
        pages.getNewOrderPage().clickAddCheeseburger();

        String beforeOrder = driver.findElement(By.cssSelector(".breadcrumb li")).getText();


        extentLogger.info("Saving order..");
        pages.getNewOrderPage().clickSave();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String afterOrder =  driver.findElement(By.cssSelector(".breadcrumb li")).getText();

        Assert.assertNotEquals(beforeOrder, afterOrder);

        extentLogger.pass("Passed Positive New Order Test");

        pages.getNewOrderPage().deleteJustMadeItem();

    }

}

