/**
 * 
 * This file is part of the SearchSuggestion Project, written as 
 * part of the assessment for INB370, semester 1, 2014. 
 *
 * NGramContainer
 * assign2.ngram 
 * 19/04/2014
 * 
 */
package assign2.ngram;
/**
 * <p>
 * The NGramContainer interface specifies a container to hold ngram results, separately holding the 
 * context phrase, a list of predicted words, and a corresponding list of probabilities w.r.t. some 
 * associated model which we do not specify. A class implementing the <code>NGramContainer</code> interface 
 * should be used in association with another class implementing the <code>NGramMap</code> interface, which 
 * holds a collection of <code>NGramContainers</code> organised according to context. 
 * </p>
 * <p>
 * You must implement this interface as class <code>NGramNode</code>, and produce a
 * <em>comprehensive</em> unit test suite for it. While a professional interface would not normally 
 * specify the constructors to be used, here for convenience you are instructed to implement the following 
 * constructor signatures for the class <code>NGramNode</code>:
 * </p><p>
 * <dl>
 * <dt><strong>Constructor 1:</strong></dt>
 * <dt><strong>Parameters:</strong></dt>
 * <dd>
 * <code>String[] words</code> - array of words in order that make up the context<br>
 * <code>String[] predictions</code> - array of next words in the phrase as predicted by the model<br>
 * <code>Double[] probabilities</code> - corresponding probabilities of context>prediction w.r.t. model<br>
 * <dt><strong>Throws:</strong> </dt>
 * <dd><code>NGramException</code> - if <br>
 * <code>words</code> is null or empty or contains at least one empty or null string<br>
 * <code>predictions</code> is null or empty or contains at least one empty or null string<br>
 * <code>probabilities</code> is null or contains at least one  entry which is null , zero, negative or greater than 1.0<br>
 * or the <code>predictions.length</code> is different from <code>probabilities.length</code></dd>
 * </dl>
 * </p>
 * <p>
 * <dl>
 * <dt><strong>Constructor 2:</strong></dt>
 * <dt><strong>Parameters:</strong></dt>
 * <dd>
 * <code>String context</code> - string containing the context phrase<br>
 * <code>String[] predictions</code> - array of next words in the phrase as predicted by the model<br>
 * <code>Double[] probabilities</code> - corresponding probabilities of context>prediction w.r.t. model<br>
 * <dt><strong>Throws:</strong> </dt>
 * <dd><code>NGramException</code> - if <br>
 * <code>context</code> is null or empty<br>
 * <code>predictions</code> is null or empty or contains at least one empty or null string<br>
 * <code>probabilities</code> is null or contains at least one  entry which is null , zero, negative or greater than 1.0<br>
 * or the <code>predictions.length</code> is different from <code>probabilities.length</code></dd>
 * </dl>
 * </p>
 * 
 * 
 * 
 * @author hogan
 * @version 1.01 - updated constructor to Double[] probabilities
 *
 */
public interface NGramContainer {

	
	/**
	 * 
	 * Format for output of probabilities 
	 */
	public static final String DecFormat="#.######";

	/**
	 * 
	 * Simple getter method for the context string
	 * 
	 * @return String containing context phrase for predictions
	 */
	public String getContext();

	/**
	 * 
	 * Simple setter method for the context string
	 * 
	 * @param context - single String containing context phrase for predictions
	 * @throws NGramException if <code>context</code> is null or empty
	 */
	public void setContext(String context) throws NGramException;

	/**
	 * 
	 * Simple setter method for the context string from multiple words
	 * 
	 * @param words - array of words in order that make up the context
	 * @throws NGramException if <code>words</code> is null or empty or contains at least one empty or null string
	 */
	public void setContext(String[] words) throws NGramException;

	/**
	 * 
	 * Simple getter method for the prediction strings
	 * 
	 * @return array of alternative next words in the phrase as predicted by the model
	 */
	public String[] getPredictions();

	/**
	 * 
	 * Simple setter method for the predictions string array
	 * 
	 * @param predictions - next word in the phrase as predicted by the model
	 * @throws NGramException if <code>predictions</code> is null or empty or contains at least one empty or null string
	 */
	public void setPredictions(String[] predictions) throws NGramException;

	/**
	 * 
	 * Simple getter method for the probabilities
	 * 
	 * @return array of probabilities of context>prediction w.r.t. model
	 */
	public Double[] getProbabilities();

	/**
	 * 
	 * Simple setter method for the probabilities 
	 * 
	 * @param probabilities - array of probabilities of context>prediction w.r.t. model
	 * @throws NGramException if <code>probabilities</code> null or contains at least one  entry which is null , zero, negative or greater than 1.0
	 */
	public void setProbabilities(Double[] probabilities) throws NGramException;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();
}