package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class DBTransShort {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement p;

	public DBTransShort() {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/warr_rsm", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean checkIfAlreadyShort(int upc) {

		try {
			p = con.prepareStatement("select * from shortitemlist");
			p.setInt(1, upc);
			rs = p.executeQuery();

			while (rs.next()) {

				if (rs.getString("UPC").equals(upc)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet addShortItem(int upc) {

		rs = null;
		p = null;

		try {
			p = con.prepareStatement("INSERT INTO shortitemlist (UPC) VALUES (?)");
			p.setInt(1, upc);
			p.execute();
			JOptionPane.showMessageDialog(null, "Item Successfully Added");

			p = con.prepareStatement("select * from shortitemlist");
			rs = p.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;

	}

}
