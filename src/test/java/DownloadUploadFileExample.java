import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFileExample {

    WebDriver driver;

    @BeforeMethod
    public void openFileTestPage() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void downloadFileTest() throws Exception {
        driver.get("https://www.leafground.com/file.xhtml");
        Thread.sleep(2000);
        WebElement downloadBtn = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadBtn.click();
        Thread.sleep(2000);

        File file = new File("C:\\Users\\ACER\\Downloads");
        File[] totalFiles = file.listFiles();

        for (File findFIle:totalFiles){
            if (findFIle.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded");
                break;
            }
        }

        //upload file

        //1st way
//        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
//        uploadBtn.click();
//
//        //windows control
//
//
//        String data = "C:\\Users\\ACER\\Downloads\\TestLeaf Logo.png";
//        StringSelection stringSelection = new StringSelection(data);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection , null);
//
//        Thread.sleep(2000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//
//        Thread.sleep(4000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);


        //using send keys
        String data = "C:\\Users\\ACER\\Downloads\\TestLeaf Logo.png";
        WebElement uploadelement = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadelement.sendKeys(data);


    }
}
