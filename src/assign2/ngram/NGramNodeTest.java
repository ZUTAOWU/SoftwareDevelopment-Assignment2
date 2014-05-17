/**
 * 
 */
package assign2.ngram;

import static org.junit.Assert.*;

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
	 * Test NGramNode first constructor, when words have null input values,
	 * predictions and probabilities show null values and then expecting an
	 * NGramExpection as part of the code. NGramException is thrown
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
	 * values, predictions show output values and probabilities show null value
	 * and then expecting an NGramExpection as part of the code. NGramException
	 * is thrown
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
	 * Test NGramNode first constructor, when words are supplied with null
	 * values, predictions show an empty string and probabilities show null
	 * value and then expecting an NGramExpection as part of the code.
	 * NGramException is thrown
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
	 * Test NGramNode second constructor, when context has empty string value,
	 * predictions and probabilities show null values and then expecting an
	 * NGramExpection as part of the code. NGramException is thrown
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
	 * then expecting an NGramExpection as part of the code. NGramException is
	 * thrown
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
	 * value, predictions and probabilities are displayed and then
	 * NGramException is thrown
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
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when the context is set to an empty string and
	 * then expecting an NGramExpection as part of the code. NGramException is
	 * thrown
	 * 
	 * @throws NGramException
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

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setContext(java.lang.String)}. <br/>
	 * <br/>
	 * Test NGramNode method, when a context is supplied with an input and then
	 * checking whether the values of the set context of user input are correct
	 * in the node as part of the code and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void setContext_Test1() throws NGramException {
		String[] words = { "Please", "Tell", "Me", "Your" };
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(words, predictions, probabilities);

		node.setContext("Come Here");
		assertEquals("Come Here", node.getContext());

	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setContext(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when a context is supplied with an array of input
	 * words and then checking whether the values of the words in the set
	 * context of user input are correct in the node as part of the code and
	 * then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void setContext_Test2() throws NGramException {
		String context = "Please Tell Me Your";
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);

		String[] words = { "Please", "Tell", "Me", "Your" };
		node.setContext(words);
		assertEquals("Please Tell Me Your", node.getContext());
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setContext(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when a context is supplied with an array of input
	 * words, special characters and blank spaces and then checking whether the
	 * values of the words in the set context of user input are correct in the
	 * node as part of the code and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

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

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setContext(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when a context of blank spaces are supplied as
	 * words input, checking whether the spaces provided in the set context of
	 * user's input (blank spaces) are correct in the node as part of the code
	 * and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

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

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input
	 * values, checking whether the predictions show a null value in the node
	 * and then expecting an NGramExpection as part of the code. NGramException
	 * is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setPredictions_Test1_Exception() throws NGramException {
		String context = "Please Tell Me Your";
		String[] predictions = null;
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input
	 * values, checking in the beginning of the predictions whether an empty
	 * string is shown in the node and then expecting an NGramExpection as part
	 * of the code. NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setPredictions_Test2_Exception() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input
	 * values, checking if the first context of the predictions shown is null in
	 * the node and then expecting an NGramExpection as part of the code.
	 * NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setPredictions_Test3_Exception() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "", "asd" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input
	 * and checking whether the array of predictions returned as part of the
	 * code is correct and shows correctly and also matches well with that of
	 * the probabilities length in the node and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void setPredictions_Test1() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Mark Knopfler" };
		Double[] probabilities = { 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("Mark Knopfler", node.getPredictions()[0]);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input
	 * and checking whether the elements of the array of predictions returned is
	 * correct and shows correctly in the node and also matches well with that
	 * of the probabilities length as part of the code and then NGramException
	 * is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void setPredictions_Test3() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Michael Jackson", "Muhammad Ali",
				"Barack Obama" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("Michael Jackson", node.getPredictions()[0]);
		assertEquals("Muhammad Ali", node.getPredictions()[1]);
		assertEquals("Barack Obama", node.getPredictions()[2]);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input
	 * and checking whether the array of predictions returned in the node is
	 * shown correctly and also matches well with that of the probabilities
	 * length as part of the code and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void setPredictions_Test2() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Joe Elliott", "Steve Clarke",
				"Justin Bieber", "Jennifer Lopez" };
		Double[] probabilities = { 0.1, 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.setPredictions(predictions);
		assertEquals("Jennifer Lopez", node.getPredictions()[3]);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input,
	 * checking whether the array of predictions returned in the node shows
	 * alphanumeric characters in both upper and lower case letters and also
	 * matches well with that of the probabilities length as part of the code
	 * and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

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

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input,
	 * checking whether the array of predictions returned in the node shows a
	 * combination of special and numeric characters and also matches well with
	 * that of the probabilities length as part of the code and then
	 * NGramException is thrown
	 * 
	 * @throws NGramException
	 */

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

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input,
	 * checking whether the array of predictions returned in the node shows
	 * special characters and also matches well with that of the probabilities
	 * length as part of the code and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

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

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when the predictions displayed for the below
	 * scenario of user input show a null value in the beginning in the node and
	 * then expecting an NGramExpection as part of the code. NGramException is
	 * thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setGetPredictions_Test1() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { null, "Victor", "Gladiator", "Fighter" };
		Double[] probabilities = { 0.1, 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when the predictions displayed for the below
	 * scenario of user input show a null value in the second place in the node
	 * and then expecting an NGramExpection as part of the code. NGramException
	 * is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setGetPredictions_Test2() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Champion", null, "Gladiator", "Fighter" };
		Double[] probabilities = { 0.1, 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when the predictions displayed for the below
	 * scenario of user input show a null value in the third place in the node
	 * and then expecting an NGramExpection as part of the code. NGramException
	 * is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setGetPredictions_Test3() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Champion", "Victor", null, "Fighter" };
		Double[] probabilities = { 0.1, 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when the predictions displayed for the below
	 * scenario of user input show a null value in the last place in the node
	 * and then expecting an NGramExpection as part of the code. NGramException
	 * is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setGetPredictions_Test4() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "Champion", "Victor", "Gladiator", null };
		Double[] probabilities = { 0.1, 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#getPredictions(java.lang.String[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input,
	 * checking whether the array of predictions returned is exact and correct
	 * in the node and also matches well with that of the probabilities length
	 * as part of the code and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void setGetPredictions_Test5() throws NGramException {
		String context = "Hello How Are You";
		String[] predictions = { "my", "his", "her", "kid" };
		Double[] probabilities = { 0.378573, 0.987097, 0.809484, 0.686995 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getPredictions();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setProbabilities(java.lang.Double[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input,
	 * checking whether the array of probabilities returned for the predictions
	 * is exact and correct in the node and also matches well with that of the
	 * probabilities length as part of the code and then NGramException is
	 * thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setProbabilities_Test1_Exception() throws NGramException {
		String context = "Come And Take Your";
		String[] predictions = { "Opportunity", "Place", "Time", "Order" };
		Double[] probabilities = { 0.198395, 0.290803, 0.375935 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getProbabilities();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setProbabilities(java.lang.Double[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input
	 * values, checking whether the initial entry in the double probability
	 * array shows a null value in the node and then expecting an NGramExpection
	 * as part of the code. NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setProbabilities_Test2_Exception() throws NGramException {
		String context = "Please Go By";
		String[] predictions = { "Train", "Bus", "Car", "Walk" };
		Double[] probabilities = { null, 0.671421, 0.935938, 0.898502 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getProbabilities();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setProbabilities(java.lang.Double[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input
	 * values, checking whether the second entry in the double probability array
	 * shows a null value in the node and then expecting an NGramExpection as
	 * part of the code. NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setProbabilities_Test3_Exception() throws NGramException {
		String context = "Please take the";
		String[] predictions = { "Sidewalk", "Ferry", "Overbridge", "Sword" };
		Double[] probabilities = { 0.358383, null, 0.685903, 0.898636 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getProbabilities();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setProbabilities(java.lang.Double[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input
	 * values, checking whether the third entry in the double probability array
	 * shows a null value in the node and then expecting an NGramExpection as
	 * part of the code. NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setProbabilities_Test4_Exception() throws NGramException {
		String context = "Passengers are requested to";
		String[] predictions = { "Board", "Sit", "Stand", "Vacate" };
		Double[] probabilities = { 0.976903, 0.605597, null, 0.574685 };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getProbabilities();
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramNode#setProbabilities(java.lang.Double[])}. <br/>
	 * <br/>
	 * Test NGramNode method, when predictions are displayed for the user input
	 * values, checking whether the last entry in the double probability array
	 * shows a null value in the node and then expecting an NGramExpection as
	 * part of the code. NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void setProbabilities_Test5_Exception() throws NGramException {
		String context = "Could you Come To The";
		String[] predictions = { "Class", "Session", "Training", "Practice" };
		Double[] probabilities = { 0.759486, 0.950593, 0.599604, null };

		NGramNode node = new NGramNode(context, predictions, probabilities);
		node.getProbabilities();
	}

	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, checking as
	 * part of the code whether the string buffer value returned is exact and
	 * correct in the node and also matches well with the number and length of
	 * the probabilities and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void toString_Test1() throws NGramException {
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "about", "now", "urgently" };
		Double[] probabilities = { 0.385354, 0.953905, 0.359035 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me", node.getContext());

		node.setContext("Kindly Inform Him");
		assertEquals(
				"Kindly Inform Him | about : 0.385354\nKindly Inform Him | now : 0.953905\nKindly Inform Him | urgently : 0.359035\n",
				node.toString());

	}

	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the first
	 * probability is 0.736578 mismatching with the below string buffer
	 * operation's probability 0.385354. So, assertNotEquals is used and checking
	 * as part of the code whether the string buffer returned is exact and
	 * correct in the node and also matches well with the number and length of
	 * the probabilities and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void toString_Test2() throws NGramException {
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "about", "now", "urgently" };
		Double[] probabilities = { 0.736578, 0.953905, 0.359035 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		node.setContext("Kindly Inform Him");
		@SuppressWarnings("unused")
		String outputNodeValue = node.toString();
		outputNodeValue = "Kindly Inform Him | about : 0.385354\nKindly Inform Him | now : 0.953905\nKindly Inform Him | urgently : 0.359035\n";
		assertNotEquals(
				"Kindly Inform Him | about : 0.385354\nKindly Inform Him | now : 0.953905\nKindly Inform Him | urgently : 0.359035\n",
				node.toString());
	}

	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the
	 * second probability is 0.679879 mismatching with the below string buffer
	 * operation's probability 0.953905. So, assertNotEquals is used and checking
	 * as part of the code whether the string buffer returned is exact and
	 * correct in the node and also matches well with the number and length of
	 * the probabilities and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void toString_Test3() throws NGramException {
		String[] words = { "Kindly", "Inform", "Us" };
		String[] predictions = { "honestly", "sincerely", "exactly" };
		Double[] probabilities = { 0.736578, 0.679879, 0.359035 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		node.setContext("Passengers are requested to");
		@SuppressWarnings("unused")
		String outputNodeValue = node.toString();
		outputNodeValue = "Passengers are requested to | honestly : 0.736578\nPassengers are requested to | sincerely : 0.953905\nPassengers are requested to | exactly : 0.359035\n";
		assertNotEquals(
				"Passengers are requested to | honestly : 0.736578\nPassengers are requested to | sincerely : 0.953905\nPassengers are requested to | exactly : 0.359035\n",
				node.toString());
	}
	
	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the
	 * second probability is 0.359035 mismatching with the below string buffer
	 * operation's probability 0.583588. So, assertNotEquals is used and checking
	 * as part of the code whether the string buffer returned is exact and
	 * correct in the node and also matches well with the number and length of
	 * the probabilities and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void toString_Test4() throws NGramException {
		String[] words = { "People", "Are", "Told" };
		String[] predictions = { "regarding", "gently", "everything" };
		Double[] probabilities = { 0.736578, 0.679879, 0.359035 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		node.setContext("Gentlemen are Informed");
		@SuppressWarnings("unused")
		String outputNodeValue = node.toString();
		outputNodeValue = "Gentlemen are Informed | regarding : 0.736578\nGentlemen are Informed | gently : 0.679879\nGentlemen are Informed | everything : 0.583588\n";
		assertNotEquals(
				"Gentlemen are Informed | regarding : 0.736578\nGentlemen are Informed | gently : 0.679879\nGentlemen are Informed | everything : 0.583588\n",
				node.toString());
	}


}
