package factorial;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost", 5000);
            Scanner sc=new Scanner(System.in);
            int msgToSend=sc.nextInt();
            PrintWriter sender=new PrintWriter(socket.getOutputStream(), true);
            sender.println(msgToSend);
            System.out.println("message snt to sever");
            socket.close();
            sc.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
