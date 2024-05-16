//package com.benza;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class SimpleServer {
//    private ServerSocket server; //variable
//
//    public void initAndStart() throws Exception{ // method
//        server = new ServerSocket(4444);
//        System.out.println("Server is running...");
//        while (true){
//            Socket clientSocket = server.accept();
//            System.out.println("Client is connected!");
//            readMessageFromSocket(clientSocket);
//        }
//
//    }
//
//    private void readMessageFromSocket(Socket clientSocket) throws Exception{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
////        for (int chr = reader.read(); reader.ready(); chr = reader.read()){
////            System.out.println((char) chr);
////        }
//        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true); //STEP3
//
//            int numMessages = 0;
//            String message = reader.readLine();
//            while (!message.equals("CLOSE")){
//                System.out.println("MESSAGE RECEIVED: " + message);
//                numMessages++;
//                output.println("MESSAGE NUM " + numMessages + " : " + message);
//                message = reader.readLine();
//            }
//    }
//
//    public void close(){
//        if (server != null) {
//            try {
//                server.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    public static void main (String[] args){
//        SimpleServer server = new SimpleServer();
//
//        try{
//            server.initAndStart();
//        }catch (Exception e){
//            server.close();
//        }
//    }
//}

