/**
 * 
 * This file is part of the SearchSuggestion Project, written as 
 * part of the assessment for INB370, semester 1, 2014. 
 *
 * BarChart.java
 * assign2.examples.jfreechart
 * 19/04/2014
 * 
 */

package assign2.examples.jfreechart;

import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author hogan
 *
 */
@SuppressWarnings("serial")
public class BarChart extends JFrame {
	
	public BarChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // This will create the dataset 
        CategoryDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);
    }
	
	 /**
     * Creates a sample dataset 
     */
    private  DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(0.13605904897333534, "be or not to", "be");
        dataset.setValue(0.06656263408951493, "be or not to", "mention");
        dataset.setValue(0.032759119479403784, "be or not to", "exceed");
        dataset.setValue(0.028824381687144844, "be or not to", "say");
        dataset.setValue(0.02452364382944196, "be or not to", "the"); 
        dataset.setValue(0.13605904897333534, "singin in the", "rain");
        dataset.setValue(0.06656263408951493, "singin in the", "shower");
        return dataset;
    }
    
    /**
     * Creates a chart
     */
    private JFreeChart createChart(CategoryDataset dataset, String title) {
    	
    	JFreeChart chart = ChartFactory.createBarChart3D(
    		title, 
     		"Phrase _____",
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
