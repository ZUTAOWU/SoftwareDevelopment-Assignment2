/**
 * 
 */
package assign2.gui;

import java.awt.BorderLayout;
import java.awt.Color;

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
import assign2.ngram.NGramNode;
import assign2.ngram.NGramStore;


/**
 * @author ZUTAOWU n8975698
 *
 */

@SuppressWarnings("serial")
public class ChartPanel extends JPanel {

	private CategoryDataset dataset;
	private JFreeChart chart;
	private org.jfree.chart.ChartPanel chartPanel;
	
	public ChartPanel() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true),"Chart Results", TitledBorder.CENTER, TitledBorder.TOP));
		dataset = createDataset();
        chart = createChart(dataset, "test");
        chartPanel = new org.jfree.chart.ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
	}
	
	public void ShowResultChart(NGramContainer node){
		remove(chartPanel);
		dataset = createDataset(node);
        chart = createChart(dataset, "test");
        chartPanel = new org.jfree.chart.ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
	}
	
	public void ShowResultChart(String[] contexts, NGramMap store){
		remove(chartPanel);
		dataset = createDataset(contexts, store);
        chart = createChart(dataset, "test");
        chartPanel = new org.jfree.chart.ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
	}
	
    private  DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        return dataset;
    }
	
	 /**
     * Creates a dataset 
     */
    private  DefaultCategoryDataset createDataset(NGramContainer node) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i = 0 ; i < node.getPredictions().length; i++) {
        	dataset.setValue(node.getProbabilities()[i], node.getContext(), node.getPredictions()[i] );
        }
        return dataset;
    }
    
    private  void addDateToDataset(DefaultCategoryDataset dataset, NGramContainer node) {
    	if(node != null) {
            for(int i = 0 ; i < node.getPredictions().length; i++) {
            	dataset.setValue(node.getProbabilities()[i], node.getContext(), node.getPredictions()[i] );
            }
    	}
    }
    
    private  DefaultCategoryDataset createDataset(String[] contexts, NGramMap store) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(String context : contexts) {
        	addDateToDataset(dataset, store.getNGram(context));
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
