package com.benza;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSide {
    private static InetAddress host;
    private static final int PORT = 4444;

    public static void main(String[] args){

        try{
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException unknownHostException) {
            System.out.println("ERROR CAUSED : " + unknownHostException.getMessage());
            System.exit(1);
        }

        accessSever();
    }

    private static void accessSever(){
        Socket link = new Socket();
        try{
            link = new Socket(host, PORT); //STEP2

            Scanner input = new Scanner(link.getInputStream()); //STEP3
            PrintWriter output = new PrintWriter(link.getOutputStream(), true); //STEP3
            Scanner inputEntry = new Scanner(System.in);
            String message, response;
            do {
                System.out.println("ENTER COMMAND: ");
                message = inputEntry.nextLine();
                output.println(message);
                response = input.nextLine();
                System.out.println("\nSERVER > " + response);
            } while (!message.equals("CLOSE"));

        } catch (IOException ioException){
            ioException.printStackTrace();
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
