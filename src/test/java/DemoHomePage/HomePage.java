package DemoHomePage;

import Pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    @DataProvider(name = "detail")
    public Object[][] enterDetail() {
        return new Object[][]{{"testNg"}, {"Cucumber"}, {"Selenium"}};
    }


    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "detail", invocationCount = 2)
    public void homePageDemo(String detail) {
        Page p = new Page(driver);
        p.verifyPageTitle();
        p.searchBar(detail);


    }
}
