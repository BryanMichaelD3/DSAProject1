public class Contact 
{
	private String name;
	private String number;
	
	public Contact()
	{
		name = "NONE";
		number = "0000";
	}
	
	public Contact(String n, String num)
	{
		name = n;
		number = num;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNumber()
	{
		return number;
	}
}