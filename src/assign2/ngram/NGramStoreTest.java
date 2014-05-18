/**
 * 
 */
package assign2.ngram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author kaushik.muthukrishnan.simili
 * 
 */
public class NGramStoreTest {
	
	@BeforeClass
	public static void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {

	}
	
	/*@Test(expected = NGramException.class)
	public void Test_addNGram_Test1() throws NGramException {
		NGramStore store = new NGramStore();
		String context = null;
		String[] predictions = { "People", "Are", "Requested" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		
		NGramNode node2 = (NGramNode) store.getNGram(null);
		assertEquals(null, node2.getContext());

	}
	
	@Test(expected = NGramException.class)
	public void Test_addNGram_Test2() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "";
		String[] predictions = { "Fill", "Petrol" };
		Double[] probabilities = { 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		
		NGramNode node2 = (NGramNode) store.getNGram("");
		assertEquals("", node2.getContext());

	}*/

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#addNGram(assign2.ngram.NGramContainer)} . <br/>
	 * <br/>
	 * Test NGramStore's method, where value of context and ngram are input as null and
	 * then NGramException is thrown
	 * 
	 * 
	 * @throws NGramException
	 */
	
	@Test
	public void Test_addNGram_Test3() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "Come Here And Deposit Your";
		String[] predictions = { "Cash", "Valuables", "Belongings" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		
		NGramNode node2 = (NGramNode) store.getNGram("Come Here And Deposit Your");
		assertEquals("Come Here And Deposit Your", node2.getContext());

	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#removeNGram(java.lang.String)} . <br/>
	 * <br/>
	 * Test NGramStore's method, where context is input with no value and ngram is input as null and then
	 * NGramException is thrown
	 * 
	 * 
	 * @throws NGramException
	 */

	@Test
	public void Test_removeNGram1() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "Please Tell Us";
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		store.removeNGram(context);
		NGramNode node2 = (NGramNode) store.getNGram("Please Tell Us");
		assertNull(node2);

	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#removeNGram(java.lang.String)} . <br/>
	 * <br/>
	 * Test NGramStore's method, where context is input with a value and ngram is input as null and then
	 * NGramException is thrown
	 * 
	 * 
	 * @throws NGramException
	 */

	@Test
	public void Test_removeNGram2() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "Hello";
		String[] predictions = { "Mister", "Mrs", "Master" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		store.removeNGram(context);
		NGramNode node2 = (NGramNode) store.getNGram("Hello");
		assertNull(node2);

	}


	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#removeNGram(java.lang.String)} . <br/>
	 * <br/>
	 * Test NGramStore's method, where value of context is input as null and
	 * then NGramException is thrown
	 * 
	 * 
	 * @throws NGramException
	 */

	@Test
	public void Test_removeNGram3() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "The Hall Is Filled in With";
		String[] predictions = { "Fans", "Pamphlets", "Brochures" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		store.removeNGram(context);
		NGramNode node2 = (NGramNode) store.getNGram("The Hall Is Filled in With");
		assertNull(node2);

	}
	
	@Test
	public void Test_removeNGram4() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "The Hall Is Filled-In With";
		String[] predictions = { "Fans", "Pamphlets", "Brochures" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		store.removeNGram(context);
		NGramNode node2 = (NGramNode) store.getNGram("The Hall Is Filled-In With");
		assertNull(node2);

	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#getNGramsFromService(java.lang.String)} . <br/>
	 * <br/>
	 * Test NGramStore's method, where context value is supplied and the
	 * corresponding context is also removed and then NGramException is thrown
	 * 
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void Test_getNGramsFromService_Exception1() throws NGramException {
		
		

	}
	

	@Test
	public void toString_Test1() throws NGramException {
		String[] words = { "Please", "Tell", "Me", "Your" };
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me Your", node.getContext());

		NGramStore store = new NGramStore();
		store.addNGram(node);
		
		// the format #.###### means show Digit, zero shows as absent. so 0.1 cannot be show as 0.100000
		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me Your | How : 0.1\nPlease Tell Me Your | Are : 0.1\nPlease Tell Me Your | You : 0.1\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());
		
	}
	
	@Test
	public void toString_Test2() throws NGramException {
		NGramStore store = new NGramStore();
		String[] words = { "Please", "Tell", "Me"};
		String[] predictions = { "How", "Now", "This" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		
		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me", node.getContext());

		NGramNode node2 = new NGramNode(words, predictions, probabilities);
		node2.setContext("Come Here Once");
		node2.setPredictions(new String[]{ "a", "in", "more", "or"});
		
		store.addNGram(node);
		store.addNGram(node2);
		
		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me | How : 0.100000\nPlease Tell Me | Now : 0.100000\nPlease Tell Me | This : 0.100000\n");
		sb.append("\n");
		sb.append("Come Here Once | Once : 0.100000\nCome Here Once | Again : 0.100000\nCome Here Once | Fast : 0.100000\n");
		assertEquals(sb.toString(), store.toString());
		
	}
}
