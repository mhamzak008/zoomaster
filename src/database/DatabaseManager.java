package database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import repository.Animal;
import repository.Plant;
import repository.Species;

public class DatabaseManager {

	private static DatabaseManager instance = null;
	
	public DatabaseManager(){
		
	}
	
	// Creates database
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
	
	// Creates tables
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
					+ "latin_name VARCHAR(50), country_of_origin VARCHAR(50), type INT,"
					+ "feeding_time TIME, picture MEDIUMBLOB, age INT, gender VARCHAR(15),"
					+ "sID INT, PRIMARY KEY(sID), INDEX species_index(name) USING HASH) ENGINE= InnoDB;";
			s.executeUpdate(sql);
			
			// Create animal table
			sql = "CREATE TABLE IF NOT EXISTS animal(hibernate CHAR(1), "
					+ "sID INT, PRIMARY KEY(sID), FOREIGN KEY(sID) REFERENCES species(sID) ON DELETE CASCADE ON UPDATE CASCADE, INDEX animal_index(sID) USING HASH)"
					+ " ENGINE=InnoDB;";
			s.executeUpdate(sql);
			
			//Create plant table
			sql = "CREATE TABLE IF NOT EXISTS plant(light_time_start TIME,"
					+ "light_time_end TIME, sID INT, PRIMARY KEY(sID), FOREIGN KEY(sID)"
					+ "REFERENCES species(sID)  ON DELETE CASCADE ON UPDATE CASCADE, INDEX plant_index(sID) USING HASH) ENGINE=InnoDB;";
			s.executeUpdate(sql);
			
			//Create password table
			sql = "CREATE TABLE IF NOT EXISTS password(password VARCHAR(100), PRIMARY KEY(password));";
			s.executeUpdate(sql);
			
		}catch(SQLException se){
			se.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
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
	
	// Adds tuple
	public boolean addDataEntry(Species s){
		
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
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(s.getImage(), "jpeg", out);
			byte[] buf = out.toByteArray();
			ByteArrayInputStream in = new ByteArrayInputStream(buf);
			
			
			// Insert into species
			String sql = "INSERT INTO species VALUES('"+ s.getName() + "', '" + s.getLatinName() + "', '" + s.getCountry() + "', " +
					s.getType() + ", '" + s.getFeedingTime() + "', ?, " + s.getAge() + ", '" + s.getGender() + "', " 
					+ s.getsID() + ");";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBinaryStream(1, in, in.available());
			ps.executeUpdate();
			
			// If it is animal
			if(s.getType() == 0){
				// Insert into animal
				Animal a = (Animal) s;
				
				sql = "INSERT INTO animal VALUES('" + a.doesHibernate() + "'," + a.getsID() + ");";
				stmt.executeUpdate(sql);
			} else {
				// Insert into animal
				Plant p = (Plant) s;
				
				sql = "INSERT INTO plant VALUES('" + p.getLightTimeStart() + "', '" + p.getLightTimeEnd() + "', "
						+ p.getsID() + ");";
				stmt.executeUpdate(sql);
			}
			
		}catch(SQLException se){
			se.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
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
	
	// Removes tuple
	public boolean removeDataEntry(int id,int typeKey){
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
				sql = "DELETE FROM animal WHERE sID=" + id + ";";
				stmt.executeUpdate(sql);
			} else {
				// Delete from plant
				sql = "DELETE FROM plant WHERE sID=" + id + ";";
				stmt.executeUpdate(sql);
			}
			
			// Delete from species
			sql = "DELETE FROM species WHERE sID=" + id + ";";
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
	
	// Modifies a tuple
	public boolean modifyDataEntry(Species s){
		//Since we do not know which value has been changed specifically,
		//we first remove that row, then add the modified species as a new row.
		
		// Delete from database
		boolean b = removeDataEntry(s.getsID(), s.getType());
		
		if(b){
			// Add new entry
			b = addDataEntry(s);
			
			if(b) return true;
		}
		
		return false;
	}
	
	// Returns tuples with their name starting with the search key
	public ArrayList<Species> getDataEntry(String name){
		Connection con = null;
		Statement stmt = null;
		ArrayList<Species> result = new ArrayList<Species>();
		
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
			
			// Get species values
			String sql = "SELECT * FROM species WHERE name LIKE '" + name + "%';	";
			ResultSet rs = stmt.executeQuery(sql);
					
			// Add species to the result after getting animal or plant values
			while(rs.next()){
				int sID = rs.getInt("sID");
				int age = rs.getInt("age");
				String sName = rs.getString("name");
				String lName = rs.getString("latin_name");
				String country = rs.getString("country_of_origin");
				String gender = rs.getString("gender");
				String feedingTime = rs.getTime("feeding_time").toString();
				Blob blob = rs.getBlob("picture");
				int blobLength = (int) blob.length();
				byte[] bytes = blob.getBytes(1, blobLength);
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
				int type = rs.getInt("type");
				
				if(type == 0){
					sql = "SELECT * FROM animal WHERE sID=" + sID + ";";
					ResultSet r = stmt.executeQuery(sql);
					
					char hibernate = r.getString("hibernate").charAt(0);
					
					Animal a = new Animal(sID, hibernate, age, image, sName, feedingTime, lName, country, gender);
					result.add(a);
				}else{
					sql = "SELECT * FROM plant WHERE sID=" + sID + ";";
					ResultSet r = stmt.executeQuery(sql);
					
					String lightTimeStart = r.getTime("light_time_start").toString(); 
					String lightTimeEnd = r.getTime("light_time_end").toString(); 
					Plant p = new Plant(sID, lightTimeStart, lightTimeEnd, age, image, sName, feedingTime, lName, country, gender);
					result.add(p);
				}
				
				
			}
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
		return result;
	}
	
	// Returns feeding times of species
	public ArrayList<Species> getFeedingTimes(){
		Connection con = null;
		Statement stmt = null;
		Statement st = null;
		ArrayList<Species> result = new ArrayList<Species>();
		
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
			st = con.createStatement();
			
			// Get species values
			String sql = "SELECT sID, feeding_time, name, type FROM species";
			ResultSet rs = stmt.executeQuery(sql);
					
			// Add species to the result after getting animal or plant values
			while(rs.next()){
				String name = rs.getString("name");
				String feedingTime = rs.getTime("feeding_time").toString();
				int sID = rs.getInt("sID");	
				int type = rs.getInt("type");
				
				if(type == 0){
					Species s = new Species(0, sID, -1, null, name, feedingTime, null, null, null);
					result.add(s);
				}else{
					sql = "SELECT light_time_start, light_time_end FROM plant WHERE sID=" + sID + ";";
					ResultSet s = st.executeQuery(sql);
					
					
					if(s.next()){
						String lightTimeStart = s.getTime("light_time_start").toString();
						String lightTimeEnd = s.getTime("light_time_end").toString();
						Plant p = new Plant(-1, lightTimeStart, lightTimeEnd, -1, null, name, feedingTime, null, null, null);
						result.add(p);
					}
				}
			}
		}catch(SQLException se){
			se.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
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
		return result;
	}
	
	// Set species id counter
	public boolean setID(){
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
			
			// Get species values
			String sql = "SELECT MAX(sID) as sID FROM species";
			ResultSet rs = stmt.executeQuery(sql);
					
			// Add species to the result after getting animal or plant values
			while(rs.next()){

				int sID = rs.getInt("sID");
				
				Species.setNewIDCount(sID+1);
			}
		}catch(SQLException se){
			se.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
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
	
	// Get password String
	public String getPassword(){
		Connection con = null;
		Statement stmt = null;
		String password = null;
		
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
			
			// Get password
			String sql = "SELECT * FROM password;";
			ResultSet rs = stmt.executeQuery(sql);
					
			// Get password from rs
			while(rs.next()){

				password = rs.getString("password");
			}
		}catch(SQLException se){
			se.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
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
		return password;
	}
	
	// Set new password
	public boolean setPassword(String pass){
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
			
			// Delete previous values
			String sql = "TRUNCATE TABLE password;";
			stmt.executeUpdate(sql);
			
			// Add new password
			sql = "INSERT INTO password VALUES('" + pass + "');";
			stmt.executeUpdate(sql);
					
		}catch(SQLException se){
			se.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
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
	
	public static DatabaseManager getInstance(){
		if(instance == null){
			instance = new DatabaseManager();
		}
		return instance;
	}
}
