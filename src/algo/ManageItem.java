package algo;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import db.DBTransCustItemList;
import db.DBTransItem;
import db.DBTransShort;
import model.Item;

public class ManageItem extends DBTransItem {
	ResultSet res = null;
	public DBTransShort d;
	public DBTransItem d1;
	private ArrayList getItems = null;

	public ResultSet searchItem(int upc) {
		res = null;
		d1 = new DBTransItem();
		res = d1.searchItemRecord(upc);
		return res;
	}

	public ResultSet sendShortItem(int upc) {

		res = null;
		d = new DBTransShort();
		res = d.addShortItem(upc);

		// try {
		// res = null;
		// d = new DBTransShort();
		// //res = d.addShortItem(upc);
		//
		// boolean flage = d.checkIfAlreadyShort(upc);
		//
		// if (flage == false) {
		// res = d.addShortItem(upc);
		// return res;
		// } else {
		// JOptionPane.showMessageDialog(null,
		// "Item Already Added TO Short Item List");
		// return null;
		// }
		// } catch (HeadlessException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return res;
	}

	public void insertItem(Item obj) {

	}

	public void updateItem(Item obj) {

	}

	public void deleteItem(Item obj) {

	}
	
	public ArrayList getAutoUtem() {
		getItems  = new ArrayList();
		getItems  = DBAutoUtem();
		return getItems;
	}
}
