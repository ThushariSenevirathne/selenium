import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class KeyboardOperations {

    WebDriver driver;

    @BeforeMethod
    public void keyBoardTestsPages() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void keyBoardTests() throws InterruptedException {
        driver.get("http://google.com");
        WebElement  googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("welcome ");

        Actions actions = new Actions(driver);
        //select Text
//        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//
//        Thread.sleep(5000);
//
//        actions.keyDown(Keys.SHIFT)
//                .sendKeys("writing capital sentence").perform();
//        Thread.sleep(5000);
//
//               actions.keyUp(Keys.SHIFT)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("a")
//                 .keyUp(Keys.CONTROL)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("x ")
//                .build().perform();

        //To write in capital text box

        actions.keyDown(googleSearchBox, Keys.SHIFT)
                .sendKeys("Hello Thushari").perform();



    }

    @Test
    public void keyBoardTests2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = elements.size();
        System.out.println("List count is: " + size);

        Actions actions = new Actions(driver);
        actions.keyDown( Keys.CONTROL )
                .click(elements.get(0))
                .click(elements.get(1))
                .click(elements.get(2))
                .perform();


    }
}
