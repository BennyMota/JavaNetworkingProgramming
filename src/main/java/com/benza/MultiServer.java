package com.benza;

import java.io.*;
import java.net.*;

public class MultiServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started. Listening for incoming connections...");

        while (true) {
            Socket client = serverSocket.accept();
            System.out.println("New client connected: " + client.getInetAddress());

            // Create a new thread for this client
            Thread clientThread = new Thread(() -> {
                try {
                    BufferedReader clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true);

                    String input;
                    while ((input = clientIn.readLine()) != null) {
                        System.out.println("Received message from client: " + input);
                        clientOut.println(input.toUpperCase());
                    }
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                } finally {
                    try {
                        client.close();
                    } catch (IOException e) {
                        System.out.println("Error closing client socket: " + e.getMessage());
                    }
                }
            });

            // Start the thread for this client
            clientThread.start();
        }
    }
}
