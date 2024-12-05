import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptExecutorExample {

    WebDriver driver;
    JavascriptExecutor js;
    @BeforeMethod
    public void javascriptExecutorPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

    }

    @Test
    public void javascriptExecutor() throws InterruptedException {

        js = (JavascriptExecutor) driver;

        //Get a Alert Box in to web page using javaScript
     //   js.executeScript("alert('Hello Thushari!');");

        //set input value in a text box using javascriptExecution
        WebElement inputNameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
        js.executeScript("arguments[0].value='im thushari';",  inputNameTextBox); //best way
        Thread.sleep(3000);


       //js.executeScript("arguments[0].getAttribute('value');", inputNameTextBox);

        //highligh element
        js.executeScript("arguments[0].style.border='3px solid red';", inputNameTextBox);
        js.executeScript("arguments[0].style.background='yellow';", inputNameTextBox);
        Thread.sleep(3000);

        //click element using jsExecutor
        WebElement maleCheckBox = driver.findElement(By.xpath("//input[@id='female']"));
        js.executeScript("arguments[0].click;", maleCheckBox);
        Thread.sleep(3000);

        //Scrolling page
        ScrollPage();

        //



    }

    public void ScrollPage() throws InterruptedException {

        //scroll some position
        js.executeScript("window.scrollTo(0,1000)");
        js.executeScript("window.scrollTo(0,-1000)");
        Thread.sleep(4000);

        //scroll bottum of the page
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(4000);



        //scroll top of the page
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(4000);


        //sroll page till element is vidible
        WebElement Srollelement = driver.findElement(By.xpath("label[for='gender']"));
        js.executeScript("arguments[0].scrollIntoView()", Srollelement);
        Thread.sleep(4000);


    }



}
