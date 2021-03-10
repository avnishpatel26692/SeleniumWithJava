package page;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
//import selenium.page.GiveFeedback;

import java.util.concurrent.TimeUnit;

public class Sample12 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    GiveFeedback giveFeedbackPO;


    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        giveFeedbackPO = PageFactory.initElements(driver, GiveFeedback.class);
//        feedBackPO = PageFactory.initElements(driver, FeedBack.class);


        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }
    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
        Assert.assertEquals("", giveFeedbackPO.getName());
        Assert.assertEquals("", giveFeedbackPO.getAge());

        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(0));
        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(1));
        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(2));
        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(3));

        //checking radioButtons are not selected
        Assert.assertFalse(giveFeedbackPO.verifyRadioButtonIsSelected(0));
        Assert.assertFalse(giveFeedbackPO.verifyRadioButtonIsSelected(1));

        //checking don't know radioButton is selected as gender
        Assert.assertTrue(giveFeedbackPO.verifyRadioButtonIsSelected(2));

        //Choose your option is selected in "How do you like us?"
        Assert.assertEquals("Choose your option", giveFeedbackPO.getSelectedOption());

        //Check button is Blue in color with White Text
        Assert.assertEquals("rgba(33, 150, 243, 1)", giveFeedbackPO.sendButtonBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedbackPO.getSendButtonColor());
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
