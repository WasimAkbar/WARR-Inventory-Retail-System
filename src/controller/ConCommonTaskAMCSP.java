package controller;

import algo.LoginAuthorization;
import algo.ManageCategory;
import creator.CreManageItem;
import creator.CreManageCategory;

public class ConCommonTaskAMCSP {

	private LoginAuthorization loginAuthorization;

	private CreManageItem creManageItem;

	public CreManageCategory creManageCategory;
	
	
	public ManageCategory manageCategory;

	public ConCommonTaskAMCSP() {

		creManageCategory = new CreManageCategory();
	}

}
