//DataProvider are used to send the set of data continuously to the test methods
//It is denoted by @DataProvider(name="GiveName")

//partially dataprovider is also used ,it is used to pass to only pass certain data from the list of data
//@DataProvider(indices={1,4,6}) it is denoted in this way

//Another way is to create  separate class for the dataProvider and use it
//it can be done by creating two class 1)testClass 2)dataProvider class
//in the test class use the annotation @test(dataProvider="dataProviderName" , dataProviderClass= dataProviderClassName.class)


package DemoTestNGDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoDataProvider {

    @DataProvider(name = "loginDetail", indices = {1})
    public Object[][] login() {
        return new Object[][]{{"Admin", "admin123"}, {"Admin", "admin234"}};
    }

    @Test(dataProvider = "loginDetail")
    public void testDataProvider(String username, String password) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.quit();

    }


}
