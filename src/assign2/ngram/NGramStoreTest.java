/**
 * 
 */
package assign2.ngram;

import static org.junit.Assert.*;

import java.util.Arrays;

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
	
	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#addNGram(assign2.ngram.NGramContainer)}
	 * <br/>
	 * <br/>
	 * {@link assign2.ngram.NGramStore#getNGram(java.lang.String)}
	 * <br/>
	 * <br/>
	 * Test NGramStore's method, where value of context is the same for two user
	 * input scenarios and the node displays the results for the latest entry
	 * and then NGramException is thrown
	 * 
	 * */
	@Test
	public void Test_addNGram_getNGram_Test1() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "I'am going to";
		String[] predictions = { "KG", "GP", "City" };
		Double[] probabilities = { 0.000000000001, 0.00000000001, 0.000000000000001 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		NGramNode nodeGet = (NGramNode) store.getNGram("I'am going to");
		assertEquals(node.toString(), nodeGet.toString());
		assertTrue(Arrays.equals(nodeGet.getPredictions(), node.getPredictions()));
		assertTrue(Arrays.equals(nodeGet.getProbabilities(), node.getProbabilities()));

		String context2 = "You're not getting it";
		String[] predictions2 = { "Sonny", "Brother", "Pal" };
		Double[] probabilities2 = { 1.00000000000, 1.0000000000000, 1.0000000000000};

		NGramNode node2 = new NGramNode(context2, predictions2, probabilities2);
		store.addNGram(node2);
		NGramNode nodeGet2 = (NGramNode) store.getNGram("You're not getting it");
		
		assertEquals(node2.toString(), nodeGet2.toString());
		assertTrue(Arrays.equals(nodeGet2.getPredictions(), node2.getPredictions()));
		assertTrue(Arrays.equals(nodeGet2.getProbabilities(), node2.getProbabilities()));
	}
	
	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#addNGram(assign2.ngram.NGramContainer)}
	 * <br/>
	 * <br/>
	 * {@link assign2.ngram.NGramStore#getNGram(java.lang.String)}
	 * <br/>
	 * <br/>
	 * Test NGramStore's method, where value of context is the same for two user
	 * input scenarios and the node displays the results for the latest entry
	 * and then NGramException is thrown
	 * 
	 * */
	@Test
	public void Test_addNGram_getNGram_Test2() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "I'am going to";
		String[] predictions = { "KG", "GP", "City" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		NGramNode nodeGet = (NGramNode) store.getNGram("I'am going to");
		assertEquals(node.toString(), nodeGet.toString());

		String context2 = "You're not getting it";
		String[] predictions2 = { "Sonny", "Brother", "Pal" };
		Double[] probabilities2 = { 0.1, 0.1, 0.1 };

		NGramNode node2 = new NGramNode(context2, predictions2, probabilities2);
		store.addNGram(node2);
		NGramNode nodeGet2 = (NGramNode) store.getNGram("You're not getting it");
		assertEquals(node2.toString(), nodeGet2.toString());

		StringBuffer sb = new StringBuffer();
		sb.append("I'am going to | KG : 0.1\nI'am going to | GP : 0.1\nI'am going to | City : 0.1\n");
		sb.append("\n");
		sb.append("You're not getting it | Sonny : 0.1\nYou're not getting it | Brother : 0.1\nYou're not getting it | Pal : 0.1\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#addNGram(assign2.ngram.NGramContainer)}
	 * <br/>
	 * <br/>
	 * {@link assign2.ngram.NGramStore#getNGram(java.lang.String)}
	 * <br/>
	 * <br/>
	 * Test NGramStore's method, where value of context is the same for two user
	 * input scenarios and the node displays the results for the latest entry
	 * and then NGramException is thrown
	 */

	@Test
	public void Test_addNGram_getNGram_Test3() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "Come Here And Deposit Your";
		String[] predictions = { "Cash", "Valuables", "Belongings" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);

		String context2 = "Come Here And Deposit Your";
		String[] predictions2 = { "Cash1", "Valuables1", "Belongings1" };
		Double[] probabilities2 = { 0.11, 0.11, 0.11 };
		NGramNode node2 = new NGramNode(context2, predictions2, probabilities2);

		store.addNGram(node);
		store.addNGram(node2);
		NGramNode nodeGet = (NGramNode) store.getNGram("Come Here And Deposit Your");
		assertEquals(nodeGet.toString(), node2.toString());
		assertNotEquals(nodeGet.toString(), node.toString());
		
		assertTrue(Arrays.equals(nodeGet.getPredictions(), predictions2));
		assertTrue(Arrays.equals(nodeGet.getProbabilities(), probabilities2));

	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#addNGram(assign2.ngram.NGramContainer)} . <br/>
	 * <br/>
	 * Test NGramStore's method, where value of context and ngram are input as
	 * null and then NGramException is thrown
	 * @throws NGramException
	 */
	@Test
	public void Test_addNGram_getNGram_Test4() throws NGramException {
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
	 * {@link assign2.ngram.NGramStore#addNGram(assign2.ngram.NGramContainer)}
	 * <br/>
	 * <br/>
	 * {@link assign2.ngram.NGramStore#getNGram(java.lang.String)}
	 * <br/>
	 * <br/>
	 * Test NGramStore's method, where value of context is the same for two user
	 * input scenarios and the node displays the results for the latest entry
	 * and then NGramException is thrown
	 * 
	 * */
	@Test
	public void Test_addNGram_getNGram_Test5() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "I'am going to";
		String[] predictions = { "KG", "GP", "City" };
		Double[] probabilities = { 0.000000000001, 0.00000000001, 0.000000000000001 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		NGramNode nodeGet = (NGramNode) store.getNGram("I'am going to");
		assertEquals(node.toString(), nodeGet.toString());
		assertTrue(Arrays.equals(nodeGet.getPredictions(), node.getPredictions()));
		assertTrue(Arrays.equals(nodeGet.getProbabilities(), node.getProbabilities()));

		String context2 = "I'am going to";
		String[] predictions2 = { "Sonny", "Brother", "Pal" };
		Double[] probabilities2 = { 1.00000000000, 1.0000000000000, 1.0000000000000};

		NGramNode node2 = new NGramNode(context2, predictions2, probabilities2);
		store.addNGram(node2);
		NGramNode nodeGet2 = (NGramNode) store.getNGram("I'am going to");
		
		assertEquals(node2.toString(), nodeGet2.toString());
		assertTrue(Arrays.equals(nodeGet2.getPredictions(), node2.getPredictions()));
		assertTrue(Arrays.equals(nodeGet2.getProbabilities(), node2.getProbabilities()));
		
		assertNotEquals(node.toString(), nodeGet2.toString());
		assertFalse(Arrays.equals(nodeGet2.getPredictions(), node.getPredictions()));
		assertFalse(Arrays.equals(nodeGet2.getProbabilities(), node.getProbabilities()));
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#removeNGram(java.lang.String)} . <br/>
	 * <br/>
	 * @throws NGramException
	 */
	@Test
	public void Test_removeNGram1() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "The Hall Is Filled-In With";
		String[] predictions = { "Fans", "Pamphlets", "Brochures" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		
		String context2 = "The Hall Is Filled-In With";
		String[] predictions2 = { "Fans", "Pamphlets", "Brochures" };
		Double[] probabilities2 = { 0.1, 0.1, 0.1 };
		NGramNode node2 = new NGramNode(context2, predictions2, probabilities2);
		
		store.addNGram(node);
		store.addNGram(node2);
		store.removeNGram(context);
		NGramNode nodeget = (NGramNode) store.getNGram("The Hall Is Filled-In With");
		assertNull(nodeget);

	} 
	
	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#removeNGram(java.lang.String)} . <br/>
	 * <br/>
	 * @throws NGramException
	 */
	@Test
	public void Test_removeNGram2() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "Please Tell Us";
		String[] predictions = { "How", "Are", "You" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		store.addNGram(node);
		
		NGramNode node2 = (NGramNode)store.getNGram(context);
		assertEquals(node2.getContext(), context);
		assertTrue(Arrays.equals(node2.getPredictions(), predictions));
		assertTrue(Arrays.equals(node2.getProbabilities(), probabilities));
		store.removeNGram(context);
		node2 = (NGramNode)store.getNGram(context);
		assertNull(node2);
	} 

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#removeNGram(java.lang.String)} . <br/>
	 * <br/>
	 * Test NGramStore's method, where context is input with no value and ngram
	 * is input as null and then NGramException is thrown
	 * 
	 * 
	 * @throws NGramException
	 */

	@Test
	public void Test_removeNGram3() throws NGramException {
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
	 * Test NGramStore's method, where context is input with a value and ngram
	 * is input as null and then NGramException is thrown
	 * @throws NGramException
	 */

	@Test
	public void Test_removeNGram4() throws NGramException {
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
	public void Test_removeNGram5() throws NGramException {
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
	public void Test_removeNGram6() throws NGramException {
		NGramStore store = new NGramStore();
		String context = "The Hall Is Filled-In With";
		String[] predictions = { "Fans", "Pamphlets", "Brochures" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };
		NGramNode node = new NGramNode(context, predictions, probabilities);
		
		String context2 = "The Hall Is Filled-In With";
		String[] predictions2 = { "Fans1", "Pamphlets1", "Brochures1" };
		Double[] probabilities2 = { 0.11, 0.1, 0.1 };
		NGramNode node2 = new NGramNode(context2, predictions2, probabilities2);
		
		store.addNGram(node);
		store.addNGram(node2);
		store.removeNGram(context);
		NGramNode nodeget = (NGramNode) store.getNGram("The Hall Is Filled-In With");
		assertNull(nodeget);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#getNGramsFromService(java.lang.String)} . <br/>
	 * <br/>
	 * NGramException test
	 * @throws NGramException
	 */
	@Test(expected = NGramException.class)
	public void Test_getNGramsFromService_Exception1() throws NGramException {
		NGramStore store = new NGramStore();
		store.getNGramsFromService("", 1);
	}
	
	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#getNGramsFromService(java.lang.String)} . <br/>
	 * <br/>
	 * NGramException test
	 * @throws NGramException
	 */
	@Test(expected = NGramException.class)
	public void Test_getNGramsFromService_Exception2() throws NGramException {
		NGramStore store = new NGramStore();
		store.getNGramsFromService("asd", -1);
	}
	
	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#getNGramsFromService(java.lang.String)} . <br/>
	 * <br/>
	 * NGramException test
	 * @throws NGramException
	 */
	@Test(expected = NGramException.class)
	public void Test_getNGramsFromService_Exception3() throws NGramException {
		NGramStore store = new NGramStore();
		store.getNGramsFromService(null, 1);
	}
	
	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#getNGramsFromService(java.lang.String)} . <br/>
	 * <br/>
	 * 
	 * @throws NGramException
	 */
	@Test
	public void Test_getNGramsFromService1() throws NGramException {
		NGramStore store = new NGramStore();
		store.getNGramsFromService("test", 1);
		assertNotNull(store.getNGram("test"));
		assertNotNull(store.toString());
		assertNotEquals(store.toString(), "");
	}
	
	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#getNGramsFromService(java.lang.String)} . <br/>
	 * <br/>
	 * 
	 * @throws NGramException
	 */
	@Test
	public void Test_getNGramsFromService2() throws NGramException {
		NGramStore store = new NGramStore();
		store.getNGramsFromService("test", 1);
		store.getNGramsFromService("asd", 1);
		NGramNode node = (NGramNode)store.getNGram("test");
		NGramNode node2 = (NGramNode)store.getNGram("asd");
		assertNotNull(node);
		assertNotNull(node2);
		assertNotNull(store.toString());
		assertNotEquals(store.toString(), "");
		assertNotNull(node.toString());
		assertNotEquals(node.toString(), "");
		assertNotNull(node2.toString());
		assertNotEquals(node2.toString(), "");
	}
	
	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#getNGramsFromService(java.lang.String)} . <br/>
	 * <br/>
	 * @throws NGramException
	 */
	@Test
	public void Test_getNGramsFromService3() throws NGramException {
		NGramStore store = new NGramStore();
		store.getNGramsFromService("I'am", 5);
		store.getNGramsFromService("I'am a", 5);
		store.getNGramsFromService("a b c", 1);
		store.getNGramsFromService("A B C", 1);
		store.getNGramsFromService("To be or not", 5);
		store.getNGramsFromService("1234", 5);
		store.getNGramsFromService("ABCDE", 5);
		store.getNGramsFromService("ABC123", 5);
		NGramNode node = (NGramNode)store.getNGram("I'am");
		NGramNode node2 = (NGramNode)store.getNGram("I'am a");
		NGramNode node3 = (NGramNode)store.getNGram("a b c");
		NGramNode node4 = (NGramNode)store.getNGram("A B C");
		NGramNode node5 = (NGramNode)store.getNGram("To be or not");
		NGramNode node6 = (NGramNode)store.getNGram("1234");
		NGramNode node7 = (NGramNode)store.getNGram("ABCDE");
		NGramNode node8 = (NGramNode)store.getNGram("ABC123");
		assertNotNull(node);
		assertNotNull(node2);
		assertNotNull(node3);
		assertNotNull(node4);
		assertNotNull(node5);
		assertNotNull(node6);
		assertNotNull(node7);
		assertNotNull(node8);
		assertNotNull(store.toString());
		assertNotEquals(store.toString(), "");
		assertNotNull(node.toString());
		assertNotEquals(node.toString(), "");
		assertNotNull(node2.toString());
		assertNotEquals(node2.toString(), "");
		assertNotNull(node3.toString());
		assertNotEquals(node3.toString(), "");
		assertNotNull(node4.toString());
		assertNotEquals(node4.toString(), "");
		assertNotNull(node5.toString());
		assertNotEquals(node5.toString(), "");
		assertNotNull(node6.toString());
		assertNotEquals(node6.toString(), "");
		assertNotNull(node7.toString());
		assertNotEquals(node7.toString(), "");
		assertNotNull(node8.toString());
		assertNotEquals(node8.toString(), "");
	}
	
	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#getNGramsFromService(java.lang.String)} . <br/>
	 * <br/>
	 * @throws NGramException
	 */
	@Test
	public void Test_getNGramsFromService4() throws NGramException {
		NGramStore store = new NGramStore();
		store.getNGramsFromService("kjasfhkjsafhsakjd", 1);
		store.getNGramsFromService("12354364573455134455642", 1);
		store.getNGramsFromService("ASDKASDJSASARWQREWQR", 1);
		store.getNGramsFromService("1321209JH123UJIO", 1);
		assertNull(store.getNGram("kjasfhkjsafhsakjd"));
		assertNull(store.getNGram("12354364573455134455642"));
		assertNull(store.getNGram("ASDKASDJSASARWQREWQR"));
		assertNull(store.getNGram("1321209JH123UJIO"));
		assertEquals(store.toString(), "");
	}
	
	@Test
	public void toString_Test1() throws NGramException {
		String[] words = { "Please", "Tell", "Me", "Your" };
		String[] predictions = { "Name", "Age", "Address" };
		Double[] probabilities = { 0.875895, 0.793874, 0.538658 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me Your", node.getContext());

		NGramStore store = new NGramStore();
		store.addNGram(node);

		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me Your | Name : 0.875895\nPlease Tell Me Your | Age : 0.793874\nPlease Tell Me Your | Address : 0.538658\n");
		sb.append("\n");

		assertEquals(sb.toString(), store.toString());

	}

	@Test
	public void toString_Test2() throws NGramException {
		NGramStore store = new NGramStore();
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "How", "Now", "This" };
		Double[] probabilities = { 0.658759, 0.357957, 0.938903 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me", node.getContext());
		store.addNGram(node);

		NGramNode node2 = new NGramNode(words, predictions, probabilities);
		node2.setContext("Come Here Once");
		node2.setPredictions(new String[] { "And", "To", "For" });
		node2.setProbabilities(new Double[] { 0.588589, 0.498599, 0.298408 });
		// store.addNGram(node2);

		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me | How : 0.658759\nPlease Tell Me | Now : 0.357957\nPlease Tell Me | This : 0.938903\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());

	}

	/**
	 * Test method : {@link assign2.ngram.NGramStore#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, checking as
	 * part of the code whether the string buffer value returned is exact and
	 * correct in the store and also matches well with the number and length of
	 * the probabilities and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void toString_Test3() throws NGramException {
		String[] words = { "Come", "Here", "Once" };
		String[] predictions = { "And", "To", "For" };
		Double[] probabilities = { 0.385354, 0.953905, 0.359035 };
		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Come Here Once", node.getContext());
		NGramStore store = new NGramStore();
		store.addNGram(node);
		StringBuffer sb = new StringBuffer();
		sb.append("Come Here Once | And : 0.385354\nCome Here Once | To : 0.953905\nCome Here Once | For : 0.359035\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());

	}

	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the first
	 * probability is 0.758959 mismatching with the below string buffer
	 * operation's probability 0.736578. So, assertNotEquals is used and
	 * checking as part of the code whether the string buffer returned is exact
	 * and correct in the store and also matches well with the number and length
	 * of the probabilities and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void toString_Test4() throws NGramException {
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "about", "now", "urgently" };
		Double[] probabilities = { 0.758959, 0.953905, 0.875876 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		node.setContext("Kindly Inform Him");

		NGramStore store = new NGramStore();
		store.addNGram(node);

		StringBuffer sb = new StringBuffer();

		sb.append("Kindly Inform Him | about : 0.736578\nKindly Inform Him | now : 0.953905\nKindly Inform Him | urgently : 0.875876\n");
		sb.append("\n");

		assertNotEquals(sb.toString(), store.toString());
	}

	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the
	 * second probability is 0.679879 mismatching with the below string buffer
	 * operation's probability 0.953905. So, assertNotEquals is used and
	 * checking as part of the code whether the string buffer returned is exact
	 * and correct in the store and also matches well with the number and length
	 * of the probabilities and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void toString_Test5() throws NGramException {
		String[] words = { "Kindly", "Inform", "Us" };
		String[] predictions = { "honestly", "sincerely", "exactly" };
		Double[] probabilities = { 0.736578, 0.679879, 0.359035 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		node.setContext("Passengers are requested to");

		NGramStore store = new NGramStore();
		store.addNGram(node);

		StringBuffer sb = new StringBuffer();

		sb.append("Passengers are requested to | honestly : 0.736578\nPassengers are requested to | sincerely : 0.953905\nPassengers are requested to | exactly : 0.359035\n");
		sb.append("\n");

		assertNotEquals(sb.toString(), store.toString());
	}

	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the third
	 * probability is 0.359035 mismatching with the below string buffer
	 * operation's probability 0.583588. So, assertNotEquals is used and
	 * checking as part of the code whether the string buffer returned is exact
	 * and correct in the store and also matches well with the number and length
	 * of the probabilities and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */

	@Test
	public void toString_Test6() throws NGramException {
		String[] words = { "People", "Are", "Told" };
		String[] predictions = { "regarding", "gently", "everything" };
		Double[] probabilities = { 0.736578, 0.679879, 0.359035 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		node.setContext("Gentlemen are Informed");

		NGramStore store = new NGramStore();
		store.addNGram(node);

		StringBuffer sb = new StringBuffer();

		sb.append("Gentlemen are Informed | regarding : 0.736578\nGentlemen are Informed | gently : 0.679879\nGentlemen are Informed | everything : 0.583588\n");
		assertNotEquals(sb.toString(), store.toString());
	}

	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the
	 * outputNodeValue i.e., node.toString() is mismatching with its correct
	 * value of string buffer operation. So, assertNotEquals is used and
	 * checking as part of the code whether the string buffer returned is exact
	 * and correct in the store and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */
	@Test
	public void toString_Test7() throws NGramException {
		String[] words = { "People", "Are", "Told" };
		String[] predictions = { "regarding", "gently", "everything" };
		Double[] probabilities = { 0.736578, 0.679879, 0.359035 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		node.setContext("Gentlemen are Informed");

		NGramStore store = new NGramStore();
		store.addNGram(node);

		StringBuffer sb = new StringBuffer();

		sb.append("Passengers are requested to | honestly : 0.736578\nPassengers are requested to | sincerely : 0.953905\nPassengers are requested to | exactly : 0.359035\n");
		assertNotEquals(
				"Gentlemen are Informed | regarding : 0.736578\nGentlemen are Informed | gently : 0.679879\nGentlemen are Informed | everything : 0.583588\n",
				node.toString());
	}

	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the
	 * outputNodeValue i.e., node.toString() is mismatching with its correct
	 * value of string buffer operation. So, assertNotEquals is used and
	 * checking as part of the code whether the string buffer returned is exact
	 * and correct in the store and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */
	@Test
	public void toString_Test8() throws NGramException {
		NGramStore store = new NGramStore();
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "How", "Now", "This" };
		Double[] probabilities = { 0.1, 0.1, 0.1 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me", node.getContext());

		NGramNode node2 = new NGramNode(words, predictions, probabilities);
		node2.setContext("Come Here Once");
		node2.setPredictions(new String[] { "a", "in", "more" });

		store.addNGram(node);
		store.addNGram(node2);

		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me | How : 0.1\nPlease Tell Me | Now : 0.1\nPlease Tell Me | This : 0.1\n");
		sb.append("\n");
		sb.append("Come Here Once | a : 0.1\nCome Here Once | in : 0.1\nCome Here Once | more : 0.1\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());

	}

	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the
	 * outputNodeValue i.e., node.toString() is mismatching with its correct
	 * value of string buffer operation. So, assertNotEquals is used and
	 * checking as part of the code whether the string buffer returned is exact
	 * and correct in the store and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */
	@Test
	public void toString_Test9() throws NGramException {
		NGramStore store = new NGramStore();
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "How", "Now", "This" };
		Double[] probabilities = { 0.2, 0.1, 0.1 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me", node.getContext());

		NGramNode node2 = new NGramNode(words, predictions, probabilities);
		node2.setContext("Come Here Once");
		node2.setPredictions(new String[] { "a", "in", "more" });

		store.addNGram(node);
		store.addNGram(node2);

		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me | How : 0.2\nPlease Tell Me | Now : 0.1\nPlease Tell Me | This : 0.1\n");
		sb.append("\n");
		sb.append("Come Here Once | a : 0.2\nCome Here Once | in : 0.1\nCome Here Once | more : 0.1\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());

	}
	
	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the
	 * outputNodeValue i.e., node.toString() is mismatching with its correct
	 * value of string buffer operation. So, assertNotEquals is used and
	 * checking as part of the code whether the string buffer returned is exact
	 * and correct in the store and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */
	@Test
	public void toString_Test10() throws NGramException {
		NGramStore store = new NGramStore();
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "How", "Now", "This" };
		Double[] probabilities = { 0.22222222222, 0.11111111111, 0.111111111111 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me", node.getContext());

		NGramNode node2 = new NGramNode(words, predictions, probabilities);
		node2.setContext("Come Here Once");
		node2.setPredictions(new String[] { "a", "in", "more" });

		store.addNGram(node);
		store.addNGram(node2);

		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me | How : 0.222222\nPlease Tell Me | Now : 0.111111\nPlease Tell Me | This : 0.111111\n");
		sb.append("\n");
		sb.append("Come Here Once | a : 0.222222\nCome Here Once | in : 0.111111\nCome Here Once | more : 0.111111\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());
	}
	
	/**
	 * Test method : {@link assign2.ngram.NGramNode#toString()}. <br/>
	 * <br/>
	 * Test NGramNode method, when probabilities are displayed exactly for the
	 * user input by getting added exactly after the predictions, here the
	 * outputNodeValue i.e., node.toString() is mismatching with its correct
	 * value of string buffer operation. So, assertNotEquals is used and
	 * checking as part of the code whether the string buffer returned is exact
	 * and correct in the store and then NGramException is thrown
	 * 
	 * @throws NGramException
	 */
	@Test
	public void toString_Test11() throws NGramException {
		NGramStore store = new NGramStore();
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "How", "Now", "This" };
		Double[] probabilities = { 0.00000000000001, 0.00000000000001, 0.00000000000001 };

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me", node.getContext());

		NGramNode node2 = new NGramNode(words, predictions, probabilities);
		node2.setContext("Come Here Once");
		node2.setPredictions(new String[] { "a", "in", "more" });

		store.addNGram(node);
		store.addNGram(node2);

		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me | How : 0\nPlease Tell Me | Now : 0\nPlease Tell Me | This : 0\n");
		sb.append("\n");
		sb.append("Come Here Once | a : 0\nCome Here Once | in : 0\nCome Here Once | more : 0\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());

	}
	
	@Test
	public void toString_Test12() throws NGramException {
		NGramStore store = new NGramStore();
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "How", "Now", "This" };
		Double[] probabilities = { 1.00000000, 1.00000000, 1.00000000};

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me", node.getContext());

		NGramNode node2 = new NGramNode(words, predictions, probabilities);
		node2.setContext("Come Here Once");
		node2.setPredictions(new String[] { "a", "in", "more" });

		store.addNGram(node);
		store.addNGram(node2);

		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me | How : 1\nPlease Tell Me | Now : 1\nPlease Tell Me | This : 1\n");
		sb.append("\n");
		sb.append("Come Here Once | a : 1\nCome Here Once | in : 1\nCome Here Once | more : 1\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());
	}
	
	@Test
	public void toString_Test13() throws NGramException {
		NGramStore store = new NGramStore();
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "How", "Now", "This" };
		Double[] probabilities = { 0.000001, 0.5555514324324234, 0.4324324324324};

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me", node.getContext());

		NGramNode node2 = new NGramNode(words, predictions, probabilities);
		node2.setContext("Come Here Once");
		node2.setPredictions(new String[] { "a", "in", "more" });

		store.addNGram(node);
		store.addNGram(node2);

		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me | How : 0.000001\nPlease Tell Me | Now : 0.555551\nPlease Tell Me | This : 0.432432\n");
		sb.append("\n");
		sb.append("Come Here Once | a : 0.000001\nCome Here Once | in : 0.555551\nCome Here Once | more : 0.432432\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());
	}
	
	@Test
	public void toString_Test14() throws NGramException {
		NGramStore store = new NGramStore();
		String[] words = { "Please", "Tell", "Me" };
		String[] predictions = { "How", "Now", "This" };
		Double[] probabilities = { 0.555555555555, 0.6666666666666, 0.77777777777};

		NGramNode node = new NGramNode(words, predictions, probabilities);
		assertEquals("Please Tell Me", node.getContext());

		NGramNode node2 = new NGramNode(words, predictions, probabilities);
		node2.setContext("Come Here Once");
		node2.setPredictions(new String[] { "a", "in", "more" });

		store.addNGram(node);
		store.addNGram(node2);

		StringBuffer sb = new StringBuffer();
		sb.append("Please Tell Me | How : 0.555556\nPlease Tell Me | Now : 0.666667\nPlease Tell Me | This : 0.777778\n");
		sb.append("\n");
		sb.append("Come Here Once | a : 0.555556\nCome Here Once | in : 0.666667\nCome Here Once | more : 0.777778\n");
		sb.append("\n");
		assertEquals(sb.toString(), store.toString());
	}

}
