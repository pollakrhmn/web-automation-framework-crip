package base;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utility.Utility;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;



public class CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(CommonAPI.class);
    Properties prop = Utility.loadProperties();
    String duration = prop.getProperty("implicit.wait", "10");

    String maximizeBrowser = prop.getProperty("maximize.browser", "true");
    String takeScreenshot = prop.getProperty("take.screenshot", "false");
    String browserstackUsername = prop.getProperty("browserstack.username");
    String browserstackPassword = prop.getProperty("browserstack.password");

    public static String currentDir = System.getProperty("user.dir");


    private WebDriver driver;
    private boolean flag;

    //ExtentReport
    public static com.relevantcodes.extentreports.ExtentReports extent;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();

        if (takeScreenshot.equalsIgnoreCase("true")) {
            if (result.getStatus() == ITestResult.FAILURE) {
                takeScreenshot(result.getName());
            }
        }
        driver.quit();
    }
    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public void getLocalDriver(String browser, String os){
        if (os.equalsIgnoreCase("windows")){
            if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", Utility.currentDir+"\\driver\\windows\\chromedriver.exe");
                driver = new ChromeDriver();
            }else if (browser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", Utility.currentDir+"\\driver\\windows\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }else if (os.equalsIgnoreCase("mac")){
            if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", Utility.currentDir + "\\driver\\mac\\chromedriver");
                driver = new ChromeDriver();
            }else if (browser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", Utility.currentDir + "\\driver\\mac\\geckodriver");
                driver = new FirefoxDriver();
            }
        }else if (os.equalsIgnoreCase("linux")){
            if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", Utility.currentDir + "\\driver\\linux\\chromedriver");
                driver = new ChromeDriver();
            }else if (browser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", Utility.currentDir+"\\driver\\linux\\geckodriver");
                driver = new FirefoxDriver();
            }
        }
    }

    public void getCloudDriver(String envName, String envUsername, String envAccessKey, String os, String osVersion, String browser, String browserVersion) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser", browser);
        cap.setCapability("browser_version", browserVersion);

        if(envName.equalsIgnoreCase("saucelabs")){
            driver = new RemoteWebDriver(new URL("https://" + envUsername + ":" + envAccessKey + "@ondemand.saucelabs.com:80/wd/hub"), cap);
        } else if (envName.equalsIgnoreCase("browserstack")) {
            driver = new RemoteWebDriver(new URL("https://" + envUsername + ":" + envAccessKey + "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
    }

    @Parameters({"useCloudEnv","envName","os", "osVersion", "browser", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("browserstack") String envName,
                      @Optional("windows") String os, @Optional("10") String osVersion, @Optional("chrome") String browserName,
                      @Optional("102") String browserVersion, @Optional("https://www.google.com") String url) throws MalformedURLException {

        if (useCloudEnv == true) {
            if (envName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(envName, Utility.decode(browserstackUsername), Utility.decode(browserstackPassword), os, osVersion, browserName, browserVersion);

            } else if (envName.equalsIgnoreCase("saucelabs")) {
                getCloudDriver(envName, "pollakrahman_FSHoC6", "2hb5L28wkM2zCeAxYfyy", os, osVersion, browserName, browserVersion);

            }

        } else {
            getLocalDriver(browserName, os);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(duration)));
        if (maximizeBrowser.equalsIgnoreCase("true")) {
            driver.manage().window().maximize();
        }
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPageTitle(){

        return driver.getTitle();

    }

    public String getUrlLink(){

        return driver.getCurrentUrl();

    }

    public String getElementText(String locator){
        try {
            return driver.findElement(By.cssSelector(locator)).getText();
        }catch (Exception e){
            return driver.findElement(By.xpath(locator)).getText();
        }
    }

    public void click(WebElement element){
        element.click();
    }

    public void type(WebElement element, String text){
        element.sendKeys(text);
    }

    public void typeAndEnter(WebElement element, String text){
        element.sendKeys(text, Keys.ENTER);
    }

    public void selectFromDropdown(WebElement dropdown, String option){
        Select select = new Select(dropdown);
        try {
            select.selectByVisibleText(option);
        }catch(Exception e){
            select.selectByValue(option);
        }
//            WebElement dropdown;
//            try {
//                dropdown = driver.findElement(By.cssSelector(dropdownLocator));
//
//            }catch (Exception e){
//                dropdown = driver.findElement(By.xpath(dropdownLocator));
//            }
    }

    public List<WebElement> getDropDownOptions(WebElement dropdown){
        Select select = new Select(dropdown);
        return select.getOptions();
    }



    public void hoverOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
//            WebElement element;
//            try {
//                element = driver.findElement(By.cssSelector(locator));
//            }catch (Exception e){
//                element = driver.findElement(By.xpath(locator));
//            }

    }

    public String alertMessage() {
       String alertMessage = getDriver().switchTo().alert().getText();
       return alertMessage;
    }
    public void okAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void iFrameHandle(WebElement element){
        driver.switchTo().frame(element);
    }
    public void getLinks(String linkText){
        driver.findElement(By.linkText(linkText)).findElement(By.tagName("a")).getText();
    }
    public boolean checkSelected(WebElement element){
        if (element.isSelected()){
            flag = true;
        }
        return flag;
    }
    public boolean checkNotSelected(WebElement element){
        if (!element.isSelected()){
            flag = true;
        }
        return flag;
    }
    public boolean checkEnabled(WebElement element){
        if (element.isEnabled()){
            flag = true;
        }
        return flag;
    }
    public boolean checkDisabled(WebElement element){
        if (!element.isEnabled()){
            flag = true;
        }
        return flag;
    }
    public boolean checkDisplayed(WebElement element){
        if (element.isDisplayed()){
            flag = true;
        }
        return flag;
    }
    public boolean checkNotDisplayed(WebElement element){
        if (!element.isDisplayed()){
            flag = true;
        }
        return flag;
    }
    public static WebDriver handleNewTab(WebDriver driver1){
        String oldTab = driver1.getWindowHandle();
        List<String> newTabs = new ArrayList<String>(driver1.getWindowHandles());
        newTabs.remove(oldTab);
        driver1.switchTo().window(newTabs.get(0));
        return driver1;
    }
    public void waitUntilClickAble(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitUntilVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilSelectable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void scrollToView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void captureScreenshot() {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("screenshots/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(String screenshotName){
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+File.pathSeparator+ "screenshots"+File.pathSeparator+screenshotName+" "+df.format(date)+".png"));

            System.out.println("Screenshot captured");
        } catch (Exception e) {
            String path = System.getProperty("user.dir")+ "/screenshots/"+screenshotName+" "+df.format(date)+".png";
            LOG.info(path);
            LOG.info("Exception while taking screenshot "+e.getMessage());
        }
    }
}


