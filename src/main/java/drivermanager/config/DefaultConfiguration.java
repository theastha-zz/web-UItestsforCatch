package drivermanager.config;

import java.util.HashMap;
import java.util.Map;
import drivermanager.config.Configuration.Browser.LaunchConfiguration;
import drivermanager.config.Configuration.Browser;


public class DefaultConfiguration {
    private final String BROWSER_NAME = "chrome";
    private final String BROWSER_VERSION = "";
    private final String PLATFORM_NAME = "ANY";
    private final boolean MAXIMIZE = true;
    private final boolean HEADLESS = false;
    private final long IMPLICIT_WAIT_IN_SECONDS = 5L;
    private final String DOWNLOAD_PATH = "/tmp/";
    private final String LOG_LEVEL = "INFO";
    private final String run_mode;
    private final Configuration.Browser browser;
    private final Configuration config;
    private final Map<String, Object> WEB_STANDARD;
    private final LaunchConfiguration launch_configuration;
;

    public DefaultConfiguration( ) {
        this.launch_configuration = new LaunchConfiguration();
        this.run_mode = RunMode.LOCAL.getRunMode();
        this.browser = new Browser();
        this.WEB_STANDARD = new HashMap();
        this.config = new Configuration();
        this.setDefaults();

    }

    private void setDefaults(){
        this.config.setRun_mode(this.run_mode);
        this.browser.setBrowserName("chrome");
        this.browser.setVersion("103.0.5060.53");
        this.browser.setPlatformName("ANY");
        this.launch_configuration.setMaximize(true);
        this.launch_configuration.setHeadless(false);
        this.launch_configuration.setImplicit_wait(5L);
        this.launch_configuration.setDownload_path("/tmp/");
        this.launch_configuration.setLog_level("INFO");
        this.browser.setLaunch_configuration(this.launch_configuration);
        this.config.setBrowser(this.browser);
        this.WEB_STANDARD.put("acceptSslCerts", true);
        this.WEB_STANDARD.put("acceptInsecureCerts", true);
        this.WEB_STANDARD.put("unexpectedAlertBehaviour", "accept");
        this.WEB_STANDARD.put("locationContextEnabled", true);

    }
    public Configuration getDefaultConfiguration() {
        return this.config;
    }
}

