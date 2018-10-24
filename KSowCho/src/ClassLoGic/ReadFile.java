/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLoGic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeMap;


/**
 *
 * @author nchdz
 */
public class ReadFile {
    public static TreeMap<String,String> map = new TreeMap<String,String>();
    
    public void rFile(String filePath) //  function doc file txt (File dict )
    {
    try {
       
    String line;
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String[] arr = new String[2];
    String value = new String("");
    String key = null;
    int count = 0;
    boolean data = true;
    while ((line = reader.readLine()) != null)
    {
        
        if(line.isEmpty())
        {
            data = true;          
           
            key = null;
            value = null;
            continue;
           
        }
        else
        {
            
            if(data)
            {  
                line+=" ";
                arr = line.split("\\s",2);
                key = arr[0];
                data = false;
                value ="\r\n"+ arr[1]+"\r\n"+"\r\n"+"\r\n";
                
                
                
            }
           
            else if(!data)
            {
                
                //value ="";
                {
                    value +="\r\n "+ line ;
                }
            }
                
        }
        map.put(key, value);
        }
    reader.close();
    }
    catch (Exception e) {
                e.printStackTrace();
                }
        }
    public void readFile(String filePath) // function doc file ev.txt cua Thay Cuong
    {
    try {
       
    String line;
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String[] arr = new String[2];
    String value = new String("");
    String key = null;
    int count = 0;
    boolean data = true;
    while ((line = reader.readLine()) != null)
    {
       
        
        if(line.isEmpty())
        {
            continue;
        }
        arr = line.split("<",2);
        
                
      
        map.put(arr[0],"<"+arr[1]);
     }
    reader.close();
    }
    catch (Exception e) {
                e.printStackTrace();
                }
        }
    public static void main(String args[])
    {
        
        
        
    }
     
    }

