import static org.junit.Assert.*;

import org.junit.Test;


public class SampleTest {
	
	//these notes ripped from elsewhere... sorta shitty, but you can look up what they actually mean.
//	Some important JUnit functions:
//
//		//true when strings equal
//		asertEquals(string1,string2)
//
//		//calls before every method
//		public void before() 
//
//		//calls after every method
//		public void after()
//
//		//only ones for all tests before all tests
//		public static void beforeClass()
//
//		//only ones for all tests after all tests
//		public static void afterClass()
//
//		//true when arrays are equal
//		assertArrayEquals(array1,array2)
//
//		//returns true when input true
//		assertTrue(true);
//
//		//returns true when input false
//		assertfalse(false);
//
//		//checks for the exception
//		(expected=NullPointerException.class)
//
//		//timeout checks
//		(timeout=2)
	
	@Test
	public void test() {
		if(false) {
			fail("Well, this is impossible.");
		}
		
		assertTrue(true);
	}

}
