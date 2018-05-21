import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoteControl {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Note note = new Note();

        boolean undoDone = false;

        while(true){
            System.out.println("Choose operation:");
            String operation = br.readLine();
            switch(operation){
                case "a":
                    String line = br.readLine();
                    note.addLine(line);
                    undoDone = false;
                    break;
                case "z":
                    note.undo();
                    undoDone = true;
                    break;
                case "y":
                    if(undoDone){
                        note.redo();
                    }
                    else{
                        System.out.println("You can't redo without making undo.");
                    }
                    break;
                case "p":
                    note.printNote();
                    break;
                case "q":
                    System.out.println("Bye.");
                    note.close();
                    return;
                default:
                    System.out.println("Unrecognised operation try: a to addLine, z to undo, y to redo, p to print, q to quit.");
            }
        }
    }
}