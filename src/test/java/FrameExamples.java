import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExamples {

    WebDriver driver;

    @BeforeMethod
    public void frameTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml;jsessionid=node0pw6f6qb52j981pl7urmgw8z667797977.node0");

    }

    @Test
    public void frameExample() {

        //Click Me (Inside frame)
        driver.switchTo().frame(0);
       WebElement button1 = driver.findElement(By.xpath("//*[@id=\"Click\"]"));
       button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("After click inside frame button Text :"+ afterClickButtonText);

        //Click Me (Inside Nested frame)
        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");
        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickButtonText3 = button3.getText();
        System.out.println("After click inside frame button3 Text :"+ afterClickButtonText3);

        //How many frames in this page?
        driver.switchTo().defaultContent();

        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        int size = iframeList.size();
        System.out.println("Size of iframe list :"+ size);

        for(WebElement iframe : iframeList) {
            String frameSrc = iframe.getAttribute("src");
            System.out.println("Frame src attribute value :"+ frameSrc);


        }
    }
}
