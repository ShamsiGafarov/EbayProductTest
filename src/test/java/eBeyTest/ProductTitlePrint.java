package eBeyTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class ProductTitlePrint {
    static WebDriver driver;
    static List<WebElement> products;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
    /*
    Go to ebay page
    Click on electronics section
    Click on all the images with a Width of 225 and a Length of 225
    Print the page title of each page
    Close the page
     */
    @Test
    public void Task01_eBay_WidthLength(){

//  Go to ebay page
        driver.get("https://www.ebay.com");
//  Click on electronics section
        driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();
//  Click on all the images with a Width of 225 and a Length of 225
//  Print the page title of each page
        products = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for (int i=0; i<products.size(); i++){
            products = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            products.get(i).click();
            System.out.println(i + 1 + ". title " + driver.getTitle());
            driver.navigate().back();
        }
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
