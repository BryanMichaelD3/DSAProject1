import java.util.List;
import java.util.LinkedList;

public class AreaCode 
{
	private String areaCode;
	private List<Contact> contactList;
	
	public AreaCode()
	{
		areaCode = "000";
		contactList = new LinkedList<>();
	}
	
	public AreaCode(String a)
	{
		areaCode = a;
		contactList = new LinkedList<>();
	}
	
	public String getAreaCode()
	{
		return areaCode;
	}
	
	public Contact getContact(int i)
	{
		return contactList.get(i);
	}
	
	public int getContactListSize()
	{
		return contactList.size();
	}
	
	public void addContact(Contact c)
	{
		contactList.add(c);
	}
}