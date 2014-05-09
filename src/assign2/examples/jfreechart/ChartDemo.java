/**
 * 
 * This file is part of the SearchSuggestion Project, written as 
 * part of the assessment for INB370, semester 1, 2014. 
 *
 * ChartDemo.java
 * assign2.examples.jfreechart
 * 19/04/2014
 * 
 */
package assign2.examples.jfreechart;

import javax.swing.JFrame;

/**
 * @author hogan
 *
 */
public class ChartDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 BarChart bar = new BarChart("Chart Demo","5-grams");
		 bar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 bar.pack();
		 bar.setVisible(true);
	}

}
