package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample6 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    }

    @Test
    public void findElementsByClassAll(){
//to print number of elements
        List<WebElement> list = driver.findElements(By.className("test"));
        System.out.println("number of elements: " +list.size());
//to print all elements
        for(int i=0; i<list.size(); i++)
        {
            System.out.println(list.get(i).getText());
        }
//getting 3rd element
        System.out.println("specific 3rd element is: " +list.get(2).getText());
    }
    @Test
    public void findElementByXPath(){
//to find  element
        WebElement amazeTxt = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println("the text is: " +amazeTxt.getText());

        System.out.println("1: "+driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]")).getText());
        System.out.println("2: "+driver.findElement(By.xpath("//p[@class='text' and @id='dummy']")).getText());
        //also can write : By.xpath("//p[@class='text'][@id='dummy']")

    }
    @Test
    public void findElementByCssName(){
        System.out.println("txt1: "+driver.findElement(By.cssSelector("div#nonStandartText > .amazing")).getText());
        System.out.println("txt2: "+driver.findElement(By.cssSelector(".text#dummy")).getText());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //Close browser
        driver.quit();
    }
}

