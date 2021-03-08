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

public class sample4 {
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
        WebElement hideButton = driver.findElement(By.name("hide_text"));
        hideButton.click();
        text = textAppear.getText();
        Assert.assertEquals("I am here!", text);
        System.out.println("clicked on button");
    }

@Test
    public void clearText() {
        WebElement textBox = driver.findElement(By.name(""));
        textBox.clear();
        textBox.sendKeys("Latvia");
    }

    //clickLink - check current url,
    // click on link with cssSelector “a[title='Link 1']”,
    // check element with tagName “h1” text and current url
    @Test
    public void clickLink(){
        WebElement link = driver.findElement(By.cssSelector("a[title='Link 1']"));
        link.click();
        String expectedText = "Link Page 1";
        String expectedCurrentURL = "https://kristinek.github.io/site/examples/link1";
        WebElement h1Tag = driver.findElement(By.tagName("h1"));
        String actualH1Text = h1Tag.getText();
        Assert.assertEquals(expectedText, actualH1Text);
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedCurrentURL, currentURL);
        System.out.println("clicked on link");
    }

    //2.clickButtonAndSeeOrHideText:
    // check that element with id “show_me” is not displayed,
    // “show_text” is enabled,
    // “hide_text” is not enabled,
    // then click on “show_text” and check that “show_me” is displayed,
    // “show_text” is not enabled, “hide_text” is enabled,
    // then click on “hide_text” and check “show_me” is not displayed,
    // “show_text” is enabled, “hide_text” is not enabled
    @Test
    public void clickButtonAndSeeOrHideText(){
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
//entertextInTextArea:
// check text and value of element with id “vfb-10”,
// then send keys to that element and check text and value again.
// Now clear content of element and send some other keys,
// check text and value
    @Test
    public void enterTextInTextArea(){
        WebElement textArea = driver.findElement(By.name("vfb-10"));
        String text = textArea.getText();
        String value = textArea.getAttribute("value");
        System.out.println("Text: "+ text);
        System.out.println("Value: " + value);

        System.out.println("=== Entering Text ===");
        textArea.sendKeys("Abracadabra");

        System.out.println("Text:" + textArea.getText());
        System.out.println("Value" + textArea.getAttribute("value"));

        System.out.println("=== Clearing Text ===");
        textArea.clear();
        textArea.sendKeys("New abracadabra");

        System.out.println("Text:" + textArea.getText());
        System.out.println("Value:" + textArea.getAttribute("Value"));
    }

    //4.enterTextInTextBox:
    // check text and value of element with id “text”,
    // send keys to this element, check text/value,
    // clear and send some other keys,
    // check text/value
    @Test
    public void enterTextInTextBox(){
        WebElement textInput = driver.findElement(By.id("text"));
        String newTextToBeEntered = "Append Text";
        String value = textInput.getAttribute("value");
        Assert.assertEquals("This is a text box", value);

        System.out.println("===== Entering Text======");
        textInput.sendKeys(newTextToBeEntered);
        value = textInput.getAttribute("value");
        Assert.assertEquals("This is a text box" + newTextToBeEntered, value);

        System.out.println("===== Clearing Text======");
        textInput.clear();
        System.out.println("===== Entering Text======");
        textInput.sendKeys(newTextToBeEntered);
        value = textInput.getAttribute("value");
        Assert.assertEquals(newTextToBeEntered, value);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        //Close browser
        driver.quit();
    }

}
