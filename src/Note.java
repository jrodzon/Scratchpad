import java.io.IOException;
import java.util.Stack;
import java.util.Date;

public class Note {
    private Stack<Line> text;
    private Stack<Line> changeStack;
    private Logger logger;

    public Note() throws IOException {
        this.text = new Stack<>();
        this.changeStack = new Stack<>();
        this.logger = new Logger();
    }

    public void addLine(String lineStr){
        Line line = new Line(lineStr, new Date());
        logger.log(Operation.AddLine, lineStr);
        text.push(line);
        changeStack.clear();
        System.out.println("Date: " + line.getDate().toString() + " Added: " + line.getLine());
    }
    public void printNote() {
        Stack<Line> tmp = new Stack<>();
        Stack<Line> copiedStack = (Stack<Line>)text.clone();
        while(!copiedStack.empty()) {

            tmp.push(copiedStack.pop());
        }
        while(!tmp.empty()) {
            System.out.println(tmp.pop().getLine());
        }
    }

    public void undo(){
        if(text.empty()){
            return;
        }
        Line line = text.pop();
        logger.log(Operation.Undo, line.getLine());
        changeStack.push(line);
        if (!text.empty())
            System.out.println("Current state from " + text.peek().getDate());
        else
            System.out.println("Working with clear scratchpad");
    }

    public void redo(){
        if(changeStack.empty()){
            return;
        }
        Line line = changeStack.pop();
        logger.log(Operation.Redo, line.getLine());
        text.push(line);
        System.out.println("Current state from " + text.peek().getDate());
    }

    public void close(){
        logger.closeLogger();
    }
}