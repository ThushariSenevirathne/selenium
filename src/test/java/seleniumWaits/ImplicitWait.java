package seleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWait {

    WebDriver driver;
    @BeforeMethod
    public void openPages(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.leafground.com/waits.xhtml;jsessionid=node01r4m7k3ldvx6u1peezjzz6tfei7860261.node0");

    }
@Test
    public void implicitWaitExample() throws InterruptedException {

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
        String newButton= driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("new button text is" + newButton);

}

@AfterMethod
public void closeBrowser(){
        driver.quit();
}
}
