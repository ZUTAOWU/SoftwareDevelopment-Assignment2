/**
 * 
 * This file is part of the SearchSuggestion Project, written as 
 * part of the assessment for INB370, semester 1, 2014. 
 *
 * SimpleNGramGenerator.java
 * assign2.examples.ngram
 * 29/04/2014
 * 
 * Original copyright notice from the ngram java wrapper follows. 
 * The supplied code is a simplified version of the Generator service 
 * example program
 * Copyright 2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package assign2.examples.ngram;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.research.webngram.service.GenerationService;
import com.microsoft.research.webngram.service.NgramServiceFactory;
import com.microsoft.research.webngram.service.GenerationService.TokenSet;


public class SimpleNGramGenerator {
	
	public static final String Key = "068cc746-31ff-4e41-ae83-a2d3712d3e68"; 
	public static final String DefaultContext = "My hovercraft is full";


    /**
     * The main method.
     * 
     * @param args - a list of words; the whole list is included as a single context call
     */
	public static void main(String[] args) {
		
		String context = " ";
		if (args.length > 0) { 
			for (String s : args) {
				context += s + " ";
			}
		} else { 
			context = SimpleNGramGenerator.DefaultContext;
		}
		
		NgramServiceFactory factory = NgramServiceFactory.newInstance(SimpleNGramGenerator.Key);
		GenerationService service = factory.newGenerationService();
		List<String> models = service.getModels();
		System.out.println(models);
		//I have used the 2013-12/5 model. Only returns 2 results - see http://weblm.research.microsoft.com/weblm/rest.svc/
		TokenSet tokenSet = service.generate(SimpleNGramGenerator.Key, "bing-body/2013-12/5", context, 5, null);
		System.out.println(tokenSet.getWords());
		List<Double> logProbs = tokenSet.getProbabilities();
		List<Double> probs = new ArrayList<Double>();
				
		System.out.println(logProbs);
		
		for (Double x : logProbs) {
			probs.add(Math.pow(10.0,x));
		}
		System.out.println(probs);
	}
}
