package selenium.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProvideFeedbackPage {

    @FindBy(id = "fb_name")
    WebElement nameText;

    @FindBy(id = "fb_age")
    WebElement ageText;

    @FindBy(xpath = "//*[@id=\"lang_check\"]//*[@type='checkbox']")
    List<WebElement> languageBoxes;

    @FindBy(id = "like_us")
    WebElement howYouLike;

    @FindBy(xpath = "//*[@id=\"fb_form\"]/form/div[4]//*[@type='radio']")
    List<WebElement> genres;

    @FindBy(xpath = "//*[@id=\"fb_form\"]/form/button")
    WebElement sendBtn;

    Select getHowYouLikeSelector(){
        return new Select(howYouLike);
    }

    WebElement getSelectedOption(Select select){
        return select.getFirstSelectedOption();
    }
}
