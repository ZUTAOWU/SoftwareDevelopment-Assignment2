/**
 * 
 */
package assign2.ngram;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import assign2.ngram.NGramNode;
import assign2.ngram.NGramException;

/**
 * @author kaushik.muthukrishnan.simili
 * 
 */
public class NGramNodeTest {

	@BeforeClass
	public static void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {

	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#NGramNode(java.lang.String[], java.lang.String[], java.lang.Double[])}
	 * . <br/>
	 * <br/>
	 * Test NGramNode first constructor, when words, predictions and
	 * probabilities show null value and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void Test_Constructor1_Exception1() throws NGramException {
		String[] words = null;
		String[] predictions = null;
		Double[] probabilities = null;
		@SuppressWarnings("unused")
		// Doubt to be asked
		NGramNode node = new NGramNode(words, predictions, probabilities);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#NGramNode(java.lang.String[], java.lang.String[], java.lang.Double[])}
	 * . <br/>
	 * <br/>
	 * Test NGramNode first constructor, when words are supplied with input
	 * values, predictions are displayed and probabilities show null value and
	 * then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void Test_Constructor1_Exception2() throws NGramException {
		String[] words = { "Please", "Let", "Me", "Know" };
		String[] predictions = { "Your", "Name" };
		Double[] probabilities = null;
		@SuppressWarnings("unused")
		NGramNode node = new NGramNode(words, predictions, probabilities);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#NGramNode(java.lang.String[], java.lang.String[], java.lang.Double[])}
	 * . <br/>
	 * <br/>
	 * Test NGramNode first constructor, when words are supplied with input
	 * values, predictions has no input value and probabilities show null value
	 * and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void Test_Constructor1_Exception3() throws NGramException {
		String[] words = null;
		String[] predictions = { "" };
		Double[] probabilities = null;
		@SuppressWarnings("unused")
		NGramNode node = new NGramNode(words, predictions, probabilities);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#NGramNode(java.lang.String[], java.lang.String[], java.lang.Double[])}
	 * . <br/>
	 * <br/>
	 * Test NGramNode second constructor, when context has no input values
	 * supplied, predictions show null value and probabilities show null value
	 * and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void Test_Constructor2_Exception1() throws NGramException {
		String context = "";
		String[] predictions = null;
		Double[] probabilities = null;
		@SuppressWarnings("unused")
		NGramNode node = new NGramNode(context, predictions, probabilities);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#NGramNode(java.lang.String[], java.lang.String[], java.lang.Double[])}
	 * . <br/>
	 * <br/>
	 * Test NGramNode second constructor, when context is supplied with an input
	 * value, predictions are displayed and probabilities show null value and
	 * then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void Test_Constructor2_Exception2() throws NGramException {
		String context = "test";
		String[] predictions = { "case", "result" };
		Double[] probabilities = null;
		@SuppressWarnings("unused")
		NGramNode node = new NGramNode(context, predictions, probabilities);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#NGramNode(java.lang.String[], java.lang.String[], java.lang.Double[])}
	 * . <br/>
	 * <br/>
	 * Test NGramNode second constructor, when context is supplied with an input
	 * value, predictions are displayed and probabilities also are displayed and
	 * then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void Test_Constructor2_Exception3() throws NGramException {
		String context = "Hello";
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.291898409, 0.229299928 };
		@SuppressWarnings("unused")
		NGramNode node = new NGramNode(context, predictions, probabilities);

	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#NGramNode(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when words are supplied with an array of input
	 * values and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */
	
	/*
	 	pay attention KAUSHIK, this kind of test is still testing the java's component
	 	We cannot test java' things!!!
	 	Every test must include and test our methods.
	 	
	 	@Test(expected = NGramException.class)
		public void setContext_Test1() throws NGramException {
			String[] words = { "Please", "Tell", "Me", "Your" };
			assertEquals("3", words.length);
		}
		
		set and get should be test together, if you set some thing, we hope we can get the same result.
	 */
	@Test
	public void setContext_Test1() throws NGramException {
		String[] words = { "Please", "Tell", "Me", "Your" };
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		
		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me Your", node.getContext());
	}
	
	@Test
	public void setContext_Test2() throws NGramException {
		String context = "Please Tell Me Your";
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		
		NGramNode node = new NGramNode(context, predictions, probabilities);
		assertEquals("Please Tell Me Your", node.getContext());
	}

}
