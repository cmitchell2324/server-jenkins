package lvc.cds;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

    public static void main(String[] args) throws IOException {
        String requestMessageLine;
        String fileName;

        ServerSocket socket = new ServerSocket(8080);
        Socket connection = socket.accept();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        DataOutputStream output = new DataOutputStream(connection.getOutputStream());

        requestMessageLine = reader.readLine();
        StringTokenizer line = new StringTokenizer(requestMessageLine);

        if(line.nextToken().equals("GET")) {
            fileName = line.nextToken();
            if(fileName.startsWith("/") == true) {
                fileName = fileName.substring(1);
            }
            File file = new File(fileName);
            int bytes = (int) file.length();
            FileInputStream readFile = new FileInputStream(fileName);
            byte[] fileBytes = new byte[bytes];
            readFile.read(fileBytes);
            output.writeBytes("HTTP/1.0 200 Document Follows\r\n");
            if(fileName.endsWith(".txt")) {
                output.writeBytes("Content-Type: text/plain\r\n");
            }
            output.writeBytes("Content-length: " + bytes + "\r\n");
            output.writeBytes("\r\n");
            output.write(fileBytes, 0, bytes);
            socket.close();
        } else {
            System.out.println("Bad Request Message");
        }
    }
}