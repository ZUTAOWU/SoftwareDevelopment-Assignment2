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

	//ArrayList<String> wordsList;
	String context;
	ArrayList<String> predictionsList;
	ArrayList<Double> probabilitiesList;
	
	/**
	 * @param
	 * String[] words - array of words in order that make up the context <br/>
	 * String[] predictions - array of next words in the phrase as predicted by the model <br/>
	 * Double[] probabilities - corresponding probabilities of context>prediction w.r.t. model <br/> 
	 * 
	 * @throws
	 * if words is null or empty or contains at least one empty or null string 
	 * predictions is null or empty or contains at least one empty or null string 
	 * probabilities is null or contains at least one entry which is null , zero, negative or greater than 1.0 
	 * or the predictions.length is different from probabilities.length
	 * 
	 */
	
	private boolean checkStringArray(String[] strArr) {
		boolean isCorrect = true;
		if(strArr != null) {
			for(int i = 0 ; i < strArr.length ; i++) {
				if(strArr[i] == null || strArr[i].equals("")) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}
	
	private boolean checkProbArray(Double[] probArr) {
		boolean isCorrect = true;
		
		if(probArr != null) {
			for(int i = 0 ; i < probArr.length ; i++) {
				if(probArr[i] == null || Double.compare(probArr[i], 0.0) <= 0 || Double.compare(probArr[i], 1.0) > 0) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}
	
	public NGramNode(String[] words, String[] predictions, Double[] probabilities) throws NGramException {
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
		
		context = "";
		predictionsList = new ArrayList<String>();
		probabilitiesList = new ArrayList<Double>();
		
		setContext(words);
		setPredictions(predictions);
		setProbabilities(probabilities);
	}
	
	public NGramNode(String context, String[] predictions, Double[] probabilities) throws NGramException {
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
		if(!checkStringArray(words)) {
			throw new NGramException("words cannnot be null or empty or contains at least one empty or null string.");
		}
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
		return predictionsList.toArray(new String[predictionsList.size()]);
	}

	/**
	 * @see assign2.ngram.NGramContainer#setPredictions(java.lang.String[])
	 */
	@Override
	public void setPredictions(String[] predictions) throws NGramException {
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
		StringBuffer sb = new StringBuffer();
		//sb.append("NGram Results for Query: ");
		//sb.append(context);
		//sb.append("\n");
		//sb.append("\n");
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
