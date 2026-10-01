package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GooglePage;
import utils.ConfigReader;

public class GoogleTest extends BaseTest {
    @Test
    public void searchGoogle() {
        driver.get(ConfigReader.getProperty("url"));
        System.out.println("Google is opened successfully");
        GooglePage googlepage = new GooglePage(driver);
        googlepage.search("Selenium");
        googlepage.clickSearch();

        String pageTitle = googlepage.getPageTitle();
        Assert.assertTrue(pageTitle.contains("Selenium"), "Page title doesnot contain Selenium");
        //SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(pageTitle, "GoogleXYZ");
        //System.out.println("Test continues");
        //softAssert.assertAll();
    }
}
