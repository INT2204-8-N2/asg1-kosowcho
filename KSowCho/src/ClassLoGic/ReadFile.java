/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLoGic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author nchdz
 */
public class ReadFile {
    public static HashMap<String,String> map = new HashMap<String, String>();
    public void rFile(String filePath)
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
           // System.out.println("");
            key = null;
            value = null;
            continue;
           
        }
        else
        {
            
            if(data)
            {
                arr = line.split("\\s",2);
                key = arr[0];
                data = false;
                value ="\r\n"+ arr[1];
                
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
    public static void main(String args[])
    {
        ReadFile rf = new ReadFile();
        rf.rFile("./AnhViet.dict");
        
    }
     
    }

