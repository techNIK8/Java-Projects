import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

public class Writefile implements Serializable {
    
    String charName;
    
    public void assignName (String c) {
        charName = c;
    }
    
    public static void main (String[] args) {
        Writefile charObj = new Writefile();
        charObj.assignName("Walt");
        try{
            FileOutputStream fileOut = new FileOutputStream ("C:\\Users\\Nick\\Desktop\\test.ser");
            ObjectOutputStream objOut = new ObjectOutputStream (fileOut);
            objOut.writeObject (charObj);
            objOut.flush();
            objOut.close();
        }
        catch (IOException ioe) {
            System.out.println("An error occured");
        
        }
    }
}
        