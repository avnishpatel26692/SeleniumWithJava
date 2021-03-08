package selenium.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample4 { static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
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
    public void clearText() throws Exception {
        WebElement Textbox = driver.findElement(By.name("vfb-5"));
        Textbox.clear();



    }

    @Test
    public void clickLink(){
        WebElement link = driver.findElement(By.cssSelector("a[title='Link 1']"));

        String expectedText = "Link Page 1";
        String ecpectedCurrentURL = "https://kristinek.github.io/site/examples/link1";

        WebElement link1 = driver.findElement(By.tagName("h1"));

        link.click();

        String actualH1Text = link1.getText();
        Assert.assertEquals(expectedText, actualH1Text);

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(ecpectedCurrentURL, currentURL);
    }



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





    @Test
    public void entertextInTextArea(){
        WebElement textArea = driver.findElement(By.name("vtb-10"));
        String text =textArea.getText();
        String value = textArea.getAttribute("value");

        System.out.println("Text: " + text);
        System.out.println("Value: " + value);


        System.out.println("##### Entering Text #######");
        textArea.sendKeys("New Text");

        System.out.println("Text:" + textArea.getText());
        System.out.println("value:" + textArea.getAttribute("value"));




    }
@Test
    public void enterTextInTextBox(){

        WebElement textInput = driver.findElement(By.id("text"));
        String newTextToBeEntered = "Append Text";
        String text = textInput.getText();
        String value = textInput.getAttribute("value");
        Assert.assertEquals("", text);
        Assert.assertEquals("This is a text box", value);

        System.out.println("@@@@@@@ Entering Text @@@@@@@@");
        textInput.sendKeys(newTextToBeEntered);
        text = textInput.getText();
        value = textInput.getAttribute("value");
        Assert.assertEquals("This is a text box"+newTextToBeEntered, value);

        System.out.println("@@@@@@ Clearing Text @@@@@@@");
        textInput.clear();
        textInput.sendKeys(newTextToBeEntered);
        text = textInput.getText();
        value = textInput.getAttribute("value");
        Assert.assertEquals("", text);
        Assert.assertEquals(newTextToBeEntered, value);


    }

}
