/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Ugur Can
 */
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import repository.Animal;

public class InfoAnimal extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public InfoAnimal() {
		setBounds(0, 0, 250, 150);																							
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(255, 0, 51));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 79, 36);
		
		add(lblNewLabel);
		
		textField = new JTextField();
                textField.setColumns(10);
                textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setForeground(new Color(255, 0, 51));
		textField.setFont(new Font("Dialog", Font.BOLD, 16));
		textField.setBounds(149, 3, 101, 36);
		add(textField);

		
		JLabel lblFeedingTime = new JLabel("Feeding Time");
		lblFeedingTime.setBounds(0, 47, 124, 36);
		lblFeedingTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblFeedingTime.setForeground(new Color(255, 0, 51));
		lblFeedingTime.setFont(new Font("Dialog", Font.BOLD, 16));
		add(lblFeedingTime);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
                textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setForeground(new Color(255, 0, 51));
		textField_1.setFont(new Font("Dialog", Font.BOLD, 16));
		textField_1.setBounds(149, 50, 101, 36);
		add(textField_1);
		
		JLabel lblHibernate = new JLabel("Hibernate");
		lblHibernate.setBounds(0, 94, 79, 36);
		lblHibernate.setHorizontalAlignment(SwingConstants.LEFT);
		lblHibernate.setForeground(new Color(255, 0, 51));
		lblHibernate.setFont(new Font("Dialog", Font.BOLD, 16));
		add(lblHibernate);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
                textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setForeground(new Color(255, 0, 51));
		textField_2.setFont(new Font("Dialog", Font.BOLD, 16));
		textField_2.setBounds(149, 97, 101, 36);
		add(textField_2);
	}
        public void modify(Animal animal){
            System.out.println(animal.getFeedingTime());
            textField.setText(animal.getGender());
            textField_1.setText(animal.getFeedingTime());
            textField_2.setText(Character.toString(animal.doesHibernate()));
        }
}

