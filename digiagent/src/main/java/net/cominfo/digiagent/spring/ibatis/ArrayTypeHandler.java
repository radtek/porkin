package net.cominfo.digiagent.spring.ibatis;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.ibatis.sqlmap.engine.type.BaseTypeHandler;
import com.ibatis.sqlmap.engine.type.TypeHandler;


/**
 * @author Administrator
 *
 */
public class ArrayTypeHandler extends BaseTypeHandler implements TypeHandler {

	
	/* (non-Javadoc)
	 * @see com.ibatis.sqlmap.engine.type.TypeHandler#getResult(java.sql.ResultSet, java.lang.String)
	 */
	public Object getResult(ResultSet rs, String columnName)
			throws SQLException {
		if (rs.wasNull()) {
			return null;
		} else {
			return rs.getArray(columnName).getArray();
		}
	}

	/* (non-Javadoc)
	 * @see com.ibatis.sqlmap.engine.type.TypeHandler#getResult(java.sql.ResultSet, int)
	 */
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		if (rs.wasNull()) {
			return null;
		} else {
			return rs.getArray(columnIndex).getArray();
		}
	}

	/* (non-Javadoc)
	 * @see com.ibatis.sqlmap.engine.type.TypeHandler#getResult(java.sql.CallableStatement, int)
	 */
	public Object getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		if (cs.wasNull()) {
			return null;
		} else {
			return cs.getArray(columnIndex).getArray();
		}
	}

	/* (non-Javadoc)
	 * @see com.ibatis.sqlmap.engine.type.TypeHandler#setParameter(java.sql.PreparedStatement, int, java.lang.Object, java.lang.String)
	 */
	public void setParameter(PreparedStatement ps, int i, Object param,
			String jdbcType) throws SQLException {
		if (param == null) {
			ps.setNull(i, Types.ARRAY);
		} else {
			Connection conn = ps.getConnection();
			Array loc = conn.createArrayOf("myArrayType", (Object[]) param);
			ps.setArray(i, loc);
		}
	}

	/* (non-Javadoc)
	 * @see com.ibatis.sqlmap.engine.type.TypeHandler#valueOf(java.lang.String)
	 */
	public Object valueOf(String s) {
		return s.getBytes();
	}

}
