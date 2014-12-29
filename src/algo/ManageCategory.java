package algo;

import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBTransCategory;
import db.DBTransCustItemList;
import model.Category;

public class ManageCategory extends DBTransCategory {

	public ResultSet res = null;
	private DBTransCategory cat;
	private ArrayList getCat = null;

	public ResultSet searchCategory(int cid) {
		 res = searchCategoryRecord(cid);
		 return res;
	}

	public void insertCategory(Category obj) {

	}

	public void updateCategory(Category obj) {

	}

	public void deleteCategory(Category obj) {

	}
	
	public ArrayList getAutoCate() {
		cat = new DBTransCategory();
		getCat  = cat.DBAutoCate();
		return getCat;
	}

}
