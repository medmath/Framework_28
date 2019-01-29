package com.lunch.tests.smoke_tests;

import com.lunch.utilities.ConfigurationReader;
import com.lunch.utilities.TestBase;
import org.testng.annotations.Test;

public class Test1_Try extends TestBase {

    @Test
    public void test1(){
        pages.login().login(ConfigurationReader.getProperty("mailManager"), ConfigurationReader.getProperty("passwordManager"));
    }



}
