import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @DataProvider (name = "dataInvalidCredentials")
    public Object[][] dpMethod(){
        return new Object[][] {{"Admin","test2344"}, {"TestUser","test"}};
    }

    @Test(dataProvider = "dataInvalidCredentials", groups = {"tobi"})
    public void testDP(String name, String pwd){
        System.out.println("Name "+name);
        System.out.println("pwd "+pwd);
        Assert.assertTrue(true);

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//button")).click();
        WebElement invalidCredentialsElement = waitForElement("//p[text()='Invalid credentials']");

        Assert.assertTrue(invalidCredentialsElement.isDisplayed(), "Invalid Credentials message is not displayed");
    }

    @DataProvider (name = "dataValidCredentials")
    public Object[][] dpMethod2(){
        return new Object[][] {{"Admin","admin123"}};
    }

    @Test(dataProvider = "dataValidCredentials", groups = {"tobi"})
    public void testDP2(String name, String pwd){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//button")).click();
        WebElement dashboardElement = waitForElement("//h6[text()='Dashboard']");
        Assert.assertTrue(dashboardElement.isDisplayed(),"Login successful");

    }

/*
    @Test(groups = {"login"} )
    public void invalidCredentialsTest() {

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin10");
        driver.findElement(By.xpath("//button")).click();
        WebElement invalidCredentialsElement = waitForElement("//p[text()='Invalid credentials']");

        Assert.assertTrue(invalidCredentialsElement.isDisplayed(), "Invalid Credentials message is not displayed");
    }

   @Parameters({"username","password"})
    @Test(groups = {"smoke", "login"})
    public void loginWithValidCredentialsTest(String username,String password) {

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button")).click();

        WebElement dashboardElement = waitForElement("//h6[text()='Dashboard']");

        Assert.assertTrue(dashboardElement.isDisplayed(),"Login failed");
    }
*/

    @Test
            //(groups = {"temp"})
    public void wrongPasswordValidation() {

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

//        WebElement optionElement = waitForElement("//input[@name='username']");
//        optionElement.sendKeys("Admin");

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin10");
        driver.findElement(By.xpath("//button")).click();
        WebElement invalidCredentialsElement = waitForElement("//p[text()='Invalid credentials']");

        Assert.assertTrue(invalidCredentialsElement.isDisplayed(), "Invalid Credentials message is not displayed");
    }

    @Test(groups = {"temp"})
    public void invalidUsernameValidation() {

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("test123");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin10");
        driver.findElement(By.xpath("//button")).click();
        WebElement invalidCredentialsElement = waitForElement("//p[text()='Invalid credentials']");

        Assert.assertTrue(invalidCredentialsElement.isDisplayed(), "Invalid Credentials message is not displayed");
    }

/*

    @Test(groups = {"tempDp"}, dataProvider = "dataInvalidCredentials")
    public void invalidLoginValidation(String username, String password) {

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button")).click();
        WebElement invalidCredentialsElement = waitForElement("//p[text()='Invalid credentials']");

        Assert.assertTrue(invalidCredentialsElement.isDisplayed(), "Invalid Credentials message is not displayed");
    } */

}


