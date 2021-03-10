package selenium.sample.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class GiveFeedBackPage {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameText;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageText;

    @FindBy(how = How.ID, using = "language")
    private WebElement languageText;

    @FindBy(how = How.ID, using = "gender")
    private WebElement genderText;

    @FindBy(how = How.ID, using = "option")
    private WebElement dropdownText;

    @FindBy(how = How.ID, using = "comment")
    private WebElement commentText;

    @FindBy(how = How.CSS, using = "button.w3-green")
    private WebElement yesButton;

    @FindBy(how = How.CSS, using = "button.w3-red")
    private WebElement noButton;

    public String getName() {
        return  nameText.getAttribute("value");
    }

    public String getAge() {
        return ageText.getAttribute("value");

    }

    public String getLanguage(){
        return languageText.getText();
    }

    public String getGender(){
        return genderText.getText();
    }

    public String getOption(){
        return dropdownText.getText();
    }

    public String getComment(){
        return commentText.getText();
    }

    public String checkYesBtnBackgroundColor() {
        return yesButton.getCssValue("background-color");
    }

    public String checkYesBtnLetterColor() {
        return yesButton.getCssValue("color");
    }

    public String checkNoBtnBackgroundColor() {
        return noButton.getCssValue("background-color");
    }

    public String checkNoBtnLetterColor() {
        return noButton.getCssValue("color");
    }



}
