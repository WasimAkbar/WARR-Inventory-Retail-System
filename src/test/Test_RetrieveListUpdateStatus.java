package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import algo.RetrieveListUpdateStatus;
import junit.framework.TestCase;

public class Test_RetrieveListUpdateStatus extends TestCase {

	public void testGetlist() {
		try {
			RetrieveListUpdateStatus list = new RetrieveListUpdateStatus();
			ResultSet rs = null;
			rs = list.getlist(51);
			////////////
			assertEquals(true, rs.isBeforeFirst());
			// assertEquals(true, list.getlist(51).next());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void testGetlistStatus() {
		try {
			RetrieveListUpdateStatus list = new RetrieveListUpdateStatus();
			assertEquals(true, list.getlistStatus(51).next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void testUpdateStatus() {
		try {
			RetrieveListUpdateStatus list = new RetrieveListUpdateStatus();
			assertEquals(true, list.UpdateStatus(51).next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void testDropItem() {

		RetrieveListUpdateStatus list = new RetrieveListUpdateStatus();
		ResultSet rs = null;
		assertEquals(true, list.dropItem(502, 51));
	}

}
