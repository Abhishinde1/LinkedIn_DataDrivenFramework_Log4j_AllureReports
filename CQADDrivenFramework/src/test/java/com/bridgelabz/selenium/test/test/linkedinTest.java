package com.bridgelabz.selenium.test.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.Dashboard;
import com.bridgelabz.selenium.pages.LoginPage;
import com.bridgelabz.selenium.readexcel.DataProviderLogic;
import org.testng.annotations.*;

public class linkedinTest extends BaseClass {
    LoginPage loginPage;
    Dashboard dashboard;

    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
    }

    @Test(dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
    public void loginToLinkedin(String userName, String Password) throws InterruptedException {
        loginPage.loginToLinkedIn(userName, Password);

    }

    @AfterMethod
    public void browserClose() {
        tearDown();
    }
}
