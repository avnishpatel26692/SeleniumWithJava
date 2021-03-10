package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class ProvideFeedbackPage {

        @FindBy(how = How.ID, using = "fb_name")
        private WebElement nameText;

        @FindBy(how = How.ID, using = "fb_age")
        private WebElement ageText;

        @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
        private List<WebElement> checkBoxes;

        @FindBy(how = How.XPATH, using = "//input[@class='w3-radio']")
        private List<WebElement> radioBtns;

        @FindBy(how = How.ID, using = "like_us")
        private WebElement likeUsDropdown;

        @FindBy(how = How.NAME, using = "comment")
        private WebElement commentText;

        @FindBy(how = How.XPATH, using = "//button[text()='Send']")
        private WebElement sendBtn;

        @FindBy(how = How.XPATH, using = "//button[@class='w3-btn w3-green w3-xlarge']")
        private WebElement yesBtn;

        @FindBy(how = How.XPATH, using = "//button[@class='w3-btn w3-red w3-xlarge']")
        private WebElement noBtn;

        @FindBy(how = How.ID, using = "name")
        private WebElement sentName;

        @FindBy(how = How.ID, using = "age")
        private WebElement sentAge;

        @FindBy(how = How.ID, using = "language")
        private WebElement sentLanguage;

        @FindBy(how = How.ID, using = "gender")
        private WebElement sentGender;

        @FindBy(how = How.ID, using = "option")
        private WebElement sentOption;

        @FindBy(how = How.ID, using = "comment")
        private WebElement sentComment;

        @FindBy(how = How.ID, using = "message")
        private WebElement sentCommentFinal;

        @FindBy(how = How.CLASS_NAME, using = "w3-green")
        private WebElement colorFinal;





        public void enterName(String name)
        {
            nameText.sendKeys(name);
        }

        public String getName()
        {
            return  nameText.getAttribute("value");
        }

        public void enterAge(String age)
        {
            ageText.sendKeys(age);
        }

        public String getAge()
        {
            return ageText.getAttribute("value");
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

        public String getYesButtonColor()
        {
            return yesBtn.getCssValue("background-color");

        }
        public String getYesButtonTextColor()
        {
            return yesBtn.getCssValue("color");

        }
        public String getNoButtonTextColor()
        {
            return noBtn.getCssValue("color");

        }
        public String getNoButtonColor()
        {
            return noBtn.getCssValue("background-color");

        }
        public void clickYes(){
            yesBtn.click();
        }
        public void clickNo(){
            noBtn.click();
        }
        public String getSentName()
        {
            return sentName.getText();
        }
        public String getSentAge()
        {
            return sentAge.getText();
        }
        public String getSentLanguage()
        {
            return sentLanguage.getText();

        }
        public String getSentGender()
        {
            return sentGender.getText();

        }
        public String getSentOption()
        {
            return sentOption.getText();

        }
        public String getSentComment()
        {
            return sentComment.getText();

        }
        public String getSentCommentFinal()
        {
            return sentCommentFinal.getText();

        }
        public String getFinalColor()
        {
            return colorFinal.getCssValue("background-color");

        }
        public String getFinalTextColor()
        {
            return colorFinal.getCssValue("color");

        }



}


