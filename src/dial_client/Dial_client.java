/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dial_client;

import java.io.*;
import java.net.*;

/**
 *
 * @author Asus
 */
public class Dial_client {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Client Started");
     Socket soc = new Socket("localhost",2177);
     DataInputStream din = new DataInputStream(soc.getInputStream());
        DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
        BufferedReader userInput = new BufferedReader( new InputStreamReader(System.in));//"System.in"(byte) to InputStreamReader(char) to BufferedReader(String)
        System.out.println("Enter a String");
        String str = userInput.readLine();//wait for the user to enter the string
        //String str1=" ", str2=" ";
        while(!str.equalsIgnoreCase("stop")){
            str = userInput.readLine();
            dout.writeUTF(str);
            dout.flush();
            str=din.readUTF();
            System.out.println("Server says: "+str);
        }
        dout.close();
        soc.close();
    }
    
}
