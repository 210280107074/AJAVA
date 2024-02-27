import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class temp {
    static class ClientHandler extends Thread{
        private Socket s = null;
        ClientHandler(Socket clientSocket){
            s = clientSocket;
        }
        public void run(){
            try (DataInputStream dis = new DataInputStream(s.getInputStream());
                 DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            ) {
                System.out.println(dis.readUTF());
                int a  = dis.readInt();
                int b = dis.readInt();
                int sum = a+b;
                System.out.println("client sends values"+"\n"+"a : "+a+"\n"+"b: "+b);
                dos.writeInt(sum);
            } catch (IOException e) {
               
                e.printStackTrace();
            }
            finally {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
    
        ServerSocket ss = new ServerSocket(1234);
        while(true){
            Socket s = ss.accept();
           ClientHandler ch = new ClientHandler(s);
           ch.start();
        }
        
    }
}
