/**
 * 
 */
package assign2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;
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

	public ResultPanel() {
		setLayout(new BorderLayout());
		this.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1, true),"Suggestion Results", TitledBorder.CENTER, TitledBorder.TOP));
		resultDisplay = new JTextArea("This is a default text message");
		resultDisplay.setPreferredSize(new Dimension(300,HEIGHT));
		this.add(resultDisplay, BorderLayout.CENTER);
		// setBackground(Color.BLACK);

	}

	public void showResultText(String result) {
		resultDisplay.setText(result);
	}



}
