import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * client
 */
public class client {

    public static void main(String[] args) {
         try {
            Socket s=new Socket("localhost", 5000);
            System.out.println("Connection established with server at 5000 port");
            BufferedReader input=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg=input.readLine();
            PrintWriter pw=new PrintWriter(s.getOutputStream()  , true);
            pw.println("sending  your msg: "+msg);
            System.out.println("msg sent");
            s.close();

        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}