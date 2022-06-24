package uitaptests;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitappages.HomePage;

public class ScrollBar extends CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(ScrollBar.class);

    @Test //T46 Verify Homepage scrollbar is usable
    public void homePageScroll() {
        HomePage home = new HomePage(getDriver());
        LOG.info("Landed on Homepage successful");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", home.lowestScroll());
        Assert.assertTrue(home.checkApacheLowestScroll());
    }
}
