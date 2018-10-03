/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLoGic;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author nchdz
 */
public class AddW extends ReadFile{
    
    ReadFile rf = new ReadFile();
    public void addW(String sfile,String word,String mean)
    {
        rf.rFile(sfile);
        try {
            File file = new File(sfile);
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(file);
            
            ReadFile.map.put(word, mean);
            
            
           for(String st: ReadFile.map.keySet())
           {
               if(st.equals(word))
               {
                   System.exit(0);
               }
           }
           pw.append(word+" ");
           pw.append(mean+"\r\n");
           pw.append("\r\n");
           
           
           
           fw.close();
           pw.close();
            
        } catch (Exception e) {
        }
    }
    
}
