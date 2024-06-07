//Parallel Execution is used to run tour scripts parallel in order to save the time
//It is generally executed through the priority.xml file
// it is denoted at the suite level and test level of the xml file
//  Denoted as follows    <suite name="All Test Suite">
//                         <test name="DemoTestNG" parallel="methods" thread-count="3">
//parallel has the parameter value like none,false,true,methods,classes,tests,instances
//thread-count accepts the integer value as positive only


package DemoTestNGParallelExecution;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.Debug;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoTest1 {

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.quit();
    }

    @Test
    public void test2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/watch?v=0J0HZrDvbjY");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.quit();
    }

    @Test
    public void test3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://fast.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.quit();
    }
}
