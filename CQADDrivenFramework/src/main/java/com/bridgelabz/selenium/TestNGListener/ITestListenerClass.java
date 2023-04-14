package com.bridgelabz.selenium.TestNGListener;

import com.bridgelabz.selenium.base.BaseClass;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ITestListenerClass implements org.testng.ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        String testM = result.getMethod().getMethodName();
        System.out.println("Test Start: "+ testM);
        long startTimeTaken = result.getStartMillis();
        System.out.println("Time taken by "+testM+" is: "+startTimeTaken);

        try {
            BaseClass.takeScreenShot(testM);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        String testM = result.getMethod().getMethodName();
        System.out.println("Test success: "+ testM);
        boolean flag = result.isSuccess();
        Assert.assertEquals(flag,true);

        try {
            BaseClass.takeScreenShot(testM);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        String testM = result.getMethod().getMethodName();
        System.out.println("Test Failed: "+ testM);
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        String testM = result.getMethod().getMethodName();
        System.out.println("Test ignored: "+ testM);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }
}

