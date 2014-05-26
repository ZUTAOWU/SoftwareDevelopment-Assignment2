/**
 * 
 */
package assign2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * @author ZUTAOWU n8975698
 * 
 */
@SuppressWarnings("serial")
public class ResultPanel extends JPanel {

	private JTextArea resultDisplay;
	JScrollPane scrollPane;
	
	/**
	 * ResultPanel hold the JTextArea which show the search result
	 */
	public ResultPanel() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true),"Results", TitledBorder.CENTER, TitledBorder.TOP));
		resultDisplay = new JTextArea("");
		resultDisplay.setEditable(false);
		// user scrollPane to hold resultDisplay to adapt for long text
		scrollPane = new JScrollPane(resultDisplay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(300,HEIGHT));
		this.add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * this method is used for showing the search result
	 * @param searchResult
	 */
	public void showResultText(String searchResult) {
		StringBuffer resultText = new StringBuffer();
		resultText.append(searchResult);
		resultDisplay.setText(resultText.toString());
		// update this panel
		updateUI();
	}
	
	/**
	 * clear all the result on result panel
	 */
	public void clearResult(){
		resultDisplay.setText("");
		// update this panel
		updateUI();
	}



}
