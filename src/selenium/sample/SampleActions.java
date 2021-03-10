package selenium.sample;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import java.util.List;

public class SampleActions{
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
    public void Try(){
        WebElement par4 = driver.findElement(By.cssSelector("p.paragraph lucky w3-pink"));
        //font size
        System.out.println(par4.getCssValue("font-size"));
        Assert.assertEquals("15 px",par4.getCssValue("font size"));

        //font family
        System.out.println(par4.getCssValue("font-family"));
        Assert.assertEquals("Verdana,sans-serif",par4.getCssValue("font-family"));

        //color
        System.out.println(par4.getCssValue("color"));
        Assert.assertEquals("rgb(255, 255, 255)",par4.getCssValue("color"));

    }
    @Test
    public void selectOptionByText() {
        WebElement entryField =driver.findElement(By.cssSelector("select#vfb-12"));
        Select field = new Select(entryField);
        System.out.println(field.getFirstSelectedOption().getText());
        //by visible Text
        field.selectByVisibleText("Option 2");
        System.out.println(field.getFirstSelectedOption().getText());
        Assert.assertEquals("Option1",field.getFirstSelectedOption().getText());
        //byIndex
        field.selectByIndex(1);
        System.out.println(field.getFirstSelectedOption().getText());
        Assert.assertEquals("Option1",field.getFirstSelectedOption().getText());
        //byValue
        field.selectByValue("value3");
        System.out.println(field.getFirstSelectedOption().getText());
        Assert.assertEquals("Option 3",field.getFirstSelectedOption().getText());


    }
    @Test
    public void XPath2(){
        WebElement entryField =driver.findElement(By.cssSelector("select#vfb-12"));
        Select field = new Select(entryField);
        System.out.println(field.getFirstSelectedOption().getText());
        field.selectByVisibleText("Option 2");
        System.out.println(field.getFirstSelectedOption().getText());
        Assert.assertEquals("Option1",field.getFirstSelectedOption().getText());



    }
    @Test
    public void CSS(){

    }
    @Test
    public void CSS2() {

    }
        @After
        public void tearDown() throws Exception {
            Thread.sleep(3000);

            //Close browser
            driver.quit();
        }
    }