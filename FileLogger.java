import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

/**
 *
 * @author adri
 */
public class FileLogger extends Logger {

    private File out;

    public FileLogger(int threshold, Logger next, File out) {

        super(threshold, next);
        this.out = out;
    }

    @Override
    protected void _log(String msg, int prior) {
        try {
            System.out.println("ARCHIVOOOO");
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.out));
            PrintWriter wr = new PrintWriter(bw); 
            wr.write(msg);
            wr.close();
            bw.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FileLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
