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
	 * This is a helper method, check if string array is correct
	 */
	private boolean checkStringArray(String[] strArr) {
		boolean isCorrect = true;
		if(strArr != null) {
			for(int i = 0 ; i < strArr.length ; i++) {
				if(strArr[i] == null || strArr[i].equals("")) {
					// if string inside string array is null or empty then this string array is not correct
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
	 * This is a helper method, check if probability array is correct
	 */
	private boolean checkProbArray(Double[] probArr) {
		boolean isCorrect = true;
		if(probArr != null) {
			for(int i = 0 ; i < probArr.length ; i++) {
				if(probArr[i] == null || Double.compare(probArr[i], 0.0) <= 0 || Double.compare(probArr[i], 1.0) > 0) {
					// if any probability is null or less than 0 or great then 1, then return false;
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
	 * @param words - array of words in order that make up the context <br/>
	 * @param predictions - array of next words in the phrase as predicted by the model <br/>
	 * @param probabilities - corresponding probabilities of context>prediction w.r.t. model <br/> 
	 * 
	 * @throws NGramException
	 * if words is null or empty or contains at least one empty or null string 
	 * predictions is null or empty or contains at least one empty or null string 
	 * probabilities is null or contains at least one entry which is null , zero, negative or greater than 1.0 
	 * or the predictions.length is different from probabilities.length
	 */
	public NGramNode(String[] words, String[] predictions, Double[] probabilities) throws NGramException {
		// handle SimulationException
		if(!checkStringArray(words)) {
			throw new NGramException("words cannnot be null or empty or contains at least one empty or null string.");
		}
		
		if(!checkStringArray(predictions)) {
			throw new NGramException("predictions cannnot be null or empty or contains at least one empty or null string.");
		}
		
		if(!checkProbArray(probabilities)) {
			throw new NGramException("probabilities cannnot be null or contains at least one entry which is null , zero, negative or greater than 1.0.");
		}
		
		if(predictions.length != probabilities.length) {
			throw new NGramException("predictions.length is different from probabilities.length.");
		}
		//-----------------------------
		context = "";
		predictionsList = new ArrayList<String>();
		probabilitiesList = new ArrayList<Double>();
		//-----------------------------
		setContext(words);
		setPredictions(predictions);
		setProbabilities(probabilities);
	}
	
	/**
	 * This NGramNode constructor is used for building NGramNode instance
	 * @param context - context - string containing the context phrase <br/>
	 * @param predictions - array of next words in the phrase as predicted by the model <br/>
	 * @param probabilities - corresponding probabilities of context>prediction w.r.t. model <br/> 
	 * 
	 * @throws NGramException
	 * if context is null or empty
	 * predictions is null or empty or contains at least one empty or null string
	 * probabilities is null or contains at least one entry which is null , zero, negative or greater than 1.0
 	 * or the predictions.length is different from probabilities.length
	 */
	public NGramNode(String context, String[] predictions, Double[] probabilities) throws NGramException {
		// handle SimulationException
		if(context == null || "".equals(context)) {
			throw new NGramException("context cannot be null or empty.");
		}
		
		if(!checkStringArray(predictions)) {
			throw new NGramException("predictions cannnot be null or empty or contains at least one empty or null string.");
		}
		
		if(!checkProbArray(probabilities)) {
			throw new NGramException("probabilities cannnot be null or contains at least one entry which is null , zero, negative or greater than 1.0.");
		}
		
		if(predictions.length != probabilities.length) {
			throw new NGramException("predictions.length is different from probabilities.length.");
		}
		//-----------------------------
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
		//Throws: NGramException - if context is null or empty
		if(context == null || "".equals(context)) {
			throw new NGramException("context cannot be null or empty.");
		}
		this.context = context;
	}

	/**
	 * @see assign2.ngram.NGramContainer#setContext(java.lang.String[])
	 */
	@Override
	public void setContext(String[] words) throws NGramException {
		// Throws: NGramException if words is null or empty or contains at least one empty or null string
		if(!checkStringArray(words)) {
			throw new NGramException("words cannnot be null or empty or contains at least one empty or null string.");
		}
		// connect string array to string
		StringBuffer contextBuffer = new StringBuffer();
		for(int i = 0 ; i < words.length ; i++) {
			contextBuffer.append(words[i]);
			if(i < words.length-1 ) {
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
		// convert array list to array
		return predictionsList.toArray(new String[predictionsList.size()]);
	}

	/**
	 * @see assign2.ngram.NGramContainer#setPredictions(java.lang.String[])
	 */
	@Override
	public void setPredictions(String[] predictions) throws NGramException {
		//Throws: NGramException - if predictions is null or empty or contains at least one empty or null string
		if(!checkStringArray(predictions)) {
			throw new NGramException("predictions cannnot be null or empty or contains at least one empty or null string.");
		}
		predictionsList.clear();
		for(int i = 0 ; i < predictions.length ; i++) {
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
		//Throws: NGramException - if probabilities null or contains at least one entry which is null , zero, negative or greater than 1.0
		if(!checkProbArray(probabilities)) {
			throw new NGramException("probabilities cannnot be null or contains at least one entry which is null , zero, negative or greater than 1.0.");
		}
		probabilitiesList.clear();
		for(int i = 0 ; i < probabilities.length ; i++) {
			probabilitiesList.add(probabilities[i]);
		}
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// output string of node
		StringBuffer sb = new StringBuffer();
		DecimalFormat df = new DecimalFormat(DecFormat);
		for(int i = 0 ; i < predictionsList.size() ; i++) {
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
