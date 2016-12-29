import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InfoPlant extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public InfoPlant() {
		setBounds(0, 0, 250, 150);																							
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(255, 0, 51));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 79, 36);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(149, 0, 101, 36);
		
		add(textField);
		textField.setColumns(10);
		
		JLabel lblFeedingTime = new JLabel("Watering Time");
		lblFeedingTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblFeedingTime.setForeground(new Color(255, 0, 51));
		lblFeedingTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFeedingTime.setBounds(0, 47, 118, 36);
		add(lblFeedingTime);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(149, 50, 101, 36);
		add(textField_1);
		
		JLabel lblHibernate = new JLabel("Light Time");
		lblHibernate.setBounds(0, 94, 118, 36);
		lblHibernate.setHorizontalAlignment(SwingConstants.LEFT);
		lblHibernate.setForeground(new Color(255, 0, 51));
		lblHibernate.setFont(new Font("Dialog", Font.BOLD, 16));
		add(lblHibernate);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(149, 94, 101, 36);
		add(textField_2);
	}
}