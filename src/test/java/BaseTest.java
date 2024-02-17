import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public WebElement waitForElement (String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }
    @BeforeSuite(alwaysRun = true)
    public void setup(){
        WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        System.out.println("LOGIN CREDENTIALS");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        WebElement usernameInput = waitForElement("//input[@name='username']");
    }

    @AfterSuite(alwaysRun = true)
    public void teardown(){driver.quit();
    }
}
