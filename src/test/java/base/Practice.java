package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("");
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for(String window : allWindows) {
            if(!window.equals(parentWindow)) {
                driver.switchTo().window(window);
            }
        }
        String pageUrl = driver.getCurrentUrl();

    }
}
