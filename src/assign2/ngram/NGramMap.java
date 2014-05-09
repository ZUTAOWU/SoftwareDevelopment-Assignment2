/**
 * 
 * This file is part of the SearchSuggestion Project, written as 
 * part of the assessment for INB370, semester 1, 2014. 
 *
 * NGramMap
 * assign2.ngram 
 * 19/04/2014
 * 
 */

package assign2.ngram;
/**
 * <p>
 * Interface that supports a collection of ngrams, each held in an object of type <code>NGramContainer</code>. 
 * The Abstract model of the collection is a <code>map<String,NGramContainer></code>, with the context string as 
 * the key. Each context string is then able to retrieve its associated container object. 
 * </p>
 * <p>
 * Note that there is some abuse of the term NGram in this documentation as a shorthand for an object 
 * of type NGramContainer, which has an ngram at the heart, but is really in itself a small collection of possible 
 * ngrams. 
 * </p>
 * <p>
 * The interface specifies methods to allow ngrams to be added to the collection, removed from the 
 * collection, and for ngrams to be sourced for a particular context string from an external web source. 
 * The approach is based on the service provided at: 
 * <a href="http://web-ngram.research.microsoft.com/">http://web-ngram.research.microsoft.com/</a>, but the 
 * specification is reasonably generic, and so the application keys and other parameters are regarded as 
 * implementation issues and not specified here. 
 * </p>
 * <p>
 * You must implement this interface as class <code>NGramStore</code>, and produce a
 * <em>comprehensive</em> unit test suite for it. While a professional interface would not normally 
 * specify the constructors to be used, here for convenience you are instructed to implement only a simple 
 * parameterless constructor for class <code>NGramStore</code>.
 * </p>
 * 
 * 
 * @author hogan
 * @version 1.0
 *
 */

public interface NGramMap {

	/**
	 * 
	 * (Silently) Add an ngram to the Map. If the <code>context</code> does not exist in the Map, 
	 * the entry is added.<br>
	 * If the <code>context</code> exists in the Map, then the associated ngram is 
	 * updated (and thus overwritten). 
	 * 
	 * @param ngram - ngram to be added 
	 */
	public abstract void addNGram(NGramContainer ngram);

	/**
	 * 
	 * (Silently) Remove an ngram from the Map. If the <code>context</code> does not exist in the Map, 
	 * the entry is not removed, but no status is returned. We guarantee that the entry no longer exists<br>
	 * If the <code>context</code> exists in the Map, then the associated ngram is removed. 
	 * 
	 * @param context - context string for ngram to be removed
	 */
	public abstract void removeNGram(String context);

	/**
	 * 
	 * Find the NGram associated with the context if it exists in the Map. 
	 * Return null if the context is not a key in the Map. 
	 * 
	 * @param context
	 * @return NGramContainer associated with the context or null 
	 */
	public NGramContainer getNGram(String context);

	/**
	 * 
	 * Get the top maxResults ngrams returned from the service.  
	 * 
	 * @param context - the context for the ngram search 
	 * @param maxResults - the maximum number of 
	 * @return true and store the NGram in the Map if the service returns at least one result<br>
	 * return false and do not store the bare context if the service returns no predictions
	 * @throws NGramException if the service fails to connect or if the NGramContainer cannot be 
	 * created. 
	 */
	public boolean getNGramsFromService(String context, int maxResults)
			throws NGramException;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();

}