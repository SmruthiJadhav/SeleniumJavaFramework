package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "Selenium Java Framework");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Automation", "Selenium + Cucumber + TestNG");
        }
        return extent;
    }
}