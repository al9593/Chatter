import java.util.*;
import java.text.*;

public class Message
{
	private String sender = "";
	private int senderPort = 0;
	private String reciever = "";
	private int recieverPort = 0;
	private String message = "";
	private Date timestamp;
	private final SimpleDateFormat form = new SimpleDateFormat("E hh:mm:ss a");
	
	public Message(String sender, int senderPort, String reciever, int recieverPort, String message)
	{
		this.sender = sender;
		this.senderPort = senderPort;
		this.reciever = reciever;
		this.recieverPort = recieverPort;
		this.message = message;
		timestamp = new Date();
	}
	
}
