package assign2.ngram;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import assign2.examples.ngram.SimpleNGramGenerator;
import com.microsoft.research.webngram.service.GenerationService;
import com.microsoft.research.webngram.service.NgramServiceFactory;
import com.microsoft.research.webngram.service.GenerationService.TokenSet;

/**
 * @author ZUTAOWU n8975698
 */
public class NGramStore implements NGramMap {

	private static final String Key = "068cc746-31ff-4e41-ae83-a2d3712d3e68";

	// ngramMap stores the context and node
	private Map<String, NGramContainer> ngramMap;

	/**
	 * NGramStore constructor
	 */
	public NGramStore() {
		// LinkedHashMap is used in order to maintain the order of user input
		ngramMap = new LinkedHashMap<String, NGramContainer>();
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
	 * 
	 */
	@Override
	public boolean getNGramsFromService(String context, int maxResults) throws NGramException {

		NgramServiceFactory factory = NgramServiceFactory.newInstance(SimpleNGramGenerator.Key);
		if (factory == null) {
			throw new NGramException("NGram Service unavailable");
		}

		// Throw NGramException if the NGramContainer cannot be created.
		try {
			GenerationService service = factory.newGenerationService();
			TokenSet tokenSet = service.generate(Key, "bing-body/2013-12/5",context, maxResults, null);
			List<String> wordsList = tokenSet.getWords();
			List<Double> logProbs = tokenSet.getProbabilities();
			List<Double> probs = new ArrayList<Double>();

			// Convert mathematical log of base 10 probability to normal probability
			for (Double x : logProbs) {
				probs.add(Math.pow(10.0, x));
			}


			// convert array list to array
			String[] predictWords = wordsList.toArray(new String[wordsList.size()]);
			Double[] probabilities = probs.toArray(new Double[probs.size()]);

			if (wordsList.size() < 1) {
				// Return false and do not store the bare context if the service returns no predictions
				return false;
			} else {

				// Return true and store the NGram in the Map if the service
				// returns at least one result
				NGramNode node = new NGramNode(context, predictWords, probabilities);
				ngramMap.put(context, node);
				return true;
			}
		} catch (Exception e) {
			throw new NGramException("Can not create NGramNode Successfully!");
		}
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Set<String> keySet = ngramMap.keySet();
		for (String s : keySet) {
			NGramNode node = (NGramNode) ngramMap.get(s);
			sb.append(node.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
