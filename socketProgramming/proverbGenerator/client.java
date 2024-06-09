package proverbGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class client {
    public static void main(String[] args) {
        List<String> topics = Arrays.asList(
            "age", "alone", "amazing", "anger", "architecture", "art", "attitude", 
            "beauty", "best", "birthday", "business", "car", "change", "communication", 
            "computers", "cool", "courage", "dad", "dating", "death", "design", "dreams", 
            "education", "environmental", "equality", "experience", "failure", "faith", 
            "family", "famous", "fear", "fitness", "food", "forgiveness", "freedom", 
            "friendship", "funny", "future", "god", "good", "government", "graduation", 
            "great", "happiness", "health", "history", "home", "hope", "humor", "imagination", 
            "inspirational", "intelligence", "jealousy", "knowledge", "leadership", "learning", 
            "legal", "life", "love", "marriage", "medical", "men", "mom", "money", "morning", 
            "movies", "success"
        );
        Random ra=new Random();
        int someIndex=ra.nextInt(topics.size());
        String chosenTopic =topics.get(someIndex);
        try (//i need to send this topic to server now
        Socket socket = new Socket("localhost", 5000)) {
        //sent topic
        PrintWriter sender=new PrintWriter(socket.getOutputStream(), true);
        sender.println(chosenTopic);
        System.out.println("Request sent for server....");
        //get proverb
        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String proverb=reader.readLine();
        System.out.println("Suhail has got a quote for you from the bottom of his heart:");
        System.out.println(proverb);
        socket.close();


        } catch (IOException e) {

        }
        
        
    }
}
