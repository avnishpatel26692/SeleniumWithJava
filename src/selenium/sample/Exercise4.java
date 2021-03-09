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

public class Exercise4 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /*clickLink - check current url, click on link with cssSelector “a[title='Link 1']”,
    check element with tagName “h1” text and current url*/
    @Test
    public void clickLink() {
        WebElement link = driver.findElement(By.cssSelector("a[title='Link 1']"));
        link.click();
        String expectedText = "Link Page 1";
        String expectedCurrentURL = "https://kristinek.github.io/site/examples/link1";
        WebElement h1Tag = driver.findElement(By.tagName("h1"));


        String actualH1Text = h1Tag.getText();
        Assert.assertEquals(expectedText, actualH1Text);

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedCurrentURL, currentURL);
    }

    @Test
    public void clickButtonAndSeeOrHideText()
    {

        WebElement showButton = driver.findElement(By.id("show_text"));
        WebElement textAppear = driver.findElement(By.id("show_me"));
        WebElement hideButton = driver.findElement(By.name("hide_text"));

        Assert.assertFalse(textAppear.isDisplayed());
        Assert.assertTrue(showButton.isEnabled());
        Assert.assertFalse(hideButton.isEnabled());

        showButton.click();
        Assert.assertTrue(textAppear.isDisplayed());
        Assert.assertFalse(showButton.isEnabled());
        Assert.assertTrue(hideButton.isEnabled());

        hideButton.click();
        Assert.assertFalse(textAppear.isDisplayed());
        Assert.assertTrue(showButton.isEnabled());
        Assert.assertFalse(hideButton.isEnabled());

    }

    @Test
    public void enterTextInTextArea(){

        WebElement textArea = driver.findElement(By.name("vfb-10"));
        String text = textArea.getText();
        String value = textArea.getAttribute("value");
        System.out.println("Text: " + text);
        System.out.println("Value: " + value);

        System.out.println("=====Entering text======");
        textArea.sendKeys("New text");

        System.out.println("Text: " + textArea.getText());
        System.out.println("Value: " + textArea.getAttribute("value"));


        System.out.println("=====Clearing text======");
        textArea.clear();
        textArea.sendKeys("New text entered");

        System.out.println("Text: " + textArea.getText());
        System.out.println("Value: " + textArea.getAttribute("value"));
    }



    @Test
    public void enterTextInTextBox()
    {
        WebElement textInput = driver.findElement(By.id("text"));
        String newTextToBeEntered = "Append text";
        String text = textInput.getText();
        String value = textInput.getAttribute("value");
        Assert.assertEquals("", text);
        Assert.assertEquals("This is a text box", value);

        //Send values in TextBox
        System.out.println("===== Entering Text======");
        textInput.sendKeys(newTextToBeEntered);
        value = textInput.getAttribute("value");
        Assert.assertEquals("", text);
        Assert.assertEquals("This is a text box" + newTextToBeEntered, value);

        //clear value And Enter Text in TextBox
        System.out.println("===== Clearing Text======");
        textInput.clear();
        System.out.println("===== Entering Text======");
        textInput.sendKeys(newTextToBeEntered);
        value = textInput.getAttribute("value");
        Assert.assertEquals("", text);
        Assert.assertEquals(newTextToBeEntered, value);

    }


        @Test
        public void clickOnButton ()
        {
            WebElement showButton = driver.findElement(By.id("show_text"));
            showButton.click();
            WebElement textAppear = driver.findElement(By.id("show_me"));
            String text = textAppear.getText();
            Assert.assertEquals("I am here!", text);
            WebElement hideButton = driver.findElement(By.name("hide_text"));
            hideButton.click();
            text = textAppear.getText();
            System.out.println("clicked on button");

        }

        @Test
        public void clearText ()
        {
            WebElement textBox = driver.findElement(By.id("text"));
            textBox.clear();
            textBox.sendKeys("Latvia");


        }


        @After
        public void tearDown () throws Exception {
            Thread.sleep(5000);

            //Close browser
            driver.quit();
        }
    }
