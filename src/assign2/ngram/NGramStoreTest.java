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

	@Test
	public void Test_addNGram_NullValues() throws NGramException {

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
		String context = "Hello";
		int maxResults = 10;
		ngramMap.remove(context);
		NGramStore store = new NGramStore();
		store.getNGramsFromService(context, maxResults);
	}
}
