package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.page.AgePage;
import selenium.page.AgeSubmitted;
import selenium.page.FeedbackPage;
import selenium.page.GiveFeedbackPage;

import java.util.concurrent.TimeUnit;

public class Task
{
    static String libWithDriversLocation = System.getProperty ("user.dir") +"/lib/";
    static WebDriver driver;
    FeedbackPage giveFeedbackPO;


    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        giveFeedbackPO = PageFactory.initElements(driver, FeedbackPage.class);

        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

    }

    @Test
    public void initialFeedbackPage() throws Exception {

       //check that all field are empty and no tick are clicked
        Assert.assertEquals("",giveFeedbackPO.getName());
        Assert.assertFalse(giveFeedbackPO.verifySpanishCheckbox());
        Assert.assertFalse(giveFeedbackPO.verifyEnglishCheckbox());
        Assert.assertFalse(giveFeedbackPO.verifyFrenchCheckbox());
        Assert.assertFalse(giveFeedbackPO.verifyChineseCheckbox());
        Assert.assertFalse(giveFeedbackPO.verifyMaleIsSelected());
        Assert.assertFalse(giveFeedbackPO.verifyFemaleIsSelected());

       //"Don't know" is selected in "Genre"
        Assert.assertTrue(giveFeedbackPO.verifyDontKnowIsSelected());

       //"Choose your option" in "How do you like us?"
        Assert.assertEquals("Choose yout option", giveFeedbackPO);

      // Check that the button send is blue with white letters
        Assert.assertEquals("rgba(33, 150, 243, 1)", giveFeedbackPO.getSendButtonBackGroundColoe());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedbackPO.getSendButtonTextColor());
    }



    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
      // click "Send" without entering any data
        giveFeedbackPO.clickSend();

//       check fields are empty or null


//         check button colors
//         (green with white letter and red with white letters)
    }

//    @Test
//    public void notEmptyFeedbackPage() throws Exception {
////         TODO:
////         fill the whole form, click "Send"
////         check fields are filled correctly
////         check button colors
////         (green with white letter and red with white letters)
//    }
//
//    @Test
//    public void yesOnWithNameFeedbackPage() throws Exception {
////         TODO:
////         enter only name
////         click "Send"
////         click "Yes"
////         check message text: "Thank you, NAME, for your feedback!"
////         color of text is white with green on the background
//    }
//
//    @Test
//    public void yesOnWithoutNameFeedbackPage() throws Exception {
////         TODO:
////         click "Send" (without entering anything
////         click "Yes"
////         check message text: "Thank you for your feedback!"
////         color of text is white with green on the background
//    }
//
//    @Test
//    public void noOnFeedbackPage() throws Exception {
////         TODO:
////         fill the whole form
////         click "Send"
////         click "No"
////         check fields are filled correctly
//    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}