package selenium.sample.task.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class FeedbackMainPage {
    @FindBy(how = How.XPATH, using = "//input[@id='fb_name']")
    private WebElement nameField;
    @FindBy(how = How.XPATH, using = "//input[@id='fb_age']")
    private WebElement ageField;

    @FindBy(how = How.XPATH, using = "//input[@value='English']")
    private WebElement checkboxEnglish;
    @FindBy(how = How.XPATH, using = "//input[@value='French']")
    private WebElement checkboxFrench;
    @FindBy(how = How.XPATH, using = "//input[@value='Spanish']")
    private WebElement checkboxSpanish;
    @FindBy(how = How.XPATH, using = "//input[@value='Chinese']")
    private WebElement checkboxChinese;

    @FindBy(how = How.XPATH, using = "//input[@class='w3-radio'][@value='male']")
    private WebElement radioBtnMale;
    @FindBy(how = How.XPATH, using = "//input[@class='w3-radio'][@value='female']")
    private WebElement radioBtnFemale;
    @FindBy(how = How.XPATH, using = "//input[@name='gender'][@disabled]")
    private WebElement radioBtnDisabled;
//
//    @FindBy(how = How.XPATH, using = "//select/option[@disabled]")
//    private WebElement selectNoOption;
//    @FindBy(how = How.XPATH, using = "//select/option[@value='Good']")
//    private WebElement selectGoodOption;
//    @FindBy(how = How.XPATH, using = "//select/option[@value='Ok, i guess']")
//    private WebElement selectOkOption;
//    @FindBy(how = How.XPATH, using = "//select/option[@value='Bad']")
//    private WebElement selectBadOption;
//    @FindBy(how = How.XPATH, using = "//select/option[@value='Why me?']")
//    private WebElement selectWhyOption;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement likeUsDropdown;

    @FindBy(how = How.XPATH, using = "//textarea[@name='comment']")
    private WebElement commentBox;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement submitButton;


    public void enterName(String name){
        nameField.clear();
        nameField.sendKeys(name);
    }

    public String getName(){
        return  nameField.getAttribute("value");
    }
    public String getAge(){
        return ageField.getAttribute("value");
    }

    public void enterAge(String age){
        ageField.clear();
        ageField.sendKeys(age);
    }

    public void clickCheckbox(String language) {
        switch (language) {
            case "English":
                checkboxEnglish.click();
                break;
            case "French":
                checkboxFrench.click();
                break;
            case "Spanish":
                checkboxSpanish.click();
                break;
            case "Chinese":
                checkboxChinese.click();
                break;
        }
    }
    public boolean verifyIsSelected(String language) {
        switch (language) {
            case "English":
                return checkboxEnglish.isSelected();
            case "French":
                return checkboxFrench.isSelected();
            case "Spanish":
                return checkboxSpanish.isSelected();
            case "Chinese":
                return checkboxChinese.isSelected();
        }

        return false;
    }
    public void clickRadioBtn(int number){
        switch (number){
            case 0:
                radioBtnMale.click();
                break;
            case 1:
                radioBtnFemale.click();
                break;
            case 2:
                radioBtnDisabled.click();
                break;

        }
    }
    public Boolean verifyRadioBtn(int number){
        switch (number){
            case 0:
                return radioBtnMale.isSelected();
            case 1:
                return radioBtnFemale.isSelected();
            case 2:
                return radioBtnDisabled.isSelected();

        }
        return false;
    }
    public void optionSelect(int number){
        Select dropdown  = new Select(likeUsDropdown);
        dropdown.selectByIndex(number);
    }
    public String getOptionSelect(){
        Select dropdown  = new Select(likeUsDropdown);
        return dropdown.getFirstSelectedOption().getText();
    }
    public void enterComment(String text){
        commentBox.sendKeys(text);
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public String getSendBtnBgColor()
    {
        return submitButton.getCssValue("background-color");
    }

    public String getSendBtnTextColor()
    {
        return submitButton.getCssValue("color");
    }

    public String getCommentText() {
        return commentBox.getAttribute("value");
    }
}
