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

    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    @FindBy(how = How.CSS, using = "div.w3-green")
    private WebElement messageBox;



    public String getName() {
        return nameText.getText();
    }

    public String getAge() {
        return ageText.getText();

    }

    public String getLanguage() {
        return languageText.getText();
    }

    public String getGender() {
        return genderText.getText();
    }

    public String getOption() {
        return dropdownText.getText();
    }

    public String getComment() {
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

    public void clickSubmit() {
        yesButton.click();
    }

    public void clickCancel() {
        noButton.click();
    }

    public String getMessage(){
        return message.getText();
    }

    public String getMessageColor(){
        return message.getCssValue("color");
    }

    public String getMessageBoxColor(){
        return messageBox.getCssValue("background-color");
    }


}
