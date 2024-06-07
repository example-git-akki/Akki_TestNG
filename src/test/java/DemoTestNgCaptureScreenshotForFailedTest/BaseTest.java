package DemoTestNgCaptureScreenshotForFailedTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    WebDriver driver;
    public static String screenShotSubFolder;

    @BeforeTest
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void methodTakeScreenshot(ITestResult result) throws IOException {


        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName());
        }
    }

    public void captureScreenshot(String fileName) throws IOException {
//        if (screenShotSubFolder == null) {
//            LocalDateTime my = LocalDateTime.now();
//            DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//            screenShotSubFolder = my.format(myFormat);
//        }
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Screenshot/" + fileName + ".png"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
