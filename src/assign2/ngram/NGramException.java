/**
 * 
 * This file is part of the SearchSuggestion Project, written as 
 * part of the assessment for INB370, semester 1, 2014. 
 *
 * NGramException
 * assign2.ngram 
 * 19/04/2014
 * 
 */

package assign2.ngram;


/**
 * This class represents any exceptions generated while dealing with 
 * NGrams.  If you find that the parameters provided to your
 * methods are invalid then you should throw a new instance of
 * this class as specified in the requirements.
 * 
 * @author hogan
 * @version 1.0
 */
@SuppressWarnings("serial") // We're not interested in binary i/o here
public class NGramException extends Exception {

	/**
	 * 
	 * Inherited constructor from superclass <code>Exception</code>
	 * 
	 */
	public NGramException() {
		super(); 
	}

	/**
	 * 
	 * Class specific constructor 
	 * 
	 * @param msg - specific error message
	 */
	public NGramException(String msg) {
		super("NGramException: " + msg);
	}
}
