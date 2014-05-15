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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
	private static final int WIDTH = 600;
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
        JButton searchButton = new JButton("Search Suggestion");
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
		textPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true),"Input text to search", TitledBorder.CENTER, TitledBorder.TOP));
		
		textPanel.setLayout(new FlowLayout());
		textPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JLabel searchLabel = new JLabel("Input Seach String: ");
		textPanel.add(searchLabel);
		
		textSearch = new JTextField(20);
		textPanel.add(textSearch);
		
		JLabel suggestionNumberLabel = new JLabel("suggestion Number: ");
		textPanel.add(suggestionNumberLabel);

		suggestionNumber = new JTextField(10);
		suggestionNumber.setText("5");
		textPanel.add(suggestionNumber);
		
        this.getContentPane().add(textPanel, BorderLayout.PAGE_START);
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

		if (buttonString.equals("Search Suggestion")) {
			String searchText = "";
			searchText = textSearch.getText();
			if ("".equals(searchText)) {
				JOptionPane.showMessageDialog(this,"Input something to search!");
			} else {
				NGramStore ns = new NGramStore();
				try {
					ns.getNGramsFromService(searchText, 5);
					((ResultPanel) resultPanel).showResultText(ns.toString());

					((ChartPanel) chartPanel).ShowResultChart((NGramNode) ns
							.getNGram(searchText));
				} catch (NGramException e1) {
					e1.printStackTrace();
				}
			}

		}
	}
	


}
