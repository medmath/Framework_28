package com.lunch.tests.functional_tests.lunch.PreviousPage;

import com.lunch.utilities.BrowserUtils;
import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

public class deleteLastOrder extends TestBase {

    @Test
    public void deleteLast(){
        extentLogger=report.createTest("Delete Checkbox Item");

        extentLogger.info("Logging to application");
        pages.login().login(ConfigurationReader.getProperty("mailManager"),ConfigurationReader.getProperty("passwordManager"));

        extentLogger.info("Going to lunch page");
        pages.login().clickLunchButton();

        pages.lunchHomePage().clickOkError();

        extentLogger.info("Going to Previous Orders section.");
        pages.lunchHomePage().clickPreviousOrder();

        BrowserUtils.wait(10);

        List<WebElement> yourOrderTable = driver.findElements(By.cssSelector("[class='ui-sortable'] tr"));
        int count=yourOrderTable.size();
        System.out.println(count);

        //TODO finish it
//        WebElement lastItem=driver.findElement(By.cssSelector(".ui-sortable .o_data_row:nth-of-type("+count+") input"));
 //       lastItem.click();


        extentLogger.info("Select last order");
        pages.getPreviousOrdersPage().lastOrderCheckBox.click();

        extentLogger.pass("Success");

    }
}
