package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Item;

public class DBTransItem {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement p;

	public DBTransItem() {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/warr_rsm", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet searchItemRecord(int upc) {
		try {
			p = con.prepareStatement("select * from item where UPC=?");
			p.setInt(1, upc);
			rs = p.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void insertItemRecord(Item obj) {

	}

	public void updateItemRecord(Item obj) {

	}

	public void deleteItemRecord(Item obj) {

	}

	public void checkItemRecord(int upc) {

	}
	
	public ArrayList DBAutoUtem() {

		ArrayList<String> itemsUPC = null;
		try {
			p = con.prepareStatement("select UPC from item");
			rs = p.executeQuery();

			itemsUPC = new ArrayList<String>();
			while (rs.next()) {
				itemsUPC.add(rs.getString("UPC"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemsUPC;
	}

}
