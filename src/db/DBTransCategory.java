package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.proteanit.sql.DbUtils;
import model.Category;

public class DBTransCategory {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement p;

	public DBTransCategory() {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/warr_rsm", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ResultSet searchCategoryRecord(int cid) {
		rs = null;
		p = null;
		
		try {
			System.out.println("ok");
			
			p = con.prepareStatement("select * from category where CID=?");
			p.setInt(1, cid);
			rs = p.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;

	}

	public void insertCategoryRecord(Category obj) {

	}

	public void updateCategoryRecord(Category obj) {

	}

	public void deleteCategoryRecord(Category obj) {

	}

	public void checkCategoryRecord(int cid) {

	}
	
	public ArrayList DBAutoCate() {

		ArrayList<String> Cat = null;
		try {
			p = con.prepareStatement("select CID from category");
			rs = p.executeQuery();

			Cat = new ArrayList<String>();
			while (rs.next()) {
				Cat.add(rs.getString("CID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Cat;
	}

}
