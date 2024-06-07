package DemoTestNgCaptureScreenshotForFailedTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DemoCaptureScreenshot extends BaseTest {


    @Test
    public void testDemoCaptureScreenshot() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//h6")).isDisplayed();

    }
}
