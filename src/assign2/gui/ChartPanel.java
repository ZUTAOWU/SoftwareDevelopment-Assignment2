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

/**
 * @author ZUTAOWU n8975698
 * 
 */

@SuppressWarnings("serial")
public class ChartPanel extends JPanel {

	// Data set to store the data on the chart
	private CategoryDataset dataset;
	// Main bar chart
	private JFreeChart chart;
	// chartPanel is used to hold the chart
	private org.jfree.chart.ChartPanel chartPanel;
	private static final String ChartTitle = "Search Statistics";

	/*
	 * Helper method to insert data into the dataset
	 * @param dataset
	 * @param node
	 */
	private void addDataToDataset(DefaultCategoryDataset dataset,
			NGramContainer node) {
		if (node != null) {
			// for every getPredictions in the node , add probabilities to data
			// set
			for (int i = 0; i < node.getPredictions().length; i++) {
				dataset.setValue(node.getProbabilities()[i], node.getContext(),
						node.getPredictions()[i]);
			}
		}
	}

	/*
	 * Helper method to create an empty data set
	 * @return
	 */
	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		return dataset;
	}

	/*
	 * Creating a data set from a single node
	 * @param node
	 * @return
	 */
	private DefaultCategoryDataset createDataset(NGramContainer node) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < node.getPredictions().length; i++) {
			dataset.setValue(node.getProbabilities()[i], node.getContext(), node.getPredictions()[i]);
		}
		return dataset;
	}

	/*
	 * Creating data set from String[] contexts and NGramMap store in order to
	 * generate characters
	 * @param contexts - context array to hold each context
	 * @param store the - NGramStore that stores all the results
	 * @return DefaultCategoryDataset
	 */
	private DefaultCategoryDataset createDataset(String[] contexts,
			NGramMap store) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (String context : contexts) {
			addDataToDataset(dataset, store.getNGram(context));
		}
		return dataset;
	}

	/*
	 * Creating a chart
	 * @param dataset - Main data shown on the bar chart
	 * @param title - Shown at the top of the bar chart
	 * @return JFreeChart
	 */
	private JFreeChart createChart(CategoryDataset dataset, String title) {
		JFreeChart chart = ChartFactory.createBarChart3D(title, "Phrase:",
				"Probability", dataset, PlotOrientation.VERTICAL, true, false,
				false);
		// Create a JFreeChart
		chart.setBackgroundPaint(Color.LIGHT_GRAY);
		chart.setBorderVisible(true);
		chart.setBorderPaint(Color.BLACK);
		chart.getTitle().setPaint(Color.BLUE);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.red);
		return chart;
	}

	/**
	 * ChartPanel constructor. Setting a borderlayout to the chart panel,
	 * creating a dataset, a chart and stacking it inside the chart panel
	 */
	public ChartPanel() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true),
				"Chart Results", TitledBorder.CENTER, TitledBorder.TOP));
		dataset = createDataset();
		chart = createChart(dataset, ChartTitle);
		chartPanel = new org.jfree.chart.ChartPanel(chart);
		add(chartPanel, BorderLayout.CENTER);
	}

	/**
	 * Displaying a single result of node values on the Chart panel
	 * @param node
	 */
	public void showResultChart(NGramContainer node) {
		remove(chartPanel);
		dataset = createDataset(node);
		chart = createChart(dataset, ChartTitle);
		chartPanel = new org.jfree.chart.ChartPanel(chart);
		add(chartPanel, BorderLayout.CENTER);
	}

	/**
	 * Displaying the results from NGramMap store on the Chart panel
	 * @param contexts - Context array to hold each context
	 * @param store - The NGramStore which stores all the results
	 */
	public void showResultChart(String[] contexts, NGramMap store) {
		remove(chartPanel);
		dataset = createDataset(contexts, store);
		chart = createChart(dataset, ChartTitle);
		chartPanel = new org.jfree.chart.ChartPanel(chart);
		add(chartPanel, BorderLayout.CENTER);
		// Updating the chart panel with the above components
		updateUI();
	}

	/**
	 * Clear all the result on the chart. Creating an empty dataset, a chart and
	 * stacking it inside the chart panel
	 */
	public void clearResultChart() {
		// Creating an empty dataset
		remove(chartPanel);
		dataset = createDataset();
		chart = createChart(dataset, ChartTitle);
		chartPanel = new org.jfree.chart.ChartPanel(chart);
		add(chartPanel, BorderLayout.CENTER);
		// Updating the chart panel with the above components
		updateUI();
	}

}
