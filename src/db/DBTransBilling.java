package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTransBilling {
	
	private Connection con;
	private ResultSet rs;
	private PreparedStatement p;
	
	public DBTransBilling() {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/warr_rsm", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public double billing(int listno) {
		rs = null;
		p = null;
		double bill = 0;
		
		try {			
			p = con.prepareStatement("select * from  liststatus where LID=?");
			p.setInt(1, listno);
			rs = p.executeQuery();
			
			while(rs.next()){
				bill = rs.getDouble("TotalPrice");
			}						
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bill;
	}

}
