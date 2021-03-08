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
    public void clickLink()
    {
        WebElement link = driver.findElement(By.cssSelector("a[title='Link 1']"));
        link.click(); //Clicking on Link

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

        Assert.assertFalse(textAppear.isDisplayed()); //I am here! is not seen
        Assert.assertTrue(showButton.isEnabled()); // Show Button is Enabled (clickable)
        Assert.assertFalse(hideButton.isEnabled()); // Hide Button is Not enabled

        showButton.click(); //Clicking on Show Button
        Assert.assertTrue(textAppear.isDisplayed()); // I am here is seen
        Assert.assertFalse(showButton.isEnabled()); // Show Button is Not Enabled
        Assert.assertTrue(hideButton.isEnabled()); // Hide Button is Enabled

        hideButton.click(); //Clicking on Hide Button
        Assert.assertFalse(textAppear.isDisplayed()); //I am here! is not seen
        Assert.assertTrue(showButton.isEnabled()); //Show Button is Enabled (clickable)
        Assert.assertFalse(hideButton.isEnabled()); //Hide Button is Not enabled
    }

    @Test
    public void enterTextinTextArea()
    {
        WebElement textArea = driver.findElement(By.name("vfb-10"));
        String text = textArea.getText();
        String value = textArea.getAttribute("value");

        System.out.println("Text: " + text);
        System.out.println("Value: " + value);

        System.out.println("===== Entering Text======");
        textArea.sendKeys("New Text");

        System.out.println("Text:" + textArea.getText());
        System.out.println("value:" + textArea.getAttribute("value"));

        System.out.println("===== Clearing Text======");
        textArea.clear();
        textArea.sendKeys("New Text Entered");

        System.out.println("Text:" + textArea.getText());
        System.out.println("value:" + textArea.getAttribute("value"));
    }

    @Test
    public void enterTextInTextBox()
    {
        WebElement textInput = driver.findElement(By.id("text"));
        String newTextToBeEntered = " Append Text";
        String value = textInput.getAttribute("value");
        Assert.assertEquals("This is a text box", value);

        //Send values in TextBox
        System.out.println("===== Entering Text======");
        textInput.sendKeys(newTextToBeEntered);
        value = textInput.getAttribute("value");
        Assert.assertEquals("This is a text box" + newTextToBeEntered, value);

        //clear value And Enter Text in TextBox
        System.out.println("===== Clearing Text======");
        textInput.clear();
        System.out.println("===== Entering Text======");
        textInput.sendKeys(newTextToBeEntered);
        value = textInput.getAttribute("value");
        Assert.assertEquals(newTextToBeEntered, value);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}


