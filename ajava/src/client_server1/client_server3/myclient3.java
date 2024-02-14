package client_server3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class myclient3 {
    public static void main(String[] args) {
        try{
                Socket s = new Socket("localhost",3456);
                
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a number : ");
                String str = sc.nextLine();
                dout.writeUTF(str);
                System.out.println(din.readUTF());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
