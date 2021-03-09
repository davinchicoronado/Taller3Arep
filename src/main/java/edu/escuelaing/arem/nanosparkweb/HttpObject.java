/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.nanosparkweb;

import java.net.Socket;

/**
 *
 * @author David Coronado
 */
public abstract class HttpObject {
    
    protected String statusLine;
    protected String header;
    protected Reader reader;
    protected Socket clientSocket;
    

    
    public HttpObject(Socket clientSocket){
        this.clientSocket=clientSocket;
        reader = new Reader();
    }
    
    public abstract void createHttp(String url);
    public abstract void sendResult();
    
}
