import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;

public class Client extends JPanel implements ActionListener
{
	private final int PORT = 4324;
	private JTextArea textarea;
	private JTextField textfield;
	private JButton button;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private String clientUserName = "";
	
	public static void main(String[] args) 
	{
		SignIn in = new SignIn();
		while(in.isClosed())
			System.out.println("I am running!");
			new Client();
	}
	
	public Client()
	{
		//Make Frame
		JFrame frame = new JFrame("Chatter");
		frame.add(this);
		frame.setSize(400,300);
		frame.setResizable(false);
		
		//Set Up Socket
		try
		{
			Socket socket = new Socket("localhost", PORT);
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        
        //Gui layout
        setLayout(null);
        textarea = new JTextArea();
        JScrollPane pane = new JScrollPane(textarea);
        pane.setSize(360, 200);
        pane.setLocation(10,10);
        add(pane);
        
        textfield = new JTextField();
        textfield.setSize(280, 25);
        textfield.setLocation(10 ,220);
        add(textfield);
        
        button = new JButton("Send");
        button.setSize(70,25);
        button.setLocation(300,220);
        button.addActionListener(this);
        add(button);
        
        
        frame.setVisible(true);
        
        //go to read method
        getMessages();
	}
	
	private void getMessages()
	{
		while(true)
		{
			try
			{
				textarea.append((String)in.readObject() + "\n");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			out.writeObject(textfield.getText());
			textfield.setText("");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
