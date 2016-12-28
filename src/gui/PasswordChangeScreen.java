package gui;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import security.PasswordManager;
import java.awt.Color;

public class PasswordChangeScreen extends JFrame{
	private JPasswordField passwordField_1;
	private JPasswordField passwordField;
	private JPasswordField oldPassField;
	public PasswordChangeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(800,600);
		
		JButton btnBack = new JButton("Back");
		
		JLabel lblOldPassword = new JLabel("Old Password:");
		
		JLabel lblNewPassword = new JLabel("New Password:");
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		
		JButton btnChangePassword = new JButton("Change Password");
		
		passwordField_1 = new JPasswordField();
		
		passwordField = new JPasswordField();
		
		oldPassField = new JPasswordField();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setVisible(false);
		
		btnChangePassword.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PasswordManager ps = PasswordManager.getInstance();
				boolean b = ps.isCorrect(oldPassField.getPassword().toString());
				if(b){
					if(passwordField_1.getPassword().toString().equals(passwordField.getPassword().toString())){
						ps.changePassword(passwordField.getPassword().toString());
						lblNewLabel.setText("Your password have been successfully changed!");
						lblNewLabel.setForeground(Color.GREEN);
						lblNewLabel.setVisible(true);
					}else{
						lblNewLabel.setForeground(Color.RED);
						lblNewLabel.setText("Entered passwords don't match!");
						lblNewLabel.setVisible(true);
					}
				}else{
					lblNewLabel.setForeground(Color.RED);
					lblNewLabel.setText("Wrong old password!");
					lblNewLabel.setVisible(true);
				}
			}
			
		});
		
		btnBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//Change according to the algorithm in main method
				getContentPane().setVisible(false);
			}
			
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(823)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblConfirmPassword)
										.addComponent(lblOldPassword)
										.addComponent(lblNewPassword))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
										.addComponent(oldPassField, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(49)
									.addComponent(btnChangePassword)))))
					.addContainerGap(861, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(btnBack)
					.addGap(277)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOldPassword)
						.addComponent(oldPassField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmPassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnChangePassword)
					.addContainerGap(536, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
