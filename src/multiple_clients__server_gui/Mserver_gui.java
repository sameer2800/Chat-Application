package multiple_clients__server_gui;

/**
 *
 * @author sameerkilamsetty
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;


public class Mserver_gui extends javax.swing.JFrame {

    public static Socket[]  globalsockets ;
    public static int[] successsockets;
    public static int socketscount;
    static DataOutputStream dout;
    static String pass;
   static boolean  success;
    
    
    public Mserver_gui() {
        initComponents();
        
        globalsockets = new Socket[20];
        successsockets = new int[20];
        
         jTextPane1.setEditable(false);
    }

     public static void socketfunc() throws Exception {
        
         ServerSocket serv = new ServerSocket(9999);
       
                   
            Thread mt = new Thread(new mainthread(serv));
        mt.start();
        
    }
    
     public static void sendthistoeveryone(String mssg,int clien_no) {
         
         for(int j =0;j < Mserver_gui.socketscount;j++){
                 if(successsockets[j] == 1 && j != clien_no){
                 DataOutputStream dout;
                     try {
                         dout = new DataOutputStream(Mserver_gui.globalsockets[j].getOutputStream());
                         
                          dout.writeUTF(mssg);
                     } catch (IOException ex) {
                         Logger.getLogger(Mserver_gui.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                 }
               }
         
     }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         try {
             // TODO add your handling code here:
             String hey = jTextField1.getText();
             jTextPane1.setText(jTextPane1.getText() + "Server : " +  hey + "\n");
             
             for(int j =0;j < Mserver_gui.socketscount;j++){
                 if(successsockets[j] == 1){
                 DataOutputStream dout = new DataOutputStream(Mserver_gui.globalsockets[j].getOutputStream());
                  dout.writeUTF("Server : " + hey);
                 }
               }
             
         
         } catch (IOException ex) {
             Logger.getLogger(Mserver_gui.class.getName()).log(Level.SEVERE, null, ex);
           }
         
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Mserver_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mserver_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mserver_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mserver_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mserver_gui().setVisible(true);
            }
        });
        
         try {
            socketfunc();
        } catch (Exception ex) {
            Logger.getLogger(Mserver_gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
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
                   
                    
                   Mserver_gui.globalsockets[i] = client;
                  
                  Mserver_gui.socketscount++;
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
        
        
        try{
            while(!x.equals("exit")) {
                  x = inp.readUTF();
                System.out.println(x);
                    
                
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
                  Mserver_gui.success = true;
                  Mserver_gui.successsockets[client_no] = 1;
                  }
                  
                }
           
                if(login && !x.startsWith("Password")) {
                Mserver_gui.jTextPane1.setText(Mserver_gui.jTextPane1.getText() + x + "\n");
                   Mserver_gui.sendthistoeveryone(x,client_no);
                }
            }
            
           
        }catch(Exception e) {
            e.printStackTrace();
           
        }
        
    }
    
    
}