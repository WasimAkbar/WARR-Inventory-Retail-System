package test;

import java.sql.SQLException;

import algo.ManageCategory;
import algo.ManageItem;
import junit.framework.TestCase;

public class Test_ManageCategory extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSearchCategory() {
		
		try {
			ManageCategory list = new ManageCategory();
			assertEquals(true, list.searchCategory(10).next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testGetAutoCate() {
		ManageItem list = new ManageItem();
		assertEquals(true, !list.getAutoUtem().isEmpty());
	}

}
