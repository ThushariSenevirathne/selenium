import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsExample {

    WebDriver driver;

@BeforeMethod
    public void windowsTestPage() throws InterruptedException {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.leafground.com/window.xhtml");
    Thread.sleep(3000);

    }
    @Test
    public void windowsExample() throws InterruptedException {

    //1)Click and Confirm new Window Opens

        String oldWindow = driver.getWindowHandle();
        System.out.println("parent window :" + oldWindow);

//        WebElement newWindowOpen = driver.findElement(By.xpath("//*[@id=\"j_idt88:new\"]/span"));
//        newWindowOpen.click();
//        Thread.sleep(3000);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Handle size :" + windowHandles.size());

        //first Method- using forEach loop
//        for (String newWindow : windowHandles) {
//            System.out.println(newWindow);
//            driver.switchTo().window(newWindow);
//            System.out.println("page title :" + driver.getTitle());
//        }
//
//        driver.close();
//
//        driver.switchTo().window(oldWindow);

//        WebElement newWindowOpen = driver.findElement(By.xpath("//*[@id=\"j_id t88:new\"]/span"));
//        boolean displayed = newWindowOpen.isDisplayed();
//        System.out.println("displayed :" + displayed);



        //using List

        List<String> List = new ArrayList<String>(windowHandles);
        if(List.size()>1){
            driver.switchTo().window(List.get(1));
            System.out.println("child page title :" + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);
        }
        WebElement newWindowOpen = driver.findElement(By.xpath("//*[@id=\"j_idt88:new\"]/span"));
        boolean displayed = newWindowOpen.isDisplayed();
        System.out.println("displayed :" + displayed);

        // 2) Find the number of opened tabs

        WebElement findTabNo = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt93\"]/span[2]"));
        findTabNo.click();
        Thread.sleep(2000);

        Set<String> multipleWindows = driver.getWindowHandles();
        int howManyWindows =multipleWindows.size();
        System.out.println("howManyWindows :" + howManyWindows);


        //Close all windows except Primary

        WebElement element = driver.findElement(By.id("j_idt88:j_idt93"));
        element.click();
        Thread.sleep(2000);

        Set<String> newWindowsHandle = driver.getWindowHandles();
        for (String handle : newWindowsHandle) {
            if (!handle.equals(oldWindow)) {
                driver.switchTo().window(handle);
                driver.close();

            }
        }
//        driver.switchTo().window(oldWindow);
//        driver.close();
        driver.quit();




    }
}
