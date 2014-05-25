/**
 * 
 */
package assign2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import assign2.ngram.NGramException;
import assign2.ngram.NGramNode;
import assign2.ngram.NGramStore;

/**
 * @author ZUTAOWU n8975698
 * 
 */
public class NGramGUI extends JFrame implements ActionListener, Runnable {

	private static final long serialVersionUID = -2419228817448519511L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	// Input field for search text
	private JTextField textSearch;
	// Input field for number of suggestions
	private JTextField suggestionNumber;
	// Bottom panel of the GUI holding the search button
	private JPanel btmPanel;
	private JButton searchButton;
	// Result panel displaying the node results
	private JPanel resultPanel;
	// Chart panel displaying the bar chart results
	private JPanel chartPanel;

	private Thread run;

	private NGramStore ns;

	/*
	 * Creating the GUI
	 */
	private void createGUI() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		createInputAreaGUI();
		createResultGUI();
		createSearchButtonGUI();
	}

	/*
	 * Helper method to create the GUI, creating the search button at the bottom
	 * of the GUI
	 */
	private void createSearchButtonGUI() {
		btmPanel = new JPanel();
		btmPanel.setLayout(new FlowLayout());
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		btmPanel.add(searchButton);
		this.getContentPane().add(btmPanel, BorderLayout.PAGE_END);
	}

	/*
	 * Helper method to create the GUI, creating the result panel and chart
	 * panel on the GUI
	 */
	private void createResultGUI() {
		resultPanel = new ResultPanel();
		this.getContentPane().add(resultPanel, BorderLayout.LINE_START);
		chartPanel = new ChartPanel();
		this.getContentPane().add(chartPanel, BorderLayout.CENTER);
	}

	/*
	 * Helper method to create the GUI, creating input text areas on the GUI for
	 * the search text and the number of suggestions
	 */
	private void createInputAreaGUI() {
		JPanel textPanel = new JPanel();
		textPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true), "NGram Search Engine", TitledBorder.CENTER, TitledBorder.TOP));
		textPanel.setLayout(new FlowLayout());
		textPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JLabel searchLabel = new JLabel("Input search text: ");
		textPanel.add(searchLabel);
		textSearch = new JTextField(20);
		textPanel.add(textSearch);
		JLabel suggestionNumberLabel = new JLabel("Specify the number of suggestions: ");
		textPanel.add(suggestionNumberLabel);

		suggestionNumber = new JTextField(10);
		// set the common number
		suggestionNumber.setText("5");
		textPanel.add(suggestionNumber);

		this.getContentPane().add(textPanel, BorderLayout.PAGE_START);
	}

	/*
	 * Helper method check if string array is valid
	 * 
	 * @param strArr
	 * 
	 * @return - true if string array is valid , false if string array is not
	 * valid
	 */
	private boolean isStrArrayValid(String[] strArr) {
		for (String s : strArr) {
			if (s == null || "".equals(s.trim())) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Helper method to test whether or not the input text is valid for the
	 * NGram suggestion search
	 * 
	 * @param searchText - Test for search suggestions
	 * 
	 * @return string array if search text is valid, split by comma
	 * 
	 * @throws NGramException if input invalid search text
	 */
	private String[] parseInput(String searchText) throws NGramException {
		// check input text using regular expression (REGEX)
		String regularExpresstion = "^[a-zA-Z0-9 ,']+$";
		//
		String[] results = searchText.split(",", -1);
		// String is not valid when
		// 1. This string cannot pass the regular expression (REGEX) test
		// 2. This string array includes null or empty string
		if (searchText.matches(regularExpresstion) && isStrArrayValid(results)) {
			for (int i = 0; i < results.length; i++) {
				results[i] = results[i].trim();
			}
			return results;
		} else {
			throw new NGramException("Please input a valid search text!");
		}
	}

	/*
	 * Helper method to show the result on the GUI
	 * 
	 * @param searchTextArr
	 * 
	 * @param ngramMap
	 * 
	 * @return
	 */
	private String getResult(String[] searchTextArr, NGramStore ngramMap) {
		StringBuffer sb = new StringBuffer();
		for (String s : searchTextArr) {
			// show header
			sb.append("NGram Results for Query: ");
			sb.append(s);
			sb.append("\n\n");
			NGramNode node = (NGramNode) ngramMap.getNGram(s);
			if (node == null) {
				// If this search text does not have any suggestions, then
				// display an error message
				sb.append("No ngram predictions were returned.").append("\n");
				sb.append("Please try another query.").append("\n");
			} else {
				// If this search text has some suggestions, then display them
				sb.append(node.toString());
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		createGUI();
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.pack();
		this.setVisible(true);
	}

	/*
	 * Helper method to search and show the results on GUI
	 * 
	 * @param seachNumber - Search for number of results
	 * 
	 * @param searchTextArr - Search for number of suggestions
	 */
	private void searchAndShowResult(final Integer seachNumber, final String[] searchTextArr) {
		// Use LinkedHashSet to ensure there are no duplicated texts to search
		Set<String> mySet = new LinkedHashSet<String>(Arrays.asList(searchTextArr));
		((ResultPanel) resultPanel).clearResult();
		((ChartPanel) chartPanel).clearResultChart();
		for (String s : mySet) {
			try {
				// For each search text, get the number of suggestions from the
				// NGram search engine
				ns.getNGramsFromService(s, seachNumber);
			} catch (NGramException e1) {
				// If a correct result is not retrieved from the NGramService,
				// then show the warning
				JOptionPane.showMessageDialog(this, "Please input valid search texts!");
				// e1.printStackTrace();
				return;
			}

		}
		// System.out.println(ns);
		String resultStr = getResult(mySet.toArray(new String[mySet.size()]), ns);
		// Display the results on the GUI from the store
		((ResultPanel) resultPanel).showResultText(resultStr);
		// Display the result on the bar chart from the NGram search engine
		((ChartPanel) chartPanel).showResultChart(searchTextArr, ns);
	}

	/*
	 * Disabling the text areas and button components on the GUI, after completion of search
	 */
	private void disableComponent() {
		searchButton.setText("Searching...");
		searchButton.setEnabled(false);
		textSearch.setEnabled(false);
		suggestionNumber.setEnabled(false);
	}

	/*
	 * Enabling the text areas and button components on the GUI, after completion of search
	 */
	private void EnableComponent() {
		searchButton.setText("Search");
		searchButton.setEnabled(true);
		textSearch.setEnabled(true);
		suggestionNumber.setEnabled(true);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();

		if (buttonString.equals("Search")) {
			String searchText = textSearch.getText();
			String searchNumberStr = suggestionNumber.getText();

			// Getting the search number input and Validating it
			final Integer seachNumber;
			try {
				seachNumber = Integer.valueOf(searchNumberStr);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Please input a valid number (strictly greater than zero without decimal points)!");
				// e1.printStackTrace();
				return;
			}
			
			if(seachNumber <= 0) {
				JOptionPane.showMessageDialog(this, "Please input a valid number (strictly greater than zero without decimal points)!");
				return;
			}

			// Getting the search text input and Validating it
			final String[] searchTextArr;
			try {
				searchTextArr = parseInput(searchText);
			} catch (Exception e1) {
				// If input string is invalid , then displaying the warning message
				JOptionPane.showMessageDialog(this, "Please input valid search texts!");
				// e1.printStackTrace();
				return;
			}

			ns = new NGramStore();

			// Opening a new thread to handle the suggestion searching processing
			run = new Thread() {
				@Override
				public void run() {
					// During search, disabling the GUI components i.e., the text areas and button
					disableComponent();
					searchAndShowResult(seachNumber, searchTextArr);
					// After searching, enabling all the GUI components
					EnableComponent();
				}
			};
			run.start();
		}
	}

}
