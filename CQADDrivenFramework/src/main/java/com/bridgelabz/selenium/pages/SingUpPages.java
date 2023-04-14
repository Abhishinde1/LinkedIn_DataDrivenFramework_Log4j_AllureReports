package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.readexcel.ReadPropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingUpPages extends ReadPropertiesFile {
    WebDriver driver;
    @FindBy(linkText = "Join now")
    WebElement signUpLink;

    public SingUpPages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void gotoSignUp() throws InterruptedException {

        signUpLink.click();
        driver.findElement(By.name(properties.getProperty("signUpMobileField"))).sendKeys(properties.getProperty("signUpEmailText"));
        Thread.sleep(1000);
    }

}