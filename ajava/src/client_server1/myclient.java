import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class myclient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        try (Socket s = new Socket("localhost",4567)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str = br.readLine();
            System.out.println(str);
        }
  

       
    }
}
