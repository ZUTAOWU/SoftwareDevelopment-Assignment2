/**
 * 
 */
package assign2.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import assign2.ngram.NGramNode;


/**
 * @author ZUTAOWU n8975698
 *
 */

@SuppressWarnings("serial")
public class ChartPanel extends JPanel {

	private CategoryDataset dataset;
	private JFreeChart chart;
	private org.jfree.chart.ChartPanel myChart;
	public ChartPanel() {
		setLayout(new BorderLayout());
		dataset = createDataset();
        chart = createChart(dataset, "test");
        myChart = new org.jfree.chart.ChartPanel(chart);
        add(myChart, BorderLayout.CENTER);
	}
	
	public void ShowResultChart(NGramNode node){
		remove(myChart);
		dataset = createDataset(node);
        chart = createChart(dataset, "test");
        myChart = new org.jfree.chart.ChartPanel(chart);
        add(myChart, BorderLayout.CENTER);
	}
	
    private  DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        return dataset;
    }
	
	 /**
     * Creates a sample dataset 
     */
    private  DefaultCategoryDataset createDataset(NGramNode node) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i = 0 ; i < node.getPredictions().length; i++) {
        	dataset.setValue(node.getProbabilities()[i], node.getContext(), node.getPredictions()[i] );
        }
        return dataset;
    }
    
    /**
     * Creates a chart
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
    	
    	chart.setBackgroundPaint(Color.LIGHT_GRAY);
    	chart.setBorderVisible(true);
    	chart.setBorderPaint(Color.BLACK);
    	chart.getTitle().setPaint(Color.BLUE); 
    	CategoryPlot p = chart.getCategoryPlot(); 
    	p.setRangeGridlinePaint(Color.red); 
    			
        return chart;
    }

}
