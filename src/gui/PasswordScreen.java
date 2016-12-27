package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import security.PasswordManager;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PasswordScreen extends JFrame{
	private JPasswordField passwordField;
	public PasswordScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{855, 0, 118, 0, 0, 124, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{100, 29, 318, 20, 23, 0, 495, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcomeToZoomaster = new JLabel("Welcome to ZooMaster");
		lblWelcomeToZoomaster.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblWelcomeToZoomaster = new GridBagConstraints();
		gbc_lblWelcomeToZoomaster.anchor = GridBagConstraints.NORTH;
		gbc_lblWelcomeToZoomaster.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcomeToZoomaster.gridwidth = 16;
		gbc_lblWelcomeToZoomaster.gridx = 0;
		gbc_lblWelcomeToZoomaster.gridy = 1;
		getContentPane().add(lblWelcomeToZoomaster, gbc_lblWelcomeToZoomaster);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		GridBagConstraints gbc_lblEnterPassword = new GridBagConstraints();
		gbc_lblEnterPassword.anchor = GridBagConstraints.EAST;
		gbc_lblEnterPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterPassword.gridx = 1;
		gbc_lblEnterPassword.gridy = 3;
		getContentPane().add(lblEnterPassword, gbc_lblEnterPassword);
		
		JButton btnSubmit = new JButton("Submit");
		
		
		btnSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PasswordManager pm = PasswordManager.getInstance();
				boolean b = pm.isCorrect(passwordField.getPassword().toString());
				// Complete here
			}
			
		});
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		getContentPane().add(passwordField, gbc_passwordField);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.anchor = GridBagConstraints.NORTH;
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 5;
		getContentPane().add(btnSubmit, gbc_btnSubmit);
	}
}
