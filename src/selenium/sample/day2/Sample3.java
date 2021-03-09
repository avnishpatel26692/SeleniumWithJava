package selenium.sample.day2;

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

public class Sample3 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();}
    @Test
    public void selectCheckBox(){
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[class='w3-check'][type='checkbox']"));
        for(int i = 0; i<checkboxes.size();i++){
            System.out.println("Option " +(i +1)+ " before click "+checkboxes.get(i).isSelected());
            Assert.assertFalse(checkboxes.get(i).isSelected());
            checkboxes.get(i).click();
            Assert.assertTrue(checkboxes.get(i).isSelected());
            System.out.println("Option " +(i + 1)+" after click "+checkboxes.get(i).isSelected());
            checkboxes.get(i).click();
        }
        Assert.assertFalse(checkboxes.get(2).isSelected());
        checkboxes.get(2).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']")).isSelected());


    }



    @Test
    public void selectRadioButton(){
        List<WebElement> radiobutton = driver.findElements(By.cssSelector("input[class='w3-check'][type='radio']"));
        for(int i = 0; i<radiobutton.size();i++) {
            System.out.println("Option " + (i + 1) + " before click " + radiobutton.get(i).isSelected());
            Assert.assertFalse(radiobutton.get(i).isSelected());
            radiobutton.get(i).click();
            Assert.assertTrue(radiobutton.get(i).isSelected());
            System.out.println("Option " + (i + 1) + " after click " + radiobutton.get(i).isSelected());
            radiobutton.get(i).click();
        }
        Assert.assertFalse(radiobutton.get(1).isSelected());
        radiobutton.get(1).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio']")).isSelected());
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
