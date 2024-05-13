import java.io.FileWriter;
import java.io.IOException;

public class TextFile {
    public static void main(String[] args){
        try{
            String text = "Text inside the file";
            FileWriter fw = new FileWriter ("C:\\Users\\Nick\\Desktop\\file.txt");
            fw.write(text);
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Failure");
        }
    }
}