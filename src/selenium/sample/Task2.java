package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.sample.page.FeedbackPage;
import selenium.sample.page.FeedbackSubmittedPage;

import java.util.concurrent.TimeUnit;

public class Task2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    static WebDriver driver;
    static FeedbackPage feedbackPagePO;
    static FeedbackSubmittedPage feedbackSubmittedPO;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        feedbackPagePO = PageFactory.initElements(driver, FeedbackPage.class);
        feedbackSubmittedPO = PageFactory.initElements(driver, FeedbackSubmittedPage.class);
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
//         check that all field are empty
        Assert.assertEquals("",feedbackPagePO.getName());
        Assert.assertEquals("",feedbackPagePO.getAge());
//         no tick are clicked
        Assert.assertFalse(feedbackPagePO.verifyCheckBoxIsSelected(0));
        Assert.assertFalse(feedbackPagePO.verifyCheckBoxIsSelected(1));
        Assert.assertFalse(feedbackPagePO.verifyCheckBoxIsSelected(2));
        Assert.assertFalse(feedbackPagePO.verifyCheckBoxIsSelected(3));

        Assert.assertFalse(feedbackPagePO.verifyRadioButtonIsSelected(0));
        Assert.assertFalse(feedbackPagePO.verifyRadioButtonIsSelected(1));
//         "Don't know" is selected in "Genre"
        Assert.assertTrue(feedbackPagePO.verifyRadioButtonIsSelected(2));
//         "Choose your option" in "How do you like us?"
        Assert.assertEquals("Choose your option", feedbackPagePO.getSelectedOption());
//         check that the button send is blue with white letters
        Assert.assertEquals("rgba(33, 150, 243, 1)",feedbackPagePO.getSendButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)",feedbackPagePO.getSendButtonTextColor());
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
        feedbackPagePO.clickOnSendBtn();
        Assert.assertEquals("",feedbackSubmittedPO.getName());
        Assert.assertEquals("",feedbackSubmittedPO.getAge());
        Assert.assertEquals("",feedbackSubmittedPO.getLang());
        Assert.assertEquals("null",feedbackSubmittedPO.getGender());
        Assert.assertEquals("null",feedbackSubmittedPO.getOpinion());
        Assert.assertEquals("",feedbackSubmittedPO.getComment());
        Assert.assertEquals("",feedbackSubmittedPO.getComment());

        Assert.assertEquals("rgba(76, 175, 80, 1)",feedbackSubmittedPO.getYesBgColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)",feedbackSubmittedPO.getNoBgColor());
        Assert.assertEquals("rgba(0, 0, 0, 1)",feedbackSubmittedPO.getBtnTextColor());
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
        feedbackPagePO.enterName("Sandra");
        feedbackPagePO.enterAge("26");
        feedbackPagePO.selectCheckBox(0);
        feedbackPagePO.selectCheckBox(2);
        feedbackPagePO.selectRadioBtn(1);
        feedbackPagePO.selectValueFromDropDown(1);
        feedbackPagePO.enterComment("Have a great day!");
        feedbackPagePO.clickOnSendBtn();

        Assert.assertEquals("Sandra",feedbackSubmittedPO.getName());
        Assert.assertEquals("26",feedbackSubmittedPO.getAge());
        Assert.assertEquals("English,Spanish", feedbackSubmittedPO.getLang());
        Assert.assertEquals("female", feedbackSubmittedPO.getGender());
        Assert.assertEquals("Good", feedbackSubmittedPO.getOpinion());
        Assert.assertEquals("Have a great day!", feedbackSubmittedPO.getComment());
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
        feedbackPagePO.enterName("Madina");
        feedbackPagePO.clickOnSendBtn();
        feedbackSubmittedPO.pressYes();
        Assert.assertEquals("Thank you, Madina, for your feedback!", feedbackSubmittedPO.getMsg());
        Assert.assertEquals("rgba(0, 0, 0, 0)", feedbackSubmittedPO.getMsgBgColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackSubmittedPO.getMsgTxtColor());
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        feedbackPagePO.clickOnSendBtn();
        feedbackSubmittedPO.pressYes();
        Assert.assertEquals("Thank you for your feedback!", feedbackSubmittedPO.getMsg());
        Assert.assertEquals("rgba(0, 0, 0, 0)", feedbackSubmittedPO.getMsgBgColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackSubmittedPO.getMsgTxtColor());
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
        feedbackPagePO.enterName("Sandra");
        feedbackPagePO.enterAge("26");
        feedbackPagePO.selectCheckBox(0);
        feedbackPagePO.selectCheckBox(2);
        feedbackPagePO.selectRadioBtn(1);
        feedbackPagePO.selectValueFromDropDown(1);
        feedbackPagePO.enterComment("Have a great day!");
        feedbackPagePO.clickOnSendBtn();

        feedbackSubmittedPO.pressNo();

        Assert.assertEquals("Sandra",feedbackPagePO.getName());
        Assert.assertEquals("26",feedbackPagePO.getAge());
        Assert.assertTrue(feedbackPagePO.verifyCheckBoxIsSelected(0));
        Assert.assertFalse(feedbackPagePO.verifyCheckBoxIsSelected(1));
        Assert.assertTrue(feedbackPagePO.verifyCheckBoxIsSelected(2));
        Assert.assertFalse(feedbackPagePO.verifyCheckBoxIsSelected(3));
        //checking gender
        Assert.assertTrue(feedbackPagePO.verifyRadioButtonIsSelected(1));
        //checking dropdown value
        Assert.assertEquals("Good",feedbackPagePO.getSelectedOption());
        //checking comment
        Assert.assertEquals("Have a great day!",feedbackPagePO.getComment());

    }

}
