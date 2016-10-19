import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ReverseLookup 
{
	public static List<AreaCode> createList(List<String> fileContents)
	{
		List<AreaCode> areaCodeList = new LinkedList<>();	// A linked list of all the area codes
		
		// Sort data
		fileContents.sort(null);
		
		// For each line of the file contents...
		for(String line: fileContents)
		{
			boolean exists = false;			// Boolean used to see if the area code already existed in the area code list
			AreaCode tempAreaCode = null;	// Pointer to the current area code, if needed
			
			// For each area code in the list...
			for(AreaCode areaCode: areaCodeList)
			{
				// If current area code equals the current contact's area code...
				if(areaCode.getAreaCode().equals(line.split(",")[0].substring(0, 3)))
				{
					// The area code already existed in list, hold onto that current area code
					tempAreaCode = areaCode;
					exists = true;
					break;
				}
			}
			
			// If area code already existed...
			if(exists)
			{
				// Add that contact's information to that area code's list of contacts
				Contact c = new Contact(line.split(",")[1], line.split(",")[0].substring(4));	// New contact created from the current line of the file contents
				tempAreaCode.addContact(c);
			}
			
			// Otherwise...
			else
			{
				// Add the new area code to the list as well as the contact's info
				AreaCode a = new AreaCode(line.split(",")[0].substring(0, 3));					// New area code created from the current line of the file contents
				Contact c = new Contact(line.split(",")[1], line.split(",")[0].substring(4));	// New contact created from the current line of the file contents
				a.addContact(c);
				areaCodeList.add(a);
			}
		}
		
		return areaCodeList;
	}
	
	public static List<String> lookUp(String number, List<AreaCode> areaCodeList)
	{
		List<String> results = new ArrayList<>();
		
		for(AreaCode areaCode: areaCodeList)
		{
			if(number.split("-")[0].compareTo(areaCode.getAreaCode()) == 0)
			{
				for(int i = 0; i < areaCode.getContactListSize(); i++)
				{
					if(number.split("-")[1].compareTo(areaCode.getContact(i).getNumber()) == 0)
					{
						results.add(areaCode.getContact(i).getName());
					}
				}
			}
		}
		
		return results;
	}
}