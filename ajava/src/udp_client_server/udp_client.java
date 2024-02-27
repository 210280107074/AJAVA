import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udp_client{
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        System.out.println("client connected...");
        String msg = "messege from client";
        byte b[] = msg.getBytes();
        InetAddress iad = InetAddress.getByName("localhost");
        DatagramPacket dp = new DatagramPacket(b, b.length, iad,3456);
        socket.send(dp);
    }
}