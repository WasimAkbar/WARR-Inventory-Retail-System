package algo;

import java.sql.ResultSet;

import db.DBTransEmpItemList;
import model.Item;

public class RetrieveListUpdateStatus extends DBTransEmpItemList {

	private Item myItems;

	private Bill bill;

	private ResultSet rs;
	double varBill = 0;
	
	public RetrieveListUpdateStatus(){
		bill = new Bill(); 
	}

	public ResultSet getlist(int listno) {
		rs = null;
		rs = getList(listno);
		return rs;
	}

	public ResultSet getlistStatus(int listno) {
		rs = null;
		rs = getStatus(listno);
		return rs;
	}

	public ResultSet UpdateStatus(int listno) {
		rs = null;
		rs = statusUpdate(listno, true);
		return rs;
	}

	public boolean dropItem(int upc, int list) {
		if (drop(upc, list)) {
			return true;
		}
		return false;
	}
	public void save(boolean stat) {

	}
	public double getTotalListBill(int listno){
		return bill.printBill(listno);
		 
	}

}
