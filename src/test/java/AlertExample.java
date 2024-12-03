import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AlertExample {


    WebDriver driver;

    @BeforeMethod
    public void alertTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01nh7qb1h8mpx06ccvmke10zif7794910.node0");

    }
    @Test
    public void alertTests() throws InterruptedException {

        //Alert (Simple Dialog)

        WebElement AlertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        AlertBox.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        //Alert (Confirm Dialog)
        WebElement confirmBox =  driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox.click();
        Alert confirm = driver.switchTo().alert();
        Thread.sleep(3000);
        confirm.dismiss();

        //Alert (Prompt Dialog)
        WebElement promptBox = driver.findElement(By.id("j_idt88:j_idt104"));
        promptBox.click();
        Alert confirm2 = driver.switchTo().alert();
        Thread.sleep(3000);
        String alertText = confirm2.getText();
        System.out.println(alertText);
        confirm2.sendKeys("My name is Thushari");
        confirm2.accept();


    }
}
