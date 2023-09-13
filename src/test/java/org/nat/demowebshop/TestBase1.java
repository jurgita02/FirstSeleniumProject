package org.nat.demowebshop;

import nat.demowebshop.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase1 {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase1.class);

    // @BeforeMethod //открывает в разных окнах браузера
    @BeforeSuite //открывает в одном окне браузера
    public void setUp() {
        app.init();
    }

    // @AfterMethod (enabled = true)
    @AfterSuite
    public void tearDown() {
        app.stop();
    }


    @BeforeMethod
    public void startTest() {
        logger.info("Start test");
    }
    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()){
            logger.info("PASSED: " + result.getMethod().getMethodName());
        }else {
            logger.error("FAILED: " + result.getMethod().getMethodName() +
                    " Screenshot: " + app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.error("******************************");
    }
}

