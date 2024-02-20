package client_server3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class myserver3 {
    public static void main(String[] args) {
        try{
                
                ServerSocket ss = new ServerSocket(3456);
                Socket s = ss.accept();
                System.out.println("connection established...");
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                String str = din.readUTF();
                int n = Integer.parseInt(str);
                if(n>0){
                    dout.writeUTF("number is POSITIVE");
                }
                else if(n<0){
                    dout.writeUTF("number is NEGATIVE");
                }
                else{
                    dout.writeUTF("number is ZERO");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
