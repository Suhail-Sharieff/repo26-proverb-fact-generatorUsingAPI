import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * server
 */
public class server {

    public static void main(String[] args) {
         try {
            ServerSocket ss=new ServerSocket(5000);
            System.out.println("Waiting for clients....");
            Socket s=ss.accept();
            System.out.println("Connection established with client at 5000 port");
            BufferedReader input=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg=input.readLine();
            PrintWriter pw=new PrintWriter(s.getOutputStream()  , true);
            pw.println("Server received your msg: "+msg);
            ss.close();

          System.out.println("Client sent a msg: "+msg);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}