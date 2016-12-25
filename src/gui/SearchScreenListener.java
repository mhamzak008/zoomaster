package database;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class SearchPanelListener implements ActionListener {
		static int lastPage,currentID;
		private int pseudonym = -1; 
		
		private int infoID;
		@Override
		
		public void actionPerformed(ActionEvent e) {
			//Start button action performed method
			if(e.getSource()==SearchPanel.btnNewButton){
				try{
				    String key;
				    key = SearchPanel.textField.getText();			    
				    SearchPanel.currentPage = 1;
				    SearchPanel.totRes = new String[SearchPanel.size];
				    ArrayList<Species> result = DatabaseManager.getDataEntry(key);
				    SearchPanel.size = result.size();
				    
				    for(int i = 0;i<6;i++)
				    	SearchPanel.textField_[i].setText("");
				    if((SearchPanel.size/6)==0)
				    	lastPage=1;
				    else{
				    	lastPage=(SearchPanel.size/6);
				    	if(SearchPanel.size%6!=0)
				    		lastPage++;
				    }
				    	
				    SearchPanel.lblNewLabel.setText(SearchPanel.currentPage+" / "+lastPage);
				    if(SearchPanel.size>6)
					    for(int i = 0;i<6;i++){
					    	SearchPanel.textField_[i].setText(SearchPanel.totRes[i]);
					    }
				    else
					    for(int i = 0;i<SearchPanel.size;i++){
					    	SearchPanel.textField_[i].setText(SearchPanel.totRes[i]);
					    }
				}
			   catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e3){
				      //Handle errors for Class.forName
				      e3.printStackTrace();
				   }
			}
			else if((e.getSource() == SearchPanel.btnSearch || e.getSource() == SearchPanel.btnSearch2
					 || e.getSource() == SearchPanel.btnSearch3 || e.getSource() == SearchPanel.btnSearch4
					 || e.getSource() == SearchPanel.btnSearch5 || e.getSource() == SearchPanel.btnSearch6)
					&& SearchPanel.comboBoxNo == 0){
				try{
					if(e.getSource() == SearchPanel.btnSearch)
						infoID = 1;
					else if(e.getSource() == SearchPanel.btnSearch2)
						infoID = 2;
					else if(e.getSource() == SearchPanel.btnSearch3)
						infoID = 3;
					else if(e.getSource() == SearchPanel.btnSearch4)
						infoID = 4;
					else if(e.getSource() == SearchPanel.btnSearch5)
						infoID = 5;
					else if(e.getSource() == SearchPanel.btnSearch6)
						infoID = 6;
					
						firstScreen.searchPanel.setVisible(false);
						firstScreen.infoPanel.setVisible(true);
					
				}
				catch(Exception infoo)
				{
					infoo.printStackTrace();
				}
			}
			else if(e.getSource()==SearchPanel.prevButton && SearchPanel.currentPage!=1){
				SearchPanel.currentPage--;
			    for(int i = 0;i<6;i++)
			    	SearchPanel.textField_[i].setText("");
				for(int i = (SearchPanel.currentPage-1)*6;i<(SearchPanel.currentPage)*6;i++){
					SearchPanel.textField_[i-(SearchPanel.currentPage-1)*6].setText(SearchPanel.totRes[i]);
				}
				SearchPanel.lblNewLabel.setText(SearchPanel.currentPage+" / "+lastPage);

			}
			else if(e.getSource()==SearchPanel.nextButton && (SearchPanel.currentPage)*6<SearchPanel.size){
				SearchPanel.currentPage++;
			    for(int i = 0;i<6;i++)
			    	SearchPanel.textField_[i].setText("");
				if((SearchPanel.currentPage)*6 > SearchPanel.size)
					for(int i = (SearchPanel.currentPage-1)*6;i<(SearchPanel.size);i++){
						SearchPanel.textField_[i-(SearchPanel.currentPage-1)*6].setText(SearchPanel.totRes[i]);
					}
				else
					for(int i = (SearchPanel.currentPage-1)*6;i<(SearchPanel.currentPage)*6;i++){
						SearchPanel.textField_[i-(SearchPanel.currentPage-1)*6].setText(SearchPanel.totRes[i]);
					}
				SearchPanel.lblNewLabel.setText(SearchPanel.currentPage+" / "+lastPage);
			}
			try{
				SearchPanel.mainBackground.setIcon(new ImageIcon(SearchPanel.class.getResource("/Background/Background2.jpg")));
			}
			catch(Exception eee){
				
			}
		}
	}