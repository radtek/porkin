package org.easymock.sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBImpl {
	@SuppressWarnings("unchecked")
	public List query(Connection conn) throws SQLException {
		List list = new ArrayList();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select user_name from t_da_user");
		try {
			ResultSet rs = ps.executeQuery();
			try {
				while (rs.next()) {
					list.add(rs.getString(1));
				}
			} finally {
				rs.close();
			}
		} finally {
			ps.close();
		}
		return list;
	}

}
