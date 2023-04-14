package com.bridgelabz.selenium.readexcel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    String filePath = "C:\\Users\\Shree\\Desktop\\Bridgelabz Testing Assignment\\LinkedIn_DataDrivenFramework_Log4j_AllureReports\\CQADDrivenFramework\\src\\main\\resources\\testData.properties";
    public Properties properties;
    BufferedReader reader;

    {
        try {
            reader = new BufferedReader(new FileReader(filePath));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
