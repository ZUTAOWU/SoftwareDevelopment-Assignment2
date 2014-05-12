/**
 * 
 */
package assign2.ngram;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import assign2.ngram.NGramNode;
import assign2.ngram.NGramException;

/**
 * @author kaushik.muthukrishnan.simili
 * 
 */
public class NGramNodeTest {

	private static NGramNode nGramNode;
	public ArrayList<String> stList = new ArrayList<String>();
	public ArrayList<Double> dblList = new ArrayList<Double>();

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

	// @Test(expected = NGramException.class)

	@Test
	public void testValidInputContext_First() throws NGramException {
		stList.add("Could");
		stList.add("You");
		stList.add("Please");
		stList.add("Tell");
		assertEquals(stList.get(0), "Could");
		assertEquals(stList.get(1), "You");
		assertEquals(stList.get(2), "Please");
		assertEquals(stList.get(3), "Tell");
	}

	@Test
	public void testStringPredictionsList_First() throws NGramException {
		stList.add("Hi");
		stList.add("How");
		stList.add("Are");
		stList.add("You");
		assertEquals(stList.get(0), "Hi");
		assertEquals(stList.get(1), "How");
		assertEquals(stList.get(2), "Are");
		assertEquals(stList.get(3), "You");
	}

	@Test
	public void testStringPredictionsList_Second() throws NGramException {
		stList.add("To");
		stList.add("be");
		stList.add("or");
		stList.add("Not");
		stList.add("To");
		assertEquals(stList.get(0), "To");
		assertEquals(stList.get(1), "be");
		assertEquals(stList.get(2), "or");
		assertEquals(stList.get(3), "Not");
		assertEquals(stList.get(4), "To");
	}

	@Test
	public void testDoubleProbalitiesList_First() throws NGramException {
		dblList.add(0.1234526262);
		dblList.add(0.7683768937693);
		dblList.add(0.956893689365);
		dblList.add(0.6586587897536);
		dblList.add(0.4873589795908509);
		dblList.add(0.598398359590585);
		assertEquals(dblList.get(0), Double.valueOf(0.1234526262));
		assertEquals(dblList.get(1), Double.valueOf(0.7683768937693));
		assertEquals(dblList.get(2), Double.valueOf(0.956893689365));
		assertEquals(dblList.get(3), Double.valueOf(0.6586587897536));
		assertEquals(dblList.get(4), Double.valueOf(0.4873589795908509));
		assertEquals(dblList.get(5), Double.valueOf(0.598398359590585));
	}

	@Test
	public void testDoubleProbalitiesList_Second() throws NGramException {
		dblList.add(0.190234526262);
		dblList.add(0.95893683768937693);
		dblList.add(0.8604893689365);
		dblList.add(0.85086587897536);
		dblList.add(0.9680948949795908509);
		dblList.add(0.80800959590585);
		dblList.add(0.769847948709);
		assertEquals(dblList.get(0), Double.valueOf(0.190234526262));
		assertEquals(dblList.get(1), Double.valueOf(0.95893683768937693));
		assertEquals(dblList.get(2), Double.valueOf(0.8604893689365));
		assertEquals(dblList.get(3), Double.valueOf(0.85086587897536));
		assertEquals(dblList.get(4), Double.valueOf(0.9680948949795908509));
		assertEquals(dblList.get(5), Double.valueOf(0.80800959590585));
		assertEquals(dblList.get(6), Double.valueOf(0.769847948709));
	}

}
