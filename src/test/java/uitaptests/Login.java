package uitaptests;

import base.CommonAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitappages.HomePage;
import uitappages.SampleAppPage;

public class Login extends CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(Login.class);

    @Test //T32 Verify that user is able to log in using valid credentials
    public void verifyValidLogin() {
        HomePage home = new HomePage(getDriver());
        home.clickSampleApp();
        SampleAppPage autoPage = new SampleAppPage(getDriver());
        autoPage.typeUserName("user");
        autoPage.typePassword("pwd");
        autoPage.clickLogButton();
        String expectedStatus = "Welcome, user!";
        String actualStatus = getElementText("#loginstatus");
        Assert.assertEquals(expectedStatus, actualStatus);
    }

    @Test //T33 Verify that user is able to log out after logging in with valid credentials
    public void verifyValidLogout() {
        HomePage home = new HomePage(getDriver());
        home.clickSampleApp();
        SampleAppPage autoPage = new SampleAppPage(getDriver());
        autoPage.typeUserName("user");
        autoPage.typePassword("pwd");
        autoPage.clickLogButton();
        autoPage.clickLogButton();
        LOG.info("Log Out click successful");
        String expectedStatus = "User logged out.";
        String actualStatus = getElementText("#loginstatus");
        Assert.assertEquals(expectedStatus, actualStatus);
    }

    @Test //T34 Verify that user is unable to log in using invalid credentials
    public void verifyInvalidLoginFail() {
        HomePage home = new HomePage(getDriver());
        home.clickSampleApp();
        SampleAppPage autoPage = new SampleAppPage(getDriver());
        autoPage.typeUserName("user");
        autoPage.typePassword("wrongpassword");
        autoPage.clickLogButton();
        String expectedStatus = "Invalid username/password";
        String actualStatus = getElementText("#loginstatus");
        Assert.assertEquals(expectedStatus, actualStatus);
    }

    @Test //T55 Verify invalid login with empty fields
    public void verifyEmptyLoginFail() {
        HomePage home = new HomePage(getDriver());
        home.clickSampleApp();
        SampleAppPage autoPage = new SampleAppPage(getDriver());
        autoPage.clickLogButton();
        LOG.info("Clicked on Login button with EMPTY FIELDS successful");
        String expectedStatus = "Invalid username/password";
        String actualStatus = getElementText("#loginstatus");
        Assert.assertEquals(expectedStatus, actualStatus);
        LOG.info("Failure to log in with empty fields successful");
    }


}
