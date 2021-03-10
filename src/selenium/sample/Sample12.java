package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.page.FeedBackPage;
import selenium.page.GiveFeedbackPage;
import selenium.page.ThankPage;

import java.util.concurrent.TimeUnit;

public class Sample12 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    GiveFeedbackPage giveFeedbackPage;
    FeedBackPage feedBackPage;
    ThankPage thankPage;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        giveFeedbackPage = PageFactory.initElements(driver, GiveFeedbackPage.class);
        feedBackPage = PageFactory.initElements(driver, FeedBackPage.class);
        thankPage = PageFactory.initElements(driver, ThankPage.class);
    }


    @After
    public void tearAfter() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    // check that all field are empty and no tick are clicked
    //"Don't know" is selected in "Genre"
    //"Choose your option" in "How do you like us?"
    //check that the button send is blue with white letters

    @Test
    public void initialFeedbackPage() throws Exception {
        //checking fields are empty
        Assert.assertEquals("",giveFeedbackPage.getName());
        Assert.assertEquals("",giveFeedbackPage.getAge());

        //checking checkboxes are not selected
        Assert.assertFalse(giveFeedbackPage.verifyCheckBoxIsSelected(0));
        Assert.assertFalse(giveFeedbackPage.verifyCheckBoxIsSelected(1));
        Assert.assertFalse(giveFeedbackPage.verifyCheckBoxIsSelected(2));
        Assert.assertFalse(giveFeedbackPage.verifyCheckBoxIsSelected(3));

        //checking radioButtons are not selected
        Assert.assertFalse(giveFeedbackPage.verifyRadioButtonIsSelected(0));
        Assert.assertFalse(giveFeedbackPage.verifyRadioButtonIsSelected(1));

        //checking don't know radioButton is selected as gender
        Assert.assertTrue(giveFeedbackPage.verifyRadioButtonIsSelected(2));

        //Choose your option is selected in "How do you like us?"
        Assert.assertEquals("Choose your option", giveFeedbackPage.getSelectedOption());

        //Check button is Blue in color with White Text
        Assert.assertEquals("rgba(33, 150, 243, 1)", giveFeedbackPage.getSendButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedbackPage.getSendButtonTextColor());
    }

    // click "Send" without entering any data
    // check fields are empty or null
    // check button colors
    // (green with white letter and red with white letters)

    @Test
    public void emptyFeedbackPage() throws Exception {
        //click send
        giveFeedbackPage.clickOnSendBtn();

        //checking fields are empty
        Assert.assertEquals("",feedBackPage.getName());
        Assert.assertEquals("",feedBackPage.getAge());
        Assert.assertEquals("",feedBackPage.getLanguage());
        Assert.assertEquals("null",feedBackPage.getGender());
        Assert.assertEquals("null",feedBackPage.getOptionOfUs());
        Assert.assertEquals("",feedBackPage.getComment());

        //check button colors green with white letters
        Assert.assertEquals("rgba(76, 175, 80, 1)", feedBackPage.getConfirmButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPage.getConfirmButtonTextColor());

        //check button colors red with white letters
        Assert.assertEquals("rgba(244, 67, 54, 1)", feedBackPage.getDenyButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPage.getDenyButtonTextColor());
    }

    //fill the whole form
    // click "Send"
    //check fields are filled correctly
    // check button colors
    //(green with white letter and red with white letters)

    @Test
    public void notEmptyFeedbackPage() throws Exception {
        //fill the whole form
        giveFeedbackPage.enterName("Aizhan");
        giveFeedbackPage.enterAge("30");
        giveFeedbackPage.selectCheckBox(0);
        giveFeedbackPage.selectRadioBtn(1);
        giveFeedbackPage.selectValueFromDropDown(1);
        giveFeedbackPage.enterComment("Great");

        //check fields are filled correctly
        Assert.assertEquals("Aizhan",giveFeedbackPage.getName());
        Assert.assertEquals("30",giveFeedbackPage.getAge());
        Assert.assertTrue(giveFeedbackPage.verifyCheckBoxIsSelected(0));
        Assert.assertTrue(giveFeedbackPage.verifyRadioButtonIsSelected(1));
        Assert.assertEquals("Good", giveFeedbackPage.getSelectedOption());
        Assert.assertEquals("Great", giveFeedbackPage.getComment());

        //click send
        giveFeedbackPage.clickOnSendBtn();

        //check button colors green with white letter
        Assert.assertEquals("rgba(76, 175, 80, 1)", feedBackPage.getConfirmButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPage.getConfirmButtonTextColor());

        //check button colors red with white letter
        Assert.assertEquals("rgba(244, 67, 54, 1)", feedBackPage.getDenyButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPage.getDenyButtonTextColor());
    }

    // enter only name
    //click "Send"
    //click "Yes"
    //check message text: "Thank you, NAME, for your feedback!"
    //color of text is white with green on the background

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
        //enter name
        giveFeedbackPage.enterName("Aizhan");
        Assert.assertEquals("Aizhan",giveFeedbackPage.getName());

        //click send
        giveFeedbackPage.clickOnSendBtn();

        //click "yes"
        feedBackPage.clickOnConfirmBtn();

        //check message text
        Assert.assertEquals("Thank you, Aizhan, for your feedback!", thankPage.getMessageText());

        //check color of text
        Assert.assertEquals("rgba(76, 175, 80, 1)", thankPage.getMessageBackground());
        Assert.assertEquals("rgba(255, 255, 255, 1)", thankPage.getMessageTextColor());
    }

    //click "Send" (without entering anything
    //click "Yes"
    //check message text: "Thank you for your feedback!"
    //color of text is white with green on the background

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
        //click send
        giveFeedbackPage.clickOnSendBtn();

        //click "yes"
        feedBackPage.clickOnConfirmBtn();

        //check message text
        Assert.assertEquals("Thank you for your feedback!", thankPage.getMessageText());

        //check color of text
        Assert.assertEquals("rgba(76, 175, 80, 1)", thankPage.getMessageBackground());
        Assert.assertEquals("rgba(255, 255, 255, 1)", thankPage.getMessageTextColor());
    }

    //fill the whole form
    //click "Send"
    //click "No"
    //check fields are filled correctly

    @Test
    public void noOnFeedbackPage() throws Exception {
        //fill the whole form
        giveFeedbackPage.enterName("Aizhan");
        giveFeedbackPage.enterAge("30");
        giveFeedbackPage.selectCheckBox(0);
        giveFeedbackPage.selectRadioBtn(1);
        giveFeedbackPage.selectValueFromDropDown(1);
        giveFeedbackPage.enterComment("Great");

        //click send
        giveFeedbackPage.clickOnSendBtn();

        //click "no"
        feedBackPage.clickOnDenyBtn();

        //check fields are filled correctly
        Assert.assertEquals("Aizhan",giveFeedbackPage.getName());
        Assert.assertEquals("30",giveFeedbackPage.getAge());
        Assert.assertTrue(giveFeedbackPage.verifyCheckBoxIsSelected(0));
        Assert.assertTrue(giveFeedbackPage.verifyRadioButtonIsSelected(1));
        Assert.assertEquals("Good", giveFeedbackPage.getSelectedOption());
        Assert.assertEquals("Great", giveFeedbackPage.getComment());
    }
}
