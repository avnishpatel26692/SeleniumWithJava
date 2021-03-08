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

public class Sample4 {
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
    public void clickLink(){
        WebElement link = driver.findElement(By.cssSelector("a[title='Link 1']"));
        link.click();
        WebElement title = driver.findElement(By.tagName("h1"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals("Link Page 1",title.getText());
        Assert.assertEquals("https://kristinek.github.io/site/examples/link1",url);

    }

    @Test
    public void clickButtonSeeOrHide(){
        WebElement btn = driver.findElement(By.id("show_text"));
        WebElement actualResult = driver.findElement(By.id("show_me"));
        WebElement btn_hide = driver.findElement(By.name("hide_text"));
        Assert.assertNotEquals("I am here!",actualResult.getText());
        Assert.assertFalse(actualResult.isDisplayed());
        Assert.assertTrue(btn.isEnabled());
        Assert.assertFalse(btn_hide.isEnabled());
        btn.click();
        Assert.assertTrue(actualResult.isDisplayed());
        Assert.assertFalse(btn.isEnabled());
        Assert.assertTrue(btn_hide.isEnabled());
        Assert.assertEquals("I am here!",actualResult.getText());

        btn_hide.click();
        Assert.assertNotEquals("I am here!",actualResult.getText());



    }

    @Test
    public void enterTextInTextArea(){
        WebElement textArea = driver.findElement(By.name("vfb-10"));
        String text = textArea.getText();
        String value = textArea.getAttribute("value");

        Assert.assertEquals("This is a text area", text);
        Assert.assertEquals("This is a text area",value);

        textArea.sendKeys("Random text");

        Assert.assertEquals("This is a text area", text);
        Assert.assertEquals("This is a text area",value);

        textArea.clear();
        textArea.sendKeys("Final text");
        String text2 = textArea.getText();
        String value2 = textArea.getAttribute("value");


        Assert.assertEquals("This is a text area", text2);
        Assert.assertEquals("Final text",value2);

    }
    @Test
    public void enterTextInTextBox(){
       // check text and value of element with id “text”, send keys to this element,
        // check text/value, clear and send some other keys, check text/value
       WebElement textWithId = driver.findElement(By.id("text"));

       String value = textWithId.getAttribute("value");
       String addedText = " Some extra text.";

       Assert.assertEquals("",textWithId.getText());
       Assert.assertEquals("This is a text box",value);

       textWithId.sendKeys(addedText);
        WebElement textWithId2 = driver.findElement(By.id("text"));

        String value2 = textWithId.getAttribute("value");
        Assert.assertEquals("",textWithId2.getText());
        Assert.assertEquals("This is a text box"+addedText,value2);

        textWithId.clear();
        WebElement textWithId3 = driver.findElement(By.id("text"));
        textWithId.sendKeys(addedText);
        String value3 = textWithId.getAttribute("value");
        Assert.assertEquals("",textWithId3.getText());
        Assert.assertEquals(addedText,value3);








    }



    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
