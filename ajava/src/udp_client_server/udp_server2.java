import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

public class udp_server2 {
    public static void main(String[] args) throws IOException {
        // DatagramSocket ds = new DatagramSocket(3456);
        // byte data[] = new byte[5000];
        // InetAddress iad = InetAddress.getByName("localhost");
        // DatagramPacket dp1 = new DatagramPacket(data, data.length);
        // ds.receive(dp1);
        // FileOutputStream fos = new FileOutputStream("file1.txt");
        String msg = new String(Files.readAllBytes(Paths.get("file1.txt")));
        // data = msg.getBytes();
        // DatagramPacket dp = new DatagramPacket(data, data.length,iad,dp1.getPort());
        // ds.send(dp);
        // ds.close();
        // System.out.println(msg);
        // System.out.println("hi");
    }
}
