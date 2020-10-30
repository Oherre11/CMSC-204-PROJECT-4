import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * @author Oscar Herrera
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	
	CourseDBStructure object;
	CourseDBElement element;
	
	/**
	 * initialize courseDBStructure 
	 */
	public CourseDBManager() {
		object = new CourseDBStructure(11);
	}

	/**
	 * adds a courseDBStructure manually or by a file
	 * @param id
	 * @param crn
	 * @param credits
	 * @param roomNum
	 * @param instrctor 
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		
		element = new CourseDBElement(id, crn, credits, roomNum, instructor); 
		object.add(element);
		
	}

	/**
	 * get a element in hash table according the index of the hashcode of the crn
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return object.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * reads a file and adds it to a hashtable
	 * @param input
	 * 
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		
		BufferedReader reader = new BufferedReader(new FileReader(input));
		String text = null;
		String [] splitArray = new String[20];
		
		try {
				
			text = reader.readLine();

			while(text != null) {
				
				splitArray = text.split("\\s+");
				
				addObject(splitArray);

				text = reader.readLine();
			}
						
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Adds all the linked lists to an Arraylist 
	 * @return arrayList
	 */

	@Override
	public ArrayList<String> showAll() {
		
		LinkedList<CourseDBElement>[] table = object.hashTable;
		ArrayList<String> strings = new ArrayList<>();
		String text = null; 
		
		for (LinkedList lnkedList: table)
		{
			if (lnkedList != null) {
			for (int i = 0; i < lnkedList.size(); i++) {
			
			
				text = lnkedList.get(i).toString();
				//text = text.substring(1, text.length() - 1);
				strings.add(text);
			}
			
			}
		} 
		
		Collections.sort(strings);
		return strings;
	}
	
	/**
	 * adds a element to a hashtable according to the length of string array
	 * @param string
	 */
	public void addObject(String[] string){
		String id, roomNum, instructor;
		int crn, credits;
		
		
		if (string.length == 6)
		{
			id = string [0];
			crn = Integer.parseInt(string [1]);
			credits = Integer.parseInt(string[2]);
			roomNum = string[3];
			instructor = string[4].concat(" " + string[5]);
			//add(id, crn, credits, roomNum, instructor);
			element = new CourseDBElement(id, crn, credits, roomNum, instructor);
			
			object.add(element);
		
		}
		
		if (string.length == 7)
		{
			id = string [0];
			crn = Integer.parseInt(string [1]);
			credits = Integer.parseInt(string[2]);
			roomNum = string[3];
			instructor = string[4].concat(" " + string[5].concat(" " + string[6]));
			//add(id, crn, credits, roomNum, instructor);
			
			element = new CourseDBElement(id, crn, credits, roomNum, instructor);
			
			object.add(element);
		}
		
		
	}

}
