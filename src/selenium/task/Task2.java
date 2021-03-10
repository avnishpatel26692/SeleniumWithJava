package selenium.task;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.page.ProvideFeedback;
import selenium.page.ReceivedFeedback;

import java.util.concurrent.TimeUnit;

public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    ProvideFeedback giveFeedBackPO;
    ReceivedFeedback getFeedBackPO;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        giveFeedBackPO = PageFactory.initElements(driver, ProvideFeedback.class);
        getFeedBackPO = PageFactory.initElements(driver, ReceivedFeedback.class);

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

    //         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
    @Test
    public void initialFeedbackPage() throws Exception {
        //Checking Fields are empty
        Assert.assertEquals("",giveFeedBackPO.getName());
        Assert.assertEquals("",giveFeedBackPO.getAge());

        //checking checkboxes are not selected
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(0));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(1));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(2));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(3));

        //checking radioButtons are not selected
        Assert.assertFalse(giveFeedBackPO.verifyRadioButtonIsSelected(0));
        Assert.assertFalse(giveFeedBackPO.verifyRadioButtonIsSelected(1));

        //checking don't know radioButton is selected as gender
        Assert.assertTrue(giveFeedBackPO.verifyRadioButtonIsSelected(2));

        //Choose your option is selected in "How do you like us?"
        Assert.assertEquals("Choose your option", giveFeedBackPO.getSelectedOption());

        //Check button is Blue in color with White Text
        Assert.assertEquals("rgba(33, 150, 243, 1)", giveFeedBackPO.getSendButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedBackPO.getSendButtonTextColor());
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
        //filling up the fields
        giveFeedBackPO.enterName("John");
        giveFeedBackPO.enterAge("23");
        giveFeedBackPO.selectCheckBox(0);
        giveFeedBackPO.selectCheckBox(3);
        giveFeedBackPO.selectRadioBtn(0);
        giveFeedBackPO.selectValueFromDropDown(3);
        giveFeedBackPO.enterComment("Hello world");
        giveFeedBackPO.clickOnSendBtn();
        //checking name and age
        Assert.assertEquals("John",getFeedBackPO.getName());
        Assert.assertEquals("23",getFeedBackPO.getAge());
        //checking checkboxes
        Assert.assertEquals("English,Chinese", getFeedBackPO.getLang());
        //checking gender
        Assert.assertEquals("male", getFeedBackPO.getGender());
        //checking dropdown value
        Assert.assertEquals("Bad",getFeedBackPO.getOpinion());
        //checking comment
        Assert.assertEquals("Hello world",getFeedBackPO.getComment());



    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
        giveFeedBackPO.enterName("Poll");
        giveFeedBackPO.clickOnSendBtn();
        getFeedBackPO.pressYes();
        Assert.assertEquals("Thank you, Poll, for your feedback!",getFeedBackPO.getMsg());
        Assert.assertEquals("rgba(0, 0, 0, 0)",getFeedBackPO.getMsgBgColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)",getFeedBackPO.getMsgTxtColor());
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        giveFeedBackPO.clickOnSendBtn();
        getFeedBackPO.pressYes();
        Assert.assertEquals("Thank you for your feedback!",getFeedBackPO.getMsg());
        Assert.assertEquals("rgba(0, 0, 0, 0)",getFeedBackPO.getMsgBgColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)",getFeedBackPO.getMsgTxtColor());
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
        giveFeedBackPO.enterName("John");
        giveFeedBackPO.enterAge("23");
        giveFeedBackPO.selectCheckBox(0);
        giveFeedBackPO.selectCheckBox(3);
        giveFeedBackPO.selectRadioBtn(0);
        giveFeedBackPO.selectValueFromDropDown(3);
        giveFeedBackPO.enterComment("Hello world");
        giveFeedBackPO.clickOnSendBtn();

        getFeedBackPO.pressNo();
        //checking name and age
        Assert.assertEquals("John",giveFeedBackPO.getName());
        Assert.assertEquals("23",giveFeedBackPO.getAge());
        //checking checkboxes
        Assert.assertTrue(giveFeedBackPO.verifyCheckBoxIsSelected(0));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(1));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(2));
        Assert.assertTrue(giveFeedBackPO.verifyCheckBoxIsSelected(3));
        //checking gender
        Assert.assertTrue(giveFeedBackPO.verifyRadioButtonIsSelected(0));
        //checking dropdown value
        Assert.assertEquals("Bad",giveFeedBackPO.getSelectedOption());
        //checking comment
        Assert.assertEquals("Hello world",giveFeedBackPO.getComment());

    }
}