package assign2.ngram;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZUTAOWU n8975698
 */
public class NGramStore implements NGramMap {
	
	private Map<String, NGramContainer> ngramMap;
	
	public NGramStore() {
		ngramMap = new HashMap<String, NGramContainer>();
	}

	/**
	 * @see assign2.ngram.NGramMap#addNGram(assign2.ngram.NGramContainer)
	 */
	@Override
	public void addNGram(NGramContainer ngram) {
		ngramMap.put(ngram.getContext(), ngram);
	}

	/**
	 * @see assign2.ngram.NGramMap#removeNGram(java.lang.String)
	 */
	@Override
	public void removeNGram(String context) {
		ngramMap.remove(context);
	}

	/**
	 * @see assign2.ngram.NGramMap#getNGram(java.lang.String)
	 */
	@Override
	public NGramContainer getNGram(String context) {
		NGramContainer nc = ngramMap.get(context);
		return nc;
	}

	/**
	 * @see assign2.ngram.NGramMap#getNGramsFromService(java.lang.String, int)
	 */
	@Override
	public boolean getNGramsFromService(String context, int maxResults)
			throws NGramException {
		
		return false;
	}

}
