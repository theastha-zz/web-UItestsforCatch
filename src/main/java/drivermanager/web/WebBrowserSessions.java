package drivermanager.web;

import drivermanager.config.RunConfiguration;
import drivermanager.config.RunMode;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WebBrowserSessions {
    protected RunConfiguration config;

    public WebBrowserSessions(RunConfiguration config) {
        this.config = config;
    }

    public WebDriver createLocalBrowserSession() throws RuntimeException {
        Platform platform = null;
        boolean maximize = false;
        Object driver;
        if (this.config.getBrowserName().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            this.configureChromeOptions(options);
            driver = new ChromeDriver(options);
            platform = this.config.getBrowserPlatform();
            maximize = this.config.getMaximize();
        } else if (this.config.getBrowserName().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            this.configureFirefoxOptions(options);
            driver = new FirefoxDriver(options);
            platform = this.config.getBrowserPlatform();
            maximize = this.config.getMaximize();
        } else {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);

        }

        if (System.getProperty("os.name").toLowerCase().contains("mac") && maximize && this.config.getRunMode().equals(RunMode.LOCAL) || ((Platform) Objects.requireNonNull(platform)).toString().toLowerCase().contains("mac") && maximize && this.config.getRunMode().equals(RunMode.REMOTE)) {
            ((WebDriver) driver).manage().window().maximize();
        }

        return (WebDriver) driver;
    }

    private void configureChromeOptions(ChromeOptions options) {
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        Map<String, Object> chromePrefs = new HashMap();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", this.config.getDownloadPath());
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", false);
        chromePrefs.put("safebrowsing.disable_download_protection", true);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments(new String[]{"--disable-extensions"});
        options.addArguments(new String[]{"--enable-javascript"});
        options.addArguments(new String[]{"--disable-notifications"});
        options.addArguments(new String[]{"--disable-dev-shm-usage"});
        options.setCapability("browserName", this.config.getBrowserName());
        options.setCapability("version", this.config.getBrowserVersion());
        options.setCapability("platform", this.config.getBrowserPlatform());
        this.config.getWebBrowserCapabilities().asMap().forEach(options::setCapability);
        if (this.config.getMaximize()) {
            options.addArguments(new String[]{"--start-maximized"});
        }

        if (this.config.getHeadless()) {
            options.setHeadless(true);
            options.addArguments(new String[]{"--disable-gpu"});
        }

    }

    private void configureFirefoxOptions(FirefoxOptions options) {
        options.setAcceptInsecureCerts(true);
        options.setCapability("marionette", true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setLogLevel(FirefoxDriverLogLevel.fromString(this.config.getBrowserLogLevel()));
        options.addPreference("browser.helperApps.neverAsk.openFile", "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/x-xls,application/xls,application/x-dos_ms_excel,application/x-ms-excel,application/msexcel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/x-xls,application/xls,application/x-dos_ms_excel,application/x-ms-excel,application/msexcel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        options.addPreference("browser.helperApps.alwaysAsk.force", false);
        options.addPreference("browser.download.manager.focusWhenStarting", false);
        options.addPreference("browser.download.manager.useWindow", false);
        options.addPreference("browser.download.manager.showAlertOnComplete", false);
        options.addPreference("browser.download.manager.closeWhenDone", false);
        options.addPreference("javascript.enabled", true);
        options.addPreference("pdfjs.disabled", true);
        options.addPreference("dom.webnotifications.serviceworker.enabled", false);
        options.addPreference("dom.webnotifications.enabled", false);
        options.setCapability("browserName", this.config.getBrowserName());
        options.setCapability("version", this.config.getBrowserVersion());
        options.setCapability("platform", this.config.getBrowserPlatform());
        this.config.getWebBrowserCapabilities().asMap().forEach(options::setCapability);
        if (this.config.getMaximize()) {
            options.addArguments(new String[]{"--start-maximized"});
        }

        if (this.config.getHeadless()) {
            options.setHeadless(true);
        }

    }
}
