package proverbGenerator;
//I have fetched all the data from {apininjas.com}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Waiting for clients...");
            try (Socket clientSocket = serverSocket.accept()) {
                // Get topic of proverb from client
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String topic = reader.readLine();
                // Generate proverb
                System.out.println("Client chose " + topic);

                // Create the URI with the topic
                URI uri = URI.create("https://api.api-ninjas.com/v1/quotes?category=" + topic);
                HttpClient httpClient = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(uri)
                        .header("X-Api-Key", "mUoCexTjBz2QzmVPFR6WIQ==vXaQnn5ffK4IUtDR") // im using my key from codingNinjaAPI
                        .GET()
                        .build();
                HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());

                // Print the raw JSON response
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(response.body()));
                StringBuilder responseStringBuilder = new StringBuilder();
                String line;
                while ((line = responseReader.readLine()) != null) {
                    responseStringBuilder.append(line);
                }
                String jsonResponse = responseStringBuilder.toString();
                // System.out.println("Raw JSON response: " + jsonResponse);

                // Parse the JSON response
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(jsonResponse);

                // Assuming the response is an array of quotes
                if (root.isArray() && root.size() > 0) {
                    JsonNode firstQuote = root.get(0);
                    String quote = firstQuote.path("quote").asText();
                    String author = firstQuote.path("author").asText();
                    System.out.println("Proverb: " + quote + " - " + author+" {on topic "+topic+"}");
                    PrintWriter writer=new PrintWriter(clientSocket.getOutputStream(), true);
                    writer.println(quote);
                } else {
                    System.out.println("No proverbs found for the topic: " + topic);
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Could not connect with client. Server error occurred");
            e.printStackTrace();
        }
    }
}
