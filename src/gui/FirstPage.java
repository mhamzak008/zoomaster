package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FirstPage extends JPanel {
	static JLabel mainBackground;
	static JButton backButton,prevButton,nextButton,btnSearch,btnSearch2,btnSearch3,btnSearch4,btnSearch5,btnSearch6;
	static JTextField textField;
	static JTextField[] textField_ = new JTextField[6];
	static JButton btnNewButton;
	static String[] totRes;
	static int[] totID;
	static int page = 1;
	static int size;
	static int currentID;
	static int comboBoxNo = 0;
	static int currentPage;
	static JLabel lblNewLabel;
	/**
	 * Create the panel.
	 */
	public FirstPage() {
		
		setBounds(0, 0, 1448, 886);																							
		setLayout(null);

		
		btnSearch = new JButton("Info");																					
		btnSearch.setFocusPainted(false);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch.setFont(new Font("Chalkduster", Font.BOLD, 37));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorder(null);
		btnSearch.setBounds(86, 190, 225, 80);
		btnSearch.setToolTipText("Information about the Search");
		add(btnSearch);
		
		btnSearch2 = new JButton("Info");																					
		btnSearch2.setFocusPainted(false);
		btnSearch2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch2.setFont(new Font("Chalkduster", Font.BOLD, 37));
		btnSearch2.setForeground(Color.WHITE);
		btnSearch2.setContentAreaFilled(false);
		btnSearch2.setBorder(null);
		btnSearch2.setBounds(86, 290, 225, 80);
		btnSearch2.setToolTipText("Information about the Search");
		add(btnSearch2);
		
		btnSearch3 = new JButton("Info");																					
		btnSearch3.setFocusPainted(false);
		btnSearch3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch3.setFont(new Font("Chalkduster", Font.BOLD, 37));
		btnSearch3.setForeground(Color.WHITE);
		btnSearch3.setContentAreaFilled(false);
		btnSearch3.setBorder(null);
		btnSearch3.setBounds(86, 390, 225, 80);
		btnSearch3.setToolTipText("Information about the Search");
		add(btnSearch3);
		
		btnSearch4 = new JButton("Info");																					
		btnSearch4.setFocusPainted(false);
		btnSearch4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch4.setFont(new Font("Chalkduster", Font.BOLD, 37));
		btnSearch4.setForeground(Color.WHITE);
		btnSearch4.setContentAreaFilled(false);
		btnSearch4.setBorder(null);
		btnSearch4.setBounds(86, 490, 225, 80);
		btnSearch4.setToolTipText("Information about the Search");
		add(btnSearch4);
		
		btnSearch5 = new JButton("Info");																					
		btnSearch5.setFocusPainted(false);
		btnSearch5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch5.setFont(new Font("Chalkduster", Font.BOLD, 37));
		btnSearch5.setForeground(Color.WHITE);
		btnSearch5.setContentAreaFilled(false);
		btnSearch5.setBorder(null);
		btnSearch5.setBounds(86, 590, 225, 80);
		btnSearch5.setToolTipText("Information about the Search");
		add(btnSearch5);
		
		btnSearch6 = new JButton("Info");																					
		btnSearch6.setFocusPainted(false);
		btnSearch6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch6.setFont(new Font("Chalkduster", Font.BOLD, 37));
		btnSearch6.setForeground(Color.WHITE);
		btnSearch6.setContentAreaFilled(false);
		btnSearch6.setBorder(null);
		btnSearch6.setBounds(86, 690, 225, 80);
		btnSearch6.setToolTipText("Information about the Search");
		add(btnSearch6);
		
		
		
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField.setBounds(569, 86, 621, 63);
		textField.setFont(new Font("Chalkduster", Font.BOLD, 30));
		textField.setForeground(Color.BLACK);
		
		add(textField);
		textField.setColumns(10);
		
		// Back Button
		backButton = new JButton();																								
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBounds(1364, 13, 58, 58);
		backButton.setToolTipText("Click to go back Main Menu");
		add(backButton);
		
		prevButton = new JButton();																								
		prevButton.setFocusPainted(false);
		prevButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		prevButton.setIconTextGap(0);
		prevButton.setContentAreaFilled(false);
		prevButton.setBorder(null);
		prevButton.setBounds(666, 780, 58, 58);
		prevButton.setToolTipText("Click to go previous results");
		add(prevButton);
		
		nextButton = new JButton();																								
		nextButton.setFocusPainted(false);
		nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextButton.setIconTextGap(0);
		nextButton.setContentAreaFilled(false);
		nextButton.setBorder(null);
		nextButton.setBounds(944, 780, 58, 58);
		nextButton.setToolTipText("Click to go next results");
		add(nextButton);
		// Background Image
		
		textField_[0] = new JTextField();
		textField_[0].setText("");
		textField_[0].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[0].setForeground(Color.BLACK);
		textField_[0].setFont(new Font("Dialog", Font.BOLD, 30));
		textField_[0].setColumns(10);
		textField_[0].setBounds(337, 193, 1043, 80);
		add(textField_[0]);
		
		textField_[1] = new JTextField();
		textField_[1].setText("");
		textField_[1].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[1].setForeground(Color.BLACK);
		textField_[1].setFont(new Font("Dialog", Font.BOLD, 30));
		textField_[1].setColumns(10);
		textField_[1].setBounds(337, 290, 1043, 80);
		add(textField_[1]);
		
		textField_[2] = new JTextField();
		textField_[2].setText("");
		textField_[2].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[2].setForeground(Color.BLACK);
		textField_[2].setFont(new Font("Dialog", Font.BOLD, 30));
		textField_[2].setColumns(10);
		textField_[2].setBounds(337, 390, 1043, 80);
		add(textField_[2]);
		
		textField_[3] = new JTextField();
		textField_[3].setText("");
		textField_[3].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[3].setForeground(Color.BLACK);
		textField_[3].setFont(new Font("Dialog", Font.BOLD, 30));
		textField_[3].setColumns(10);
		textField_[3].setBounds(337, 490, 1043, 80);
		add(textField_[3]);
		
		textField_[4] = new JTextField();
		textField_[4].setText("");
		textField_[4].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[4].setForeground(Color.BLACK);
		textField_[4].setFont(new Font("Dialog", Font.BOLD, 30));
		textField_[4].setColumns(10);
		textField_[4].setBounds(337, 590, 1043, 80);
		add(textField_[4]);
		
		textField_[5] = new JTextField();
		textField_[5].setText("");
		textField_[5].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[5].setForeground(Color.BLACK);
		textField_[5].setFont(new Font("Dialog", Font.BOLD, 30));
		textField_[5].setColumns(10);
		textField_[5].setBounds(337, 690, 1043, 80);
		add(textField_[5]);
		
		
		lblNewLabel = new JLabel("-/-");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(737, 784, 191, 54);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Chalkduster", Font.BOLD, 33));
		add(lblNewLabel);
		
		
		btnNewButton = new JButton("Search");
		btnNewButton.setBounds(1195, 87, 181, 63);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 30));
		add(btnNewButton);
		

		mainBackground = new JLabel("");																					
		mainBackground.setBounds(0, 0, 1448, 886);
		mainBackground.setHorizontalAlignment(SwingConstants.CENTER);
		add(mainBackground);
		try {				
			
			btnSearch.setRolloverIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/rollbutton2.png")));		//Start button icon when mouse entered 
			btnSearch.setIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/button2.png")));	
			btnSearch2.setRolloverIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/rollbutton2.png")));		//Start button icon when mouse entered 
			btnSearch2.setIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/button2.png")));
			btnSearch3.setRolloverIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/rollbutton2.png")));		//Start button icon when mouse entered 
			btnSearch3.setIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/button2.png")));
			btnSearch4.setRolloverIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/rollbutton2.png")));		//Start button icon when mouse entered 
			btnSearch4.setIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/button2.png")));
			btnSearch5.setRolloverIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/rollbutton2.png")));		//Start button icon when mouse entered 
			btnSearch5.setIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/button2.png")));
			btnSearch6.setRolloverIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/rollbutton2.png")));		//Start button icon when mouse entered 
			btnSearch6.setIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/button2.png")));
			backButton.setRolloverIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/backbutton.png")));
			prevButton.setRolloverIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/rollbackbutton.png")));
			prevButton.setIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/backbutton.png")));
			nextButton.setRolloverIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/rollforwbutton.png")));
			nextButton.setIcon(new ImageIcon(FirstPage.class.getResource("/Buttons/forwbutton.png")));
			mainBackground.setIcon(new ImageIcon(FirstPage.class.getResource("/Background/Background2.jpg")));
				
		}catch (NullPointerException e2) {
		}
	}
}
