import java.net.*;
import java.util.*;
import java.io.*;

public class ClientHandler implements Runnable
{
	private ObjectOutputStream out;
    private ObjectInputStream in;
    private ArrayList<ClientHandler> clients;
    
	public  ClientHandler(Socket socket, ArrayList<ClientHandler> c)
	{
		try
		{
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		clients = c;		
	}
	
	public void run()
	{
		String message = "";
		boolean connected = true;
		while(connected)
		{
			try
			{
				message = (String)in.readObject();
				broadcastMessage(message);
				System.out.println("Sent: " + message);
			}
			catch(Exception e)
			{
				clients.remove(this);
				connected = false;
			}
		}
	}
	
	private void broadcastMessage(String m)
	{
		for(int i = 0; i < clients.size(); i++)
		{
			clients.get(i).sendMessage(m);
		}
	}
	
	public void sendMessage(String m)
	{
		try
		{
			out.writeObject(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


