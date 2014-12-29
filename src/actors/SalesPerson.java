package actors;

import java.sql.ResultSet;

import creator.CreManageItem;
import algo.ManageCategory;
import algo.Person;
import algo.RetrieveListUpdateStatus;
import algo.WarningList;

public class SalesPerson extends Person {

	public RetrieveListUpdateStatus retrieveListUpdateStatus;

	public WarningList warningList;
	public ManageCategory manageCategory;
	public CreManageItem creManageItem;

	public SalesPerson() {

		retrieveListUpdateStatus = new RetrieveListUpdateStatus();
		warningList = new WarningList();
		manageCategory = new ManageCategory();
		creManageItem = new CreManageItem();
		}

	public void dealCustomer(int listNo) {
		
	}

	public void sendShort(int upc) {

	}

}
