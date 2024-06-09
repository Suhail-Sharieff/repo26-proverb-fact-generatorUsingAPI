package factorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static int fac(int n){
        if (n==0||n==1) {
            return n;
        }
        return (n*fac(n-1));
    }
    public static void main(String[] args) {
        try {
            ServerSocket serSoc=new ServerSocket(5000);
            System.out.println("waiting for clients");
            Socket socket=serSoc.accept();
            System.out.println("Connected successfllly");
            System.out.println("waiting for client command");
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int msgReceived=Integer.parseInt(br.readLine());
            System.out.println("client sent: "+msgReceived+" whose factorial is "+fac(msgReceived));
            serSoc.close();


        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
