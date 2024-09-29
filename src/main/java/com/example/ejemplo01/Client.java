package com.example.ejemplo01;

import java.net.Socket;

public class Client {

    private static final int PORT = 13;
    private static final String HOST = "localhost";
    public static void main(String[] args) {
        try {
           Socket socket = new Socket(HOST, PORT);
           System.out.println("1 > Conectando al servidor: " + HOST + ":" + PORT);
        
            System.out.println("2 > Cerrando conexión");
            socket.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
}
