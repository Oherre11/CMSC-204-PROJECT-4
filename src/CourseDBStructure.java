import java.io.IOException;
import java.util.LinkedList;

/**
 * 
 * @author Oscar Herrera
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{

	int size;
	LinkedList<CourseDBElement> [] hashTable;

	/**
	 * Argument constructor
	 * @param size
	 */
	public CourseDBStructure(int size) {
		this.size = size;
		hashTable = new LinkedList[size];
		
		for (int i = 0; i < hashTable.length; i++)
		{
			hashTable[i] = null;
		}
	}
	
	/**
	 * Test constructor
	 * @param test
	 * @param size
	 */
	public CourseDBStructure(String test, int size){
		this.size = size;
		hashTable = new LinkedList[size];	
		
		for (int i = 0; i < hashTable.length; i++)
		{
			hashTable[i] = null;
		}
	}
	
	/**
	 * Add a courseDBElement to the hashTable using buckets
	 * @param element to add
	 * 
	 */

	@Override
	public void add(CourseDBElement element) {
		
		int index = element.hashCode() % size;
		LinkedList<CourseDBElement> lnkedList = hashTable[index];
		
		
		if (lnkedList == null)
		{
			lnkedList = new LinkedList<CourseDBElement>();
			lnkedList.add(element);
			hashTable[index] = lnkedList;
			return;
		}
		
		else {
			
			for (CourseDBElement list : lnkedList) {
				
				if (list.CRN == element.CRN)
				{
					list = element;
					return;
				}
			}
			
			lnkedList.add(element);
		}
		
	}
	
	
	/**
	 * get the linked list according to crn
	 * @param crn
	 * @return element at index according to crn
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		
		int index = String.valueOf(crn).hashCode() % size;
		
		LinkedList<CourseDBElement> list = hashTable[index];
		
		if(list.get(index) != null)
		{
			return list.get(index);
		}
		else {
		
		throw new IOException();
		
		}
	
	}

	/**
	 * returns table size
	 * @return size
	 */
	@Override
	public int getTableSize() {
		return size;
	}

}
