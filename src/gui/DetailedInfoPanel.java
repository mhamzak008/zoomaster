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
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;

public class DetailedInfoPanel extends JPanel {
	JLabel mainBackground;
	static JButton btnSearch;
	static JTextField txtCountryOfOrigin;
	private JLabel txtName;
	private JLabel lblCountryOfOrigin;
	private JLabel lblBirthplace;
	static JTextField txtPseudonym;
	private JLabel lblImageLink;
	static JTextField txtLausanne;
	static JTextField txtDasdasgasgasgasgas;
	private InfoPlant infoPlant;
	private InfoAnimal infoAnimal;
	/**
	 * Create the panel.
	 */
	public DetailedInfoPanel() {
		

		setBounds(0, 0, 800, 600);																							
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(479, 141, 253, 231);
		add(lblNewLabel);
		
		txtName = new JLabel();
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		//txtName.setBackground(UIManager.getColor("Button.background"));
		txtName.setText("Name:");
		txtName.setFont(new Font("Chalkduster", Font.BOLD, 16));
		txtName.setForeground(new Color(255, 0, 51));
		txtName.setBounds(46, 141, 83, 36);
		add(txtName);
		
		txtCountryOfOrigin = new JTextField();
		txtCountryOfOrigin.setHorizontalAlignment(SwingConstants.LEFT);
		txtCountryOfOrigin.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtCountryOfOrigin.setBounds(196, 142, 239, 36);
		txtCountryOfOrigin.setFont(new Font("Chalkduster", Font.BOLD, 16));
		txtCountryOfOrigin.setForeground(Color.BLACK);
		txtCountryOfOrigin.setText("");
		
		add(txtCountryOfOrigin);
		txtCountryOfOrigin.setColumns(10);
		
		lblCountryOfOrigin = new JLabel();
		lblCountryOfOrigin.setText("Country of Origin:");
		lblCountryOfOrigin.setHorizontalAlignment(SwingConstants.LEFT);
		lblCountryOfOrigin.setForeground(new Color(255, 0, 51));
		lblCountryOfOrigin.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCountryOfOrigin.setBounds(46, 188, 154, 36);
		add(lblCountryOfOrigin);
		
		lblBirthplace = new JLabel();
		lblBirthplace.setText("Latin Name:");
		lblBirthplace.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthplace.setForeground(new Color(255, 0, 51));
		lblBirthplace.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBirthplace.setBounds(46, 235, 154, 36);
		add(lblBirthplace);
		
		// Background Image
		mainBackground = new JLabel("");																					
		mainBackground.setHorizontalAlignment(SwingConstants.CENTER);
		mainBackground.setBounds(-23, -88, 1448, 886);
		
		btnSearch = new JButton("Delete");																					
		btnSearch.setFocusPainted(false);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch.setFont(new Font("Chalkduster", Font.BOLD, 16));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorder(null);
		btnSearch.setBounds(330, 504, 133, 45);
		//btnSearch.addActionListener(new SearchPanelListener());
		btnSearch.setToolTipText("Information about the Search");
		add(btnSearch);
		
		txtPseudonym = new JTextField();
		txtPseudonym.setHorizontalAlignment(SwingConstants.LEFT);
		txtPseudonym.setForeground(Color.BLACK);
		txtPseudonym.setFont(new Font("Dialog", Font.BOLD, 16));
		txtPseudonym.setColumns(10);
		txtPseudonym.setBounds(196, 191, 228, 36);
		add(txtPseudonym);
		
		lblImageLink = new JLabel();
		lblImageLink.setText("Age:");
		lblImageLink.setHorizontalAlignment(SwingConstants.LEFT);
		lblImageLink.setForeground(new Color(255, 0, 51));
		lblImageLink.setFont(new Font("Dialog", Font.BOLD, 16));
		lblImageLink.setBounds(46, 282, 118, 36);
		add(lblImageLink);
		
		txtLausanne = new JTextField();
		txtLausanne.setHorizontalAlignment(SwingConstants.LEFT);
		txtLausanne.setForeground(Color.BLACK);
		txtLausanne.setFont(new Font("Dialog", Font.BOLD, 16));
		txtLausanne.setColumns(10);
		txtLausanne.setBounds(196, 235, 253, 36);
		add(txtLausanne);
		
		txtDasdasgasgasgasgas = new JTextField();
		txtDasdasgasgasgasgas.setHorizontalAlignment(SwingConstants.LEFT);
		txtDasdasgasgasgasgas.setForeground(Color.BLACK);
		txtDasdasgasgasgasgas.setFont(new Font("Dialog", Font.BOLD, 16));
		txtDasdasgasgasgasgas.setColumns(10);
		txtDasdasgasgasgasgas.setBounds(197, 282, 99, 36);
		add(txtDasdasgasgasgasgas);
		
		JLabel lblNewAuthor = new JLabel();
		lblNewAuthor.setText("SPECIES");
		lblNewAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewAuthor.setForeground(new Color(255, 0, 51));
		lblNewAuthor.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewAuthor.setBounds(10, 11, 780, 63);
		add(lblNewAuthor);
		
		infoPlant = new InfoPlant();
		infoAnimal = new InfoAnimal();
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(46, 329, 250, 172);
		layeredPane.add(infoPlant);
		layeredPane.add(infoAnimal);
		infoPlant.setVisible(true);
		infoAnimal.setVisible(false);
		add(layeredPane);
		try {
			mainBackground.setIcon(new ImageIcon(DetailedInfoPanel.class.getResource("/Background/Background2.jpg")));
			btnSearch.setRolloverIcon(new ImageIcon(DetailedInfoPanel.class.getResource("/Buttons/rollhardbutton.png")));		//Start button icon when mouse entered 
			btnSearch.setIcon(new ImageIcon(DetailedInfoPanel.class.getResource("/Buttons/hardbutton.png")));
			

			

			add(mainBackground);
		}catch (NullPointerException e2) {
		}
	}
}
