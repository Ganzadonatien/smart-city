
package serversocket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author user
 */
public class Serversocket {

    
    public static void main(String[] args) {
        try 
        {
       System.out.println("wait client message...");
       ServerSocket ss = new ServerSocket(2180);
       Socket soc = ss.accept();
       System.out.println("connection is established.");
       DataInputStream dis= new DataInputStream(soc.getInputStream());
//DataOutputStream dos= new DataOutputStream(soc.getOutputStream());
      // BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
      //String str=in.readLine();
       //PrintWriter out = PrintWriter(soc.getOutputStream(), true );
       String str=(String)dis.readUTF();
       System.out.println(str);
    }
    
    catch(Exception e)
    {
    e.printStackTrace();
    }
    
    }

    private static PrintWriter PrintWriter(OutputStream outputStream, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
