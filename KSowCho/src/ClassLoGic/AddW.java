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
    
   
    public void addW(String sfile,String word,String mean,String pronunc,String type)
    {

        
        boolean set = true;
        try {
            File file = new File(sfile);
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw, true);
            
            
           set = ReadFile.map.containsKey(word);
            
            
          
           if(set == false)               
           {
          
           ReadFile.map.put(word,"<html><i>"+pronunc+"</i><br/><ul><li><b><i>"+type+"</i></b><ul><li><font color='#cc0000'><b>"+mean+"</b></font></li></ul></html>");         
           pw.append(word);
           pw.append("<html><i>"+pronunc+"</i><br/><ul><li><b><i>"+type+"</i></b><ul><li><font color='#cc0000'><b>"+mean+"</b></font></li></ul></html>");
           pw.append("\r\n");
           JOptionPane.showMessageDialog(null,"Success !!!");
           
           }
           else
           {
               JOptionPane.showMessageDialog(null, "This word is already there !!!");
           }
          
           
           
           //f1.addListModel();
           fw.close();
           pw.close();
            
        } catch (Exception e) {
        }
    }
    
}
