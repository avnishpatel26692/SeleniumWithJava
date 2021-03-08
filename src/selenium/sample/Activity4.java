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

public class Activity4 {
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

    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);
        driver.quit();
    }

    /*@Test
    public void clickLink() {
        WebElement link = driver.findElement(By.cssSelector("a[title='Link 1']"));
        link.click();
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());
        Assert.assertEquals("https://kristinek.github.io/site/examples/link1", driver.getCurrentUrl());

    }*/

    @Test
    public void clickButtonAndSeeOrHideText() {
        WebElement hiddenText = driver.findElement(By.id("show_me"));
        WebElement hideButton = driver.findElement(By.name("hide_text"));
        WebElement showButton = driver.findElement(By.id("show_text"));

        Assert.assertFalse(hiddenText.isDisplayed());
        Assert.assertTrue(showButton.isEnabled());
        Assert.assertFalse(hideButton.isEnabled());

        showButton.click();
        Assert.assertTrue(hiddenText.isDisplayed());
        Assert.assertFalse(showButton.isEnabled());
        Assert.assertTrue(hideButton.isEnabled());

        hideButton.click();
        Assert.assertFalse(hiddenText.isDisplayed());
        Assert.assertTrue(showButton.isEnabled());
        Assert.assertFalse(hideButton.isEnabled());

    }

    //entertextInTextArea - check text and value of element with name “vfb-10”,
    // then send keys to that element and check text and value again.
    // Now clear content of element and send some other keys, check text and value
    @Test
    public void enterTextInTextArea(){

        WebElement element = driver.findElement(By.name("vfb-10"));
        System.out.println("Text: " + element.getText());
        System.out.println("Value: " + element.getAttribute("value"));
        System.out.println("--------------");
        element.sendKeys("qqq");
        System.out.println("Text: " + element.getText());
        System.out.println("Value: " + element.getAttribute("value"));
        System.out.println("--------------");
        element.clear();
        element.sendKeys("www");
        System.out.println("Text: " + element.getText());
        System.out.println("Value: " + element.getAttribute("value"));
    }
    //.enterTextInTextBox - check text and value of element with id “text”,
    // send keys to this element, check text/value, clear and send some other keys, check text/value
    @Test
    public void enterTextInTextBox(){
        WebElement element = driver.findElement(By.id("text"));
        String text = element.getText();
        String value = element.getAttribute("value");
        System.out.println("Text: " + text);
        System.out.println("Value: " + value);
        Assert.assertEquals("This is a text box", value);
        System.out.println("-------------------");

        element.sendKeys("some keys");
        System.out.println("Text: " + text);
        System.out.println("Value: " + value);
        //Assert.assertEquals("This is a text boxsome keys", value);
        System.out.println("-------------------");

        element.clear();
        element.sendKeys("To be or not to be");
        System.out.println("Text: " + text);
        System.out.println("Value: " + value);
        Assert.assertEquals("To be or not to be", value);
    }


}
