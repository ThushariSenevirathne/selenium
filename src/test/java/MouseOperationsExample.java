import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOperationsExample {

    WebDriver driver;

    @BeforeMethod
    public void DragTestsPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/drag.xhtml");

    }
    @Test
    public void dragTest() throws InterruptedException {

        //move to element
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
                 .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
                 .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

//Drag and Drop operation
        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        //actions.clickAndHold(from).moveToElement(to).release(to).perform(); //1st way
        actions.dragAndDrop(from, to).perform(); //2nd way
        //driver.quit();

        //slider operation
        WebElement sliderPoint = driver.findElement(By.xpath("//div[@id='form:j_idt125']//span[1]"));
        System.out.println("slider point of before moving :" + sliderPoint.getLocation());
        actions.dragAndDropBy(sliderPoint,50,0).perform();
        System.out.println("slider point of after moving :" + sliderPoint.getLocation());


    }

    @Test
    public void mouseOperation2(){

        //right click operation
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html#example-code-simple-context-menu");
        WebElement element = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
        Alert alertpop = driver.switchTo().alert();
        System.out.println("alert is : " + alertpop.getText());
        alertpop.accept();

    }
}
