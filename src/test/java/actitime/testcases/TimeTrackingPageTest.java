package actitime.testcases;

import actitime.base.TestBase;
import actitime.pages.HomePage;
import actitime.pages.LoginPage;
import actitime.pages.TimeTrackingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TimeTrackingPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    TimeTrackingPage timeTrackingPage;

    public TimeTrackingPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        timeTrackingPage = homePage.clickOnTimeTrackingLink();
    }

    @Test(priority = 1)
    public void timeTrackingPageTest() {
        boolean flag = timeTrackingPage.validateTimeTrackingPage();
        Assert.assertTrue(flag, "Cannot find Page Header");
    }

    @Test(priority = 2)
    public boolean approveTimeSheet() {
        return timeTrackingPage.isReadyForApproval();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
