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
	
	private JPanel btmPanel;
	private JTextField textSearch;
	private JTextField suggestionNumber;
	
	private JPanel resultPanel;
	private JPanel chartPanel;
	
	private void createGUI() {
		setSize(WIDTH, HEIGHT);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout());
        createInputAreaGUI();
        createResultGUI();
        createSearchButtonGUI();
	}

	/**
	 * 
	 */
	private void createSearchButtonGUI() {
		btmPanel = new JPanel();
        btmPanel.setLayout(new FlowLayout());
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
	    btmPanel.add(searchButton);
        this.getContentPane().add(btmPanel, BorderLayout.PAGE_END);
	}

	/**
	 * 
	 */
	private void createResultGUI() {
		resultPanel = new ResultPanel();
        this.getContentPane().add(resultPanel, BorderLayout.LINE_START);
        chartPanel = new ChartPanel();
        this.getContentPane().add(chartPanel, BorderLayout.CENTER);
	}

	/**
	 * 
	 */
	private void createInputAreaGUI() {
		JPanel textPanel = new JPanel(); 
		textPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true),"Ngram Search Engine", TitledBorder.CENTER, TitledBorder.TOP));
		textPanel.setLayout(new FlowLayout());
		textPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JLabel searchLabel = new JLabel("Input search text: ");
		textPanel.add(searchLabel);
		textSearch = new JTextField(20);
		textPanel.add(textSearch);
		JLabel suggestionNumberLabel = new JLabel("Specify the number of suggestions: ");
		textPanel.add(suggestionNumberLabel);

		suggestionNumber = new JTextField(10);
		suggestionNumber.setText("5");
		textPanel.add(suggestionNumber);
		
        this.getContentPane().add(textPanel, BorderLayout.PAGE_START);
	}
	
	private String[] parseInput(String searchText) throws NGramException {
		String regularExpresstion = "^[a-zA-Z0-9 ,']+$";
		if(searchText.matches(regularExpresstion)) {
			String[] results = searchText.split(",");
			for(int i = 0 ; i < results.length ; i++) {
				results[i] = results[i].trim();
			}
			return results;
		} else {
			throw new NGramException("Please input a valid search text!");
		}
	}
	
	private String getResult(String[] searchTextArr, NGramStore ngramMap) {
		StringBuffer sb = new StringBuffer();
		for (String s : searchTextArr) {
			sb.append("NGram Results for Query: ");
			sb.append(s);
			sb.append("\n\n");
			NGramNode node = (NGramNode) ngramMap.getNGram(s);
			if (node == null) {
				sb.append("No ngram predictions were returned.").append("\n");
				sb.append("Please try another query.").append("\n");
			} else {
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
	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();

		if (buttonString.equals("Search")) {
			String searchText = textSearch.getText();
			String searchNumberStr = suggestionNumber.getText();

			Integer seachNumber = null;
			try {
				seachNumber = Integer.valueOf(searchNumberStr);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Please input a valid number for search!");
				e1.printStackTrace();
				return;
			}

			
			String[] searchTextArr = null;
			try {
				searchTextArr = parseInput(searchText);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Please input valid search texts!");
				e1.printStackTrace();
				return;
			}
			
			Set<String> mySet = new LinkedHashSet<String>(Arrays.asList(searchTextArr));

			NGramStore ns = new NGramStore();
			for (String s : mySet) {
				try {
					ns.getNGramsFromService(s, seachNumber);
				} catch (NGramException e1) {
					JOptionPane.showMessageDialog(this, "Please input valid search texts!");
					e1.printStackTrace();
					return;
				}
			}
			((ResultPanel) resultPanel).showResultText(getResult(mySet.toArray(new String[mySet.size()]), ns));
			((ChartPanel) chartPanel).ShowResultChart(searchTextArr,ns);
			chartPanel.updateUI();
			System.out.println(ns);
		}
	}
	


}
