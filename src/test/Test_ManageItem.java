package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import algo.ManageItem;
import junit.framework.TestCase;

public class Test_ManageItem extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSearchItem() {
		try {
			ManageItem list = new ManageItem();
			assertEquals(true, list.searchItem(502).next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void testSendShortItem() {
		try {
			ManageItem list = new ManageItem();
			assertEquals(true, list.sendShortItem(996).next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
