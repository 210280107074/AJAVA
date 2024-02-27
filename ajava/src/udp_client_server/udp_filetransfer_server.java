import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class udp_filetransfer_server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(3456);
        byte data[] = new byte[5000];
        InetAddress iad = InetAddress.getByName("localhost");
        DatagramPacket dp1 = new DatagramPacket(data, data.length);
        ds.receive(dp1);
        
        // String msg = new String(Files.readAllBytes(Paths.get("file1.txt")));

         FileReader fileReader = new FileReader("E:\\AJAVA\\ajava\\src\\udp_client_server\\file1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            bufferedReader.close();
            String fileContent = stringBuilder.toString();

        data = fileContent.getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length,iad,dp1.getPort());
        ds.send(dp);
        ds.close();
        System.out.println("file sent successfully");
        // System.out.println(fileContent);
    
    }
}
