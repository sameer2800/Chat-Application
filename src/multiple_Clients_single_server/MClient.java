package multiple_Clients_single_server;

/**
 *
 * @author sameer
 */

import java.net.*;
import java.io.*;
import static java.lang.Thread.sleep;
import java.util.Scanner;

public class MClient {
    
    public static void main(String args[]) throws Exception {
    
        Socket cli = new Socket("localhost",9999);
        
        
        
          DataInputStream  dinp =  new DataInputStream(cli.getInputStream());
          
          DataOutputStream dout = new DataOutputStream(cli.getOutputStream());
          
          Thread t1 = new Thread(new clientoutput(dinp));
            t1.start();
            
          Thread t2 = new Thread(new clientinput((dout)));
          t2.start();    
          
        
    }
    
}

class clientoutput implements Runnable {

    
    DataInputStream inp;
    String x ;
    
    public clientoutput(DataInputStream dinp ) {
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
           // inp.close();
           
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}


class clientinput implements Runnable {

    
    
    DataOutputStream outp;
    String x ;
    
    public clientinput(DataOutputStream dout ) {
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
            
         //  outp.close();  
            
        }catch(Exception e) {
            e.printStackTrace();
        }
      
       
    }
       
}
