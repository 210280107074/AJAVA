
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server22 {
    static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
        public void run(){
            try (
                DataInputStream din = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream())
            ) {
                String msg = din.readUTF();
                System.out.println("Client message: " + msg);  
                String stringWithoutSpaces = msg.replaceAll("\\s", "");
                dout.writeUTF("Number of characters in \"" + msg + "\" is : " + stringWithoutSpaces.length());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3456);
            System.out.println("Server started...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   
}
