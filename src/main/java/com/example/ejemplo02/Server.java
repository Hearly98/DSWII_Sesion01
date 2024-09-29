package com.example.ejemplo02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 13;

    Server() {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("1> Servidor iniciado en el puerto " + PORT);
            while (true) {
                System.out.println("2 > Esperando al cliente ...");
                Socket client = server.accept();
                System.out.println("3 > Cliente conectado por " + client.getInetAddress());

                // Flujos de comunicación
                BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter salida = new PrintWriter(client.getOutputStream(), true);

                // Leer mensaje del cliente
                String mensaje = entrada.readLine();

                // procesar mensaje
                String precio = "";
                switch (mensaje) {
                    case "PLATEA":
                        precio = "50";
                        break;
                    case "VIP":
                        precio = "150";
                        break;
                    case "PLATINUM":
                        precio = "250";
                        break;
                    default:
                        break;
                }
                //Enviar mensaje al cliente
                System.out.print("4 > El precio del tipo de cliente " + mensaje + "es " + precio);
                salida.println("El precio del tipo de cliente " + mensaje + " es " + precio);
                System.out.println("5 > Cerrando conexión");
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
