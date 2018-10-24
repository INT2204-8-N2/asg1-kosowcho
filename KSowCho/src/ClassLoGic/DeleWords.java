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
import java.util.TreeMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author nchdz
 */
public class DeleWords {
  //  private int count = 0;
    ReadFile rf = new ReadFile();
    public static boolean set = false;
  public DefaultListModel remove(String file, String lineToRemove,TreeMap<String,String> map) {
    DefaultListModel model = new  DefaultListModel();
        try {
             File inFile = new File(file);
             
             FileWriter fw = new FileWriter(inFile);
             
             PrintWriter pw = new PrintWriter(fw);
      
      
     

       
      
       set = map.containsKey(lineToRemove);
       
       map.remove(lineToRemove);
       for(String st:map.keySet())
       {
           model.addElement(st);
       }
       if(set == true)
       {    
       
       for(String st: map.keySet())
       {
           
           pw.append(st);
           pw.append(map.get(st));
           pw.append("\r\n");
           
        
       }
       JOptionPane.showMessageDialog(null,"Success!!!");
       
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Not found OR Empty!!!");
          for(String st: map.keySet())
          {
              
           pw.append(st);
           pw.append(map.get(st));
           pw.append("\r\n");
              
           
        
          }
           
       }
        } catch (Exception e) {
        }
    
    return model;
    }
    public void deleteW(File file) throws FileNotFoundException
    {

    }
    public static void main(String args[]) throws FileNotFoundException
    {
       
       
     
    }

    
}
