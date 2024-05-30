import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author user
 */
public class Clientsocket {

    
    public static void main(String[] args) {
       
       try
       {
           System.out.println("Client has started");
        Socket soc =new  Socket("localhost",2180);
//DataInputStream dis= new DataInputStream(soc.getInputStream());
DataOutputStream dos= new DataOutputStream(soc.getOutputStream());
dos.writeUTF("hellooo server!!!!");
dos.flush();
dos.close();
       }
        
       catch(Exception e)
    {
    e.printStackTrace();
    }
    }

    
    
}
