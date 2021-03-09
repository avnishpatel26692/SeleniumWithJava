package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample6{

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void alerts(){
        WebElement toSummonBtn = driver.findElement(By.className("w3-red"));
        toSummonBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement clickToEnterBtn = driver.findElement(By.className("w3-khaki"));
        clickToEnterBtn.click();
        alert = driver.switchTo().alert();
        alert.sendKeys("15");
        alert.accept();

    }

    @Test
    public void findElementByClassAll(){

        List<WebElement> list = driver.findElements(new By.ByClassName("test"));
        System.out.println("number of Elements: "+list.size());

//        for(WebElement text:list){
//            System.out.println(text.getText());
//        }

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getText());
        }


        System.out.println("3rd elements is: " + list.get(2).getText());
        }

    @Test
    public void findElementByXPath(){
        WebElement test = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(test.getText());
    }

    @Test
    public void findElementByCssName(){
        WebElement test = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        WebElement test2 = driver.findElement(By.cssSelector(".text#dummy"));
        System.out.println(test.getText());
        System.out.println(test2.getText());

    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}