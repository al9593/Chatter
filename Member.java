import java.io.*;
@SuppressWarnings("serial")

public class Member implements Serializable
{
	private String MUsername = "";
	private String MPassword = "";
	
	public Member(String MUsername, String MPassword)
	{
		this.MUsername = MUsername;
		this.MPassword = MPassword;
	}
	
	public String getMUsername()
	{
		return MUsername;
	}
	
	public void setMUsername(String MUsername)
	{
		this.MUsername = MUsername;
	}
	
	public String getMPassword()
	{
		return MPassword;
	}
	
	public void setMPassword(String MPassword)
	{
		this.MPassword = MPassword;
	}
}
