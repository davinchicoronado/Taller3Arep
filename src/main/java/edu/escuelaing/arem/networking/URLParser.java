package edu.escuelaing.arem.networking;

import java.net.*;

/**
 * 
 *  @author David Coronado
 */
public class URLParser 
{
    public static void main( String[] args )
    {
        URL google;
        try {
            google = new URL("http://www.google.com:80/anatomy-of-full-path-url-hostname-protocol-path-more/to/myfile.html?key=value1&key2=value2#domain-name");
            
            
            System.out.println("Protocol: "+google.getProtocol());
           
            //Authority = Host Name + Port No
            System.out.println("Authority: "+google.getAuthority());
            System.out.println("Host: "+google.getHost());
            System.out.println("Port: "+google.getPort());
            System.out.println("Path: "+google.getPath());
            System.out.println("Query: "+google.getQuery());
            System.out.println("File: "+google.getFile());
            System.out.println("Anchor: "+google.getRef());
            
        } catch (MalformedURLException ex) {
                ex.printStackTrace();
        }
        //https://developer.mozilla.org/es/docs/Learn/Common_questions/Qu%C3%A9_es_una_URL
        
    }
    
}
