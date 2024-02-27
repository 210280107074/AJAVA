 import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.io.*;
public class temp2 {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost",1234);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        System.out.println("enter a value of a : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("enter the value of b : ");
        int b = sc.nextInt();
        dos.writeUTF("client 1 is connected");
        dos.writeInt(a);
        dos.writeInt(b);
        System.out.println("sum calculated by server is : "+dis.readInt());
        s.close();
    }
}
