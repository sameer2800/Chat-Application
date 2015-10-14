package multiple_Clients_single_server;

/**
 *
 * @author sameer  and copyrights to sameer only
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.print.DocFlavor;


public class MServer {
    
    public static Socket[]  globalsockets ;
    public static int socketscount;
    
    public static void main(String args[]) throws Exception {
    
           globalsockets = new Socket[20]; 
        
        ServerSocket serv = new ServerSocket(9999);
        socketscount = 0;
                
        Thread mt = new Thread(new mainthread(serv));
        mt.start();
          
    }     
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
            
            Thread epic =  new Thread(new epicthread());
            epic.start();
            
            while(true) {
                Socket client = yosoc.accept();
                
                DataInputStream  dinp =  new DataInputStream(client.getInputStream());
               // DataOutputStream dout = new DataOutputStream(client.getOutputStream());
                
              Thread  newthread = new Thread(new serveroutput(dinp));
                    newthread.start();
                   
                    
                   MServer.globalsockets[i] = client;
                  
                  MServer.socketscount++;
                    i++;
            
            }
        
            
        }catch (Exception e){
             e.printStackTrace();
        }
    }

}

class epicthread implements Runnable{
    
    Socket[] sockmany;
    int max;
    
    public epicthread(){
        max = 0;
        
    }
    
    
    
    public void run(){
        
       try {
           Scanner sc= new Scanner(System.in);
           
           while(true){
              String xy =  sc.nextLine();
              
               for(int j =0;j < MServer.socketscount;j++){
                   DataOutputStream dout = new DataOutputStream(MServer.globalsockets[j].getOutputStream());
                   dout.writeUTF(xy);
               }
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
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