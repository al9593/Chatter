import java.io.*;
import java.util.ArrayList;

public class MemberList
{
	private ArrayList<Member> members = new ArrayList<Member>();
	
	public void addMember(Member m)
	{
		members.add(m);
	}
	
	public Member get(int index)
	{
		return members.get(index);
	}
	
	public int getSize()
	{
		return members.size();
	}
	
	public void readFile()
	{
		try
		{
			File file = new File("People.peeps");
			if(file.exists())
			{
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fis);
				members = (ArrayList<Member>)in.readObject();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void writeFile()
	{
		try
		{
			File file = new File("People.peeps");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(members);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
