package selenium.sample.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GiveFeedBackPage {


    @FindBy(how = How.ID, using ="fb_name")
    private WebElement name;

    @FindBy(how = How.ID, using ="fb_age")
    private WebElement age;

    // checkbox
    @FindBy(how = How.XPATH, using = "//input[@type='English']")
    private WebElement englishCheckBoxes;
    @FindBy(how = How.XPATH, using = "//input[@type='Spanish']")
    private WebElement spanishCheckBoxes;
    @FindBy(how = How.XPATH, using = "//input[@type='French']")
    private WebElement frenchCheckBoxes;
    @FindBy(how = How.XPATH, using = "//input[@type='Chinese']")
    private WebElement ChineseCheckBoxes;


    // radio btn
    @FindBy(how = How.XPATH, using = "//input[@class='w3-radio'][1]")
    private WebElement maleBtn;
    @FindBy(how = How.XPATH, using = "//input[@class='w3-radio'][2]")
    private WebElement femaleBtn;
    @FindBy(how = How.XPATH, using = "//input[@class='w3-radio'][3]")
    private WebElement doNotRadioBtn;


    //dropdown
    @FindBy(how = How.NAME, using = "option")
    private WebElement dropDown;

    //comment
    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentText;

    //send bottom
    @FindBy(how = How.CSS, using = "input[class='w3-btn-block w3-blue w3-section']")
    private WebElement sendBtn;

    public void enterName(String name)
    {
        getName();
    }

    public String getName()
    {
        return  name.getAttribute("value");
    }

    public void enterAge(String age)
    {
        sendKeys(age);
    }

    public String getAge()
    {
        return age.getAttribute("value");
    }

    public boolean verifyCheckBoxIsSelected(int index)
    {
        return checkBoxes.get(index).isSelected();
    }

    public void selectCheckBox(int index)
    {
        checkBoxes.get(index).click();
    }

    public boolean verifyRadioButtonIsSelected(int index)
    {
        return radioBtns.get(index).isSelected();
    }

    public void selectRadioBtn(int index)
    {
        radioBtns.get(index).click();
    }

    public String getSelectedOption()
    {
        Select dropdown  = new Select(likeUsDropdown);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectValueFromDropDown(int index)
    {
        Select dropdown  = new Select(likeUsDropdown);
        dropdown.selectByIndex(index);
    }

    public void enterComment(String comment)
    {
        commentText.sendKeys(comment);
    }

    public void clickOnSendBtn()
    {
        sendBtn.click();
    }

    public String getSendButtonBackGroundColor()
    {
        return sendBtn.getCssValue("background-color");
    }

    public String getSendButtonTextColor()
    {
        return sendBtn.getCssValue("color");
    }








}
