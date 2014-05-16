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
	 * pay attention KAUSHIK, this kind of test is still testing the java's
	 * component We cannot test java' things!!! Every test must include and test
	 * our methods.
	 * 
	 * @Test(expected = NGramException.class) public void setContext_Test1()
	 * throws NGramException { String[] words = { "Please", "Tell", "Me", "Your"
	 * }; assertEquals("3", words.length); }
	 * 
	 * set and get should be test together, if you set some thing, we hope we
	 * can get the same result. see below
	 */

	@Test(expected = NGramException.class)
	public void setContext_Exception1() throws NGramException {
		String[] words = { "Please", "Tell", "Me", "Your" };
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me Your", node.getContext());

		node.setContext("");
	}

	@Test
	public void setContext_Test1() throws NGramException {
		String[] words = { "Please", "Tell", "Me", "Your" };
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me Your", node.getContext());

		node.setContext("abc def");
		assertEquals("abc def", node.getContext());
		
		System.out.println(node.toString());
	}

	@Test
	public void setContext_Test2() throws NGramException {
		String context = "Please Tell Me Your";
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		assertEquals("Please Tell Me Your", node.getContext());

		String[] words = { "Please", "Tell", "Me", "Your" };
		node.setContext(words);
		assertEquals("Please Tell Me Your", node.getContext());
	}

	@Test
	public void setContext_Test3() throws NGramException {
		String context = "123";
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		assertEquals("123", node.getContext());

		String[] words = { "!@#", " ", "!@#,", "Your" };
		node.setContext(words);
		assertEquals("!@#   !@#, Your", node.getContext());
	}

	@Test
	public void setGetContext_Test4() throws NGramException {
		String context = "Please Tell Me Your";
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		assertEquals("Please Tell Me Your", node.getContext());

		String[] words = { " ", " " };
		node.setContext(words);
		assertEquals("   ", node.getContext());
	}

	@Test(expected = NGramException.class)
	public void setPredictions_Test1_Exception() throws NGramException {
		String context = "Please Tell Me Your";
		String[] predictions = null;
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}

	@Test(expected = NGramException.class)
	public void setPredictions_Test2_Exception() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}
	
	@Test(expected = NGramException.class)
	public void setPredictions_Test3_Exception() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "" ,"asd" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}
	
	@Test
	public void setPredictions_Test1() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Jack-Ass" };
		Double[] probabilities = { 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("Jack-Ass", node.getPredictions()[0]);
	}
	
	@Test
	public void setPredictions_Test2() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Smart Ass" };
		Double[] probabilities = { 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("Smart Ass", node.getPredictions()[0]);
	}


	@Test
	public void setPredictions_Test3() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Mister" };
		Double[] probabilities = { 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("Mister", node.getPredictions()[0]);
	}

	@Test
	public void setPredictions_Test4() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Mister", "Mrs" };
		Double[] probabilities = { 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("Mister", node.getPredictions()[0]);
		assertEquals("Mrs", node.getPredictions()[1]);
	}

	@Test
	public void setPredictions_Test5() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Mister", "Mrs", "Master" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("Mister", node.getPredictions()[0]);
		assertEquals("Mrs", node.getPredictions()[1]);
		assertEquals("Master", node.getPredictions()[2]);
	}

	@Test
	public void setPredictions_Test6() throws NGramException {
		String context = "Please Tell Me Your";
		String[] predictions = { "ajw25", "skjghk32", "YTBBJ58", "GFAG47" };
		Double[] probabilities = { 0.1, 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("ajw25", node.getPredictions()[0]);
		assertEquals("skjghk32", node.getPredictions()[1]);
		assertEquals("YTBBJ58", node.getPredictions()[2]);
		assertEquals("GFAG47", node.getPredictions()[3]);
	}

	@Test
	public void setPredictions_Test7() throws NGramException {
		String context = "Please Tell Me Your";
		String[] predictions = { "$^%^25", "$%$^&%32", "^&*^&58", "#$#%47" };
		Double[] probabilities = { 0.1, 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("$^%^25", node.getPredictions()[0]);
		assertEquals("$%$^&%32", node.getPredictions()[1]);
		assertEquals("^&*^&58", node.getPredictions()[2]);
		assertEquals("#$#%47", node.getPredictions()[3]);
	}

	@Test
	public void setPredictions_Test8() throws NGramException {
		String context = "Please Come And Attend";
		String[] predictions = { "$^%^&*", "$%$^&%*(=&", "^&*^&#$%",
				"$%$^&%$^", "&%^&^%&" };
		Double[] probabilities = { 0.1, 0.1, 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("$^%^&*", node.getPredictions()[0]);
		assertEquals("$%$^&%*(=&", node.getPredictions()[1]);
		assertEquals("^&*^&#$%", node.getPredictions()[2]);
		assertEquals("$%$^&%$^", node.getPredictions()[3]);
		assertEquals("&%^&^%&", node.getPredictions()[4]);

	}

	@Test
	public void setGetPredictions_Test1() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Sonny", "Hero", "Queen", "King" };
		Double[] probabilities = { 0.1, 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}
	
	@Test(expected = NGramException.class)
	public void setProbabilities_Test1_Exception() throws NGramException {
		String context = "Come And Take Your";
		String[] predictions = { "Opportunity", "Place", "Time", "Order" };
		Double[] probabilities = { 0.1, 0.1, 0.1};

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getProbabilities();
	}
	
	@Test(expected = NGramException.class)
	public void setProbabilities_Test2_Exception() throws NGramException {
		String context = "Please Go By";
		String[] predictions = { "Train", "Bus", "Car", "Walk" };
		Double[] probabilities = { null, 0.1, 0.1, 0.1};

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getProbabilities();
	}
	
	@Test(expected = NGramException.class)
	public void setProbabilities_Test3_Exception() throws NGramException {
		String context = "Please take the";
		String[] predictions = { "Sidewalk", "Ferry", "Overbridge", "Sword" };
		Double[] probabilities = { 0.1, null, 0.1, 0.1};

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getProbabilities();
	}
	
	@Test(expected = NGramException.class)
	public void setProbabilities_Test4_Exception() throws NGramException {
		String context = "Passengers are requested to";
		String[] predictions = { "Board", "Sit", "Stand", "Vacate" };
		Double[] probabilities = { 0.1, 0.1, null, 0.1};

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getProbabilities();
	}
	
	@Test(expected = NGramException.class)
	public void setProbabilities_Test5_Exception() throws NGramException {
		String context = "Could you Come To The";
		String[] predictions = { "Class", "Session", "Training", "Practice" };
		Double[] probabilities = { 0.1, 0.1, 0.1, null};

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getProbabilities();
	}
	

	@Test
	public void toString_Test1() throws NGramException {
		String[] words = { "Please", "Tell", "Me", "Your" };
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me Your", node.getContext());

		node.setContext("abc def");
		assertEquals("abc def | How : 0.10000\nabc def | Are : 0.10000\nabc def | You : 0.10000\n", node.toString());
		
	}
}
