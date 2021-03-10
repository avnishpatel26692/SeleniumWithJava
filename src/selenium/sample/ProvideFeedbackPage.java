package selenium.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProvideFeedbackPage extends Page {

    @FindBy(id = "fb_name")
    private WebElement nameText;

    @FindBy(id = "fb_age")
    private WebElement ageText;

    @FindBy(xpath = "//*[@id=\"lang_check\"]//*[@type='checkbox']")
    private List<WebElement> languageBoxes;

    @FindBy(id = "like_us")
    private WebElement howYouLike;

    @FindBy(xpath = "//*[@id=\"fb_form\"]/form/div[4]//*[@type='radio']")
    private List<WebElement> genres;

    @FindBy(xpath = "//*[@id=\"fb_form\"]/form/button")
    private WebElement sendBtn;

    @FindBy(xpath = "//*[@id=\"fb_form\"]/form/div[6]/textarea")
    private WebElement comment;

    public WebElement getNameText() {
        return nameText;
    }

    public WebElement getAgeText() {
        return ageText;
    }

    public List<WebElement> getLanguageBoxes() {
        return languageBoxes;
    }

    public WebElement getHowYouLike() {
        return howYouLike;
    }

    public List<WebElement> getGenres() {
        return genres;
    }

    public WebElement getSendBtn() {
        return sendBtn;
    }

    public void enterName(String s){
        nameText.sendKeys(s);
    }

    public void enterAge(String s){
        ageText.sendKeys(s);
    }

    public void selectCheckBox(int index){
        languageBoxes.get(index).click();
    }

    public void selectRadioButton(int index){
        genres.get(index).click();
    }

    public void selectHowYouLikeUsOption(int index){
        getSelector(howYouLike).selectByIndex(index);
    }

    public void enterComment(String s){
        comment.sendKeys(s);
    }

}
