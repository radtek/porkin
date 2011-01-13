package net.cominfo.digiagent.persistence.dao;

import net.cominfo.digiagent.persistence.domain.Sequence;
import net.cominfo.digiagent.persistence.sqlmapdao.SequenceDAOImpl;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceDao extends SequenceDAOImpl {

	private final int START_POINT = 1;

	private final String USER_KEY = "user";

	private final String COMMODITY_KEY = "commodity";

	private final String BRAND_KEY = "brand";

	private final String CATEGORY_KEY = "category";

	private final String CITY_KEY = "city";

	private final String COMMODITYIMAGE_KEY = "commodityimage";

	private final String CONTACT_KEY = "contact";

	private final String COUNTRY_KEY = "country";

	private final String HISTORY_KEY = "history";

	private final String PRODUCT_KEY = "product";

	private final String PRODUCTBRAND_KEY = "productbrand";

	private final String PROVINCE_KEY = "province";

	private final String ROLE_KEY = "role";

	private final String SUPPLIER_KEY = "supplier";

	private final String SUPPLIERPRODUC_KEY = "supplierproduc";

	private final String USERROLE_KEY = "userrole";

	private final String COMMENTS_KEY = "comments";

	private final String SORTABLE_KEY = "sortable";

	private final String SORT_ORDER_KEY = "sort_order";

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
		sequence.setNextid(result + 1);
		updateByPrimaryKey(sequence);
		return result;
	}

	public void reset(String name) throws DataAccessException {
		Sequence sequence = selectByPrimaryKey(name);
		if (sequence == null) {
			throw new DataRetrievalFailureException("'" + name
					+ "': sequence does not exist");
		}
		sequence.setNextid(START_POINT);
		updateByPrimaryKey(sequence);
	}

	public int getUserNexId() {
		return getNextId(USER_KEY);
	}

	public int getCommodityNexId() {
		return getNextId(COMMODITY_KEY);
	}

	public int getBrandNexId() {
		return getNextId(BRAND_KEY);
	}

	public int getCategoryNexId() {
		return getNextId(CATEGORY_KEY);
	}

	public int getCityNexId() {
		return getNextId(CITY_KEY);
	}

	public int getCommodityimageNexId() {
		return getNextId(COMMODITYIMAGE_KEY);
	}

	public int getContactNexId() {
		return getNextId(CONTACT_KEY);
	}

	public int getCountryNexId() {
		return getNextId(COUNTRY_KEY);
	}

	public int getHistoryNexId() {
		return getNextId(HISTORY_KEY);
	}

	public int getProductNexId() {
		return getNextId(PRODUCT_KEY);
	}

	public int getProductbrandNexId() {
		return getNextId(PRODUCTBRAND_KEY);
	}

	public int getProvinceNexId() {
		return getNextId(PROVINCE_KEY);
	}

	public int getRoleNexId() {
		return getNextId(ROLE_KEY);
	}

	public int getSupplierNexId() {
		return getNextId(SUPPLIER_KEY);
	}

	public int getSupplierproducNexId() {
		return getNextId(SUPPLIERPRODUC_KEY);
	}

	public int getUserroleNexId() {
		return getNextId(USERROLE_KEY);
	}

	public int getCommentsNexId() {
		return getNextId(COMMENTS_KEY);
	}

	public int getSortableNexId() {
		return getNextId(SORTABLE_KEY);
	}

	public int getSortOrderNexId() {
		return getNextId(SORT_ORDER_KEY);
	}

	public void resetSortable() {
		reset(SORTABLE_KEY);
	}

	public void resetSortOrder() {
		reset(SORT_ORDER_KEY);
	}

}
