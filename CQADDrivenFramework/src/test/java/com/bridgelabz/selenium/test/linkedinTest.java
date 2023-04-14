package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.TestNGListener.ITestListenerClass;
import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.Dashboard;
import com.bridgelabz.selenium.pages.LoginPage;
import com.bridgelabz.selenium.pages.SingUpPages;
import com.bridgelabz.selenium.readexcel.DataProviderLogic;
import org.testng.annotations.*;

@Listeners(ITestListenerClass.class)
public class linkedinTest extends BaseClass {
    LoginPage loginPage;
    Dashboard dashboard;

    SingUpPages singUpPages;

    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        singUpPages = new SingUpPages(driver);
    }

    @Test(priority = 1, dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
    //@Parameters({"userName","password"})
    public void loginToLinkedIn(String userName, String password) throws InterruptedException {
        loginPage.loginToLinkedIn(userName,password);
    }

    @Test(priority = 2)
    //@Parameters({"userName","password"})
    public void registrationToLinkedIn() throws InterruptedException {
        singUpPages.gotoSignUp();
        Thread.sleep(500);
    }

    @AfterMethod
    public void browserClose() {
        tearDown();
    }
}
