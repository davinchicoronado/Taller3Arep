/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.nanosparkweb;

import java.io.IOException;

/**
 *
 * @author David Coronado
 */
public class App {
    public static void main(String[] args) throws IOException {
          HttpServer server = new HttpServer();
          server.start();
    
    }
}
