/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author David Coronado
 */
public class EchoServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        
        try{
            clientSocket = serverSocket.accept();
            
        }  catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    clientSocket.getInputStream()));
        
        String inputLine, outputLine;
        Integer value;
        int cont=0;
        System.out.println("Ingresa un número para calcular su el cuadrado de este.");
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje:" + inputLine);
            value=Integer.parseInt(inputLine);
            value=value*value;
            outputLine = String.valueOf(value);
            out.println(outputLine);
            if (cont>19)
                    break;
            cont++;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }
    
    
}
