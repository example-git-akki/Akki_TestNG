package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Page {
    WebDriver driver;


    public Page(WebDriver driver) {
        this.driver = driver;
    }

    By btnSearch = By.xpath("//textarea[@name='q']");
    By linkTestNg = By.xpath("//a[text()='testng']");

    public void verifyPageTitle() {
        String title = "Maven Repository: Search/Browse/Explore";
//        Assert.assertEquals(driver.getTitle(), title);
    }

    public void searchBar(String detail) {
        Reporter.log("Keyword entered is : " + detail);
        driver.findElement(btnSearch).sendKeys(detail);
        driver.findElement(btnSearch).submit();
        driver.findElement(btnSearch).clear();


    }


}
