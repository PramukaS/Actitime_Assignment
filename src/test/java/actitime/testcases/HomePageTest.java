package actitime.testcases;

import actitime.base.TestBase;
import actitime.pages.HomePage;
import actitime.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 1)
    public void homePageLogoTest() {
        boolean flag = homePage.validateActiTimeLogo();
        Assert.assertTrue(flag, "Cannot find the Logo");
    }

    @Test(priority = 2)
    public void homePageTaskLinkTest() {
        homePage.clickOnTaskLink();
        Assert.assertEquals(1, 2);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
