package selenium.sample;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.List;

public class SampleXPathCSS{
    static String libWithDriversLocation = System.getProperty ("user.dir") +"/lib/";

    WebDriver driver;
    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void assertEqualExample(){
        //find all elements with class "test"
        List<WebElement> list = driver.findElements(By.className("test"));

        //print number of elements
        System.out.println("number of Elements" + list.size());

        //print all elements
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
        //print 3rd element
        System.out.println("3rd Element is" +list.get(2).getText());
    }
    @Test
    public void XPath1(){

        WebElement element = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(element.getText());
    }
    @Test
    public void XPath2(){
        WebElement element3 = driver.findElement(By.xpath("//p[@class='text' and @id='dummy']"));
        System.out.println(element3.getText());
    }
    @Test
    public void CSS(){
        WebElement element4 = driver.findElement(By.cssSelector("div#nonStandartText >.amazing"));
        System.out.println(element4.getText());
    }
    @Test
    public void CSS2(){
        WebElement element5 = driver.findElement(By.cssSelector(".text#dummy"));
        System.out.println(element5.getText());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}