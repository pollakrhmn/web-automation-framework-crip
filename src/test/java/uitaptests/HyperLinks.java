package uitaptests;

import base.CommonAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitappages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class HyperLinks extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(HyperLinks.class);

    @Test //T1 Verify the "Resources" link is usable
    public void clickResourcesTabTest() {
        HomePage home = new HomePage(getDriver());
        home.clickResources();
        String expectedUrlLink = "http://uitestingplayground.com/resources";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }


    @Test //T2 Verify the logo link is usable
    public void clickLogoTest() {
        HomePage home = new HomePage(getDriver());
        home.clickLogo();
        String expectedUrlLink = "http://uitestingplayground.com/";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T3 Verify the "Home" link is usable
    public void clickHomeTabTest() {
        HomePage home = new HomePage(getDriver());
        home.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T4 Verify the "Scrollbars" link is usable
    public void clickScrollBarsLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickScrollBars();
        String expectedUrlLink = "http://uitestingplayground.com/scrollbars";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T5 Verify the "Dynamic ID" link is usable
    public void clickDynamicIdLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickDynamicId();
        String expectedUrlLink = "http://uitestingplayground.com/dynamicid";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T6 Verify the "AJAX Data" link is usable
    public void clickAjaxDataLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickAjaxData();
        String expectedUrlLink = "http://uitestingplayground.com/ajax";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T7 Verify the "Visibility" link is usable
    public void clickVisibilityLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickVisibility();
        String expectedUrlLink = "http://uitestingplayground.com/visibility";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T8 Verify the "Overlapped Element" link is usable
    public void clickOverlappedLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickOverlappedElement();
        String expectedUrlLink = "http://uitestingplayground.com/overlapped";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T9 Verify the "Class Attribute" link is usable
    public void clickClassAttributeLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickClassAttribute();
        String expectedUrlLink = "http://uitestingplayground.com/classattr";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T10 Verify the "Client Side Delay" link is usable
    public void clickClientSideDelayLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickClientSideDelay();
        String expectedUrlLink = "http://uitestingplayground.com/clientdelay";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T11 Verify the "Dynamic Table" link is usable
    public void clickDynamicTableLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickDynamicTable();
        String expectedUrlLink = "http://uitestingplayground.com/dynamictable";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T12 Verify the "Sample App" link is usable
    public void clickSampleAppLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickSampleApp();
        String expectedUrlLink = "http://uitestingplayground.com/sampleapp";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T13 Verify the "Hidden Layers" link is usable
    public void clickHiddenLayerLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickHiddenLayers();
        String expectedUrlLink = "http://uitestingplayground.com/hiddenlayers";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T14 Verify the "Click" link is usable
    public void clickClickLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickClickLink();
        String expectedUrlLink = "http://uitestingplayground.com/click";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T15 Verify the "Verify Text" link is usable
    public void clickVerifyTextLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickVerifyText();
        String expectedUrlLink = "http://uitestingplayground.com/verifytext";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T16 Verify the "Mouse Over" link is usable
    public void clickMouseOverLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickMouseOver();
        String expectedUrlLink = "http://uitestingplayground.com/mouseover";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T17 Verify that "Load Delay" webpage is able to load after a delay
    public void clickLoadDelayLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickLoadDelay();
        String expectedUrlLink = "http://uitestingplayground.com/loaddelay";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T18 Verify the "Text Input" link is usable
    public void clickTextInputLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickTextInput();
        String expectedUrlLink = "http://uitestingplayground.com/textinput";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T19 Verify the "Progress Bar" link is usable
    public void clickNonBreakingSpaceLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickNonBreakingSpace();
        String expectedUrlLink = "http://uitestingplayground.com/nbsp";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T20 Verify the "Non-Breaking Space" link is usable
    public void clickProgressBarLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickProgressBar();
        String expectedUrlLink = "http://uitestingplayground.com/progressbar";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T53 Verify "Star" link is usable
    public void starLinkExternalLink() {
        HomePage home = new HomePage(getDriver());
        home.clickStarLink();
        List<String> newTabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTabs.get(1));
        getDriver().switchTo().window(newTabs.get(0));
        getDriver().close();
        LOG.info("Previous tab closed successful");
        getDriver().switchTo().window(newTabs.get(1));
        LOG.info("Switch to new tab successful");
        String expectedURL = "https://github.com/inflectra/ui-test-automation-playground";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL);
        LOG.info("Webpage match successful");
    }

    @Test //T54 Verify "Fork the Website on Github" link is usable
    public void forkGitExternalLink() {
        HomePage home = new HomePage(getDriver());
        home.clickForkWebsite();
        String expectedURL = "https://github.com/inflectra/ui-test-automation-playground";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL);
        LOG.info("Webpage match successful");
    }

    @Test //T56 Verify "Rapise" external link is usable
    public void rapiseExternalLink() {
        HomePage home = new HomePage(getDriver());
        home.clickRapise();
        String expectedURL = "https://www.inflectra.com/Rapise/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL);
        LOG.info("Webpage match successful");
    }

    @Test //T57 Verify "Inflectra Corporation" external link is usable
    public void inflectraExternalLink() {
        HomePage home = new HomePage(getDriver());
        home.clickInflectraCorp();
        String expectedURL = "https://www.inflectra.com/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL);
        LOG.info("Webpage match successful");
    }

    @Test //T58 Verify "CC 4.0 BY-NC" external link is usable
    public void cc4ExternalLink() {
        HomePage home = new HomePage(getDriver());
        home.clickCC4Link();
        String expectedURL = "https://creativecommons.org/licenses/by-nc/4.0/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL);
        LOG.info("Webpage match successful");
    }

    @Test //T59 Verify "Apache License 2.0" external link is usable
    public void apacheLicenseExternalLink() {
        HomePage home = new HomePage(getDriver());
        home.clickApacheLicense();
        String expectedURL = "https://www.apache.org/licenses/LICENSE-2.0";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL);
        LOG.info("Webpage match successful");
    }

    @Test //T75 Verify the "Shadow DOM" link is usable
    public void clickShadowDOMLinkTest() {
        HomePage home = new HomePage(getDriver());
        home.clickShadowDOM();
        String expectedURL = "http://uitestingplayground.com/shadowdom";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL);
        LOG.info("Webpage match successful");
    }
}
