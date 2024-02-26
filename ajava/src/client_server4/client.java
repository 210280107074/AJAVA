package jdbc.client_server4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost",3456);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the messege : ");
        String str = sc.nextLine();
        dout.writeUTF(str);
        System.out.println(din.readUTF());
}
}
