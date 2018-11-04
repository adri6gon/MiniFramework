import java.util.List;
import java.util.Observable;

/**
 *
 * @author adri
 */
abstract public class Operation extends Observable{
    private float progress;
    private boolean necessaryLicense;

    public float getProgress() {
        return progress;
    }
    
    protected void setProgress(float p){
        this.progress = p;
        this.setChanged();
        this.notifyObservers();
    }

    public boolean isNecessaryLicense() {
        return necessaryLicense;
    }

    public void setNecessaryLicense(boolean necessaryLicense) {
        this.necessaryLicense = necessaryLicense;
    }
       
    abstract public String getName();
    abstract public List<String> getParams();
    abstract public String execute(List<String> paramsValues);
}
