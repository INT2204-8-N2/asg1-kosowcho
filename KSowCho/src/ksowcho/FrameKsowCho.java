/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksowcho;

import API.Translator;
import ClassLoGic.History;
import ClassLoGic.ReadFile;
import TextOnImage.my_main;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author nchdz
 */
public class FrameKsowCho extends javax.swing.JFrame {

    /**
     * Creates new form FrameKsowCho
     */
    private static final String VOICENAME ="kevin16";
    
    ReadFile rfile = new ReadFile();
    addWord add = new addWord(); 
    DeleteWords delete = new DeleteWords();
    JScrollPane sb1 ;
    JList<String> list ;
    JTextPane jt = new JTextPane();
    JEditorPane editorpane = new JEditorPane();
    lichsu ls = new lichsu();
    jschoorse js = new jschoorse();
    RenderImage image = new RenderImage();
    CreateLoading loading = new CreateLoading();
    public static String textimage = "";
    public static int count = 0;
    public static boolean data = true;
    static DefaultListModel model = new DefaultListModel();
    public FrameKsowCho() {
        initComponents();
    }
    
    public  void addListModel()
    {   // them phan tu vao list
        DefaultListModel l1 = new DefaultListModel();
        for(String key : ReadFile.map.keySet())
        {         
            l1.addElement(key);                                                   
        }
        jList2.setModel(l1);
        
    }
    public void addMeanByList()
    {
       // add mean khi click vao cac phan tu trong list
        
       int data = jList2.getSelectionModel().getAnchorSelectionIndex();
       // jt.removeAll();
        jEditorPane1.removeAll();
        for(String st : ReadFile.map.keySet())
        {
            if(st.equals(jList2.getModel().getElementAt(data)))
            {
               
                jEditorPane1.setText(ReadFile.map.get(st));
                jTextSearchWord.setText(st);
               
            }
        }
    }
    public void updateList()
    {
        // update
         DefaultListModel model1 = new DefaultListModel();
        if(jTextSearchWord.getText().equals(""))
        {
            jList2.setModel(model);
            
        }
        else
        {
            for(String key: ReadFile.map.keySet())
            {
                if(check(jTextSearchWord.getText(),key))
                {
                    model1.addElement(key);
                }
            }
        }
        jList2.setModel(model1);
    }
    public void addMeanAndAddListModel(String data) throws Exception
    {
        // khi click  search
         
         String setT = null;
         DefaultListModel l1 = new DefaultListModel();
         
        
        if(data.isEmpty() )
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập từ cần tìm");
        }
        else
        {
            
        
        for(String key : ReadFile.map.keySet())
        {   
            l1.addElement(key);            
            if(key.equals(data))
            {
                setT = ReadFile.map.get(key);
                jList2.setVisible(true);
               
                break;
                            
            }
                     
        }
       
        if(setT == null)
        {
            
           
            
            int set = JOptionPane.showConfirmDialog(null,"Từ này không có sẵn có muốn tìm kiếm online không?");
            if (set == 0)
            {
                String st = Translator.Translator(data);
                setT = "<html><i>"+data+"</i><br/><ul><li><font color='#cc0000'><b>"+st+"</b></font></li></ul></html>";
            }
            else if(set == 1)
            {   
                jEditorPane1.removeAll();
                JOptionPane.showMessageDialog(null, "Hãy thử với tù khác !!!");
                
               
                
            }
              
        }
        else
        {
            
            jList2.setModel(l1);  
            
        }
        updateList();
        jEditorPane1.setText(setT);
        
      
    }   
           
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextSearchWord = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jBtLs = new javax.swing.JButton();
        jBtSearch = new javax.swing.JButton();
        jBtDelete = new javax.swing.JButton();
        jBtAdd = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Từ Điển ");
        setBackground(new java.awt.Color(0, 102, 102));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(300, 400));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksowcho/image/td.png"))); // NOI18N
        jLabel2.setText(" Từ Điển");

        jTextSearchWord.setMargin(new java.awt.Insets(5, 2, 2, 2));
        jTextSearchWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearchWordActionPerformed(evt);
            }
        });
        jTextSearchWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextSearchWordKeyReleased(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksowcho/image/mic.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jBtLs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksowcho/image/clock.png"))); // NOI18N
        jBtLs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLsActionPerformed(evt);
            }
        });

        jBtSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksowcho/image/search.png"))); // NOI18N
        jBtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSearchActionPerformed(evt);
            }
        });

        jBtDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksowcho/image/delete.png"))); // NOI18N
        jBtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDeleteActionPerformed(evt);
            }
        });

        jBtAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksowcho/image/add.png"))); // NOI18N
        jBtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAddActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksowcho/image/speech.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksowcho/image/setting.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextSearchWord, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jBtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 582, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jBtLs, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jBtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jBtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtLs, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextSearchWord)
                    .addComponent(jBtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(2, 2, 2))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setAutoscrolls(true);

        jEditorPane1.setEditable(false);
        jEditorPane1.setContentType("text/html"); // NOI18N
        jEditorPane1.setForeground(new java.awt.Color(51, 102, 255));
        jScrollPane1.setViewportView(jEditorPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setAutoscrolls(true);

        jList2.setModel(setListModel());
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jList2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jList2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jList2KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        
        renderTxt rtxt = new renderTxt();
        rtxt.setLocation(500, 350);
        rtxt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        rtxt.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSearchActionPerformed
        // button search
        
        
            editorpane.removeAll();
            jEditorPane1.removeAll();
        try {
           
            
           
            addMeanAndAddListModel(jTextSearchWord.getText());
           
            History.addW("./txt/lichsu.txt", jTextSearchWord.getText());
            ls.setTeditpane(jTextSearchWord.getText());
            
           
            
            
        } catch (Exception ex) {
            Logger.getLogger(FrameKsowCho.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_jBtSearchActionPerformed

    private void jBtLsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLsActionPerformed
            // history 
           if(count == 0)
           {
            History.readFile("./txt/lichsu.txt");
            String txt ="";
           
           for(String st : History.treeset)
           {
            txt += st+"\r\n";
            
           }
           count++;
           ls.setTeditpane(txt);
           }
           
           ls.setLocation(200, 300);
           ls.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
           ls.setVisible(true);
    }//GEN-LAST:event_jBtLsActionPerformed

    private void jBtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAddActionPerformed
             
        
             
             jTextSearchWord.getText();
             add.getjTextMean().removeAll();
             add.getjTextWord().removeAll();
             add.getjTextpronunc().removeAll();
             add.setLocation(350, 250);
             add.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
             
            // String arr[]= add.getText();       
             add.setVisible(true);
    }//GEN-LAST:event_jBtAddActionPerformed

    private void jBtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDeleteActionPerformed
       
        //JOptionPane.showMessageDialog(this, delete.getText());
        //delete.getjTextField1().setText("");
        delete.setLocation(400,350);
        delete.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        delete.setVisible(true);
    }//GEN-LAST:event_jBtDeleteActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        try {
            voice.speak(jTextSearchWord.getText());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
      addMeanByList();
        //JOptionPane.showMessageDialog(null, jList2.getModel().getElementAt(data));
        
    }//GEN-LAST:event_jList2MouseClicked

    private void jList2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList2KeyTyped
        // bat event tu ban phim 
        int data = jList2.getSelectionModel().getAnchorSelectionIndex();
        jt.removeAll();
        jTextSearchWord.removeAll();
        for(String st : ReadFile.map.keySet())
        {
            if(st.equals(jList2.getModel().getElementAt(data)))
            {
                jt.setText(ReadFile.map.get(st));
                jTextSearchWord.setText(st);
            }
        }
    }//GEN-LAST:event_jList2KeyTyped

    private void jList2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList2KeyPressed
       
    }//GEN-LAST:event_jList2KeyPressed

    private void jTextSearchWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchWordActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextSearchWordActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // phan image
        int chooser = fileChooser.showOpenDialog(this);
        
        if(chooser == JFileChooser.APPROVE_OPTION)
        {
            
            
            File file = fileChooser.getSelectedFile();
            
            String st = file.getAbsolutePath();          
            textimage = my_main.pathFile(st);
            ImageIcon icon = new ImageIcon(st);
            jTextSearchWord.setText(textimage);
            
           
            image.lb().setIcon(icon);
            image.setLocation(200, 200);
            image.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            image.setSize(500, 500);
            image.setVisible(true);
               
            try {
                //Translator.Translator(textimage);
                
                jEditorPane1.setText(Translator.Translator(textimage));
            } catch (Exception ex) {
                Logger.getLogger(FrameKsowCho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ChangeW change = new  ChangeW();
        change.setLocation(500, 350);
        change.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        change.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList2KeyReleased
        // event tu ban phim ( mui ten len xuong)
        int location = evt.getKeyLocation();
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
           
           addMeanByList();
           
        }           
        else if (location == KeyEvent.KEY_LOCATION_UNKNOWN) {
          
           addMeanByList();
        } 
    }//GEN-LAST:event_jList2KeyReleased
    
    private void jTextSearchWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSearchWordKeyReleased
        
        jEditorPane1.setContentType("text/plain");
        jEditorPane1.setText("");
        jEditorPane1.setContentType("text/html");
        jEditorPane1.removeAll();
       
        updateList();
        
    }//GEN-LAST:event_jTextSearchWordKeyReleased
    private boolean check(String wordSearch,String wordDict)
    {
        if(wordSearch.length() > wordDict.length())
        {
            return false;
        }
        for(int i = 0 ; i< wordSearch.length();i++)
        {
            if(wordSearch.charAt(i) != wordDict.charAt(i))
            {
                return false;
            }
        }
        return true;
    }
   public DefaultListModel setListModel() {
        
        
        rfile.readFile("./txt/evdemo.html");
        for(String st: ReadFile.map.keySet())
        {
            model.addElement(st);
            
        }
       
        return model;
        
    }
   public static JList getJlist()
   {
       return jList2;
   }
   public static JEditorPane getEdit()
   {
       return jEditorPane1;
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameKsowCho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameKsowCho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameKsowCho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameKsowCho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // ActionEvent evt = null;
               // new FrameKsowCho().jButton4ActionPerformed(evt);
                new FrameKsowCho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jBtAdd;
    private javax.swing.JButton jBtDelete;
    private javax.swing.JButton jBtLs;
    private javax.swing.JButton jBtSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    public static javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JList<String> jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField jTextSearchWord;
    // End of variables declaration//GEN-END:variables
}
