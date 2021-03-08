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
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver88.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void clickLink() {
        WebElement clickLink = driver.findElement(By.id("link1"));
        clickLink.click();
        String getLink = driver.getCurrentUrl();
        String expectedLink = "https://kristinek.github.io/site/examples/link1";
        Assert.assertEquals(expectedLink,getLink);
        WebElement getH1 = driver.findElement(By.id("h1"));
        String textWritteninH1 = getH1.getText();
        String expectedWrittenH1 = "Link Page 1";
        Assert.assertEquals(expectedWrittenH1,textWritteninH1);
    }
    @Test
    public void clickButtonAndSeeOrHideText(){
        WebElement showButton = driver.findElement(By.id("show_text"));
        showButton.click();
        WebElement textAppear = driver.findElement(By.id("show_me"));
        String textWritten = textAppear.getText();
        Assert.assertEquals("I am here!",textWritten);

        WebElement hideButton = driver.findElement(By.name("hide_text"));
        hideButton.click();
        WebElement showButton2 = driver.findElement(By.id("show_text"));
        Assert.assertTrue(showButton2.isEnabled());

        WebElement hideButton2 = driver.findElement(By.name("hide_text"));
        Assert.assertFalse(hideButton2.isEnabled());
    }
    @Test
    public void enterTextInTextArea() {
        WebElement getElem = driver.findElement(By.id("text_area"));
        String textBefore = getElem.getText();
        String expectedBefore = "This is a text area";
        Assert.assertEquals(expectedBefore,textBefore);

        WebElement getElem2 = driver.findElement(By.name("vfb-10"));
        getElem2.click();
        getElem2.sendKeys("123");
        driver.findElement(By.id("result_button_text_area")).click();
        WebElement textAfter = driver.findElement(By.id("result_text_area"));
        String textAfter1 = textAfter.getText();
        Assert.assertEquals("You entered text area: \"This is a text area123\"",textAfter1);

        driver.findElement(By.id("clear_result_button_text_area")).click();
        String textAfter2 = getElem2.getText();
        Assert.assertEquals("This is a text area",textAfter2);
    }
    @Test
    public void enterTextInTextBox() {
        WebElement getText1 = driver.findElement(By.id("text"));
        String text = getText1.getText();
        Assert.assertEquals("",text);

        getText1.sendKeys(" 123ABC");
        text = getText1.getText();
        Assert.assertEquals("This is a text box 123ABC",text);

        getText1.clear();
        getText1.sendKeys(" 123ABC");
        text = getText1.getText();
        Assert.assertEquals(" 123ABC",text);
    }



    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }

}
