package selenium.sample;

import org.junit.After;
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
    }

    //findElementByClassAll - where you find elements by className “test” and then print out
    //•number of elements
    //•the text of this elements
    //•3rd element

    @Test
    public void findElementByClassAll(){
// find all elements with Class "test"
        List<WebElement> list = driver.findElements(By.className("test"));
        //to print number of Elements
        System.out.println("number of Elements" + list.size());
// To print all elements
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getText());
        }
        //Getting 3rd element
        System.out.println("3rd Element is "+list.get(2).getText());
    }

    //findElementByXPath - where you find element by xpath:
    //•“//div[@id='nonStandartText']/*[contains(@class,'text amazing')]” and then print out the text of this element
    //•“//p[@class='text' and @id='dummy']” and then print out the text of this element

    @Test
    public void findElementByXPath(){
        System.out.println(driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]")).getText());

        System.out.println(driver.findElement(By.xpath("//p[@class='text' and @id='dummy']")).getText());
    }

    //7.findElementByCssName - where you find element by css:
    //•“div#nonStandartText > .amazing” and then print out the text of this element
    //•“.text#dummy” and then print out the text of this element
    @Test
    public void findElementByCssName(){
        WebElement cssElement = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(cssElement.getText());
        //or
        System.out.println(driver.findElement(By.cssSelector("div#nonStandartText > .amazing")).getText());

        System.out.println(driver.findElement(By.cssSelector(".text#dummy")).getText());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
