package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample8 {
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

    //selectCheckBox - create a “for” loop for element with selector “.w3-check[type='checkbox']”,
    // within loop check that checkbox is not selected, then click on it and check that it is selected, then click again
    //Then via getElements check that “option 3” is not selected, then click on it and
    // check then element with css “".w3-check[value='Option 3'][type='checkbox']“” is selected
    @Test
    public void selectCheckBox() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        System.out.println("number of Elements: " + checkboxes.size());

        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
            checkbox.click();
            Assert.assertTrue(checkbox.isSelected());
            checkbox.click();
        }
        WebElement checkbox3 = driver.findElement(By.cssSelector("input#vfb-6-2"));
        Assert.assertFalse(checkbox3.isSelected());
        checkbox3.click();
        Assert.assertTrue(checkbox3.isSelected());
    }

    //selectRadioButton - create a “for” loop for element with selector “.w3-check[type=radio']”,
    // within loop check that checkbox is not selected, then click on it and check that it is selected, then click again
    //Then via getElements check that “option 3” is not selected, then click on it
    // and check then element with css “".w3-check[value='Option 3'][type=radio']“” is selected
    @Test
    public void selectRadioButton() {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type= 'radio']"));
        for (WebElement radio : radioButtons) {
            Assert.assertFalse(radio.isSelected());
            radio.click();
            Assert.assertTrue(radio.isSelected());
            radio.click();
        }
        WebElement radioButton2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio']"));
        Assert.assertFalse(radioButton2.isSelected());
        radioButton2.click();
        Assert.assertTrue(radioButton2.isSelected());


    }
}
