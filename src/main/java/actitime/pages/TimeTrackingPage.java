package actitime.pages;

import actitime.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeTrackingPage extends TestBase {

    //Page Factory - Object Repository

    @FindBy(xpath = "//table[@class='approveTTMainContentBody']")
    WebElement ApproveTimeTrackingHeader;

    @FindBy(xpath = "//input[@class='filterFieldInput inputFieldWithPlaceholder']")
    WebElement searchUserInput;

    @FindBy(xpath = "//*[@id='ttaHistoryButton']")
    WebElement historyButton;

    @FindBy(xpath = "//*[@id='extendedTTAHistoryLightBoxDiv']/div[2]/table/tbody[1]/tr[1]/td[5][normalize-space()='is ready for Approval']")
    WebElement readyForApprovalTag;

    @FindBy(xpath = "/html[1]/body[1]/div[14]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/a[1]")
    WebElement detailsLink;

    @FindBy(xpath = "//*[@id='changeStatusButton approveButton']")
    WebElement approveButton;

    @FindBy(xpath = "//*[@class='currentStatusCell statusText']")
    WebElement statusText;

    public TimeTrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateTimeTrackingPage() {
        return ApproveTimeTrackingHeader.isDisplayed();
    }

    public boolean isReadyForApproval(){
        historyButton.click();
        if(readyForApprovalTag.isDisplayed()){
            detailsLink.click();
            approveButton.click();
            return statusText.getText() == "Approved";
        }else{
            return false;
        }
    }

}
