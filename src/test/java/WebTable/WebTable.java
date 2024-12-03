package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {

    WebDriver driver;

@BeforeMethod

   public void WebTablePage(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://testautomationpractice.blogspot.com/2018/09/automation-form.html");

    }

    @Test
    public void WebTables() throws InterruptedException {
//count table rows
      int rowCount = driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr")).size();
        System.out.println("Rows count is :"+rowCount);

//count table columns
        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']//thead/tr/th")).size();
        System.out.println("Rows count is :"+rowCount);

        //specific row data
        String getText= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("Specific data of the table"+getText);

        //Retrieve all the data from table
        for (int i = 1; i <=rowCount; i++) {
            for (int j = 1; j <columnCount; j++) {
               String tbData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
               System.out.print ("Table data of the table"+tbData);

            }
            System.out.println();
        }

        //PRINT ID and name only
        //find the product price

        for (int i=1; i<=rowCount; i++) {
           String tblID= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
           String tblProductName= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
           System.out.println("tbl id :"+tblID + "product name is : "+tblProductName);

           if(tblProductName.equals("Product 3")){
             String productPrice=  driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
             System.out.println("Product price is : "+productPrice);
             break;

           }
        }

        //Select all the checkboxes

        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> count= driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for(int k=0;k<pageCount;k++){
            count.get(k).click();
            Thread.sleep(1000);
            for(int i =1; i<=rowCount; i++) {
                boolean selected = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[4]/input")).isSelected();
                if(selected){
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[4]/input")).click();
                    Thread.sleep(1000);
                }

            }
        }

//Select one checkbox
        int tbRow =1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + tbRow + "]/td[4]/input")).click();

    }
}
