import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

     WebDriver driver;

@BeforeMethod//Precondition
public void openButtonTestpage(){
    driver = new ChromeDriver();
   Dimension newsize = new Dimension(800, 600);
   driver.manage().window().setSize(newsize);
    //driver.manage().window().maximize();
    driver.get("https://www.leafground.com/button.xhtml");

}
@Test
    public void buttonTest(){

    // Click and confirm title
    driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
    String ExpectedTitle = "Dashboard";
    String ActualTitle = driver.getTitle();
//    if (ExpectedTitle.equals(ActualTitle)){
//        System.out.println("Actual Title is same as expexted ");
//        }else{
//            System.out.println("Actual Title is different ");
//        }
    Assert.assertEquals(ActualTitle, ExpectedTitle,"Title miss matched");

    //Find the position of the Submit button
    driver.navigate().back();
    WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt98"));
    Point xypoint = getPosition.getLocation();
    int x = xypoint.getX();
    int y = xypoint.getY();
    System.out.println("X position is " + x + " and Y position is " + y);

    //Find the Save button color
    WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
    String color = buttonColor.getCssValue("background-color");
    System.out.println("button color is " + color);

    //Find the height and width of this button
    WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
    int height = size.getSize().getHeight();
    int width = size.getSize().getWidth();
    System.out.println("height is : " + height + " and width is : " + width);


}
}
