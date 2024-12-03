import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.Driver;
import java.util.List;

public class BrokenImageExample {

    WebDriver driver;

    @BeforeMethod
    public void openImageTestPage() {
        ChromeOptions options = new ChromeOptions();
        File file = new File("C:\\Users\\ACER\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
        options.addExtensions(file);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();


    }

    @Test
    public void brokenImageExample() {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> elements = driver.findElements(By.xpath("//div [@class='example']/img"));

        //naturalWidth"=" '0'
        int i=1;
        for (WebElement element : elements) {
            if (element.getAttribute("naturalWidth").equals(0)) {
                System.out.println("Image "+i +" is Broken");
            }else {
                System.out.println("Image "+i +" is Not Broken");
            }
            i++;

        }

    }

    @Test
    public void brokenImageExample2() {
        driver.get("https://demoqa.com/broken");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/img[2]"));
        if(element.getAttribute("naturalWidth").equals(0)){
            System.out.println("Image is Broken");
        }else {
            System.out.println("Image is Not Broken");
        }
    }

}
