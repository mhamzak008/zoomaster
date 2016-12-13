package database;

import java.sql.*;
import repository.Animal;
import repository.Plant;
import repository.Species;

public class DatabaseManager {

	private static DatabaseManager instance = null;
	
	public DatabaseManager(){
		
	}
	
	public boolean createDatabase(){
		Connection con = null;
		Statement s = null;
		
		final String DB_DRIVER = "com.mysql.jdbc.Driver";
		final String HOST_URL = "jdbc:mysql://localhost/";
		final String DB_USER = "root";
		final String DB_PASS = "12345";
		
		try{
			// Register driver
			Class.forName(DB_DRIVER);
			
			// Get connection
			con = DriverManager.getConnection(HOST_URL, DB_USER, DB_PASS);
			
			// Create statement
			s = con.createStatement();
			
			// Create database
			String sql = "CREATE DATABASE IF NOT EXISTS zoomaster;";
			s.executeUpdate(sql);
			
		}catch(SQLException se){
			return false;
		}catch(Exception e){
			return false;
		}finally{
			// Close statement and connection
			try{
				if(s != null){
					s.close();
					con.close();
				}
			}catch(SQLException e){}				
			
			try{
				if(con!=null) con.close();
		    }catch(SQLException e){
		         e.printStackTrace();
		    }			
		}
		return true;
	}
	
	public boolean createTables(){
		Connection con = null;
		Statement s = null;
		
		final String DB_DRIVER = "com.mysql.jdbc.Driver";
		final String HOST_URL = "jdbc:mysql://localhost/zoomaster";
		final String DB_USER = "root";
		final String DB_PASS = "12345";
		
		try{
			// Register driver
			Class.forName(DB_DRIVER);
			
			// Get connection
			con = DriverManager.getConnection(HOST_URL, DB_USER, DB_PASS);
			
			// Create statement
			s = con.createStatement();
			
			// Create species tables
			String sql = "CREATE TABLE IF NOT EXISTS species(name VARCHAR(50),"
					+ "latin_name VARCHAR(50), country_of_origin VARCHAR(50), "
					+ "feeding_time TIME, picture BLOB, age INT, gender VARCHAR(15),"
					+ "sID int, PRIMARY KEY(sID)) ENGINE= InnoDB;";
			s.executeUpdate(sql);
			
			// Create animal table
			sql = "CREATE TABLE IF NOT EXISTS animal(aID INT, hibernate CHAR(1),"
					+ "sID INT, PRIMARY KEY(aID), FOREIGN KEY(sID) REFERENCES species(sID) ON DELETE CASCADE ON UPDATE CASCADE)"
					+ "ENGINE=InnoDB;";
			s.executeUpdate("sql");
			
			//Create plant table
			sql = "CREATE TABLE IF NOT EXISTS plant(pID INT, light_need FLOAT,"
					+ "light_time TIME, sID INT, PRIMARY KEY(pID), FOREIGN KEY(sID) ON DELETE CASCADE ON UPDATE CASCADE"
					+ "REFERENCES species(sID)) ENGINE=InnoDB;";
			s.executeUpdate(sql);
		}catch(SQLException se){
			return false;
		}catch(Exception e){
			return false;
		}finally{
			// Close statement and connection
			try{
				if(s != null){
					s.close();
					con.close();
				}
			}catch(SQLException e){}				
			
			try{
				if(con!=null) con.close();
		    }catch(SQLException e){
		         e.printStackTrace();
		    }			
		}
		return true;
	}
	
	public boolean addDataEntry(Species s, int index){
		
		Connection con = null;
		Statement stmt = null;
		
		final String DB_DRIVER = "com.mysql.jdbc.Driver";
		final String HOST_URL = "jdbc:mysql://localhost/zoomaster";
		final String DB_USER = "root";
		final String DB_PASS = "12345";
		
		try{
			// Register driver
			Class.forName(DB_DRIVER);
			
			// Get connection
			con = DriverManager.getConnection(HOST_URL, DB_USER, DB_PASS);
			
			// Create statement
			stmt = con.createStatement();
			
			// Insert into species
			String sql = "INSERT INTO species VALUES("+ s.getName() + ", " + s.getLatinName() + ", " + s.getCountry() + ", " +
					s.getFeedingTime() + ", " + s.getImage() + ", " + s.getAge() + ", " + s.getGender() + ", " + index + ");";
			stmt.executeUpdate(sql);
			
			// If it is animal
			if(s.getType() == 0){
				// Insert into animal
				Animal a = (Animal) s;
				
				sql = "INSERT INTO species VALUES(" + a.getID() + ", " + a.doesHibernate() + ", " + index + ");";
				stmt.executeUpdate(sql);
			} else {
				// Insert into animal
				Plant p = (Plant) s;
				
				sql = "INSERT INTO species VALUES(" + p.getID() + ", " + p.getLightNeed() + ", " + p.getLightTime() + ", "
						+ index + ");";
				stmt.executeUpdate(sql);
			}
			
		}catch(SQLException se){
			return false;
		}catch(Exception e){
			return false;
		}finally{
			// Close statement and connection
			try{
				if(stmt != null){
					stmt.close();
					con.close();
				}
			}catch(SQLException e){}				
			
			try{
				if(con!=null) con.close();
		    }catch(SQLException e){
		         e.printStackTrace();
		    }			
		}
		return true;
	}
	
	public boolean removeDataEntry(int index,int typeKey){
		Connection con = null;
		Statement stmt = null;
		
		final String DB_DRIVER = "com.mysql.jdbc.Driver";
		final String HOST_URL = "jdbc:mysql://localhost/zoomaster";
		final String DB_USER = "root";
		final String DB_PASS = "12345";
		
		try{
			// Register driver
			Class.forName(DB_DRIVER);
			
			// Get connection
			con = DriverManager.getConnection(HOST_URL, DB_USER, DB_PASS);
			
			// Create statement
			stmt = con.createStatement();
			
			String sql;
			if(typeKey == 0) {
				// Delete from animal
				sql = "DELETE FROM animal WHERE sID=" + index + ";";
				stmt.executeUpdate(sql);
			} else {
				// Delete from plant
				sql = "DELETE FROM plant WHERE sID=" + index + ";";
				stmt.executeUpdate(sql);
			}
			
			// Delete from species
			sql = "DELETE FROM species WHERE sID=" + index + ";";
			stmt.executeUpdate(sql);
			
		}catch(SQLException se){
			return false;
		}catch(Exception e){
			return false;
		}finally{
			// Close statement and connection
			try{
				if(stmt != null){
					stmt.close();
					con.close();
				}
			}catch(SQLException e){}				
			
			try{
				if(con!=null) con.close();
		    }catch(SQLException e){
		         e.printStackTrace();
		    }			
		}
		return true;
	}
	
	public boolean modifyDataEntry(int index, Species s){
		//Since we do not know which value has been changed specifically,
		//we first remove that row, then add the modified species as a new row.
		
		// Delete from database
		boolean b = removeDataEntry(index, s.getType());
		
		if(b){
			// Add new entry
			b = addDataEntry(s, index);
			
			if(b) return true;
		}
		
		return false;
	}
	
	public Species getDataEntry(int index, int typeKey){
		Connection con = null;
		Statement stmt = null;
		Species s = null;
		
		final String DB_DRIVER = "com.mysql.jdbc.Driver";
		final String HOST_URL = "jdbc:mysql://localhost/zoomaster";
		final String DB_USER = "root";
		final String DB_PASS = "12345";
		
		try{
			// Register driver
			Class.forName(DB_DRIVER);
			
			// Get connection
			con = DriverManager.getConnection(HOST_URL, DB_USER, DB_PASS);
			
			// Create statement
			stmt = con.createStatement();
			
					
		}catch(SQLException se){
			return null;
		}catch(Exception e){
			return null;
		}finally{
			// Close statement and connection
			try{
				if(stmt != null){
					stmt.close();
					con.close();
				}
			}catch(SQLException e){}				
			
			try{
				if(con!=null) con.close();
		    }catch(SQLException e){
		         e.printStackTrace();
		    }			
		}
		return s;
	}
	
	public static DatabaseManager getInstance(){
		if(instance == null){
			instance = new DatabaseManager();
		}
		return instance;
	}
}
