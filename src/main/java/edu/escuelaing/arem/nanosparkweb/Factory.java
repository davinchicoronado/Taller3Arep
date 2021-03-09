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
public class Factory {
    
   public static HttpObject build(ContentType type, Socket clientSocket){
       switch(type){
           case html:
               return new HttpHtml(clientSocket);
           case jpg :
               return new HttpImage(clientSocket,type);
       }
        
       return null;
   }
    
}
