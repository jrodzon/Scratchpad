import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {
    private PrintWriter writer;

    public Logger() throws IOException {
        this.writer = new PrintWriter("log.txt", "UTF-8");
    }

    public void log(Operation operation, String line){
        this.writer.println((new Date()).toString() + ", operation: " + operation.toString() + ", difference: " + line);
    }

    public void closeLogger(){
        writer.close();
    }
}
