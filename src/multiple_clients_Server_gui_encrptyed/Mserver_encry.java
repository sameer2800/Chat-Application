package multiple_clients_Server_gui_encrptyed;

/**
 *
 * @author sameerkilamsetty
 */

import com.sun.crypto.provider.DESCipher;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


public class Mserver_encry extends javax.swing.JFrame {

    public static Socket[]  globalsockets ;
    public static int[] successsockets;
    public static int socketscount;
    static DataOutputStream dout;
    static String pass;
   static boolean  success;
  public static Cipher desCipher;
  public static SecretKey myDesKey ;
  public static int testint = 2;
    
    
    public Mserver_encry() {
        testint = 3;
        initComponents();
        
        globalsockets = new Socket[20];
        successsockets = new int[20];
        
         jTextPane1.setEditable(false);
    
      	   
    
    }

    public static int gettestint(){
        testint = 3;
        return testint;
    }
    
    
     public static void socketfunc() throws Exception {
        
         ServerSocket serv = new ServerSocket(9999);
       
                   
            Thread mt = new Thread(new mainthread(serv));
        mt.start();
        
    }
    
     public static void sendthistoeveryone(String mssg,int clien_no) {
         
         for(int j =0;j < Mserver_encry.socketscount;j++){
                 if(successsockets[j] == 1 && j != clien_no){
                 DataOutputStream dout;
                     try {
                         dout = new DataOutputStream(Mserver_encry.globalsockets[j].getOutputStream());
                         
                         Mserver_encry.desCipher.init(Cipher.ENCRYPT_MODE, Mserver_encry.myDesKey);
                         
                          byte[] textEncrypted = Mserver_encry.desCipher.doFinal( mssg.getBytes("ISO-8859-1"));
                         
                           dout.writeUTF(new String( textEncrypted,"ISO-8859-1"));
                         
                         
                          
                     } catch (Exception ex) {
                         Logger.getLogger(Mserver_encry.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                 }
               }
         
     }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTextPane1);

        jLabel1.setText("SERVER");

        jButton1.setText("SEND");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
         try {
             // TODO add your handling code here:
             String hey = jTextField1.getText();
             jTextPane1.setText(jTextPane1.getText() + "Server : " +  hey + "\n");
             
             for(int j =0;j < Mserver_encry.socketscount;j++){
                 if(successsockets[j] == 1){
                 DataOutputStream dout = new DataOutputStream(Mserver_encry.globalsockets[j].getOutputStream());
                 
                     try { 
                         Mserver_encry.desCipher.init(Cipher.ENCRYPT_MODE, Mserver_encry.myDesKey);
                         
                          byte[] textEncrypted = Mserver_encry.desCipher.doFinal(( "Server : " + hey).getBytes("ISO-8859-1"));
                         
                           dout.writeUTF(new String( textEncrypted,"ISO-8859-1"));
                          
                         
                     } catch (Exception ex) {
                         Logger.getLogger(Mserver_encry.class.getName()).log(Level.SEVERE, null, ex);
                     }
                  
                    }
               }
             
         
         } catch (IOException ex) {
             Logger.getLogger(Mserver_encry.class.getName()).log(Level.SEVERE, null, ex);
           }
         
         
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
            java.util.logging.Logger.getLogger(Mserver_encry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mserver_encry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mserver_encry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mserver_encry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mserver_encry().setVisible(true);
            }
        });
        
        
          try {
            
             byte[] desKeyData = { (byte)0x01, (byte)0x02, (byte)0x03, 
            (byte)0x04, (byte)0x05, (byte)0x06, (byte)0x07, (byte)0x08 };
            DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
             SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
                myDesKey = keyFactory.generateSecret(desKeySpec);
		    
		  

		    // Create the cipher 
		    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		    
		    // Initialize the cipher for encryption
		    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey); 
            
        } catch (Exception ex) {
            Logger.getLogger(Mserver_encry.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
         try {
            socketfunc();
        } catch (Exception ex) {
            Logger.getLogger(Mserver_encry.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextPane jTextPane1;
    // End of variables declaration                   
}



class mainthread implements Runnable {
    
    ServerSocket yosoc;
    DataInputStream dinp;
    DataOutputStream dout;
    Thread[] t1 = new Thread[10];
    
    public mainthread(ServerSocket yo) {
        yosoc =  yo;
    }

    
    public void run() {
        
        int i  =0;
        try {
            
          //  Thread epic =  new Thread(new epicthread());
          //  epic.start();
            
            while(true) {
                Socket client = yosoc.accept();
                
                DataInputStream  dinp =  new DataInputStream(client.getInputStream());
               // DataOutputStream dout = new DataOutputStream(client.getOutputStream());
                
                  t1[i] = new Thread(new serveroutput(dinp,i));
                    t1[i].start();
                   
                    
                   Mserver_encry.globalsockets[i] = client;
                  
                  Mserver_encry.socketscount++;
                    i++;
            
            }
        
            
        }catch (Exception e){
             e.printStackTrace();
        }
    }

}




class serveroutput implements Runnable {

    
    DataInputStream inp;
   
    String x ;
    String pass;
    int flag;
    boolean login;
    int client_no; 
    
    public serveroutput(DataInputStream dinp ,int clientno ) {
            inp = dinp;
            
            x = "init";
            pass = "root";
            flag = 0;
            login = false;
            client_no = clientno;
    }
    
    
    
    @Override
    public void run() {
        byte[] arr;
        
        try{
            while(!x.equals("exit")) {
                  x = inp.readUTF();
                System.out.println(x);
                 System.out.println(x.getBytes());
                
                Mserver_encry.desCipher.init(Cipher.DECRYPT_MODE, Mserver_encry.myDesKey);

		    // Decrypt the text
		    byte[] textDecrypted = Mserver_encry.desCipher.doFinal(x.getBytes("ISO-8859-1"));
                     System.out.println(textDecrypted);
                   // x = textDecrypted.toString();
                    x = new String(textDecrypted,"ISO-8859-1");
                    System.out.println( "final " + x);
                    
                if(x.startsWith("Password")){
                    int j =0;
                   for(int k = 9; k <=12;k++,j++){
                       if(x.charAt(k) != pass.charAt(j)){
                           flag = 1;
                           break;
                       }else
                           flag = 2;
                   } 
                    
                  if(flag == 2) {
                      login = true;
                  Mserver_encry.success = true;
                  Mserver_encry.successsockets[client_no] = 1;
                  }
                  
                }
           
                if(login && !x.startsWith("Password")) {
                Mserver_encry.jTextPane1.setText(Mserver_encry.jTextPane1.getText() + x + "\n");
                   Mserver_encry.sendthistoeveryone(x,client_no);
                }
            }
            
           
        }catch(Exception e) {
            e.printStackTrace();
           
        }
        
    }
    
    
}
