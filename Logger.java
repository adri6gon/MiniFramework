import java.io.File;

/**
 *
 * @author adri
 */
abstract public class Logger {
    static final int DEBUG = 0;
    static final int INFO = 1;
    static final int ERROR = 2;
    private int threshold;
    private final Logger next;
    private static Logger singleton;
    
    public Logger(int threshold, Logger next) {
        this.threshold = threshold;
        this.next = next;
    }
   
    public void log(String msg, int prior){
        if(prior>=this.threshold){
            this._log(msg,prior);
        }else{
            this.next._log(msg, prior);
        }
    }
    public static Logger getInstance(){
        if(Logger.singleton==null){
            singleton = new ConsoleLogger(INFO,new FileLogger(ERROR,null,new File("log.txt")));
        }
        return singleton;
    }
    
    protected abstract void _log(String msg, int prior);
    
    
    
}
