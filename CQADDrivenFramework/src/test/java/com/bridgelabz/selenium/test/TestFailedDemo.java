package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.TestNGListener.IReporterListener;
import com.bridgelabz.selenium.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(IReporterListener.class)
public class TestFailedDemo  extends BaseClass {

    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
    }

    @Test
    public void testPass(){
        Assert.assertTrue(true);
    }

    @Test
    public void  testFailed(){
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "testPass")
    public void  testDepends(){
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void browserClose(){
        tearDown();
    }
}