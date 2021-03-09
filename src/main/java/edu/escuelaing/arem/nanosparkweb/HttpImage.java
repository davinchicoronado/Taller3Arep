/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.nanosparkweb;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Coronado
 */
public class HttpImage extends HttpObject{
    
    protected byte[] body;
    protected String contentLength;
    ContentType type;
    
    public HttpImage(Socket clientSocket , ContentType type){
        super(clientSocket);
        this.type=type;
    }
    

    @Override
    public void createHttp(String url) {
       
       body = reader.readImagen(url);
       System.out.println(body.length);
       if(body.length==0){
           statusLine="HTTP/1.1 404 Not Found";
       }
       else{
            statusLine="HTTP/1.1 200 OK\r\n" ;
            header="Content-Type: image/"+type+"\r\n";
            System.out.println(header);
            contentLength="Content-Length: "+body.length+"\r\n";
            
       
       }
    }
    @Override
    public void sendResult() {
        DataOutputStream binaryOut;
        try {
            binaryOut = new DataOutputStream(clientSocket.getOutputStream());
            binaryOut.writeBytes(statusLine);
            binaryOut.writeBytes(header);
            binaryOut.writeBytes(contentLength);
            binaryOut.writeBytes("\r\n");
            binaryOut.write(body);
            binaryOut.close();
            clientSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(HttpImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
        
    }
    
    
}
