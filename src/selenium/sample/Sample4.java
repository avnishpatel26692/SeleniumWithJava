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
    public void clickOnButton(){
    WebElement showButton = driver.findElement(By.id("show_text"));
    showButton.click();
    WebElement textAppear = driver.findElement(By.id("show_me"));
    String text = textAppear.getText();
    Assert.assertEquals("I am here!", text);
        System.out.println("clicked on button");
    }
    @Test
    public void clickOnButtonHide(){
        WebElement showButton = driver.findElement(By.id("show_text"));
         WebElement textAppear = driver.findElement(By.id("show_me"));
         WebElement hideButton = driver.findElement(By.name("hide_text"));
        //initial state - no text, Show is clickable
        Assert.assertFalse(textAppear.isDisplayed()); //will be false, bacause button is not pressed, text wont'be isible
        Assert.assertTrue(showButton.isEnabled()); // button clickable
        Assert.assertFalse(hideButton.isEnabled()); //button not clickable
        showButton.click(); // click button "Show"
        Assert.assertTrue(textAppear.isDisplayed());
        Assert.assertFalse(showButton.isEnabled());// button not clickable
        Assert.assertTrue(hideButton.isEnabled()); // button clickable
        hideButton.click(); // click buton "Hide"
        Assert.assertFalse(textAppear.isDisplayed());
        Assert.assertTrue(showButton.isEnabled());
        Assert.assertFalse(hideButton.isEnabled());


//        System.out.println("clicked on button");
    }
    @Test
    public void clearEnterText(){
        WebElement textBox = driver.findElement(By.name("vfb-10"));
        String text = textBox.getText();
        String value = textBox.getAttribute("value");
        System.out.println("Text: "+text);
        System.out.println("Value: "+value);

        System.out.println("Clearing area");
        textBox.clear(); // to delete text from field
        textBox.sendKeys("this is SUPER DUPER testing text"); // to enter text in field
        System.out.println("Text: " +textBox.getText());
        System.out.println("Value: " +textBox.getAttribute("value"));
    }

    @Test
    public void clickLink(){
//        WebElement clickLink = driver.findElement(By.cssSelector("a[title='Link 1']"));
//        String expectedText = "Link Page 1";
//        String expectedCurrentURL = "https://kristinek.github.io/site/examples/link1";
//        WebElement h1Tag = driver.findElement(By.id("h1"));
//        clickLink.click();
//
//        String actualH1Text = h1Tag.getText();
//        Assert.assertEquals(expectedText, actualH1Text);
//
//        String currentURL = driver.getCurrentUrl();
//        Assert.assertEquals(expectedCurrentURL, currentURL);
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
    @Test
    public void enterTextInBox(){
        WebElement tBox = driver.findElement(By.name("vfb-5")); //id=text
        String newTextToEnter = "country - Latvia";
        String text = tBox.getText();
        String value = tBox.getAttribute("value");
        System.out.println("Text: "+text);
        System.out.println("Value: "+value);
     //   Assert.assertEquals("", text);
        Assert.assertEquals("This is a text box", value);

//send values in TextBox (tBox)
        System.out.println("Adding text");
//        tBox.clear(); // to delete text from field
        tBox.sendKeys(newTextToEnter); // to enter text in field
        value = tBox.getAttribute("value");
        System.out.println("Text: " +tBox.getText());
        System.out.println("Value: " +tBox.getAttribute("value"));
       // Assert.assertEquals("", text);
        Assert.assertEquals("This is a text box"+newTextToEnter, value);
//clear value & enter text in tBox
        System.out.println("Clearing area");
        tBox.clear(); // to delete text from field
        tBox.sendKeys(newTextToEnter); // to enter text in field
        value = tBox.getAttribute("value");
        System.out.println("Text: " +tBox.getText());
        System.out.println("Value: " +tBox.getAttribute("value"));
//        Assert.assertEquals("", text);
        Assert.assertEquals(newTextToEnter, value);
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //Close browser
        driver.quit();
    }
}
