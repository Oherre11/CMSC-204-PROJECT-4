import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Oscar Herrera
 * 
 *this is a test for CourseDBManager
 */
class CourseDBManagerStudentTest {
	
	private CourseDBManagerInterface dataMgr = new CourseDBManager();
	
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}
	
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}
	
	

	/**
	 * Test read file method
	 */

	@Test
	void testReadFile() {
		try {
			File inputFile = new File("Test2.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Robert P. Jessup");
			inFile.print("CMSC203 30503 4 SC450 Ashley D. Jacob");
			inFile.println("CMSC110 30506 4 SC450 Mario J. Elliot");
			
			inFile.close();
			
			dataMgr.readFile(inputFile);
			
			ArrayList<String> list = dataMgr.showAll();
			
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	
	/**
	 * test show all method
	 */

	@Test
	void testShowAll() {
		
		dataMgr.add("CMSC204",21504,4,"SC450","George Lopez");
		dataMgr.add("CMSC204",21503,4,"SC450","Tyler Perry");
		dataMgr.add("CMSC207",21559,4,"SC450","Gabriel Iglesias");
		ArrayList<String> list = dataMgr.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:21503 Credits:4 Instructor:Tyler Perry Room:SC450");
		assertEquals(list.get(1),"\nCourse:CMSC204 CRN:21504 Credits:4 Instructor:George Lopez Room:SC450");
		assertEquals(list.get(2),"\nCourse:CMSC207 CRN:21559 Credits:4 Instructor:Gabriel Iglesias Room:SC450");
	}

}
