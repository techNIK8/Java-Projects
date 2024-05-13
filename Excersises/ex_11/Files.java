
import java.io.*;
import java.util.*;
public class Files{
    private static int SpaceCounter(String word) {  
        int spaceCount = 0;
        for (char c : word.toCharArray()) {
            if (c == ' ') {
            spaceCount++;
            }
        }
        return spaceCount;
    }
  public static void main(String args[]){
     File srcF = new File("C:/Users/Nikos/Desktop/src.txt");
        if(!srcF.exists())
        {System.out.println("It does not exist");}
        else{
        try{
        FileReader scr = new FileReader(srcF);
        long srcSizeBf = srcF.length();
        BufferedReader reader = new BufferedReader(scr);
        String text = "";
         try{
           int replacedSpaces = 0;
           String line = reader.readLine();
               while( line != null){
                    text += line;
                    int spaces = SpaceCounter(reader.readLine());
                    if(line==null){line.replace("","@");
                      replacedSpaces += spaces;
                    }
                    line = reader.readLine();
            } 
            System.out.println("Ta kena einai : " + replacedSpaces);
        }
          catch(Exception e){
                    e.printStackTrace();
              }
        try{
            File destj = new File("C:/Users/Nikos/My documents/dest8.txt");
            long destFileSizeBf = destj.length();
            FileWriter Filew = new FileWriter(destj);
            BufferedWriter buffW = new BufferedWriter(Filew);
            buffW.write(text);
            destj.delete();
            buffW.close();
            long srcSizeAfter = srcF.length();
            long destFileSizeAfter = destj.length();
        
        System.out.println("To megethos tou Src File meta einai : " + srcSizeAfter + " Kai prin htan : " + srcSizeBf);
        System.out.println("To megethos tou Dest File meta einai : " + destFileSizeAfter + " Kai prin htan :" + destFileSizeBf);
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
            }
    catch(FileNotFoundException  fe)
    {   
        System.out.println(" To arxeio dn yparxei ston trexonta katalogo!");
    }
}
    }
}
