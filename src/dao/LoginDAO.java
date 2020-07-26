package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Login;
import serivce.ConnectionManager;

public class LoginDAO {

	public boolean validate(Login login) throws ClassNotFoundException, SQLException {
		String userName = login.getUserName();
		String password = login.getPassword();
		
		ConnectionManager cm = new ConnectionManager();
		Statement st = cm.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM USERDETAILS");
		
		while(rs.next()) {
			if(userName.equals(rs.getString(3))&& password.equals(rs.getString(4))) {
				cm.getConnection().close();
				return true;
			}
			else {
				cm.getConnection().close();
				return false;
			}
		}
		
		return false;
	}

}
