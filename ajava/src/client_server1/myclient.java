import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class myclient {
    public static void main(String[] args) throws  IOException {
        while(true){
            try (Socket s = new Socket("localhost",4567)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String str = br.readLine();
                System.out.println(str);
            }  
            catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}
