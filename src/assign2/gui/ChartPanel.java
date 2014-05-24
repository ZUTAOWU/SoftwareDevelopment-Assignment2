/**
 * 
 */
package assign2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import assign2.ngram.NGramContainer;
import assign2.ngram.NGramMap;

/**
 * @author ZUTAOWU n8975698
 *
 */

@SuppressWarnings("serial")
public class ChartPanel extends JPanel {

	// data set store the chart data
	private CategoryDataset dataset;
	// main bar chart
	private JFreeChart chart;
	// chartPanel is used to hold the chart
	private org.jfree.chart.ChartPanel chartPanel;
	private static final String ChartTitle = "Search Statistics";
    
    /*
     * helper method to insert data to data set
     * @param dataset
     * @param node
     */
    private void addDataToDataset(DefaultCategoryDataset dataset, NGramContainer node) {
    	if(node != null) {
    		// for every getPredictions in the node , add probabilities to data set
            for(int i = 0 ; i < node.getPredictions().length; i++) {
            	dataset.setValue(node.getProbabilities()[i], node.getContext(), node.getPredictions()[i] );
            }
    	}
    }
    
    /*
     * helper method to create empty data set
     * @return
     */
    private  DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        return dataset;
    }
    
    
    /*
     * create data set from single node
     * @param node
     * @return
     */
    private  DefaultCategoryDataset createDataset(NGramContainer node) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i = 0 ; i < node.getPredictions().length; i++) {
        	dataset.setValue(node.getProbabilities()[i], node.getContext(), node.getPredictions()[i] );
        }
        return dataset;
    }
    
    /*
     * create data set from String[] contexts and NGramMap store use to generate char
     * @param contexts - contexts array hold each context 
     * @param store the - NGramStore which store all results
     * @return DefaultCategoryDataset
     */
    private  DefaultCategoryDataset createDataset(String[] contexts, NGramMap store) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(String context : contexts) {
        	addDataToDataset(dataset, store.getNGram(context));
        }
        return dataset;
    }

    /*
     * create Chart
     * @param dataset - main data show on the chart
     * @param title - show on the top
     * @return JFreeChart
     */
    private JFreeChart createChart(CategoryDataset dataset, String title) {
    	JFreeChart chart = ChartFactory.createBarChart3D(
    		title, 
     		"Phrase:",
    		"Probability",
    		dataset, 
    		PlotOrientation.VERTICAL, 
    		true, 
    		false, 
    		false
    	);
    	// create JFreeChart
    	chart.setBackgroundPaint(Color.LIGHT_GRAY);
    	chart.setBorderVisible(true);
    	chart.setBorderPaint(Color.BLACK);
    	chart.getTitle().setPaint(Color.BLUE); 
    	CategoryPlot p = chart.getCategoryPlot(); 
    	p.setRangeGridlinePaint(Color.red); 
        return chart;
    }
	
	/**
	 * CharPanel constructor
	 */
	public ChartPanel() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true),"Chart Results", TitledBorder.CENTER, TitledBorder.TOP));
		dataset = createDataset();
        chart = createChart(dataset, ChartTitle);
        chartPanel = new org.jfree.chart.ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
	}
	
	/**
	 * show the single result from node on the Chart panel
	 * @param node
	 */
	public void showResultChart(NGramContainer node){
		remove(chartPanel);
		dataset = createDataset(node);
        chart = createChart(dataset, ChartTitle);
        chartPanel = new org.jfree.chart.ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
	}
	
	/**
	 * show the results from NGramMap store on the Chart panel
	 * @param contexts - contexts array hold each context 
	 * @param store - the NGramStore which store all results
	 */
	public void showResultChart(String[] contexts, NGramMap store){
		remove(chartPanel);
		dataset = createDataset(contexts, store);
        chart = createChart(dataset, ChartTitle);
        chartPanel = new org.jfree.chart.ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Clear all result on Chart
	 */
	public void clearResultChart() {
		//dataset.
//		chartPanel.remove((Component)chart);
//		remove(chartPanel);
//		System.out.println("clearResultChart!!!");
//		dataset = createDataset();
//        chart = createChart(dataset, ChartTitle);
//        chartPanel = new org.jfree.chart.ChartPanel(chart);
//        add(chartPanel, BorderLayout.CENTER);
	}
	


}
