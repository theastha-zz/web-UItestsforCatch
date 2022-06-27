package drivermanager.config;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RunConfiguration {
    private static final DefaultConfiguration defaultConfigs = new DefaultConfiguration();

    private String configFilePath ;
    private Configuration config;


    public RunConfiguration() {
        this.config = defaultConfigs.getDefaultConfiguration();
    }
    //ToDo To read config from File Path
//    public RunConfiguration(String configFilePath) {
//        this.configFilePath = configFilePath;
//    }

    public String getBrowserName() {
        String browser = System.getProperty("browser.name");
        if (this.isNullOrEmpty(browser)) {
            browser = this.config.getBrowser().getBrowserName();
        }

        return browser;
    }

    public String getBrowserVersion() {
        String browserVersion = System.getProperty("browser.version");
        return this.isNullOrEmpty(browserVersion) ? this.config.getBrowser().getVersion() : browserVersion;
    }

    public Platform getBrowserPlatform() {
        String browserPlatform = System.getProperty("browser.platform");
        return this.isNullOrEmpty(browserPlatform) ? Platform.fromString(this.config.getBrowser().getPlatformName()) : Platform.fromString(browserPlatform);
    }

    public String getBrowserLogLevel() {
        String browserPlatform = System.getProperty("browser.loglevel");
        return this.isNullOrEmpty(browserPlatform) ? this.config.getBrowser().getLaunch_configuration().getLog_level() : browserPlatform;
    }
    public String getDownloadPath() {
        String downloadPath = System.getProperty("downloadpath");
        return !this.isNullOrEmpty(downloadPath) ? downloadPath : this.config.getBrowser().getLaunch_configuration().getDownload_path();
    }

    public long getImplicitWait() {
        String implicitWait = System.getProperty("implicitwait");
        return !this.isNullOrEmpty(implicitWait) ? Long.parseLong(implicitWait) : this.config.getBrowser().getLaunch_configuration().getImplicit_wait();
    }

    private boolean isNullOrEmpty(String property) {
        return property == null || property.equals("");
    }

    public boolean getMaximize() {
        String maximize = System.getProperty("maximize");
        return !this.isNullOrEmpty(maximize) ? Boolean.parseBoolean(maximize) : this.config.getBrowser().getLaunch_configuration().isMaximize();
    }

    public boolean getHeadless() {
        String headless = System.getProperty("headless");
        return !this.isNullOrEmpty(headless) ? Boolean.parseBoolean(headless) : this.config.getBrowser().getLaunch_configuration().isHeadless();
    }
    public RunMode getRunMode() {
        String mode = System.getProperty("runmode");
        if (this.isNullOrEmpty(mode)) {
            this.config.setRun_mode("local");
            mode = this.config.getRun_mode();
        }
        return RunMode.LOCAL;
    }



    public DesiredCapabilities getWebBrowserCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities(this.config.getWeb_standard());
        return caps;
    }
}
