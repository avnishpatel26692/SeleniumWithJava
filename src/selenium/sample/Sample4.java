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

        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void clickLink() {
        WebElement link = driver.findElement(By.cssSelector("a[title='Link 1']"));
        link.click();

        WebElement h1Tag = driver.findElement(By.tagName("h1"));
        String expectedText = "Link Page 1";
        String actualH1Text = h1Tag.getText();
        Assert.assertEquals(expectedText, actualH1Text);

        String expectedCurURL = "https://kristinek.github.io/site/examples/link1";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedCurURL, currentURL);
    }

    @Test
    public void clickButtonAndSeeOrHideText()
    {
        WebElement textAppear = driver.findElement(By.id("show_me"));
        WebElement showButton = driver.findElement(By.id("show_text"));
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
    public void enterTextinTextArea()
    {
        WebElement textArea = driver.findElement(By.name("vfb-10"));
        String text = textArea.getText();
        String value = textArea.getAttribute("value");
        System.out.println("Text: " + text);
        System.out.println("Value: " + value);

        textArea.sendKeys("New Text");
        System.out.println("Text:" + textArea.getText());
        System.out.println("value:" + textArea.getAttribute("value"));

        textArea.clear();
        textArea.sendKeys("New Text Entered");

        System.out.println("Text:" + textArea.getText());
        System.out.println("value:" + textArea.getAttribute("value"));
    }

    @Test
    public void enterTextInTextBox()
    {
        WebElement textInput = driver.findElement(By.id("text"));
        String value = textInput.getAttribute("value");
        Assert.assertEquals("This is a text box", value);

        String newText = " and something new";
        textInput.sendKeys(newText);
        value = textInput.getAttribute("value");
        Assert.assertEquals("This is a text box" + newText, value);

        textInput.clear();
        String newText1 = "The cool one!";
        textInput.sendKeys(newText1);
        value = textInput.getAttribute("value");
        Assert.assertEquals(newText1, value);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}