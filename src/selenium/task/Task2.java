package selenium.task;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.page.GiveFeedBackPage;
import selenium.page.GiveFeedBackPage2;

import java.util.concurrent.TimeUnit;

public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    GiveFeedBackPage giveFeedBackPO;
    GiveFeedBackPage2 giveFeedBack2PO;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        giveFeedBackPO = PageFactory.initElements(driver, GiveFeedBackPage.class);
        giveFeedBack2PO = PageFactory.initElements(driver, GiveFeedBackPage2.class);

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
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

        giveFeedBackPO.clickOnSendBtn();


        Assert.assertEquals("", giveFeedBack2PO.getName());
        Assert.assertEquals("", giveFeedBack2PO.getAge());
        Assert.assertEquals("", giveFeedBack2PO.getLang());
        Assert.assertEquals("", giveFeedBack2PO.getGender());
        Assert.assertEquals("", giveFeedBack2PO.getOpinion());
        Assert.assertEquals("", giveFeedBack2PO.getComment());



        Assert.assertEquals("", giveFeedBack2PO.getNoBgColor());
        Assert.assertEquals("", giveFeedBack2PO.getYesBgColor());










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

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }

}