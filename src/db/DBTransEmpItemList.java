package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import algo.ManageAccount;

public class DBTransEmpItemList extends ManageAccount {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement p, p1;

	public DBTransEmpItemList() {

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/warr_rsm", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean checkListValidation(int listno) {
		boolean flage = false;
		
		try {			
			p = con.prepareStatement("select * from  liststatus where LID=?");
			p.setInt(1, listno);
			rs = p.executeQuery();
			
			while(rs.next()){
				char value = rs.getString("Status").charAt(0);
				if(value == 'N'){
					flage = false;
				}
				else
					flage = true;
			}						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flage;

	}

	public ResultSet getList(int listno) {
		rs = null;
		p = null;

		try {

			p = con.prepareStatement("select * from custlist where LID=?");
			p.setInt(1, listno);

			rs = p.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	public ResultSet getStatus(int listno) {
		rs = null;
		p = null;

		try {

			p = con.prepareStatement("select * from liststatus where LID=?");
			p.setInt(1, listno);
			rs = p.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	public boolean drop(int upc, int list) {
		PreparedStatement p = null;

		try {

			p = con.prepareStatement("DELETE FROM custlist WHERE UPC=? AND LID=?");
			p.setInt(1, upc);
			p.setInt(2, list);
			p.execute();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet statusUpdate(int listno, boolean status) {

		rs = null;
		p = null;

		try {

			// JOptionPane.showMessageDialog(null,
			// "Item List Successsfully Sold");

			
			
			String query1 = "UPDATE `liststatus` SET `Status`= '" + 'Y'
					+ "' WHERE `LID`=" + listno;

			p = con.prepareStatement(query1);
			p.execute();

			p = con.prepareStatement("select TotalPrice from liststatus where LID=?");
			p.setInt(1, listno);
			rs = p.executeQuery();

			p = con.prepareStatement("select * from liststatus");
			rs = p.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;

	}

}
