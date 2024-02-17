import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PIM extends BaseTest{
    @Test

    public void configuration (){
        driver.findElement(By.xpath("//span[text()='PIM']")).click();

    }






}
