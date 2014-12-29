package actors;

import controller.ConCommonTaskAM;
import algo.Person;
import algo.SendWarning;
import algo.ShortList;
import creator.CreManageBudget;
import creator.CreManagePerson;

public class Manager extends Person implements ConCommonTaskAM {

	private SendWarning sendWarning;

	private ShortList shortList;

	private CreManageBudget creManageBudget;

	private CreManagePerson creManagePerson;

	public void sendwarningftn() {

	}

	public void viewShortList() {

	}


	/**
	 * @see controller.ConCommonTaskAM#managebudget()
	 */
	public void managebudget() {

	}


	/**
	 * @see controller.ConCommonTaskAM#manageperson()
	 */
	public void manageperson() {

	}

}
