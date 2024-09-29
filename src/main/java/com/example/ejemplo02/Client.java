package com.example.ejemplo02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Client {

    private static final int PORT = 13;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);
            System.out.println("1 > Conectando al servidor: " + HOST + ":" + PORT);

            // Flujos de comunicación
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String[] mensajes = { "PLATEA", "VIP", "PLATINUM" };
            Random random = new Random();
            int index = random.nextInt(mensajes.length);
            String mensaje = mensajes[index];
            System.out.println("2 > Enviando mensake al servidor: " + mensaje);
            // Enviar mensaje al servidor
            salida.println(mensaje);
            // Se recibe el mensaje del servidor (precio)
            String respuesta = entrada.readLine();
            System.out.println("3 > Respuesta del servidor: " + respuesta);
            System.out.println("4 > Cerrando conexión");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
