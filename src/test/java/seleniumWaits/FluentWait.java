package seleniumWaits;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWait {

    WebDriver driver;
    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/waits.xhtml;jsessionid=node01r4m7k3ldvx6u1peezjzz6tfei7860261.node0");

    }
    @Test
    public void testFluentWait(){

        Wait<WebDriver> wait = new FluentWait<WebElement>(driver)
                                .withTimeout(Duration.ofSeconds(30))
                                .pollingEvery(Duration.ofSeconds(5))
                                .ignoring(NoSuchElementException.class);


        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        WebElement fluentwaitElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span"));
            }
        });

        String newButton= driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("new button text is" + newButton);
    }
    @AfterMethod

    public void closeBrowser(){
        driver.quit();
    }
}
