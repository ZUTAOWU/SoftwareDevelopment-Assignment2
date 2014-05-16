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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * @author ZUTAOWU n8975698
 * 
 */
public class ResultPanel extends JPanel {

	private static final long serialVersionUID = 1937556717072963711L;
	// private static final int CENTER = 0;

	private JTextArea resultDisplay;
	JScrollPane scrollPane;
	//private StringBuffer resultText;
	public ResultPanel() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true),"Suggestion Results", TitledBorder.CENTER, TitledBorder.TOP));
		resultDisplay = new JTextArea("");
		
		resultDisplay.setEditable(false);
		
		//resultText = new StringBuffer();
		scrollPane = new JScrollPane(resultDisplay,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(300,HEIGHT));
		//scrollPane.setBounds(10,60,780,500);
		//scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
//	public void addResultText(String searchText, String searchResult) {
////		resultText.append("NGram Results for Query: ");
////		resultText.append("searchText");
////		resultText.append("\n\n");
//		resultText.append(searchResult);
//		resultText.append("\n");
//	}

	public void showResultText(String searchResult) {
		
		StringBuffer resultText = new StringBuffer();
		resultText.append(searchResult);
		resultText.append("\n");
		resultDisplay.setText(resultText.toString());

		//resultText = new StringBuffer();
		//this.remove(scrollPane);
		//scrollPane = new JScrollPane(resultDisplay);
		//scrollPane.setBounds(10,60,780,500);
		//scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//this.add(scrollPane, BorderLayout.CENTER);
		
	}



}
