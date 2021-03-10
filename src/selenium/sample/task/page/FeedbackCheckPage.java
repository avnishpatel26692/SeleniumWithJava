package selenium.sample.task.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedbackCheckPage {
    @FindBy(how = How.XPATH, using = "//span[@id='name']")
    private WebElement nameField;
    @FindBy(how = How.XPATH, using = "//span[@id='age']")
    private WebElement ageField;
    @FindBy(how = How.XPATH, using = "//span[@id='language']")
    private WebElement languageField;
    @FindBy(how = How.XPATH, using = "//span[@id='gender']")
    private WebElement genderField;
    @FindBy(how = How.XPATH, using = "//span[@id='option']")
    private WebElement optionField;
    @FindBy(how = How.XPATH, using = "//span[@id='comment']")
    private WebElement commentField;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Yes')]")
    private WebElement buttonYes;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'No')]")
    private WebElement buttonNo;

    public String getNameField(){
        return nameField.getText();
    }
    public String getAgeField(){
        return ageField.getText();
    }
    public String getLanguageField(){
        return languageField.getText();
    }
    public String getGenderField(){
        return genderField.getText();
    }
    public String getOptionField(){
        return optionField.getText();
    }
    public String getCommentField(){
        return commentField.getText();
    }

    public String getYesBtnCollor(){
        return buttonYes.getCssValue("background-color");
    }

    public String getNoBtnCollor(){
        return buttonNo.getCssValue("background-color");
    }

    public String getYesBtnTextCollor(){
        return buttonYes.getCssValue("color");
    }

    public String getNoBtnTextCollor(){
        return buttonNo.getCssValue("color");
    }


}
