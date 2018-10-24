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
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author nchdz
 */
public class ChangeWords {
     
      public static boolean set = false;
     public void changeW(String sfile,String word,String mean,String pronunc,String type)
    {
        //String sfile = "./evdemo.html";
     /*   if(count == 0)
        {
            rf.readFile(sfile);
        }
        count++;*/
        
        boolean set = true;
        try {
            File file = new File(sfile);
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw, true);
            
            
           
            
           ReadFile.map.remove(word);
           
           
           ReadFile.map.put(word,"<html><i>"+pronunc+"</i><br/><ul><li><b><i>"+type+"</i></b><ul><li><font color='#cc0000'><b>"+mean+"</b></font></li></ul></html>");     
         
          
           pw.append(word);
           pw.append("<html><i>"+pronunc+"</i><br/><ul><li><b><i>"+type+"</i></b><ul><li><font color='#cc0000'><b>"+mean+"</b></font></li></ul></html>");
           pw.append("\r\n");
           
           
           
           JOptionPane.showMessageDialog(null,"Success!!!");
           
          
           
           
           
           fw.close();
           pw.close();
            
        } catch (Exception e) {
        }
    }
}
