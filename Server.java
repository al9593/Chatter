import java.net.*;
import java.util.*;
import java.io.*;

public class Server
{
    private static int PORT = 4324;

    public static void main(String [] args) throws Exception
    {
		ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
		String message = "";    
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("Server ready...");
		
		while(true)
		{
			Socket socket = server.accept();
			ClientHandler h = new ClientHandler(socket, clients);
			clients.add(h);
			Thread t = new Thread(h);
			t.start();
			System.out.println("Client connected...");
			System.out.println("There are " + clients.size() + " clients connected.");
		}
       
        
	}
}
