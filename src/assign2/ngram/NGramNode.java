/**
 * 
 */
package assign2.ngram;

/**
 * @author ZUTAOWU n8975698
 *
 */
public class NGramNode implements NGramContainer {

	/**
	 * @see assign2.ngram.NGramContainer#getContext()
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public String getContext() {
		return null;
	}

	/**
	 * @see assign2.ngram.NGramContainer#setContext(java.lang.String)
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public void setContext(String context) throws NGramException {

	}

	/**
	 * @see assign2.ngram.NGramContainer#setContext(java.lang.String[])
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public void setContext(String[] words) throws NGramException {

	}

	/**
	 * @see assign2.ngram.NGramContainer#getPredictions()
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public String[] getPredictions() {
		return null;
	}

	/**
	 * @see assign2.ngram.NGramContainer#setPredictions(java.lang.String[])
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public void setPredictions(String[] predictions) throws NGramException {

	}

	/**
	 * @see assign2.ngram.NGramContainer#getProbabilities()
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public Double[] getProbabilities() {
		return null;
	}

	/**
	 * @see assign2.ngram.NGramContainer#setProbabilities(java.lang.Double[])
	 * @author ZUTAOWU n8975698
	 */
	@Override
	public void setProbabilities(Double[] probabilities) throws NGramException {

	}

}
