/**
 * 
 */
package assign2.ngram;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import assign2.ngram.NGramNode;
import assign2.ngram.NGramStore;
import assign2.ngram.NGramException;

/**
 * @author kaushik.muthukrishnan.simili
 * 
 */
public class NGramNodeTest {

	private static NGramNode nGramNode;

	@BeforeClass
	public static void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		nGramNode = null;
	}

	@Test
	public void testValidInputContext() throws NGramException {
		nGramNode.setContext("Hi How are you");
		assertEquals("Hi How are you", nGramNode.getContext());
	}

	@Test(expected = NGramException.class)
	public void testInvalidInputContext() throws NGramException {
		nGramNode.setContext("");
	}

}
