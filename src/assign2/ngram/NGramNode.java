/**
 * 
 */
package assign2.ngram;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author ZUTAOWU n8975698
 * 
 */
public class NGramNode implements NGramContainer {

	String context;
	ArrayList<String> predictionsList;
	ArrayList<Double> probabilitiesList;

	/*
	 * This is a helper method, checking whether or not the string array is
	 * correct
	 */
	private boolean checkStringArray(String[] strArr) {
		boolean isCorrect = true;
		if (strArr != null) {
			for (int i = 0; i < strArr.length; i++) {
				if (strArr[i] == null || strArr[i].equals("")) {
					// If any of the strings inside the string array is null or
					// empty then this string array is incorrect
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

	/*
	 * This is a helper method, checking whether or not the probability array is
	 * correct
	 */
	private boolean checkProbArray(Double[] probArr) {
		boolean isCorrect = true;
		if (probArr != null) {
			for (int i = 0; i < probArr.length; i++) {
				if (probArr[i] == null || Double.compare(probArr[i], 0.0) <= 0 || Double.compare(probArr[i], 1.0) > 0) {
					// If any of the probabilities are null (OR) less than 0
					// (OR) greater than 1, then returning as false
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

	/**
	 * This NGramNode constructor is used for building NGramNode instance
	 * 
	 * @param words
	 *            - array of words in order that make up the context <br/>
	 * @param predictions
	 *            - array of the next set of words for a given phrase as
	 *            predicted by the model <br/>
	 * @param probabilities
	 *            - corresponding probabilities of context>prediction w.r.t.
	 *            model <br/>
	 * 
	 * @throws NGramException
	 *             if words is null or empty or contains at least one empty or
	 *             null string predictions is null or empty or contains at least
	 *             one empty or null string probabilities is null or contains at
	 *             least one entry which is null , zero, negative or greater
	 *             than 1.0 or the predictions.length is different from
	 *             probabilities.length
	 */
	public NGramNode(String[] words, String[] predictions, Double[] probabilities) throws NGramException {
		// handling SimulationException
		if (!checkStringArray(words)) {
			throw new NGramException("Words cannot be null (OR) empty (OR) contain at least one empty or null string.");
		}

		if (!checkStringArray(predictions)) {
			throw new NGramException("Predictions cannot be null (OR) empty (OR) contain at least one empty or null string.");
		}

		if (!checkProbArray(probabilities)) {
			throw new NGramException("Probabilities cannot be null (OR) contain at least one entry which is null (OR) zero (OR) negative (OR) greater than 1.0.");
		}

		if (predictions.length != probabilities.length) {
			throw new NGramException("Length of predictions is different from that of length of probabilities.");
		}
		// -----------------------------
		context = "";
		predictionsList = new ArrayList<String>();
		probabilitiesList = new ArrayList<Double>();
		// -----------------------------
		setContext(words);
		setPredictions(predictions);
		setProbabilities(probabilities);
	}

	/**
	 * This NGramNode constructor is used for building NGramNode instance
	 * 
	 * @param context
	 *            - context - string containing the context phrase <br/>
	 * @param predictions
	 *            - array of the next set of words for a given phrase as
	 *            predicted by the model <br/>
	 * @param probabilities
	 *            - corresponding probabilities of context>prediction w.r.t.
	 *            model <br/>
	 * 
	 * @throws NGramException
	 *             if context is null or empty predictions is null or empty or
	 *             contains at least one empty or null string probabilities is
	 *             null or contains at least one entry which is null , zero,
	 *             negative or greater than 1.0 or the predictions.length is
	 *             different from probabilities.length
	 */
	public NGramNode(String context, String[] predictions, Double[] probabilities) throws NGramException {
		// handling SimulationException
		if (context == null || "".equals(context)) {
			throw new NGramException("Context cannot be null or empty.");
		}

		if (!checkStringArray(predictions)) {
			throw new NGramException("Predictions cannot be null (OR) empty (OR) contain at least one empty or null string.");
		}

		if (!checkProbArray(probabilities)) {
			throw new NGramException("Probabilities cannot be null (OR) contain at least one entry which is null (OR) zero (OR) negative (OR) greater than 1.0.");
		}

		if (predictions.length != probabilities.length) {
			throw new NGramException("Length of predictions is different from that of length of probabilities.");
		}
		// -----------------------------
		this.context = context;
		predictionsList = new ArrayList<String>();
		probabilitiesList = new ArrayList<Double>();

		setContext(context);
		setPredictions(predictions);
		setProbabilities(probabilities);
	}

	/**
	 * @see assign2.ngram.NGramContainer#getContext()
	 */
	@Override
	public String getContext() {
		return this.context;
	}

	/**
	 * @see assign2.ngram.NGramContainer#setContext(java.lang.String)
	 */
	@Override
	public void setContext(String context) throws NGramException {
		// Throws: NGramException - if context is null or empty
		if (context == null || "".equals(context)) {
			throw new NGramException("Context cannot be null or empty.");
		}
		this.context = context;
	}

	/**
	 * @see assign2.ngram.NGramContainer#setContext(java.lang.String[])
	 */
	@Override
	public void setContext(String[] words) throws NGramException {
		// Throws: NGramException if words are null (OR) empty (OR) contains at
		// least one empty or null string
		if (!checkStringArray(words)) {
			throw new NGramException("Words cannot be null (OR) empty (OR) contain at least one empty or null string.");
		}
		// Connecting string array to string
		StringBuffer contextBuffer = new StringBuffer();
		for (int i = 0; i < words.length; i++) {
			contextBuffer.append(words[i]);
			if (i < words.length - 1) {
				contextBuffer.append(" ");
			}
		}
		this.context = contextBuffer.toString();
	}

	/**
	 * @see assign2.ngram.NGramContainer#getPredictions()
	 */
	@Override
	public String[] getPredictions() {
		// Converting array list to array
		return predictionsList.toArray(new String[predictionsList.size()]);
	}

	/**
	 * @see assign2.ngram.NGramContainer#setPredictions(java.lang.String[])
	 */
	@Override
	public void setPredictions(String[] predictions) throws NGramException {
		// Throws: NGramException - if predictions are null (OR) empty (OR)
		// contains at least one empty or null string
		if (!checkStringArray(predictions)) {
			throw new NGramException("Predictions cannot be null (OR) empty (OR) contain at least one empty or null string.");
		}
		predictionsList.clear();
		for (int i = 0; i < predictions.length; i++) {
			predictionsList.add(predictions[i]);
		}
	}

	/**
	 * @see assign2.ngram.NGramContainer#getProbabilities()
	 */
	@Override
	public Double[] getProbabilities() {
		return probabilitiesList.toArray(new Double[probabilitiesList.size()]);
	}

	/**
	 * @see assign2.ngram.NGramContainer#setProbabilities(java.lang.Double[])
	 */
	@Override
	public void setProbabilities(Double[] probabilities) throws NGramException {
		// Throws: NGramException - if probabilities are null (OR) contains at
		// least one entry which is null (OR) zero (OR) negative (OR) greater
		// than 1.0
		if (!checkProbArray(probabilities)) {
			throw new NGramException("Probabilities cannot be null (OR) contain at least one entry as null (OR) zero (OR) negative (OR) greater than 1.0.");
		}
		probabilitiesList.clear();
		for (int i = 0; i < probabilities.length; i++) {
			probabilitiesList.add(probabilities[i]);
		}
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// Output string for node
		StringBuffer sb = new StringBuffer();
		DecimalFormat df = new DecimalFormat(DecFormat);
		for (int i = 0; i < predictionsList.size(); i++) {
			sb.append(context);
			sb.append(" | ");
			sb.append(predictionsList.get(i));
			sb.append(" : ");
			sb.append(df.format(probabilitiesList.get(i)));
			sb.append("\n");
		}
		return sb.toString();
	}

}
