package ru.itpark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try(
                final Socket socket = new Socket("localhost", 9876);
                final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                final OutputStream outputStream = socket.getOutputStream();
        ){
            outputStream.write("hello".getBytes());
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

    } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
