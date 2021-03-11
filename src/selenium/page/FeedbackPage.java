package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class FeedbackPage {

    @FindBy(how = How.ID, using ="fb_name")
    private WebElement nameText ;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageText;

    @FindBy(how = How.XPATH, using ="//input[@value='English']")
    private WebElement englishCheckBox;

    @FindBy (how =How.XPATH, using = "//input[@value='Spanish']")
    private WebElement spanishCheckBox;

    @FindBy (how =How.XPATH, using = "//input[@value='French']")
    private WebElement frenchCheckBox;

    @FindBy (how =How.XPATH, using = "//input[@value='Chinese']")
    private WebElement chineseCheckBox;

    @FindBy (how =How.XPATH, using = "//input[@class ='w3-radio'][1]")
    private WebElement maleRadioButton;

    @FindBy (how =How.XPATH, using = "//input[@class ='w3-radio'][2]")
    private WebElement femaleRadioButton;

    @FindBy (how =How.XPATH, using = "//input[@class ='w3-radio'][3]")
    private WebElement DontKnowRadioButton;

    @FindBy (how =How.XPATH, using = "//option[@value = 'Good']")
    private WebElement GoodDropdownList;

    @FindBy (how =How.XPATH, using = "//option[@value = 'Ok, i guess']")
    private WebElement OkIGuessDropdownList;

    @FindBy (how =How.XPATH, using = "//option[@value = 'Bad']")
    private WebElement BadDropdownList;

    @FindBy (how =How.XPATH, using = "//option[@value = 'Why me?']")
    private WebElement WhyMeDropdownList;

    @FindBy (how =How.NAME, using = "comment")
    private WebElement CommentField;

    @FindBy (how =How.XPATH, using = "//button[@type='submit']")
    private WebElement SendButton;

    @FindBy(how = How.ID, using = "error")
    private WebElement errorMsg;

    public void enterName(String name){
        nameText.sendKeys(name);
    }
    public String getName (){
        return nameText.getAttribute("value");
    }


    public void enterAge(String age){
        ageText.sendKeys(age);
    }
    public String getAge(String age){
        return ageText.getAttribute("value");
    }


    public void selectEnglishCheckbox (){
        englishCheckBox.click();
    }
    public boolean verifyEnglishCheckbox(){
        return englishCheckBox.isSelected();
    }


    public void selectSpanishCheckbox (){
        spanishCheckBox.click();
    }
    public boolean verifySpanishCheckbox()
    {
        return spanishCheckBox.isSelected();
    }


    public void selectFrenchCheckbox (){
        frenchCheckBox.click();
    }
    public boolean verifyFrenchCheckbox()
    {
        return frenchCheckBox.isSelected();
    }

    public void selectChineseCheckbox (){
        chineseCheckBox.click();
    }
    public boolean verifyChineseCheckbox(){
        return chineseCheckBox.isSelected();
    }



    public void selectMale (){
        maleRadioButton.click();
    }
    public boolean verifyMaleIsSelected (){
        return maleRadioButton.isSelected();
    }


    public void selectFemale (){
        femaleRadioButton.click();
    }
    public boolean verifyFemaleIsSelected (){
        return femaleRadioButton.isSelected();
    }


    public void selectDontKnow (){
        DontKnowRadioButton.click();
    }
    public boolean verifyDontKnowIsSelected (){
        return DontKnowRadioButton.isSelected();
    }



    public void SelectGoodFromDropdown (){
      Select Good =new Select (GoodDropdownList);
      Good.getFirstSelectedOption();
    }

    public void SelectOKFromDropdown (){
        Select OK =new Select (OkIGuessDropdownList);
        OK.getFirstSelectedOption();
    }

    public void SelectBadFromDropdown (){
        Select Bad =new Select (BadDropdownList);
        Bad.getFirstSelectedOption();
    }
    public void SelectWhyMeFromDropdown (){
        Select WhyMe =new Select (WhyMeDropdownList);
        WhyMe.getFirstSelectedOption();
    }

    public void ChooseyourOptionisWritten (){
        Select WhyMe =new Select (WhyMeDropdownList);
        WhyMe.getFirstSelectedOption();
    }


    public void enterComment (String comment){
        CommentField.sendKeys(comment);
    }

    public void clickSend (){
        SendButton.click();

    }

    public String getSendButtonBackGroundColoe (){
        return SendButton.getCssValue("background-color");
    }
    public String getSendButtonTextColor (){
        return SendButton.getCssValue("color");
    }


    }




