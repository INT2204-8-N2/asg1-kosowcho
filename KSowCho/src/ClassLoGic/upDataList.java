/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLoGic;

import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author nchdz
 */
public class upDataList extends ksowcho.FrameKsowCho{
      public  void addListModel(JList l)
    {
        DefaultListModel l1 = new DefaultListModel();
        for(String key : ReadFile.map.keySet())
        {         
            l1.addElement(key);                                                   
        }
        l.setModel(l1);
        
    }
}
