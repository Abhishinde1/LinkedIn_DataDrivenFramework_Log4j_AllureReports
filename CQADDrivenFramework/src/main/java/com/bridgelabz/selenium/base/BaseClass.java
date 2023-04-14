package com.bridgelabz.selenium.base;

import com.bridgelabz.selenium.readexcel.ReadPropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import static java.awt.SystemColor.info;

public class BaseClass extends ReadPropertiesFile {
    public static WebDriver driver;

    static Logger log = Logger.getLogger(BaseClass.class.getName());

    public void initialization(String browserName) {
        PropertyConfigurator.configure("C:\\Users\\Shree\\Downloads\\CQADDrivenFramework\\log4j.properties");
        BasicConfigurator.configure();
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(properties.getProperty("App_Url"));
            log.info("chrome browser open Sucessfully");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get(properties.getProperty("App_Url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    public void tearDown() {
        driver.close();
    }

    public static void takeScreenShot(String methodN) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File("C:\\Users\\Shree\\Desktop\\Bridgelabz Testing Assignment\\LinkedIn_DataDrivenFramework_Log4j_AllureReports\\CQADDrivenFramework\\ScreenShot"+methodN+".png") ;
        FileUtils.copyFile(src,file);
    }
}
