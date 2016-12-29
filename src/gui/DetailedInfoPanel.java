package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class DetailedInfoPanel extends JPanel {
	JLabel mainBackground;
	static JButton backButton,btnSearch;
	static JTextField txtAuthorNamemiddleNamesurname;
	private JLabel txtName;
	private JLabel lblPseu;
	private JLabel lblBirthplace;
	private JLabel lblEmail;
	static JTextField txtPseudonym;
	private JLabel lblDeathdate;
	private JLabel lblImageLink;
	private JLabel lblLanguage;
	static JTextField txtLausanne;
	static JTextField textField_2;
	static JTextField txtAsdasdasdasdgmailcom;
	static JTextField txtDasdasgasgasgasgas;
	static JTextField txtEnglish;
	/**
	 * Create the panel.
	 */
	public DetailedInfoPanel() {
		
		setBounds(0, 0, 1448, 886);																							
		setLayout(null);
		
		txtName = new JLabel();
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		//txtName.setBackground(UIManager.getColor("Button.background"));
		txtName.setText("Name:");
		txtName.setFont(new Font("Chalkduster", Font.BOLD, 40));
		txtName.setForeground(new Color(255, 0, 51));
		txtName.setBounds(92, 174, 137, 63);
		add(txtName);
		
		txtAuthorNamemiddleNamesurname = new JTextField();
		txtAuthorNamemiddleNamesurname.setHorizontalAlignment(SwingConstants.LEFT);
		txtAuthorNamemiddleNamesurname.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtAuthorNamemiddleNamesurname.setBounds(237, 177, 529, 63);
		txtAuthorNamemiddleNamesurname.setFont(new Font("Chalkduster", Font.BOLD, 30));
		txtAuthorNamemiddleNamesurname.setForeground(Color.BLACK);
		txtAuthorNamemiddleNamesurname.setText("");
		
		add(txtAuthorNamemiddleNamesurname);
		txtAuthorNamemiddleNamesurname.setColumns(10);
		
		// Back Button
		backButton = new JButton();																								
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		//backButton.addActionListener(new SearchPanelListener());
		backButton.setBounds(1364, 13, 58, 58);
		backButton.setToolTipText("Click to go back Main Menu");
		add(backButton);
		
		lblPseu = new JLabel();
		lblPseu.setText("Country of Origin:");
		lblPseu.setHorizontalAlignment(SwingConstants.LEFT);
		lblPseu.setForeground(new Color(255, 0, 51));
		lblPseu.setFont(new Font("Dialog", Font.BOLD, 40));
		lblPseu.setBounds(92, 265, 392, 63);
		add(lblPseu);
		
		lblBirthplace = new JLabel();
		lblBirthplace.setText("Latin Name:");
		lblBirthplace.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthplace.setForeground(new Color(255, 0, 51));
		lblBirthplace.setFont(new Font("Dialog", Font.BOLD, 40));
		lblBirthplace.setBounds(92, 356, 262, 63);
		add(lblBirthplace);
		
		lblEmail = new JLabel();
		lblEmail.setText("Feeding Time:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(new Color(255, 0, 51));
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 40));
		lblEmail.setBounds(92, 447, 282, 63);
		add(lblEmail);
		
		// Background Image
		mainBackground = new JLabel("");																					
		mainBackground.setHorizontalAlignment(SwingConstants.CENTER);
		mainBackground.setBounds(0, 0, 1448, 886);
		
		btnSearch = new JButton("Delete");																					
		btnSearch.setFocusPainted(false);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch.setFont(new Font("Chalkduster", Font.BOLD, 37));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorder(null);
		btnSearch.setBounds(633, 692, 225, 80);
		//btnSearch.addActionListener(new SearchPanelListener());
		btnSearch.setToolTipText("Information about the Search");
		add(btnSearch);
		
		txtPseudonym = new JTextField();
		txtPseudonym.setHorizontalAlignment(SwingConstants.LEFT);
		txtPseudonym.setForeground(Color.BLACK);
		txtPseudonym.setFont(new Font("Dialog", Font.BOLD, 30));
		txtPseudonym.setColumns(10);
		txtPseudonym.setBounds(450, 268, 470, 63);
		add(txtPseudonym);
		
		lblDeathdate = new JLabel();
		lblDeathdate.setText("Gender:");
		lblDeathdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeathdate.setForeground(new Color(255, 0, 51));
		lblDeathdate.setFont(new Font("Dialog", Font.BOLD, 40));
		lblDeathdate.setBounds(714, 356, 239, 63);
		add(lblDeathdate);
		
		lblImageLink = new JLabel();
		lblImageLink.setText("Age:");
		lblImageLink.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageLink.setForeground(new Color(255, 0, 51));
		lblImageLink.setFont(new Font("Dialog", Font.BOLD, 40));
		lblImageLink.setBounds(92, 538, 118, 63);
		add(lblImageLink);
		
		lblLanguage = new JLabel();
		lblLanguage.setText("Does Hibernate or Light Time:");
		lblLanguage.setHorizontalAlignment(SwingConstants.LEFT);
		lblLanguage.setForeground(new Color(255, 0, 51));
		lblLanguage.setFont(new Font("Dialog", Font.BOLD, 40));
		lblLanguage.setBounds(92, 629, 606, 63);
		add(lblLanguage);
		
		txtLausanne = new JTextField();
		txtLausanne.setHorizontalAlignment(SwingConstants.LEFT);
		txtLausanne.setForeground(Color.BLACK);
		txtLausanne.setFont(new Font("Dialog", Font.BOLD, 30));
		txtLausanne.setColumns(10);
		txtLausanne.setBounds(394, 359, 253, 63);
		add(txtLausanne);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Dialog", Font.BOLD, 30));
		textField_2.setColumns(10);
		textField_2.setBounds(963, 359, 190, 63);
		add(textField_2);
		
		txtAsdasdasdasdgmailcom = new JTextField();
		txtAsdasdasdasdgmailcom.setHorizontalAlignment(SwingConstants.LEFT);
		txtAsdasdasdasdgmailcom.setForeground(Color.BLACK);
		txtAsdasdasdasdgmailcom.setFont(new Font("Dialog", Font.BOLD, 30));
		txtAsdasdasdasdgmailcom.setColumns(10);
		txtAsdasdasdasdgmailcom.setBounds(414, 450, 529, 63);
		add(txtAsdasdasdasdgmailcom);
		
		txtDasdasgasgasgasgas = new JTextField();
		txtDasdasgasgasgasgas.setHorizontalAlignment(SwingConstants.LEFT);
		txtDasdasgasgasgasgas.setForeground(Color.BLACK);
		txtDasdasgasgasgasgas.setFont(new Font("Dialog", Font.BOLD, 30));
		txtDasdasgasgasgasgas.setColumns(10);
		txtDasdasgasgasgasgas.setBounds(196, 541, 447, 63);
		add(txtDasdasgasgasgasgas);
		
		txtEnglish = new JTextField();
		txtEnglish.setHorizontalAlignment(SwingConstants.LEFT);
		txtEnglish.setForeground(Color.BLACK);
		txtEnglish.setFont(new Font("Dialog", Font.BOLD, 30));
		txtEnglish.setColumns(10);
		txtEnglish.setBounds(685, 629, 266, 63);
		add(txtEnglish);
		
		JLabel lblNewAuthor = new JLabel();
		lblNewAuthor.setText("SPECIES");
		lblNewAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewAuthor.setForeground(new Color(255, 0, 51));
		lblNewAuthor.setFont(new Font("Dialog", Font.BOLD, 60));
		lblNewAuthor.setBounds(625, 61, 439, 63);
		add(lblNewAuthor);

		try {																													

			backButton.setRolloverIcon(new ImageIcon(DetailedInfoPanel.class.getResource("/Buttons/rollbackbutton.png")));
			backButton.setIcon(new ImageIcon(DetailedInfoPanel.class.getResource("/Buttons/backbutton.png")));
			mainBackground.setIcon(new ImageIcon(DetailedInfoPanel.class.getResource("/Background/Background2.jpg")));
			btnSearch.setRolloverIcon(new ImageIcon(DetailedInfoPanel.class.getResource("/Buttons/rollhardbutton.png")));		//Start button icon when mouse entered 
			btnSearch.setIcon(new ImageIcon(DetailedInfoPanel.class.getResource("/Buttons/hardbutton.png")));
			add(mainBackground);
		}catch (NullPointerException e2) {
		}
	}
}
