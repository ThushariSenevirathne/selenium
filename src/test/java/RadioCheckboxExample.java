import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckboxExample {

    WebDriver driver;

    @BeforeClass
    public  void radioCheckboxExample() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void radioTest() {
        //find default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chrome = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefox = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safari = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edge = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chrome) {
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default select radio button is : " + chromeText);
        } else if (firefox) {
            String firefoxtext = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("default select radio button is : " + firefoxtext);
        } else if (safari) {
            String safaritext = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default select radio button is : " + safaritext);
        }else if (edge) {
            String edgetext = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("default select radio button is : " + edgetext);
        }

        //Select the age group (only if not selected)
        WebElement AgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isSelected = AgeGroup.isSelected();
        if (!isSelected) {
            //AgeGroup.click();
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();

        }


    }

    @Test
    public void chechboxTest() {
        //Choose your favorite language(s)

        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> chechBoxElements = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element : chechBoxElements) {
            if (!(element.getText().equals("Others"))) {
                element.click();

            }
        }
        for (int i = 1; i <= chechBoxElements.size(); i++) {
            boolean checkBoxselected = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i + "]")).isSelected();
            System.out.println("checkBox" + i + "selected status : " + checkBoxselected );


        }



    }
}
