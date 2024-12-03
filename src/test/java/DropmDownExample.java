import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class DropmDownExample {

    WebDriver driver;

    @BeforeMethod
    public void dropdownTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void dropdownExample() throws InterruptedException {
        driver.get("https://www.leafground.com/select.xhtml");
        //Basic dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //Get number of get options
        List<WebElement> ListOfOptions = select.getOptions();
        int size = ListOfOptions.size();
        System.out.println("Number of options selected: " + size);

        for (WebElement element : ListOfOptions) {
            System.out.println(element.getText());
        }

        //Using sendkeys select dropdown
        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //selecting value in a Bootstrap dropdown
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> DropDownElements = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : DropDownElements) {
            String text = element.getText();
            if (text.equals("USA")) {
                element.click();
                break;
            }
        }
    }

        //google search
    @Test
    public void googleDropDown() throws InterruptedException {
    driver.get("https://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("palitha");
    Thread.sleep(2000);
    List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role = 'listbox']/li//div[@class='wM6W7d']"));
    System.out.println(googleSearchList.size());
    for (WebElement element :googleSearchList){
        System.out.println(element.getText());
    }

    //Handle Hidden Auto Suggestions Drop Down And Search using DOM Debugger Trick


        }

    }

