import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("129");


        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0mpzpuls0k3di1pc4skm6xaxm47773883.node0");
        Thread.sleep(3000);
    }

    @Test
    public void textBoxExample(){
        //Type your name
        WebElement name= driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Thushari Senevirathne");

        //Append country
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");

        //Verify if text box is disabled
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box enabled: " + enabled);

        //clear the typed Text.
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //Retrieve the typed Text
        WebElement retrieveTyped = driver.findElement(By.id("j_idt88:j_idt95"));
        String value = retrieveTyped.getAttribute("value");
        System.out.println(value);

        //Type email and....
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("thusharisenevirathne48@gmail." + Keys.TAB + "Confirm control moved to next element.");



    }
}
