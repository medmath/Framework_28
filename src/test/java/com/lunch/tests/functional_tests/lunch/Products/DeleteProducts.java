package com.lunch.tests.functional_tests.lunch.Products;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteProducts extends TestBase {

    @Test
    public void DeleteProduct(){

        /*
         *This test deletes items from the product page. It goes back one page, selects an item, then deletes it.
         * To verify the test passed, it will compare the number of items on the specific page before deletion and
         * after deletion.
         */
        extentLogger = report.createTest("Delete already created product.");

        extentLogger.info("Logging in..");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page..");
        pages.login().clickLunchButton();

        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to products page..");
        pages.lunchHomePage().clickProducts();

        extentLogger.info("Going back one products page..");
        pages.getProductsPage().clickPreviousProductsButton();

        /*FIXME
        Added another sleep, page changes too quickly, maybe use explicit wait to make sure its on the last page.
         */

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //this turns the rows into a list, with each row being an item. then the number of items in the list is counted.
        List<WebElement> productsTable = driver.findElements(By.cssSelector("[class='ui-sortable'] tr"));
        int count = productsTable.size();

        WebElement lastItem = driver.findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type("+count+") .o_required_modifier:nth-of-type(2)"));

        extentLogger.info("Clicking last item");
        lastItem.click();

        //Getting initial number of products in table
        String initPageLimit = driver.findElement(By.className("o_pager_limit")).getText();

        extentLogger.info("Deleting item");
        pages.getProductsPage().deleteIndivProduct();

        //gets final number of products in table
        String finalPageLimit = driver.findElement(By.className("o_pager_limit")).getText();

        Assert.assertNotEquals(initPageLimit, finalPageLimit);

        extentLogger.pass("Positive deletion test");






    }
}
