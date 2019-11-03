package ru.itpark;
import ru.itpark.IllegalReguestExceptionMethodException.IllegalReguestExceptionMethodException;
import ru.itpark.IllegalRequestException.IllegalReguestException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) {
        try (final ServerSocket serverSocket = new ServerSocket(9876);) {
            while (true) {
                try (
                        final Socket socket = serverSocket.accept();
                        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        final OutputStream os = socket.getOutputStream();
                ) {
                    System.out.println("connected");

                    final String line = reader.readLine();
                    final String[] parts = line.split(" ");

                    if(parts.length<3){
                        throw new IllegalReguestException();
                    }
                    final String method = parts [0]; //get
                    final String path = parts [1]; // index.html
                    final String version = parts [2]; //HTTP1.1

                    if (Arrays.asList("Get", "POST", "PUT", "DELETE", "OPTIONS", "HEAD").contains(method)) {
                        throw new IllegalReguestExceptionMethodException(method);
                    }

                    if (path.equals("/index.html")) {
                        final byte[] bytes = Files.readAllBytes(Paths.get("index.html"));
                        os.write(("HTTP/1.1 200 OK\r\n" +
                                "Content-Type: text/html; charset=UTF-8\r\n" +
                                "Content-Length: " + bytes.length + "\r\n" +
                                "Connection: close\r\n" +
                                "\r\n" +
                                new String (bytes)).getBytes());
                        continue;

                    }
                    final byte[] bytes = Files.readAllBytes(Paths.get("notfound.html"));
                    os.write(("HTTP/1.1 404 Not Found\r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n" +
                            "Content-Length: " + bytes.length + "\r\n" +
                            "Connection: close\r\n" +
                            "\r\n" +
                            new String (bytes)).getBytes());
                    continue;



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}