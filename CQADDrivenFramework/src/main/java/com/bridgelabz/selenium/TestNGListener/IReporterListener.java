package com.bridgelabz.selenium.TestNGListener;

import org.testng.*;
import org.testng.reporters.IReporterConfig;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class IReporterListener implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
//        IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
        for(ISuite suite: suites){
            String suiteName = suite.getName();
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for(ISuiteResult sr : suiteResults.values()){
                ITestContext tc = sr.getTestContext();
                System.out.println("number of passed test cases: "+ tc.getPassedTests().getAllResults().size());
                System.out.println("number of failed test cases: "+ tc.getFailedTests().getAllResults().size());
                System.out.println("number of skipped test cases: "+ tc.getSkippedTests().getAllResults().size());

                Set<ITestResult> passedTestResults = tc.getPassedTests().getAllResults();

                for(ITestResult passedTestResult : passedTestResults){
                    String methodName = passedTestResult.getName();
                    System.out.println("Method name: "+methodName);
                    System.out.println("Status: "+passedTestResult.getStatus());
                    System.out.println("Exception : "+passedTestResult.getThrowable());
                }

                Set<ITestResult> failedTestResults = tc.getFailedTests().getAllResults();

                for(ITestResult failedTestResult : failedTestResults){
                    String methodName = failedTestResult.getName();
                    System.out.println("Method name: "+methodName);
                    System.out.println("Status: "+failedTestResult.getStatus());
                    System.out.println("Exception : "+failedTestResult.getThrowable());
                }

                Set<ITestResult> skippedTestResults = tc.getSkippedTests().getAllResults();

                for(ITestResult skippedTestResult : skippedTestResults){
                    String methodName = skippedTestResult.getName();
                    System.out.println("Method name: "+methodName);
                    System.out.println("Status: "+skippedTestResult.getStatus());
                    System.out.println("Exception : "+skippedTestResult.getThrowable());
                }

            }
        }
    }

    @Override
    public IReporterConfig getConfig() {
        return IReporter.super.getConfig();
    }
}


