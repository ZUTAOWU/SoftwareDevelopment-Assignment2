/**
 * 
 */
package assign2.ngram;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import assign2.ngram.NGramStore;
import assign2.ngram.NGramException;
import assign2.ngram.NGramContainer;

/**
 * @author kaushik.muthukrishnan.simili
 * 
 */
public class NGramStoreTest {

	private Map<String, NGramContainer> ngramMap = new HashMap<String, NGramContainer>();

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
	 * {@link assign2.ngram.NGramStore#addNGram(assign2.ngram.NGramContainer)} . <br/>
	 * <br/>
	 * Test NGramStore's method, where value of context and ngram are input as null and
	 * then NGramException is thrown
	 * 
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void Test_addNGram_NullValues_Exception1() throws NGramException {
		// Inserting null values to the map
		String context = null;
		NGramContainer ngram = null;
		ngramMap.put(context, ngram);
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

	@Test(expected = NGramException.class)
	public void Test_addNGram_NullValues_Exception2() throws NGramException {
		// Inserting no value to context to the map
		String context = "";
		NGramContainer ngram = null;
		ngramMap.put(context, ngram);
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

	@Test(expected = NGramException.class)
	public void Test_addNGram_Exception3() throws NGramException {
		// Removing the null value from the map
		String context = "Hello";
		NGramContainer ngram = null;
		ngramMap.put(context, ngram);
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

	@Test(expected = NGramException.class)
	public void Test_removeNGram_Exception1() throws NGramException {
		// Removing the null value from the map
		String context = null;
		ngramMap.remove(context);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#removeNGram(java.lang.String)} . <br/>
	 * <br/>
	 * Test NGramStore's method, where context is input as empty value and then
	 * NGramException is thrown
	 * 
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void Test_removeNGram_Exception2() throws NGramException {
		String context = "";
		ngramMap.remove(context);
	}

	/**
	 * Test method :
	 * {@link assign2.ngram.NGramStore#removeNGram(java.lang.String)} . <br/>
	 * <br/>
	 * Test NGramStore's method, where context value is supplied and the
	 * corresponding context is also removed and then NGramException is thrown
	 * 
	 * 
	 * @throws NGramException
	 */

	@Test(expected = NGramException.class)
	public void Test_removeNGram_Exception3() throws NGramException {
		String context = "Hello";
		ngramMap.remove(context);
	}
}
