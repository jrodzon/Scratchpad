import java.io.IOException;
import java.util.Stack;

public class Note {
    private Stack<String> text;
    private Stack<String> changeStack;
    private Logger logger;

    public Note() throws IOException {
        this.text = new Stack<>();
        this.changeStack = new Stack<>();
        this.logger = new Logger();
    }

    public void addLine(String line){
        logger.log(Operation.AddLine, line);
        text.push(line);
        changeStack.clear();
    }

    public void undo(){
        if(text.empty()){
            return;
        }
        String line = text.pop();
        logger.log(Operation.Undo, line);
        changeStack.push(line);
    }

    public void redo(){
        if(changeStack.empty()){
            return;
        }
        String line = changeStack.pop();
        logger.log(Operation.Redo, line);
        text.push(line);
    }

    public void close(){
        logger.closeLogger();
    }
}
