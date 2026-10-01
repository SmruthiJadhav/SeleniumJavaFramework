package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.DriverManager;
import java.io.File;
import java.util.Base64;


import java.util.Base64;

public class Hooks {
   // public static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        // Create Extent test
        ExtentReports extent =
                ExtentManager.getExtentReports();

        ExtentTest test =
                extent.createTest(scenario.getName());

        ExtentTestManager.setExtentTest(test);

        // Load configuration
        ConfigReader.loadProperties();
        String browser = ConfigReader.getProperty("browser");
        // driver = DriverFactory.createDriver(browser);
       // driver.get(ConfigReader.getProperty("url"));

        // Create WebDriver
        WebDriver driver = DriverFactory.createDriver(browser);

        // Store driver for current thread
        DriverManager.setDriver(driver);

        // Open application
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();
        if (scenario.isFailed()) {
            ExtentTestManager.getExtentTest()
                    .fail("Scenario failed");
            if(driver != null) {
                TakesScreenshot ts = (TakesScreenshot)driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure screenshot");

                String base64Screenshot = Base64.getEncoder().encodeToString(screenshot);
                ExtentTestManager.getExtentTest().addScreenCaptureFromBase64String(base64Screenshot,"Failure Screenshot");
            }
        }
        else {
            ExtentTestManager.getExtentTest()
                    .pass("Scenario passed");
        }

        // Flush Extent report
        ExtentManager.getExtentReports().flush();

        // Close browser
        DriverManager.quitDriver();

        // Remove ExtentTest from current thread
        ExtentTestManager.removeTest();

       /* if(driver != null) {
            driver.quit(); */
        }
    }


