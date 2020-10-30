/**
 * 
 * @author Oscar Herrera
 *
 */
public class CourseDBElement implements Comparable {
	
	String courseID;
	int CRN;
	int numOfCredits;
	String roomNumber;
	String instructorsName; 
	
	/**
	 * default constructor
	 */
	CourseDBElement(){
		courseID = null;
		this.CRN = 0;
		numOfCredits = 0;
		roomNumber = null;
		instructorsName = null; 
	}
	
	/**
	 * arg constructor
	 * @param id
	 * @param CRN
	 * @param credit
	 * @param room
	 * @param instructor
	 */
	CourseDBElement(String id, int CRN, int credit, String room, String instructor){
		courseID = id;
		this.CRN = CRN;
		numOfCredits = credit;
		roomNumber = room;
		instructorsName = instructor; 
		
		
	}
	
	/**
	 * organizes a list in order by CRN
	 */
	@Override 
	public int compareTo(CourseDBElement element) {
		return this.CRN - element.CRN;
		
	}


	/**
	 * returns a crn 
	 * @return crn
	 */
	public int getCRN() {
		return CRN;
	}
	
	/**
	 * returns class courseID
	 * @return courseID
	 */
	public String getCourseID() {
		return courseID;
	}
	
	/**
	 * returns number of credits
	 * @return numOfCredits
	 */
	public int getNumOfCredits() {
		return numOfCredits;
	}
	
	/**
	 * returns roomsnumber
	 * @return roomsnumber
	 */
	public String roomNumber() {
		return roomNumber;
	}
	
	/**
	 * instructors name
	 * @return instructors name
	 */
	public String instructorsName() {
		return instructorsName;
	}
	
	/**
	 * returns a list of all elements 
	 */
	@Override
	public String toString() {
		return  "\nCourse:" + courseID +" " + "CRN:" + String.valueOf(CRN) + " "+ "Credits:" + String.valueOf(numOfCredits) +  " " + "Instructor:"  + instructorsName + " " + "Room:" + roomNumber;
	
	}
	
	/**
	 * sets crn
	 * @param crn
	 */
	public void setCRN(int crn) {
		CRN = crn;
	}
	
	/**
	 * overrides hash code
	 * @return hashcode for crn
	 */
	@Override
	public int hashCode(){
		String crn = String.valueOf(CRN);
		int hashCode = crn.hashCode();
		return hashCode;
	}
 
}
