import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class myserver{
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(4567)) {
            while(true){
                Socket s = ss.accept();
                System.out.println("connection established....");
                PrintStream ps = new PrintStream(s.getOutputStream());
                ps.println("greeting");
                System.out.println("enter a messege to client : ");
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                ps.println(str);
            }
        }  
   }
}