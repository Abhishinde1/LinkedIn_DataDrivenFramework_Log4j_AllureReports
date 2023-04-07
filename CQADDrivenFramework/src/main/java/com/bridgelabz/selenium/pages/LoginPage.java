package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class LoginPage extends BaseClass {

    @FindBy(xpath = "//input[@id='session_key']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='session_password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String loginToLinkedIn(String name, String pass) throws InterruptedException {
        userName.sendKeys(name);
        Thread.sleep(500);
        password.sendKeys(pass);
        Thread.sleep(500);
        signBtn.click();
        Thread.sleep(500);
        String SignInTitle = driver.getTitle();
        return SignInTitle;
    }

    public void loginToLinkedIn1(String name) throws InterruptedException {
        userName.sendKeys(name);
        Thread.sleep(500);
    }
}
