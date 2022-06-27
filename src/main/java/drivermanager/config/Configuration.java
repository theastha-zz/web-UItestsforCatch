package drivermanager.config;

import java.util.Map;
import java.util.TreeMap;

public class Configuration {
    private Configuration.Browser browser;
    private Map<String, Object> web_standard = new TreeMap();
    private String run_mode;

    public Configuration() {
    }
    public String getRun_mode() {
        return this.run_mode;
    }
    Configuration.Browser getBrowser() {
        return this.browser;
    }

    public void setBrowser(Configuration.Browser browser) {
        this.browser = browser;
    }
    public Map<String, Object> getWeb_standard() {
        return this.web_standard;
    }
    public void setRun_mode(String run_mode) {
        this.run_mode = run_mode;
    }
    public void setWeb_standard(Map<String, Object> web_standard) {
        this.web_standard = web_standard;
    }

    public static class Browser {
        private String browserName;
        private String version;
        private String platformName;
        private Configuration.Browser.LaunchConfiguration launch_configuration;

        public Browser() {
        }

        public String getBrowserName() {
            return this.browserName;
        }

        public String getVersion() {
            return this.version;
        }

        public String getPlatformName() {
            return this.platformName;
        }

        public Configuration.Browser.LaunchConfiguration getLaunch_configuration() {
            return this.launch_configuration;
        }

        public void setBrowserName(String browserName) {
            this.browserName = browserName;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public void setPlatformName(String platformName) {
            this.platformName = platformName;
        }

        public void setLaunch_configuration(Configuration.Browser.LaunchConfiguration launch_configuration) {
            this.launch_configuration = launch_configuration;
        }


    public static class LaunchConfiguration {
        private boolean maximize;
        private boolean headless;
        private long implicit_wait;
        private String download_path;
        private String log_level;

        public LaunchConfiguration() {
        }

        public boolean isMaximize() {
            return this.maximize;
        }

        public boolean isHeadless() {
            return this.headless;
        }

        public long getImplicit_wait() {
            return this.implicit_wait;
        }

        public String getDownload_path() {
            return this.download_path;
        }

        public String getLog_level() {
            return this.log_level;
        }

        public void setMaximize(boolean maximize) {
            this.maximize = maximize;
        }

        public void setHeadless(boolean headless) {
            this.headless = headless;
        }

        public void setImplicit_wait(long implicit_wait) {
            this.implicit_wait = implicit_wait;
        }

        public void setDownload_path(String download_path) {
            this.download_path = download_path;
        }

        public void setLog_level(String log_level) {
            this.log_level = log_level;
        }
    }}

}
