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

public class Sample4{

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void clickOnButton(){
        WebElement showButton = driver.findElement(By.id("show_text"));
        showButton.click();
        WebElement textAppear = driver.findElement(By.id("show_me"));
        String text = textAppear.getText();
        Assert.assertEquals("I am here!", text);
    }


    @Test
    public void clearText(){
        WebElement textBox = driver.findElement(By.id("text"));
        textBox.clear();
        textBox.sendKeys("Hello");

    }

    @Test
    public void clickLink(){
        WebElement link = driver.findElement(By.cssSelector("a[title='Link 1']"));
        link.click();
        String url = driver.getCurrentUrl();
        String eurl = "https://kristinek.github.io/site/examples/link1";
        Assert.assertEquals(eurl,url);

        WebElement h1 = driver.findElement(new By.ByTagName("h1"));
        String etext = "Link Page 1";
        String text=h1.getText();
        Assert.assertEquals(etext,text);

    }
//error somewhere
    @Test
    public void clickButtonAndSeeOrHideText(){
        WebElement me = driver.findElement(By.id("show_me"));
        WebElement show = driver.findElement(By.id("show_text"));
        WebElement hide = driver.findElement(new By.ByName("hide_text"));

        Assert.assertFalse(me.isDisplayed());
        Assert.assertTrue(show.isEnabled());
        Assert.assertFalse(hide.isEnabled());

        show.click();
        Assert.assertFalse(show.isEnabled());
        Assert.assertTrue(me.isDisplayed());
        Assert.assertTrue(hide.isEnabled());

        hide.click();
        Assert.assertFalse(me.isDisplayed());
        Assert.assertTrue(show.isEnabled());
        Assert.assertFalse(hide.isEnabled());



    }
//?
    @Test
    public void enterTextInTextArea(){
        WebElement box = driver.findElement(By.name("vfb-10"));
        String boxText = box.getText();
        String boxValue = box.getAttribute("value");


        box.sendKeys("New Text");

        box.clear();

        box.sendKeys("Newer Text!");




    }
//?
    @Test
    public void enterTextInTextBox(){
    WebElement box = driver.findElement(By.id("text"));
    String eText = "This is a text box";
    String text= box.getText();
    String nText="New Text";
    String value=box.getAttribute("value");
    Assert.assertEquals("",text);
    Assert.assertEquals(eText,value);

    System.out.println("=============Entering new text=================");
    box.sendKeys(nText);
    text= box.getText();
    value=box.getAttribute("value");
    Assert.assertEquals(text+nText,value+nText);

    System.out.println("=============Clearing text====================");
    box.clear();

    System.out.println("=============Entering new text=================");
    box.sendKeys("Newer Text");
    text = box.getText();
    value = box.getAttribute("value");
    Assert.assertEquals(text,value);



    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}