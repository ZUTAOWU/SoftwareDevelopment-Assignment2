/**
 * 
 */
package assign2.ngram;

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

	// @Test(expected = NGramException.class)

	@Test(expected = NGramException.class)
	public void testValidInputContext_First() throws NGramException {
		@SuppressWarnings("unused")
		NGramNode node = new NGramNode("", null, null);
		
	}
}
