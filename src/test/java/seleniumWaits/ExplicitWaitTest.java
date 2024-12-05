package seleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitTest {

    WebDriver driver;
    @BeforeMethod
    public void openpage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/waits.xhtml;jsessionid=node01r4m7k3ldvx6u1peezjzz6tfei7860261.node0");

    }
@Test
    public void explicitWaitTest(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

       By newBtnLocator = By.xpath("//button[@id='j_idt87:j_idt90']/span");
       WebElement NewBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(newBtnLocator));
       String newButton= NewBTN.getText();
       System.out.println("new button text is" + newButton);


    }
    @AfterMethod

    public void closeBrowser(){
        driver.quit();
    }
}
