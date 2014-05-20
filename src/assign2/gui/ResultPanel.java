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
public class ResultPanel extends JPanel {

	private static final long serialVersionUID = 1937556717072963711L;
	private JTextArea resultDisplay;
	JScrollPane scrollPane;
	public ResultPanel() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true),"Results", TitledBorder.CENTER, TitledBorder.TOP));
		resultDisplay = new JTextArea("");
		resultDisplay.setEditable(false);
		scrollPane = new JScrollPane(resultDisplay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(300,HEIGHT));
		this.add(scrollPane, BorderLayout.CENTER);
	}

	public void showResultText(String searchResult) {
		StringBuffer resultText = new StringBuffer();
		resultText.append(searchResult);
		resultText.append("\n");
		resultDisplay.setText(resultText.toString());
	}



}
