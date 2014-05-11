package assign2.ngram;

/**
 * @author ZUTAOWU n8975698
 * 
 */
public class NGramStore implements NGramMap {

	/**
	 * @see assign2.ngram.NGramMap#addNGram(assign2.ngram.NGramContainer)
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public void addNGram(NGramContainer ngram) {

	}

	/**
	 * 
	 * @see assign2.ngram.NGramMap#removeNGram(java.lang.String)
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public void removeNGram(String context) {

	}

	/**
	 * 
	 * @see assign2.ngram.NGramMap#getNGram(java.lang.String)
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public NGramContainer getNGram(String context) {
		return null;
	}

	/**
	 * 
	 * @see assign2.ngram.NGramMap#getNGramsFromService(java.lang.String, int)
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public boolean getNGramsFromService(String context, int maxResults)
			throws NGramException {
		return false;
	}

}
