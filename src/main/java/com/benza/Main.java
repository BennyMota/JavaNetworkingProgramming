package com.benza;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static ServerSocket serverSocket;
    private static final int PORT = 1234;


    public static void main(String[] args) throws IOException {

        System.out.println("OPENING PORT : " + PORT + "\n");
        try {
            serverSocket = new ServerSocket(PORT); //STEP 1

        } catch (IOException ioException){
            System.out.println("UNABLE TO ATTACH TO PORT ! EXCEPTION: " + ioException.getMessage());
        }

        do {
            handleClient();
        } while (true);

    }

    private static void handleClient(){
        Socket link = null;
        try{
            link = serverSocket.accept(); //STEP2

            Scanner input = new Scanner(link.getInputStream()); //STEP3
            PrintWriter output = new PrintWriter(link.getOutputStream(), true); //STEP3

            int numMessages = 0;
            String message = input.nextLine();
            while (!message.equals("***CLOSES***")){
                System.out.println("MESSAGE RECEIVED");
                numMessages++;
                output.println("MESSAGE NUM " + numMessages + " : " + message);
                message = input.nextLine();
            }

            output.println(numMessages + "messages received");
        } catch (IOException ioException){
            ioException.printStackTrace();
            System.out.println(ioException);
        }
        finally {
            try{
                System.out.println("\n* CLOSING CONNECTION...*");
                link.close();
            } catch (IOException e) {
                System.out.println("UNABLE TO DISCONNECT ! : " + e.getMessage());
                System.exit(1);
            }
        }
    }
}