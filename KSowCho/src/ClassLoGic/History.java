/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLoGic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.TreeSet;

/**
 *
 * @author nchdz
 */
public class History {
     
     public static  TreeSet<String> treeset = new TreeSet<String>();
     public static void readFile(String filePath)   
    {
        String data ="";
    try {
       
    String line;
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    
    
    
    while ((line = reader.readLine()) != null)
    {
       
        
        if(line.isEmpty())
        {
            continue;
        }
       
        treeset.add(line);
       
      
       
     }
   
    reader.close();
    
    }
    catch (Exception e) {
                e.printStackTrace();
                }
        System.out.println(data);
        
        }
    public static void addW(String sfile,String word)
    {
        
       
        
        
        try {
            File file = new File(sfile);
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw, true);
            
            
          
            
            
          
          
         
           pw.append(word);
           pw.append("\r\n");
          
          
           
           
           
           fw.close();
           pw.close();
            
        } catch (Exception e) {
        }
    }
}
