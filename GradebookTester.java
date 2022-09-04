import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class GradebookTester {
		private GradeBook book1; 
		private GradeBook book2;
	@BeforeEach
	void setUp() throws Exception {
		book1 = new GradeBook(5);
		book1.addScore(61);
		book1.addScore(22);
		
		book2 = new GradeBook(5);
		book2.addScore(96);
		book2.addScore(1);
		book2.addScore(24);
		book2.addScore(78);
	}

	@AfterEach
	void tearDown() throws Exception {
		book1 = book2 = null;
	}

	@Test
	void testAddScore() {
		
		//Book 1 tests
		String str = book1.toString();
		assertTrue(str.equals("61.0 22.0 ")); 
		assertEquals(2, book1.getScoreSize());
		
		//Book 2 tests
		String str2 = book2.toString();
		assertTrue(str2.equals("96.0 1.0 24.0 78.0 ")); 
		assertEquals(4, book2.getScoreSize());
		
	}

	@Test
	void testSum() {
		assertEquals(83, book1.sum(), .0001);
		assertEquals(199, book2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(22, book1.minimum(), .0001);
		assertEquals(1, book2.minimum(), .0001);
	}

	@Test
	void testFinalScore() {
		assertEquals(61, book1.finalScore(), .0001);
		assertEquals(198, book2.finalScore(), .0001);
	}

	@Test
	void testGetScoreSize() {
		/*	document did not say to implement this test 
			& this is indirectly tested indirectly tested in the test
			for the addScore method
		*/
	}

	@Test
	void testToString() {
		/*	document did not say to implement this test 
		& this is indirectly tested indirectly tested in the test
		for the addScore method
		 */	
	}

}
