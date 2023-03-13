package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomeScreenPage {

    private AndroidDriver androidDriver;
    public BasePage basePage = new BasePage();

    public HomeScreenPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(id = "android:id/title")
    WebElement home_Screen_Title;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")
    WebElement hello_Text;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='l10nCD']/android.widget.TextView")
    WebElement localization_Text;

    @FindBy(xpath = "//android.widget.Button[@content-desc='buttonTestCD']")
    WebElement en_Button;

    @FindBy(id = "buttonStartWebview")
    WebElement chrome_Button;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='startUserRegistrationCD']")
    WebElement file_Button;

    @FindBy(id = "my_text_field")
    WebElement edit_Text;

    @FindBy(id = "waitingButtonTest")
    WebElement show_Progress_Bar_Button;

    @FindBy(id = "input_adds_check_box")
    WebElement accept_Check_Box;

    @FindBy(id = "visibleButtonTest")
    WebElement display_Text_View_Button;

    @FindBy(id = "showToastButton")
    WebElement display_Toast_Button;

    @FindBy(id = "showPopupWindowButton")
    WebElement display_PopUp_Window_Button;

    @FindBy(id = "exceptionTestButton")
    WebElement unHandled_Exceptipon_Button;

    @FindBy(id = "exceptionTestField")
    WebElement unHandled_Exceptipon_EditText;

    @FindBy(id = "encodingTextview")
    WebElement encoded_Text;

    @FindBy(id = "topLevelElementTest")
    WebElement layout_Button;

    public void getHomeScreenTitle(String title) {
        basePage.explicitWait(androidDriver, home_Screen_Title);
        Assert.assertEquals(home_Screen_Title.getAttribute("text"), title);
    }

    public WebElement helloText() {
        return hello_Text;
    }

    public WebElement localizationText() {
        return localization_Text;
    }

    public WebElement enButton() {
        return en_Button;
    }

    public WebElement chromeButton() {
        return chrome_Button;
    }

    public WebElement fileButton() {
        return file_Button;
    }

    public WebElement editText() {
        return edit_Text;
    }

    public WebElement showProgressBarButton() {
        return show_Progress_Bar_Button;
    }

    public WebElement acceptCheckBox() {
        return accept_Check_Box;
    }

    public WebElement displayTextViewButton() {
        return display_Text_View_Button;
    }

    public WebElement displayToastButton() {
        return display_Toast_Button;
    }

    public WebElement displayPopUpWindowButton() {
        return display_PopUp_Window_Button;
    }

    public WebElement unHandledExceptiponButton() {
        return unHandled_Exceptipon_Button;
    }

    public WebElement unHandledExceptiponEditText() {
        return unHandled_Exceptipon_EditText;
    }

    public WebElement encodedText() {
        return encoded_Text;
    }

    public WebElement layoutButton() {
        return layout_Button;
    }

}
