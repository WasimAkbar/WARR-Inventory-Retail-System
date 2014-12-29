package algo;

import java.util.ArrayList;

import db.DBTransCustItemList;
import db.DBTransItem;
import model.Item;

public class ItemList extends DBTransCustItemList {

	private Item myList;
	public DBTransCustItemList dList;
	public ArrayList<String> getItems = null;


	public void enterItem(int upc, int qty) {

	}

	public void dropItem(int upc) {

	}

	public void save() {

	}

	public ArrayList getAutoList() {
		dList = new DBTransCustItemList();
		getItems = dList.getAutoList();
		return getItems;
	}
}
