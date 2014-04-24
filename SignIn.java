import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignIn implements ActionListener
{
	private String username = "";
	private String password = "";
	private JTextField userField;
	private JPasswordField passField;
	private JButton signInButton;
	private JButton signUpButton;
	private JFrame frame;
	private MemberList List = new MemberList();
	
	public SignIn()
	{
		List.readFile();
		makeSignInWindow();
	}
	
	private void makeSignInWindow()
	{
		JPanel SignInPanel = new JPanel();
		frame = new JFrame("Sign In");
		frame.add(SignInPanel);
		frame.setSize(240,210);
		frame.setResizable(false);
		SignInPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		JLabel intro = new JLabel("Enter the following credentials");
		JLabel userLabel = new JLabel("UserName:");
		userField = new JTextField();
		userField.setPreferredSize(new Dimension(212,20));
		JLabel passLabel = new JLabel("Password:");
		passField = new JPasswordField(19);
		signInButton = new JButton("Sign In");
		signInButton.addActionListener(this);
		signUpButton = new JButton("Sign Up");
		signUpButton.addActionListener(this);
		
		SignInPanel.add(intro);
		SignInPanel.add(userLabel);
		SignInPanel.add(userField);
		SignInPanel.add(passLabel);
		SignInPanel.add(passField);
		SignInPanel.add(signInButton);
		SignInPanel.add(signUpButton);

		frame.setVisible(true);
	}
	
	public boolean isClosed()
	{
		if(frame.isVisible())
			return false;
		else
			return true;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(char[] password)
	{
		password = passField.getPassword();
		String sPassword = new String(password);
		this.password = sPassword;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(signInButton == e.getSource())
		{
			setUsername(userField.getText());
			setPassword(passField.getPassword());
			if(check())
			{
				JOptionPane.showMessageDialog(new JFrame(), "Login Successful");
				frame.setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(new JFrame(), "Either username or password is incorrect. Please try again.");
		}
		if(signUpButton == e.getSource())
		{
			setUsername(userField.getText());
			setPassword(passField.getPassword());
			if(!check())
			{
				Member m = new Member(username, password);
				List.addMember(m);
				List.writeFile();
				JOptionPane.showMessageDialog(new JFrame(), "User created.");
				frame.setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(new JFrame(), "Someone has already used those credentials. Please try a different username or password");
		}
	}
	
	public boolean check()
	{
		for (int i = 0; i < List.getSize(); i++)
		{
			Member m = List.get(i);
			String user = m.getMUsername();
			String pass = m.getMPassword();
			
			if(username.equals(user) && password.equals(pass))
			{
				return true;
			}	
		}	
		return false;	
	}
}
