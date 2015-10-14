package Single_server_client;

/**
 *
 * @author sameer
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.print.DocFlavor;


public class server {
    
    public static void main(String args[]) throws Exception {
    
        ServerSocket serv = new ServerSocket(9999);
        
        Socket client = serv.accept();
        
          DataInputStream  dinp =  new DataInputStream(client.getInputStream());
          
         
          
          DataOutputStream dout = new DataOutputStream(client.getOutputStream());
         
          Thread t1 = new Thread(new serveroutput(dinp));
            t1.start();
            
          Thread t2 = new Thread(new serverinput((dout)));
          t2.start();    
          
    }     
}


class serveroutput implements Runnable {

    
    DataInputStream inp;
    String x ;
    
    public serveroutput(DataInputStream dinp ) {
            inp = dinp;
            x = "init";
    }
    
    
    
    @Override
    public void run() {
        
        
        try{
            while(!x.equals("exit")) {
                 x = inp.readUTF();
                System.out.println(x);
            }
            
           
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}

class serverinput implements Runnable {

    
    
    DataOutputStream outp;
    String x ;
    
    public serverinput(DataOutputStream dout ) {
            outp = dout;
            x = "init";
    }
    
    
    
    @Override
    public void run() {
        
        Scanner s = new Scanner(System.in);
        
        try{
            while(!x.equals("exit")) {
                 x = s.nextLine();
                 outp.writeUTF(x);
            }
            
           
           
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}