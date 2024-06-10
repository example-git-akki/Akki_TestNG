package TestListenrs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Listeners(Listner.class)

public class Page {
    static WebDriver driver;


    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.similarweb.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        driver.quit();
    }


    public static void takeScreenShot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(f, new File("./Screenshot/" + result.getName() + "taken.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test()
    public void testPage() {

        driver.findElement(By.xpath("//button//*[text()='Products']")).click();
        try {
            driver.findElement(By.xpath("//a[text()='Stock Platform']")).click();
        } catch (TimeoutException e) {
            System.out.println("Handled timeout exception");
        }
    }

    @Test
    public void testPage1() {

        driver.findElement(By.xpath("//button//*[text()='Products']")).click();
        try {
            driver.findElement(By.xpath("//a[text()='Stock Platform']")).click();
        } catch (TimeoutException e) {
            System.out.println("Handled timeout exception");
        }
//        driver.findElement(By.xpath("//a[text()='Stock Platform']")).click();
    }
}
