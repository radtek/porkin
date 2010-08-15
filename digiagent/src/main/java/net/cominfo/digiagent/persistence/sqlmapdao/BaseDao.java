package net.cominfo.digiagent.persistence.sqlmapdao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDao extends SqlMapClientDaoSupport {
	
	private String countSqlKey;
	
	private String listSqlKey;
	
	
	
	public String getCountSqlKey() {
		return countSqlKey;
	}

	public void setCountSqlKey(String countSqlKey) {
		this.countSqlKey = countSqlKey;
	}

	public String getListSqlKey() {
		return listSqlKey;
	}

	public void setListSqlKey(String listSqlKey) {
		this.listSqlKey = listSqlKey;
	}

	@Autowired
	public void setSqlMapClientBase(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}
	
	// FIXME expend start
	@SuppressWarnings("unchecked")
	public List<? extends Object> queryListByExample(Object example,  
            PaginationContext paginationContext){
		
		assert paginationContext.getSkipResults() >= 0;  
        assert paginationContext.getMaxResults() >= 0;  
  
        try {  
            List<?> result = new ArrayList();  
            try {  
            	getSqlMapClient().startTransaction();  
                performQuery(example, paginationContext, result);  
                getSqlMapClient().commitTransaction();  
            } finally {  
            	getSqlMapClient().endTransaction();  
            }  
            return Collections.unmodifiableList(result);  
        } catch (SQLException e) {  
            throw new RuntimeException(e);  
        }  
		
	}
	
	@SuppressWarnings("unchecked")  
    private void performQuery(Object example,  
            PaginationContext paginationContext, List<?> result)  
            throws SQLException {  
  
        // Gather total number of results using a separate query  
        if (!paginationContext.hasTotalCount()) {  
            updateTotalCount(example, paginationContext);  
        }  
  
        // iBatis does physical pagination using database cursor if  
        // available using ResultSet.absolute(position);  
        List queryForList = getSqlMapClient().queryForList(listSqlKey,  
        		example, paginationContext.getSkipResults(),  
                paginationContext.getMaxResults());  
        result.addAll(queryForList);  
    }  
  
    private void updateTotalCount(Object example,  
            PaginationContext paginationContext) throws SQLException {  
        paginationContext.updateTotalCount((Integer) getSqlMapClient()  
                .queryForObject(countSqlKey, example));  
    } 
	// expend end
}
