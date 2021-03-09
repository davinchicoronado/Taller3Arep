/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.nanosparkweb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Coronado
 */
public class Reader {
    
    String salto;
    
    public Reader(){
        salto="\n";
    }
    
    public String readText(String route){
        BufferedReader br;
        FileReader fr;
        String body="";
        
        try{
            fr = new FileReader(route);
            br = new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null){
                  body+=(line+salto);
            }
            
        }catch(Exception ex){
        
        }
    
        return body;
    }
        public byte[] readImagen(String url){
        try {
            File graphicResource= new File(url);
            FileInputStream inputImage = new FileInputStream(graphicResource);
            byte[] bytes = new byte[(int) graphicResource.length()];
            inputImage.read(bytes);
            return bytes;
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
