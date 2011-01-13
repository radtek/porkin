package org.easymock.sample;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class JDBCTest {
	private DBImpl dbimpl;

	@Before
	public void setUp() throws Exception {
		dbimpl = new DBImpl();
	}
	
	@After
	public void tearDown() throws Exception {
		dbimpl = null;
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testJdbc() throws SQLException {
		IMocksControl control = EasyMock.createControl();
		Connection conn = control.createMock(Connection.class);
		ResultSet rs = control.createMock(ResultSet.class);
		PreparedStatement ps = control.createMock(PreparedStatement.class);

		EasyMock
				.expect(conn.prepareStatement(("select user_name from t_da_user")))
				.andReturn(ps);
		EasyMock.expect(ps.executeQuery()).andReturn(rs);
		EasyMock.expect(rs.next()).andReturn(true);
		EasyMock.expect(rs.getString(1)).andReturn("root");
		EasyMock.expect(rs.next()).andReturn(true);
		EasyMock.expect(rs.getString(1)).andReturn("tester");
		EasyMock.expect(rs.next()).andReturn(true);
		EasyMock.expect(rs.getString(1)).andReturn("中文");
		EasyMock.expect(rs.next()).andReturn(false);

		rs.close();

		ps.close();

		control.replay();
		List expected = Arrays.asList(new String[] { "root", "tester", "中文" });
		List result = dbimpl.query((Connection) conn);
		assertEquals(expected, result);
		control.verify();

	}
}
