/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLoGic;

/**
 *
 * @author nchdz
 */
public class rString {
    public static String getSt(String demo)
    {
        if(demo.length() > 72)
        {                    
        String arr[] = demo.split(">",6);                      
        String data[] = arr[5].split("<",2);
        return data[0];
        }
        else
        {
            return null;
        }
        
        
    }
    public static void main(String args[])
    {
        String st = "<?xml version=\"1.0\" encoding=\"utf-8\"?><recognitionResults success=\"0\" />";
        
        System.out.println(rString.getSt(st));
    }
    
}
