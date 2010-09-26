package net.cominfo.digiagent.persistence.dao;

import net.cominfo.digiagent.persistence.domain.Sequence;
import net.cominfo.digiagent.persistence.sqlmapdao.SequenceDAOImpl;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceDao extends SequenceDAOImpl {
	
	private final String USER_KEY = "user";

	/**
	 * This is a generic sequence ID generator that is based on a database table
	 * called 'SEQUENCE', which contains two columns (NAME, NEXTID). This
	 * approach should work with any database.
	 * 
	 * @param name
	 *            the name of the sequence
	 * @return the next ID
	 */
	public int getNextId(String name) throws DataAccessException {
		
		Sequence sequence = selectByPrimaryKey(name);
		
		if (sequence == null) {
			throw new DataRetrievalFailureException(
					"Could not get next value of sequence '" + name
							+ "': sequence does not exist");
		}
		
		int result = sequence.getNextid();
		sequence.setNextid(result+1);
		updateByPrimaryKey(sequence);
		return result;
	}
	
	
	public int getUserNexId(){
		return getNextId(USER_KEY);
	}

}
