Step1: u need to download these JAR files before running .
run these on powershell:


New-Item -ItemType Directory -Path "C:\Users\suhai\Desktop\socketProgramming\lib"

Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.14.0/jackson-databind-2.14.0.jar" -OutFile "C:\Users\suhai\Desktop\socketProgramming\lib\jackson-databind-2.14.0.jar"
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.14.0/jackson-core-2.14.0.jar" -OutFile "C:\Users\suhai\Desktop\socketProgramming\lib\jackson-core-2.14.0.jar"
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.14.0/jackson-annotations-2.14.0.jar" -OutFile "C:\Users\suhai\Desktop\socketProgramming\lib\jackson-annotations-2.14.0.jar"

javac -cp ".\lib\jackson-databind-2.14.0.jar;.\lib\jackson-core-2.14.0.jar;.\lib\jackson-annotations-2.14.0.jar" -d out src\proverbGenerator\Server.java

java -cp ".\out;.\lib\jackson-databind-2.14.0.jar;.\lib\jackson-core-2.14.0.jar;.\lib\jackson-annotations-2.14.0.jar" proverbGenerator.Server


step 2:run server.java first
step2: run client.java next, enjoy the api😁

note:the main stuff is in proverbGenerator folder. the remaining are just to brush up socket programming


ON ANOTHER DEVICE
Steps to Run the Java Project on Another Device
Set Up the Project Structure:
Ensure the other device has a similar directory structure. You can create the structure manually or copy the entire project directory (socketProgramming) from your current device to the other device.

arduino
Copy code
C:\Users\<username>\Desktop\socketProgramming\
├── lib\
│   ├── jackson-databind-2.14.0.jar
│   ├── jackson-core-2.14.0.jar
│   └── jackson-annotations-2.14.0.jar
├── src\
│   ├── proverbGenerator\
│   │   ├── Server.java
│   │   └── Client.java
└── out\
Install Java Development Kit (JDK):
Ensure the other device has the JDK installed. You can download it from Oracle's official site or use OpenJDK.

Compile the Java Project:
On the other device, open a command prompt or terminal, navigate to the project directory, and compile the Java project:

bash
Copy code
cd C:\Users\<username>\Desktop\socketProgramming
javac -cp ".\lib\jackson-databind-2.14.0.jar;.\lib\jackson-core-2.14.0.jar;.\lib\jackson-annotations-2.14.0.jar" -d out src\proverbGenerator\Server.java src\proverbGenerator\Client.java
Run the Server:
In the command prompt or terminal, navigate to the project directory and run the server:

bash
Copy code
java -cp ".\out;.\lib\jackson-databind-2.14.0.jar;.\lib\jackson-core-2.14.0.jar;.\lib\jackson-annotations-2.14.0.jar" proverbGenerator.Server
Run the Client:
Open another command prompt or terminal, navigate to the project directory, and run the client:

bash
Copy code
java -cp ".\out;.\lib\jackson-databind-2.14.0.jar;.\lib\jackson-core-2.14.0.jar;.\lib\jackson-annotations-2.14.0.jar" proverbGenerator.Client
Additional Notes
Network Configuration: Ensure that the client and server are on the same network, or configure the server's firewall to allow connections from the client.

API Key: Ensure the API key is correctly set in your Server.java code:

java
Copy code
HttpRequest request = HttpRequest.newBuilder()
    .uri(uri)
    .header("X-Api-Key", "YOUR_ACTUAL_API_KEY_HERE") // Replace with your actual API key
    .GET()
    .build();
Dependencies: Ensure all dependencies (JAR files) are present in the lib directory on the other device.
