package actitime.pages;

import actitime.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - Object Repository

    @FindBy(xpath = "//input[@name='username']")
    @CacheLookup
    WebElement userName;

    @FindBy(xpath = "//input[@type='password' and @name='pwd']")
    WebElement passWord;

    @FindBy(xpath = "//a[@id='loginButton']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@name='remember']")
    WebElement keepmeLoggedinCheckBox;

    @FindBy(xpath = "//a[@id='toPasswordRecoveryPageLink']")
    WebElement forgotYourPasswordLink;

    @FindBy(xpath = "//div[@class='atLogoImg']")
    WebElement actiTimeLogo;


    //initialization

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods

    public Boolean validateActiTimeLogo() {
        return actiTimeLogo.isDisplayed();
    }

    public HomePage login(String uName, String pword) {
        userName.sendKeys(uName);
        passWord.sendKeys(pword);
        loginButton.click();
        return new HomePage();
    }
}