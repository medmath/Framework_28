package com.lunch.tests.functional_tests.lunch.Alerts;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteAlertsTest extends TestBase {

    @Test
    public void deleteAlertsTest(){
        WebDriverWait wait = new WebDriverWait(driver, 5);

        extentLogger = report.createTest("Alerts Page check list check ");

        extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        extentLogger.info("Getting past error");
        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Alerts section.");
        pages.lunchHomePage().alertsPageButton.click();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        for (int i=0; i<20; i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }

        List<WebElement> productsTable = driver.findElements(By.cssSelector("[class='ui-sortable'] tr"));

        int count = productsTable.size();

        String initialCount = driver.findElement(By.cssSelector(".o_pager_limit")).getText();


        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-sortable .o_data_row:nth-of-type("+count+") [type]")));

        WebElement lastItemCheckbox = driver.findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type("+count+") [type]"));

        lastItemCheckbox.click();

        pages.getAlertsPage().deleteFromAction();


        String finalCount = driver.findElement(By.cssSelector(".o_pager_limit")).getText();


        Assert.assertNotEquals(finalCount, initialCount);



    }
}
