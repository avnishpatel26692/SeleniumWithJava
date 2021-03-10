package selenium.sample.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.sample.pages.AgePage;
import selenium.sample.pages.FeedbackPage;
import selenium.sample.pages.GiveFeedBackPage;

import java.util.concurrent.TimeUnit;

public class FeedbackTest {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    FeedbackPage feedbackPO;
    GiveFeedBackPage giveFeedbackPO;


    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        feedbackPO = PageFactory.initElements(driver, FeedbackPage.class);
        giveFeedbackPO = PageFactory.initElements(driver, GiveFeedBackPage.class);

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
        Assert.assertEquals("",feedbackPO.getAge());
        Assert.assertEquals("",feedbackPO.getName());
        Assert.assertFalse(feedbackPO.verifyLanguageSelected(0));
        Assert.assertFalse(feedbackPO.verifyLanguageSelected(1));
        Assert.assertFalse(feedbackPO.verifyLanguageSelected(2));
        Assert.assertFalse(feedbackPO.verifyLanguageSelected(3));

        Assert.assertTrue(feedbackPO.verifyUnknownGenderSelected());

        Assert.assertEquals("Choose your option", feedbackPO.getTheSelectedOption());

        Assert.assertEquals("rgba(33, 150, 243, 1)", feedbackPO.checkSubmitBtnBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackPO.checkSubmitBtnLetterColor());
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
        feedbackPO.submit();

        Assert.assertEquals(null, giveFeedbackPO.getName());
        Assert.assertEquals(null, giveFeedbackPO.getAge());
        Assert.assertEquals("null", giveFeedbackPO.getGender());
        Assert.assertEquals("null", giveFeedbackPO.getOption());
        Assert.assertEquals("", giveFeedbackPO.getComment());

        Assert.assertEquals("rgba(76, 175, 80, 1)", giveFeedbackPO.checkYesBtnBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedbackPO.checkYesBtnLetterColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)", giveFeedbackPO.checkNoBtnBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedbackPO.checkNoBtnLetterColor());
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)

    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background

    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
    }
}

