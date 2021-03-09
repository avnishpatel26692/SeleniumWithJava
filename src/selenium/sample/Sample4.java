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

//    @Test
//    public void clickOnButton(){
//        WebElement showButton = driver.findElement(By.id("show_text"));
//        showButton.click();
//        WebElement textAppear = driver.findElement(By.id("show_me"));
//        String text = textAppear.getText();
//        Assert.assertEquals("I am here!", text);
//
//        WebElement hideButton = driver.findElement(By.name("hide_text"));
//        hideButton.click();
//        text = textAppear.getText();
//        Assert.assertEquals("I am here!", text);
//        System.out.println("clicked on button");
//    }

    @Test
    public void clearTest(){
        WebElement textBox = driver.findElement(By.id("text"));
        textBox.clear();
        textBox.sendKeys("Latvia"); // enter text in the text box
    }
//1.clickLink - check current url, click on link with cssSelector “a[title='Link 1']”, check element with tagName “h1” text and current url
    @Test
    public void testToTestAnna(){
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
//2.clickButtonAndSeeOrHideText - check that element with id “show_me” is not displayed,
// “show_text” is enabled, “hide_text” is not enabled, then click on “show_text” and check that “show_me” is displayed,
// “show_text” is not enabled, “hide_text” is enabled,
// then click on “hide_text” and check “show_me” is not displayed, “show_text” is enabled, “hide_text” is not enabled
    @Test
    public void testToTestAnna2(){
        WebElement showButton = driver.findElement(By.id("show_me"));
        WebElement textAppear = driver.findElement(By.id("show_text"));
        WebElement hideButton = driver.findElement(By.name("hide_text"));
        Assert.assertFalse(textAppear.isDisplayed()); // I am her is not seen
        Assert.assertTrue(showButton.isEnabled()); // Show Button  is Enabled (clickable)
        Assert.assertFalse(hideButton.isEnabled()); // Hide Button is Not enabled

        showButton.click();
        Assert.assertTrue(textAppear.isDisplayed()); //I am here is seen
        Assert.assertFalse(showButton.isEnabled()); // Shoe Button is nor enabled
        Assert.assertTrue(hideButton.isEnabled()); // Hide Button is Enabled

        hideButton.click();
        Assert.assertFalse(textAppear.isDisplayed());
        Assert.assertTrue(showButton.isEnabled());
        Assert.assertFalse(hideButton.isEnabled());

    }

    //entertextInTextArea - check text and value of element with id “vfb-10”,
    // then send keys to that element and check text and value again.
    // Now clear content of element and send some other keys, check text and value

    @Test
    public void testToTestAnna3(){
        WebElement textArea = driver.findElement(By.name("vfb-10"));
        String text = textArea.getText();
        String value = textArea.getAttribute("value");

        System.out.println("Text " + text);
        System.out.println("Value " + value);

        System.out.println("====== Enter text ======");
        textArea.sendKeys("New Text"); // enter text in the text box

        System.out.println(textArea.getText());
        System.out.println(textArea.getAttribute("value"));

        System.out.println("====== Clearing text ======");
        textArea.clear();
        textArea.sendKeys("New Text Entered"); // enter text in the text box

        System.out.println(textArea.getText());
        System.out.println(textArea.getAttribute("value"));

    }
//enterTextInTextBox - check text and value of element with id “text”,
// send keys to this element, check text/value, clear and send some other keys, check text/value
    @Test
    public void testToTestAnna4(){
        WebElement textInput = driver.findElement(By.id("text"));
        String newTextToBeEntered = " Append Text";
       // String text = textInput.getText(); // not mandatory to check text
        String value = textInput.getAttribute("value");
        //Assert.assertEquals("", text);
        Assert.assertEquals("This is a text box", value);

        System.out.println("===== Entering text =====");
        textInput.sendKeys(newTextToBeEntered); //send values in Text box
        //text = textInput.getText();
        value = textInput.getAttribute("value");
        //Assert.assertEquals("", text);
        Assert.assertEquals("This is a text box"+newTextToBeEntered, value);

        System.out.println("===== Clearing Text =====");
        textInput.clear(); // clear value  and enter text in TextBox
        System.out.println("===== Entering text =====");
        textInput.sendKeys(newTextToBeEntered);
        //text = textInput.getText();
        value = textInput.getAttribute("value");
       // Assert.assertEquals("", text);
        Assert.assertEquals(newTextToBeEntered, value);
    }

    @Test
    public void assertEqualsExample() throws Exception {
        WebElement heading1 = driver.findElement(By.id("heading_1"));
        String actualValue = heading1.getText();
        String expectedValue = "Heading 1";
        Assert.assertEquals("This should be failed",expectedValue, actualValue);
    }

    @Test
    public void assertTrueExample(){
        String  expectedValue = "This is a button";
        WebElement btn = driver.findElement(By.name("randomButton1"));
        String actualValue = btn.getAttribute("value");
        Assert.assertTrue(actualValue.equalsIgnoreCase(expectedValue));
    }


    //getText from id: heading_1
//AssertEquals with expected: "Heading 1"
    @Test
    public void assertEquals(){
        String expectedValue = "Heading 1";
        WebElement h1= driver.findElement(By.id("heading_1"));
        String actualValue = h1.getText();
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void failWithMessage(){
        //write down any logic or conditions, if not satisfied then you can fail the test
        Assert.fail("I want to fail this test");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
