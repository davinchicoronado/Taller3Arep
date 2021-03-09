/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.nanosparkweb;
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
public class HttpServer {

    
    public void start() throws IOException{
        
        
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 36000.");
            System.exit(1);
        }
        boolean running = true;
        
        while(running){
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            String route = "";
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (inputLine.contains("GET")) {
                    route = inputLine.split(" ")[1];
                }
                if (!in.ready()) {
                    break;
                }

            }
            route = route.substring(1);
            try {
                HttpObject obj = Factory.build(ContentType.valueOf(route.split("\\.")[route.split("\\.").length - 1]),clientSocket);
                obj.createHttp(route);
                obj.sendResult();
                
            } catch (Exception ex) {
                String outputLine;   
                outputLine = "HTTP/1.1 404 Not Found";
                PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(), true);
                out.println(outputLine);
                out.close();
                clientSocket.close();
            }
            
            
            in.close();
             
        }
        serverSocket.close();

    }
    private int getPort() {
            if (System.getenv("PORT") != null) {
                    return Integer.parseInt(System.getenv("PORT"));
            }
            return 36000; //returns default port if heroku-port isn't set(i.e. on localhost)
 }
    
    
        

}
