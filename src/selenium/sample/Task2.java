package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class Task2 extends Sample {

    ProvideFeedbackPage provideFeedbackPage;
    CheckFeedbackPage checkFeedbackPage;

    @Override
    public void setUp() {
        super.setUp();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        provideFeedbackPage = PageFactory.initElements(driver, ProvideFeedbackPage.class);
    }

    @Test
    public void initialFeedbackPage() {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters

        assertTrue(provideFeedbackPage.getText(provideFeedbackPage.getNameText()).isEmpty());
        assertTrue(provideFeedbackPage.getText(provideFeedbackPage.getAgeText()).isEmpty());
        assertTrue(provideFeedbackPage.getGenres().get(2).isSelected());

        provideFeedbackPage.getLanguageBoxes().forEach(element -> {
            assertFalse(element.isSelected());
        });

        assertEquals("Choose your option", provideFeedbackPage.getSelectedOption(provideFeedbackPage.getHowYouLike()).getText());
        assertEquals("rgba(33, 150, 243, 1)", provideFeedbackPage.getBackgroundColor(provideFeedbackPage.getSendBtn()));
        assertEquals("rgba(255, 255, 255, 1)", provideFeedbackPage.getColor(provideFeedbackPage.getSendBtn()));
    }

    @Test
    public void emptyFeedbackPage() {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)

        provideFeedbackPage.getSendBtn().click();
        checkFeedbackPage = PageFactory.initElements(driver, CheckFeedbackPage.class);

        checkFeedbackPage.getDescriptions().forEach(element -> {
            assertEmptyOrNull(element.getText());
        });

        assertEquals("rgba(76, 175, 80, 1)", checkFeedbackPage.getBackgroundColor(checkFeedbackPage.getYesButton()));
        assertEquals("rgba(244, 67, 54, 1)", checkFeedbackPage.getBackgroundColor(checkFeedbackPage.getNoButton()));
        assertEquals("rgba(255, 255, 255, 1)", checkFeedbackPage.getColor(checkFeedbackPage.getYesButton()));
        assertEquals("rgba(255, 255, 255, 1)", checkFeedbackPage.getColor(checkFeedbackPage.getNoButton()));

    }

    @Test
    public void notEmptyFeedbackPage() {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)

        provideFeedbackPage.enterName("John");
        provideFeedbackPage.enterAge("34");
        provideFeedbackPage.selectCheckBox(0);
        provideFeedbackPage.selectCheckBox(1);
        provideFeedbackPage.selectRadioButton(1);
        provideFeedbackPage.selectHowYouLikeUsOption(1);
        provideFeedbackPage.enterComment("some comment");

        provideFeedbackPage.getSendBtn().click();
        checkFeedbackPage = PageFactory.initElements(driver, CheckFeedbackPage.class);

        assertEquals("John", checkFeedbackPage.getText(checkFeedbackPage.getDescriptions().get(0)));
        assertEquals("34", checkFeedbackPage.getText(checkFeedbackPage.getDescriptions().get(1)));
        assertEquals("English,French", checkFeedbackPage.getText(checkFeedbackPage.getDescriptions().get(2)));
        assertEquals("female", checkFeedbackPage.getText(checkFeedbackPage.getDescriptions().get(3)));
        assertEquals("Good", checkFeedbackPage.getText(checkFeedbackPage.getDescriptions().get(4)));
        assertEquals("some comment", checkFeedbackPage.getText(checkFeedbackPage.getDescriptions().get(5)));
    }

    @Test
    public void yesOnWithNameFeedbackPage() {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
        provideFeedbackPage.enterName("John");
        provideFeedbackPage.getSendBtn().click();
        checkFeedbackPage = PageFactory.initElements(driver, CheckFeedbackPage.class);

        checkFeedbackPage.getYesButton().click();
        assertEquals("Thank you, John, for your feedback!", checkFeedbackPage.getMessage().getText());
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        provideFeedbackPage.getSendBtn().click();
        checkFeedbackPage = PageFactory.initElements(driver, CheckFeedbackPage.class);

        checkFeedbackPage.getYesButton().click();
        assertEquals("Thank you for your feedback!", checkFeedbackPage.getMessage().getText());
    }

    @Test
    public void noOnFeedbackPage() {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
        provideFeedbackPage.enterName("John");
        provideFeedbackPage.enterAge("34");
        provideFeedbackPage.selectCheckBox(0);
        provideFeedbackPage.selectCheckBox(1);
        provideFeedbackPage.selectRadioButton(1);
        provideFeedbackPage.selectHowYouLikeUsOption(1);
        provideFeedbackPage.enterComment("some comment");

        provideFeedbackPage.getSendBtn().click();
        checkFeedbackPage = PageFactory.initElements(driver, CheckFeedbackPage.class);

        checkFeedbackPage.getNoButton().click();

        assertEquals("John", provideFeedbackPage.getNameText().getAttribute("value"));
        assertEquals("34", provideFeedbackPage.getAgeText().getAttribute("value"));
        assertTrue(provideFeedbackPage.getLanguageBoxes().get(0).isSelected());
        assertTrue(provideFeedbackPage.getLanguageBoxes().get(1).isSelected());
        assertTrue(provideFeedbackPage.getGenres().get(1).isSelected());
        assertEquals("Good", provideFeedbackPage.getSelectedOption(provideFeedbackPage.getHowYouLike()).getText());

    }

    static void assertEmptyOrNull(String s) {
        if (s != null) {
            if (!s.isEmpty()) {
                if (!s.contains("null")) {
                    fail("Value: " + s + " need be empty or null");
                }
            }
        }
    }
}
