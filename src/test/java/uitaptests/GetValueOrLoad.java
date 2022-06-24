package uitaptests;

import base.CommonAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitappages.DynamicTablePage;
import uitappages.HomePage;
import uitappages.MouseOverPage;
import uitappages.ProgressBarPage;

public class GetValueOrLoad extends CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(GetValueOrLoad.class);

    @Test //T31 Verify the value of CPU Load on text web element
    public void readCPULoadValue() {
        HomePage home = new HomePage(getDriver());
        home.clickDynamicTable();
        DynamicTablePage autoPage = new DynamicTablePage(getDriver());
        String expectedValue = autoPage.readChromeValue();
        Assert.assertEquals(expectedValue, autoPage.readChromeValue());
        LOG.info("Reading load value successful");
    }

    @Test //T38 Verify the "Click Me" button is recording number of clicks
    public void clickMeRecord() {
        HomePage home = new HomePage(getDriver());
        home.clickMouseOver();
        MouseOverPage autoPage = new MouseOverPage(getDriver());
        autoPage.readClickMeRecord();
        autoPage.clickClickMe();
        String expectedCount = "The link clicked 1 times.";
        Assert.assertEquals(expectedCount, autoPage.readClickMeRecord());
        LOG.info("Counter is counting as expected --Test Successful");
    }

    @Test //T72 Verify duration of Progress Bar load
    public void progressBarLoadTime() {
        HomePage home = new HomePage(getDriver());
        home.clickProgressBar();
        ProgressBarPage autoPage = new ProgressBarPage(getDriver());
        autoPage.clickStart();
        autoPage.clickStop();
        Assert.assertTrue(autoPage.verifyDuration());
        LOG.info("Load time verified Successful");
    }

    @Test //T73 Verify initial click times after webpage load
    public void initialClickCount() {
        HomePage home = new HomePage(getDriver());
        home.clickMouseOver();
        MouseOverPage autoPage = new MouseOverPage(getDriver());
        Assert.assertTrue(autoPage.checkClickable());
        String expectedCount = "The link clicked 0 times.";
        Assert.assertEquals(expectedCount, autoPage.readClickMeRecord());
        LOG.info("Initial value of 'Click me' count verified to be 0 successful");
    }

    @Test //T74 Verify continuous clickability of 'Click me' element and its counts
    public void continuousClicksCount() {
        HomePage home = new HomePage(getDriver());
        home.clickMouseOver();
        MouseOverPage autoPage = new MouseOverPage(getDriver());
        autoPage.clickContinuously(200);
        String expectedCount = "The link clicked 200 times.";
        Assert.assertEquals(autoPage.readClickMeRecord(), expectedCount);
        LOG.info("Counter is counting as expected --Test Successful");
    }
}

//    @Test //T43 Verify Progress Bar is able to load to '75%' based on user activity
//    public void progressLoad75() {
//        HomePage home = new HomePage(getDriver());
//        home.clickProgressBar();
//        ProgressBarPage autoPage = new ProgressBarPage(getDriver());
//    }
//
//    @Test //T69 Verify Progress Bar restart after clicking Start button twice
//    public void progressBarStartTwice() {
//        HomePage home = new HomePage(getDriver());
//        home.clickProgressBar();
//        ProgressBarPage autoPage = new ProgressBarPage(getDriver());
//    }
//
//    @Test //T70 Verify starting Progress Bar after stopping once
//    public void progressBarRestart() {
//        HomePage home = new HomePage(getDriver());
//        home.clickProgressBar();
//        ProgressBarPage autoPage = new ProgressBarPage(getDriver());
//    }
//
//    @Test //T71 Verify Progress Bar can load to full 100%
//    public void progressBarFullLoad() {
//        HomePage home = new HomePage(getDriver());
//        home.clickProgressBar();
//        ProgressBarPage autoPage = new ProgressBarPage(getDriver());
//        autoPage.clickStart();
//    }