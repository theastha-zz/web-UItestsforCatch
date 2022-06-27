package drivermanager.config;

public enum RunMode {
    LOCAL("local"),
    REMOTE("remote");

    private String runMode;

    private RunMode(String runMode) {
        this.runMode = runMode;
    }

    public String getRunMode() {
        return this.runMode;
    }
}
