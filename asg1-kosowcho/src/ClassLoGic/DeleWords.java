 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLoGic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import javax.naming.ldap.HasControls;

/**
 *
 * @author nchdz
 */
public class DeleWords {
  //  private int count = 0;
      public void remove(String file, String lineToRemove,HashMap<String,String> map) {

    try {

      File inFile = new File(file);

      if (!inFile.isFile()) {
        System.out.println("Parameter is not an existing file");
        return;
      }

      //Construct the new file that will later be renamed to the original filename.
      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

      BufferedReader br = new BufferedReader(new FileReader(file));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

      String line = null;
      map.remove(lineToRemove);
    //  count++;
        //int i;
       
       for(String st: map.keySet())
       {
           pw.append(st+" ");
           pw.append(map.get(st)+"\r\n");
           pw.append("\r\n");
           //pw.flush();
       }
      //Read from the original file and write to the new
      //unless content matches data to be removed.
       
    /*  while ((line = br.readLine()) != null) {
       // line.
        if (!line.trim().equals(lineToRemove)) {
          pw.println(line);
          pw.flush();
        }
      }*/
      pw.close();
      br.close();

      //Delete the original file
      if (!inFile.delete()) {
        System.out.println("Could not delete file");
        return;
      }

      //Rename the new file to the filename the original file had.
      if (!tempFile.renameTo(inFile))
        System.out.println("Could not rename file");

    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }
    public void deleteW(File file) throws FileNotFoundException
    {

    }
    public static void main(String args[]) throws FileNotFoundException
    {
        DeleWords dele = new DeleWords();
        File file = new File("./demo.txt");
       // dele.remove("./demo.txt","abc");
       // String data = "broadly";
        ReadFile rf = new ReadFile();
        rf.rFile("./demo.txt");
        HashMap<String,String> demo = new HashMap<String,String>();
        demo = ReadFile.map;
       
       // dele.remove("./demo.txt","binary");
        
       /* for(String st :  demo.keySet())
        {
            System.out.println(st+" :" +demo.get(st));
        }*/
        
    }

    
}
