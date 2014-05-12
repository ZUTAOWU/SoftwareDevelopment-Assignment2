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
	
	@SuppressWarnings("unused")
	private static NGramNode nGramNode;

	/**
	 * @throws java.lang.Exception
	 */
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
	
	/**
	 * Test method for {@link asgn1Solution.DamActions#DamActions(java.lang.Integer, java.lang.Integer, java.lang.Integer, WaterLog log)}.
	 * This test method tests the if condition of the constructor of the DamActions class. It tests the case where the job duration is not strictly positive (greater than zero).
	 * @exception SimulationException - Thrown when the supplied value of Job Duration is negative.
	 * @see SimulationException
	 */
	@Test
	public void testValidInputContext() throws NGramException{
			
		nGramNode.setContext("Hi How are you");
		assertEquals("Hi How are you", nGramNode.getContext());
		}
	
	@Rule
	public ExpectedException invalidPredictionsInputContent = ExpectedException.none();
	
	/**
	 * Test method for {@link asgn1Solution.DamActions#DamActions(java.lang.Integer, java.lang.Integer, java.lang.Integer, WaterLog log)}.
	 * This test method tests the if condition of the constructor of the DamActions class. It tests the case where the job duration is not strictly positive (greater than zero).
	 * @exception SimulationException - Thrown when the supplied value of Job Duration is negative.
	 * @see SimulationException
	 */
	@Test
	public void testInvalidPredictionsInputContent() throws NGramException{
			
		invalidPredictionsInputContent.expect(NGramException.class);
		invalidPredictionsInputContent.expectMessage("You have entered an invalid input content");
	/*	nGramNode.s("Hi");
		assertArrayEquals(new String[]{"HI","BYE"},new String[]{"HI","BYE"});*/
		}
	
	
	
}
	
