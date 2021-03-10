package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class Task2 extends Sample{

    ProvideFeedbackPage page;

    @Override
    public void setUp() {
        super.setUp();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        page = PageFactory.initElements(driver, ProvideFeedbackPage.class);
    }

    @Test
    public void initialFeedbackPage() {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters

        assertTrue(page.nameText.getText().isEmpty());
        assertTrue(page.ageText.getText().isEmpty());
        assertTrue(page.genres.get(2).isSelected());

        page.languageBoxes.forEach(element -> {
            assertFalse(element.isSelected());
        });

        assertEquals("Choose your option", page.getSelectedOption(page.getHowYouLikeSelector()).getText());
        assertEquals("rgba(33, 150, 243, 1)", page.sendBtn.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", page.sendBtn.getCssValue("color"));
    }

    @Test
    public void emptyFeedbackPage() {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
            page.sendBtn.click();

        assertEquals("rgba(33, 150, 243, 1)", page.sendBtn.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", page.sendBtn.getCssValue("color"));
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
