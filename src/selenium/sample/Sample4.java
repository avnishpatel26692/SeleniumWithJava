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
    public static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
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
    public void tearAfter() throws InterruptedException {
        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void clickOnButton() throws Exception {
        WebElement showButton = driver.findElement(By.id("show_text"));
        showButton.click();
        WebElement textAppear = driver.findElement(By.id("show_me"));
        String text = textAppear.getText();
        Assert.assertEquals("I am here!", text);
        System.out.println("clicked on button");
    }

    @Test
    public void clearText() {
        WebElement textBox = driver.findElement(By.name("vfb-5"));
        textBox.clear();
        textBox.sendKeys("Latvia");
    }

    @Test
    public void clickLink()  {
        WebElement link = driver.findElement(By.cssSelector("a[title='Link 1']"));
        link.click();

        WebElement textAppear = driver.findElement(By.tagName("h1"));
        String text = textAppear.getText();
        Assert.assertEquals("Link Page 1", text);
    }

    @Test
    public void clickButtonAndSeeOrHideText()  {
        WebElement showMe = driver.findElement(By.id("show_me"));
        Assert.assertFalse(showMe.isDisplayed());

        WebElement showText = driver.findElement(By.id("show_text"));
        Assert.assertTrue(showText.isEnabled());

        WebElement hideText = driver.findElement(By.name("hide_text"));
        Assert.assertFalse(hideText.isEnabled());

        showText.click();

        Assert.assertTrue(showMe.isDisplayed());

        Assert.assertFalse(showText.isEnabled());

        hideText.click();

        Assert.assertFalse(showMe.isDisplayed());

        Assert.assertTrue(showText.isEnabled());

        Assert.assertFalse(hideText.isEnabled());
    }

    @Test
    public void testTextArea() {
        WebElement area = driver.findElement(By.name("vfb-10"));
        area.clear();
        area.sendKeys("Latvia");
        String actualText = area.getAttribute("value");
        Assert.assertTrue(actualText.contains("Latvia"));

        area.clear();

        area.sendKeys("Riga");
        actualText = area.getAttribute("value");
        Assert.assertTrue(actualText.contains("Riga"));
    }

    @Test
    public void enterTextInTextBox() {
        WebElement area = driver.findElement(By.id("text"));

        String actualText = area.getAttribute("value");
        Assert.assertEquals("This is a text box", actualText);

        area.clear();

        area.sendKeys("Aizhan");
        actualText = area.getAttribute("value");
        Assert.assertTrue(actualText.contains("Aizhan"));
    }
}
