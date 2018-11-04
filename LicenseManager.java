/**
 *
 * @author adri
 */
public class LicenseManager {
    private boolean checkFullVersion;

    public LicenseManager(boolean checkFullVersion) {
        this.checkFullVersion = checkFullVersion;
    }

    public boolean isCheckFullVersion() {
        return checkFullVersion;
    }

    public void setCheckFullVersion(boolean checkFullVersion) {
        this.checkFullVersion = checkFullVersion;
    }
}
