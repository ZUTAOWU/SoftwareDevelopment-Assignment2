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
	 * @throws NGramException 
	 * 
	 * @throws
	 * if words is null or empty or contains at least one empty or null string 
	 * predictions is null or empty or contains at least one empty or null string 
	 * probabilities is null or contains at least one entry which is null , zero, negative or greater than 1.0 
	 * or the predictions.length is different from probabilities.length
	 * 
	 */
	public NGramNode(String[] words, String[] predictions, Double[] probabilities) throws NGramException {
		context = "";
		predictionsList = new ArrayList<String>();
		probabilitiesList = new ArrayList<Double>();
		
		setContext(words);
		setPredictions(predictions);
		setProbabilities(probabilities);
	}
	
	public NGramNode(String context, String[] predictions, Double[] probabilities) throws NGramException {
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
		this.context = context;
	}

	/**
	 * @see assign2.ngram.NGramContainer#setContext(java.lang.String[])
	 */
	@Override
	public void setContext(String[] words) throws NGramException {
		StringBuffer contextBuffer = new StringBuffer();
		for(int i = 0 ; i < words.length ; i++) {
			contextBuffer.append(words[i]).append(" ");
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
