package com.lunch.tests.functional_tests.lunch.Products;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReorderProductColumns extends TestBase {
    @Test
    public void orderColumnsTest(){
        extentLogger = report.createTest("Reorder Product Columns Test");

        extentLogger.info("Logging in");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Getting past error");
        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to products section.");
        pages.lunchHomePage().clickProducts();

        String firstItem = driver.findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type(1) .o_required_modifier:nth-of-type(2)")).getText();


        pages.getProductsPage().clickProductNameSort();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        for (int i=0; i<10; i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }

        String finalFirstItem = driver.findElement(By.cssSelector("tbody .o_data_row:nth-of-type(1) .o_required_modifier:nth-of-type(2)")).getText();

        Assert.assertNotEquals(firstItem, finalFirstItem);
        extentLogger.pass("Sucessful product column reorder test");
    }
}
