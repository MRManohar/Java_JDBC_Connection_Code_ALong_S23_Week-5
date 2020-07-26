package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Registration;
import serivce.ConnectionManager;

public class RegistrationDAO {
	public void addUser(Registration registration) throws ClassNotFoundException, SQLException {
		String firstName = registration.getFirstName();
		String lastName = registration.getLastName();
		String userName = registration.getUserName();
		String password = registration.getPassword();
		String email = registration.getEmail();
		
		ConnectionManager cm = new ConnectionManager();
		//Install all the details into database
		String sql = "insert into USERDETAILS(FIRSTNAME,LASTNAME,USERNAME,PASSWORD,EMAIL)VALUES(?,?,?,?,?)";
		//create statement object
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		
		st.setString(1, firstName);
		st.setString(2, lastName);
		st.setString(3, userName);
		st.setString(4, password);
		st.setString(5, email);
		
		st.executeUpdate();
		cm.getConnection().close();
	}
}
