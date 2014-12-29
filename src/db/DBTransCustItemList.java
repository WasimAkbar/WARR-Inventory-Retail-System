package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBTransCustItemList {

	// public int listno := saveList() {
	// return 0;
	// }

	private Connection con;
	private ResultSet rs;
	private PreparedStatement p;

	public DBTransCustItemList() {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/warr_rsm", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList getAutoList() {

		ArrayList<String> items = null;
		try {
			p = con.prepareStatement("select LID from liststatus");
			rs = p.executeQuery();

			items = new ArrayList<String>();
			while (rs.next()) {
				items.add(rs.getString("LID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return items;
	}
}
