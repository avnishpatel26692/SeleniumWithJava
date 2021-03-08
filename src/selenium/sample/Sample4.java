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
    public void clickOnButton() {

        WebElement showButton = driver.findElement(By.id("show_text"));
        showButton.click();
        WebElement textAppear = driver.findElement(By.id("show_me"));
        String text = textAppear.getText();
        Assert.assertEquals("I am here!", text);
        WebElement hideButton = driver.findElement(By.name("hide_text"));
        hideButton.click();
        text = textAppear.getText();
        Assert.assertEquals("I am here!", text);
        System.out.println("BUTTON");

    }

    @Test
    public void clearText() {

        WebElement textBox = driver.findElement(By.id("text"));
        textBox.clear();
    }

    @Test
    public void findByCss() {

            WebElement link = driver.findElement(By.cssSelector("a[title='Link 1']"));
            link.click();

            String expectedText = "Link Page 1";
//            String url = driver.getCurrentUrl();
            String expectedCurrentUrl = "https://kristinek.github.io/site/examples/link1";
            WebElement h1tag = driver.findElement(new By.ByTagName("h1"));

            String actualH1text = h1tag.getText();

            Assert.assertEquals(expectedText, actualH1text);


    }
    @Test
    public void clickButtonAndSeeOrHideText() {
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
    public void enterTextInTextArea() {
        WebElement textArea = driver.findElement(By.name("vfb-10"));
        String text = textArea.getText();
        String value = textArea.getAttribute("value");

        System.out.println("Text - " + text);
        System.out.println("value - " + value);

        System.out.println("=====Entering text=====");
        textArea.sendKeys(" - New Text");

        System.out.println(textArea.getText());
        System.out.println(textArea.getAttribute("value"));

        System.out.println("=====Entering text=====");
        textArea.clear();
        textArea.sendKeys(" New txt entered ");

        System.out.println("Text - " + textArea.getText());
        System.out.println("Text - " + textArea.getAttribute("value"));


    }
    @Test
    public void enterTextInTextBox() {
        WebElement textInput = driver.findElement(By.id("text"));
        String newTextToBeEntered = "Append Text";
        String text = textInput.getText();
        String value = textInput.getAttribute("value");
        Assert.assertEquals("", text);
        Assert.assertEquals("This is a text box", value);

//        send values in textBox
        System.out.println("=====Entering text=====");
        textInput.sendKeys(newTextToBeEntered);
       text = textInput.getText();
       value = textInput.getAttribute("value");
        Assert.assertEquals("", text);
        Assert.assertEquals("This is a text box"  + newTextToBeEntered, value);

        System.out.println("=====Entering text=====");
        textInput.clear();
        System.out.println("=====Entering text=====");
        textInput.sendKeys(newTextToBeEntered);
        text = textInput.getText();
        value = textInput.getAttribute("value");
        Assert.assertEquals("", text);
        Assert.assertEquals(newTextToBeEntered, value);


    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
