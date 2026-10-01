package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        ConfigReader.loadProperties();
        String browser = ConfigReader.getProperty("browser");
        driver = DriverFactory.createDriver(browser);
    }

    @AfterMethod
    public void teardown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
