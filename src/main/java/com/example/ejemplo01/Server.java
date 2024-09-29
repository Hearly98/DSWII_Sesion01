package com.example.ejemplo01;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 13;
    Server(){
       try {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("1> Servidor iniciado en el puerto " + PORT);
        while (true) {
             System.out.println("2 > Esperando al cliente ...");
             Socket client = server.accept();
             System.out.println("2 > Cliente conectado por " + client.getInetAddress());
        
             System.out.println("4 > Cerrando conexión");
             client.close();
         }  
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Server();
    }
}
