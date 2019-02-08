package com.lunch.tests.functional_tests.lunch.ProductCategories;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.Driver;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductCategoryTests extends TestBase {

    @Test
    public void createProductCategory(){
        extentLogger = report.createTest("Create new product category test");

        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        pages.login().clickLunchButton();

        pages.lunchHomePage().clickOkError();

        pages.lunchHomePage().clickProductCategories();

        //Clicks create button, inputs name as "American", does NOT click save
        pages.getProductCategoriesPage().createNewProductCategory("American");

        String beforeIndicator = driver.findElement(By.cssSelector(".breadcrumb li:nth-of-type(2)")).getText();

        pages.getProductCategoriesPage().clickSave();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.titleContains("American"));

        String afterIndicator = driver.findElement(By.cssSelector(".breadcrumb li:nth-of-type(2)")).getText();

        Assert.assertNotEquals(afterIndicator, beforeIndicator);

    }

    @Test
    public void deleteProductCategory(){
        extentLogger = report.createTest("Delete last item in product categories");

        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        pages.login().clickLunchButton();

        pages.lunchHomePage().clickOkError();

        pages.lunchHomePage().clickProductCategories();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        JavascriptExecutor js = (JavascriptExecutor)driver;

        for (int i=0; i<10; i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }


        List<WebElement> productsTable = driver.findElements(By.cssSelector("[class='ui-sortable'] tr"));

        int count = productsTable.size();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-sortable .o_data_row:nth-of-type("+count+") [type]")));

        WebElement lastItemCheckbox = driver.findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type("+count+") [type]"));

        lastItemCheckbox.click();

        pages.getProductCategoriesPage().clickMainPageAction();

        wait.until(ExpectedConditions.elementToBeClickable(pages.getProductCategoriesPage().mainPageDelete));

        pages.getProductCategoriesPage().clickMainPageDelete();

        wait.until(ExpectedConditions.elementToBeClickable(pages.getProductCategoriesPage().deleteOK));

        pages.getProductCategoriesPage().clickOKDelete();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-content")));

        driver.findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type(13) .o_required_modifier")).click();

        String finalCount = driver.findElement(By.cssSelector(".o_pager_limit")).getText();

        String earlierCount = String.valueOf(count);

        System.out.println(finalCount + " " + earlierCount);

        Assert.assertNotEquals(count, finalCount);




    }
}
