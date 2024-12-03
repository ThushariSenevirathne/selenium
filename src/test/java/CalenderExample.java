import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CalenderExample {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(3000);

    }

    @Test
    public void calenderExample() {

        //method1

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
//        WebElement element = driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
//        element.sendKeys("11/06/2024");

        //method2
        WebElement datepick = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datepick.click();

        selectFutureDate("2024","octomber", "15" );


    }
    public void selectFutureDate(String year, String month, String day) {
        while (true) {
            String Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            String Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (Year.equals(year) && Month.equals(month)) {
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();

            }

        }

        List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement days : allDays) {
            if(days.getText().equals(day)) {
                days.click();
                break;
            }
        }


    }

    public void selectpastDate(String year, String month, String day) {
        while (true) {
            String Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            String Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (Year.equals(year) && Month.equals(month)) {
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();

            }

        }

        List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement days : allDays) {
            if(days.getText().equals(day)) {
                days.click();
                break;
            }
        }


    }
}
