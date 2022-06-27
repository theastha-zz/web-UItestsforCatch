package drivermanager;

import org.openqa.selenium.remote.DesiredCapabilities;

public interface BrowserInterface<T> {
    T getDriver();
    void destroyDriver(T var1);

}
