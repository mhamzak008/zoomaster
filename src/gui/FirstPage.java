package gui;
import database.DatabaseManager;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import repository.Species;
import repository.Animal;
import repository.Plant;

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
        static int lastPage;
	static JLabel lblNewLabel;
        static ArrayList <Species> species;
        static JFrame detailFrame;
        static DetailedInfoPanel detailedInfoPanel;
	/**
	 * Create the panel.
	 */
        private void detailedFrame(int i){
            if((currentPage-1)*6+i<=species.size()){
                detailFrame = new JFrame();
                detailFrame.setPreferredSize(new Dimension(800,600));
                detailFrame.pack();
                detailedInfoPanel = new DetailedInfoPanel(species.get((currentPage-1)*6+i-1));
                detailFrame.add(detailedInfoPanel);
                detailFrame.setVisible(true);                
                }
        }
	public FirstPage() {
		
		setBounds(0, 0, 800, 600);																							
		setLayout(null);

		btnSearch = new JButton("Info");																					
		btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch.setFont(new Font("Chalkduster", Font.BOLD, 16));
		btnSearch.setBounds(63, 140, 85, 44);
                btnSearch.addActionListener(
                    new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            detailedFrame(1);
                        }
                    }
                );
		btnSearch.setToolTipText("Information about the Search");
		add(btnSearch);
		
		btnSearch2 = new JButton("Info");																					
		btnSearch2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch2.setFont(new Font("Chalkduster", Font.BOLD, 16));
		btnSearch2.setBounds(63, 200, 85, 44);
		btnSearch2.setToolTipText("Information about the Search");
                btnSearch2.addActionListener(
                    new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            detailedFrame(2);
                        }
                    }
                );
		add(btnSearch2);
		
		btnSearch3 = new JButton("Info");																					
		btnSearch3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch3.setFont(new Font("Chalkduster", Font.BOLD, 16));
		btnSearch3.setBounds(63, 260, 85, 44);
		btnSearch3.setToolTipText("Information about the Search");
                btnSearch3.addActionListener(
                    new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            detailedFrame(3);
                        }
                    }
                );
		add(btnSearch3);
		
		btnSearch4 = new JButton("Info");																					
		btnSearch4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch4.setFont(new Font("Chalkduster", Font.BOLD, 16));
		btnSearch4.setBounds(63, 320, 85, 44);
		btnSearch4.setToolTipText("Information about the Search");
                btnSearch4.addActionListener(
                    new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            detailedFrame(4);
                        }
                    }
                );
		add(btnSearch4);
		
		btnSearch5 = new JButton("Info");																					
		btnSearch5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch5.setFont(new Font("Chalkduster", Font.BOLD, 16));;
		btnSearch5.setBounds(63, 380, 85, 44);
		btnSearch5.setToolTipText("Information about the Search");
                btnSearch5.addActionListener(
                    new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            detailedFrame(5);
                        }
                    }
                );
		add(btnSearch5);
		
		btnSearch6 = new JButton("Info");																					
		btnSearch6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch6.setFont(new Font("Chalkduster", Font.BOLD, 16));
		btnSearch6.setBounds(63, 440, 85, 44);
		btnSearch6.setToolTipText("Information about the Search");
                btnSearch6.addActionListener(
                    new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            detailedFrame(6);
                        }
                    }
                );
		add(btnSearch6);
		
		
		
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField.setBounds(50, 36, 602, 34);
		textField.setFont(new Font("Chalkduster", Font.BOLD, 16));
		textField.setForeground(Color.BLACK);
		
		add(textField);
		textField.setColumns(10);
		
		prevButton = new JButton();
                prevButton.setText("Prev");
		prevButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		prevButton.setBounds(280, 485, 60, 34);
		prevButton.setToolTipText("Click to go previous results");
                prevButton.addActionListener(
                    new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            if(currentPage!=1){
                                currentPage--;
                                for(int i = 0;i<6;i++)
                      	    	textField_[i].setText("");
				for(int i = (currentPage-1)*6;i<(currentPage)*6;i++){
					textField_[i-(currentPage-1)*6].setText(species.get(i).getName()+" "+species.get(i).getsID());
				}
				lblNewLabel.setText(currentPage+" / "+lastPage);
                        }
                
                    }
                    }
                );
		add(prevButton);
		
		nextButton = new JButton();
                nextButton.setText("Next");
		nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextButton.setBounds(465, 485, 60, 34);
		nextButton.setToolTipText("Click to go next results");
                nextButton.addActionListener(
                    new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            if((currentPage)*6<species.size()){
                                currentPage++;
                                for(int i = 0;i<6;i++)
                      	    	textField_[i].setText("");
                                if((currentPage)*6<species.size())
                                    for(int i = (currentPage-1)*6;i<(currentPage)*6;i++){
					textField_[i-(currentPage-1)*6].setText(species.get(i).getName()+" "+species.get(i).getsID());
                                    }
                                else
                                    for(int i = (currentPage-1)*6;i<species.size();i++){
					textField_[i-(currentPage-1)*6].setText(species.get(i).getName()+" "+species.get(i).getsID());
                                    }
				lblNewLabel.setText(currentPage+" / "+lastPage);
                        }
                
                    }
                    }
                );
		add(nextButton);
		// Background Image
		
		textField_[0] = new JTextField();
		textField_[0].setText("");
		textField_[0].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[0].setForeground(Color.BLACK);
		textField_[0].setFont(new Font("Dialog", Font.BOLD, 16));
		textField_[0].setColumns(10);
		textField_[0].setBounds(163, 140, 500, 44);
		add(textField_[0]);
		
		textField_[1] = new JTextField();
		textField_[1].setText("");
		textField_[1].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[1].setForeground(Color.BLACK);
		textField_[1].setFont(new Font("Dialog", Font.BOLD, 16));
		textField_[1].setColumns(10);
		textField_[1].setBounds(163, 200, 500, 44);
		add(textField_[1]);
		
		textField_[2] = new JTextField();
		textField_[2].setText("");
		textField_[2].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[2].setForeground(Color.BLACK);
		textField_[2].setFont(new Font("Dialog", Font.BOLD, 16));
		textField_[2].setColumns(10);
		textField_[2].setBounds(163, 260, 500, 44);
		add(textField_[2]);
		
		textField_[3] = new JTextField();
		textField_[3].setText("");
		textField_[3].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[3].setForeground(Color.BLACK);
		textField_[3].setFont(new Font("Dialog", Font.BOLD, 16));
		textField_[3].setColumns(10);
		textField_[3].setBounds(163, 320, 500, 44);
		add(textField_[3]);
		
		textField_[4] = new JTextField();
		textField_[4].setText("");
		textField_[4].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[4].setForeground(Color.BLACK);
		textField_[4].setFont(new Font("Dialog", Font.BOLD, 16));
		textField_[4].setColumns(10);
		textField_[4].setBounds(163, 380, 500, 44);
		add(textField_[4]);
		
		textField_[5] = new JTextField();
		textField_[5].setText("");
		textField_[5].setHorizontalAlignment(SwingConstants.LEFT);
		textField_[5].setForeground(Color.BLACK);
		textField_[5].setFont(new Font("Dialog", Font.BOLD, 16));
		textField_[5].setColumns(10);
		textField_[5].setBounds(163, 440, 500, 44);
		add(textField_[5]);
		
		
		lblNewLabel = new JLabel("-/-");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(345, 485, 110, 34);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Chalkduster", Font.BOLD, 16));
		add(lblNewLabel);
		
		
		btnNewButton = new JButton("Search");
		btnNewButton.setBounds(662, 36, 90, 34);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
                btnNewButton.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        currentPage = 1;
                        for(int i = 0;i<6;i++)
                      	    	textField_[i].setText("");
                        for(int i = 0;i<6;i++)
                      	    	textField_[i].setText("");
                        DatabaseManager db = DatabaseManager.getInstance();
                        species = db.getDataEntry(textField.getText());
                        System.out.println(species.size());
                        if((species.size()/6)==0)
                            lastPage=1;
                        else{
                            lastPage=(species.size()/6);
                            if(species.size()%6!=0)
				lastPage++;
			}
                        if(species.size()>6)
                            for(int i = 0;i<6;i++){
				textField_[i].setText(species.get(i).getName()+" with ID: "+species.get(i).getsID());
                            }
                        else
                            for(int i = 0;i<species.size();i++){
                                textField_[i].setText(species.get(i).getName()+" with ID: "+species.get(i).getsID());
                            }
                        lblNewLabel.setText(currentPage+" / "+lastPage);

                        //textField_[0].setText(Integer.toString(species.size()));
                        //textField_[1].setText(textField.getText());
                    }
                });
		add(btnNewButton);

	}
}

