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
/**
 * @author ZUTAOWU n8975698
 *
 */
public class NGramGUI extends JFrame implements ActionListener, Runnable {

	private static final long serialVersionUID = -2419228817448519511L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	

	// input field of test search
	private JTextField textSearch;
	// input field of suggestion number 
	private JTextField suggestionNumber;
	// bottom panel hold the search button
	private JPanel btmPanel;
	private JButton searchButton;
	// result panel show the result
	private JPanel resultPanel;
	// chart panel show the bar chart result 
	private JPanel chartPanel;
	
	private Thread run;
	
	private NGramStore ns;
	/*
	 * createGUI
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
	 * helper method to create GUI, create the search button at the bottom on the GUI
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
	 * helper method to create GUI, create the result panel and char panel on the GUI
	 */
	private void createResultGUI() {
		resultPanel = new ResultPanel();
        this.getContentPane().add(resultPanel, BorderLayout.LINE_START);
        chartPanel = new ChartPanel();
        this.getContentPane().add(chartPanel, BorderLayout.CENTER);
	}

	/*
	 * helper method to create GUI, create the Input Area on the GUI
	 */
	private void createInputAreaGUI() {
		JPanel textPanel = new JPanel(); 
		textPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true),"NGram Search Engine", TitledBorder.CENTER, TitledBorder.TOP));
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
	 * a helper method to test is the input text is valid for the NGram suggestion Search
	 * @param searchText - the test for search suggestion
	 * @return string array if search text is valid, split by comma 
	 * @throws NGramException if input invalid search text
	 */
	private String[] parseInput(String searchText) throws NGramException {
		// check input text using regular expression
		String regularExpresstion = "^[a-zA-Z0-9 ,']+$";
		if(searchText.matches(regularExpresstion)) {
			// if it is valid input string , then split by comma
			String[] results = searchText.split(",");
			for(int i = 0 ; i < results.length ; i++) {
				results[i] = results[i].trim();
			}
			return results;
		} else {
			throw new NGramException("Please input a valid search text!");
		}
	}
	
	
	/*
	 * a helper method to show the result on the GUI
	 * @param searchTextArr
	 * @param ngramMap
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
				// if this text do not have any suggestion, then out put error message
				sb.append("No ngram predictions were returned.").append("\n");
				sb.append("Please try another query.").append("\n");
			} else {
				// if this text have some suggestion, then output them
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
		this.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		this.pack();
		this.setVisible(true);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String buttonString = e.getActionCommand();
//
//		if (buttonString.equals("Search")) {
//			String searchText = textSearch.getText();
//			String searchNumberStr = suggestionNumber.getText();
//
//			// get search number and validation
//			Integer seachNumber = null;
//			try {
//				seachNumber = Integer.valueOf(searchNumberStr);
//			} catch (Exception e1) {
//				JOptionPane.showMessageDialog(this, "Please input a valid number for search!");
//				e1.printStackTrace();
//				return;
//			}
//
//			// get search texts and validation
//			String[] searchTextArr = null;
//			try {
//				searchTextArr = parseInput(searchText);
//			} catch (Exception e1) {
//				// if input string is invalid , then show the warning
//				JOptionPane.showMessageDialog(this, "Please input valid search texts!");
//				e1.printStackTrace();
//				return;
//			}
//			
//			// use LinkedHashSet to ensure there are no duplicated texts to search
//			Set<String> mySet = new LinkedHashSet<String>(Arrays.asList(searchTextArr));
//			NGramStore ns = new NGramStore();
//			for (String s : mySet) {
//				try {
//					// for each search text, get suggestions from NGram services
//					ns.getNGramsFromService(s, seachNumber); 
//				} catch (NGramException e1) {
//					// if can not get correct result from NGramService, then show the warning  
//					JOptionPane.showMessageDialog(this, "Please input valid search texts!");
//					e1.printStackTrace();
//					return;
//				}
//			}
//			
//			// show all the result on GUI from the store
//			String resultStr = getResult(mySet.toArray(new String[mySet.size()]), ns);
//			((ResultPanel) resultPanel).showResultText(resultStr);
//			// show the result by bar chart
//			((ChartPanel) chartPanel).ShowResultChart(searchTextArr,ns);
//			
//			// update the result panel
//			resultPanel.updateUI();
//			chartPanel.updateUI();
//			System.out.println(ns);
//		}
//	}
	
	/*
	 * @param seachNumber
	 * @param searchTextArr
	 */
	private void searchAndShowResult(final Integer seachNumber, final String[] searchTextArr) {
		// use LinkedHashSet to ensure there are no duplicated texts to search
		//final Set<String> mySet = new LinkedHashSet<String>(Arrays.asList(searchTextArr));
		Set<String> mySet = new LinkedHashSet<String>(Arrays.asList(searchTextArr));
		((ResultPanel) resultPanel).clearResult();
		((ChartPanel) chartPanel).clearResultChart();
		for (String s : mySet) {
			try {
				// for each search text, get suggestions from NGram services
				ns.getNGramsFromService(s, seachNumber); 
			} catch (NGramException e1) {
				// if can not get correct result from NGramService, then show the warning  
				//JOptionPane.showMessageDialog(this, "Please input valid search texts!");
				e1.printStackTrace();
				return;
			}
			
		}
		System.out.println(ns);
		// show all the result on GUI from the store
		String resultStr = getResult(mySet.toArray(new String[mySet.size()]), ns);
		((ResultPanel) resultPanel).showResultText(resultStr);
		// show the result by bar chart
		((ChartPanel) chartPanel).showResultChart(searchTextArr,ns);
		// update the result panel
		resultPanel.updateUI();
		chartPanel.updateUI();
	}
	
	private void disableComponent() {
		searchButton.setText("Searching");
		searchButton.setEnabled(false);
		textSearch.setEnabled(false);
		suggestionNumber.setEnabled(false);
	}
	
	private void EnableComponent() {
		searchButton.setText("Search");
		searchButton.setEnabled(true);
		textSearch.setEnabled(true);
		suggestionNumber.setEnabled(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();

		if (buttonString.equals("Search")) {
			String searchText = textSearch.getText();
			String searchNumberStr = suggestionNumber.getText();

			// get search number and validation
			final Integer seachNumber;
			try {
				seachNumber = Integer.valueOf(searchNumberStr);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Please input a valid number for search!");
				e1.printStackTrace();
				return;
			}

			// get search texts and validation
			final String[] searchTextArr;
			try {
				searchTextArr = parseInput(searchText);
			} catch (Exception e1) {
				// if input string is invalid , then show the warning
				JOptionPane.showMessageDialog(this, "Please input valid search texts!");
				e1.printStackTrace();
				return;
			}
			
			ns = new NGramStore();
			run = new Thread() {
				@Override
				public void run() {
					disableComponent();
					searchAndShowResult(seachNumber, searchTextArr);
					EnableComponent();
				}
			};
			run.start();
		}
	}
	


}
