package com.lunch.tests.functional_tests.lunch.Products;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewProduct extends TestBase {

    @Test
    public void NewProduct(){
        extentLogger = report.createTest("Create new product test");

        extentLogger.info("Logging in");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Getting past error");
        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to products section.");
        pages.lunchHomePage().clickProducts();

        extentLogger.info("Starting to create new product");
        pages.getProductsPage().clickCreateButton();


        //creates new product
        extentLogger.info("Entering information for new product");
        pages.getProductsPage().createNewProduct("Olivier Salad", "6.00", "Potato and Ham salad", "Galata Restaurant");

        extentLogger.info("Saving product");
        pages.getProductsPage().clickSaveButton();


        //Waiting here. Trying to make it so it waits for the name of the actual product.

        //FIXME
        //Figure out a way to make this explicit wait, or find a way to do this without Thread.sleep at all!

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extentLogger.info("Getting information and comparing data to see if it was a success");
        String productNameAtTop = driver.findElement(By.cssSelector(".breadcrumb li:nth-of-type(2)")).getText();

        Assert.assertEquals(productNameAtTop, "Olivier Salad");

        extentLogger.pass("Successful product creation test");
    }

}
