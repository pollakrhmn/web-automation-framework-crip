package uitaptests;

import base.CommonAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitappages.ClassAttributePage;
import uitappages.HomePage;

public class PopUps extends CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(PopUps.class);

    @Test //T29 Verify that clicking the primary button will result in a popup window requiring user to click 'ok'
    public void primaryPopUp() {
        HomePage home = new HomePage(getDriver());
        home.clickClassAttribute();
        ClassAttributePage autoPage = new ClassAttributePage(getDriver());
        autoPage.clickBlueButton();
        getDriver().switchTo().alert().accept();
        LOG.info("Popup handled successfully");
        Assert.assertTrue(autoPage.checkBlueClickable());
    }

}
