import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    @Test(groups = {"smoke"})
    public void searchUser(){

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button")).click();
        WebElement dashboardElement = waitForElement("//h6[text()='Dashboard']");

        driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//span[text()='Admin']")).click();
        WebElement adminClick = waitForElement("(//span[@class='oxd-topbar-body-nav-tab-item'])[1]");

        driver.findElement(By.xpath("(//form[@class='oxd-form'] //input)[1]")).sendKeys("Admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement adminSearch = waitForElement("//div [@role='cell']//div[text()='Admin']");

        Assert.assertTrue(adminSearch.isDisplayed(),"Admin not displayed");



    }


}
