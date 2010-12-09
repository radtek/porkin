package net.cominfo.digiagent.service;

import java.util.Iterator;
import java.util.List;

import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.dao.SortableDao;
import net.cominfo.digiagent.persistence.domain.Sortable;
import net.cominfo.digiagent.persistence.domain.SortableCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SortableService {

	@Autowired
	private SortableDao sortableDao;

	@Autowired
	private SequenceDao sequenceDao;

	/**
	 * 根据Key获取Sortalbe对象
	 * 
	 * @param sortableList
	 * @param key
	 * @return
	 */
	private Sortable getSortableByKey(List<Sortable> sortableList, int key) {
		Sortable result = null;
		if (sortableList != null & sortableList.size() > 0) {
			Iterator<Sortable> iterator = sortableList.iterator();
			Sortable temp = null;
			while (iterator.hasNext()) {
				temp = iterator.next();
				if (temp.getSortableKey() == key) {
					result = temp;
					break;
				}
			}
		}
		return result;
	}

	
	/**
	 * 通用的重排序方法 
	 * @param childIds 排好序的子ID的数组
	 * @param rootId 父ID
	 * @param type 类型
	 */
	public void sort(int[] childIds, int rootId, String type) {

		// 查找现存的顺序
		Integer parentId = null;
		SortableCriteria criteria = new SortableCriteria();
		if(rootId>0){
			criteria.createCriteria().andSortableTypeEqualTo(type);
		}
		else{
			criteria.createCriteria().andSortableTypeEqualTo(type).andParentIdEqualTo(rootId);
			parentId = new Integer(rootId);
		}
		
		List<Sortable> sortableList = sortableDao.selectByExample(criteria);

		// 增加或更新顺序
		Sortable newSortable = null;
		for (int childId : childIds) {
			newSortable = getSortableByKey(sortableList, childId);

			// 新增类别顺序
			if (newSortable == null) {
				newSortable = new Sortable();
				newSortable.setSortableId(sequenceDao.getSortableNexId());
				newSortable.setSortableKey(childId);
				newSortable.setSortableOrder(sequenceDao.getSortOrderNexId());
				newSortable.setSortableType(type);
				newSortable.setParentId(parentId);
				sortableDao.insert(newSortable);
			}
			// 更新类别顺序
			else {
				sortableList.remove(newSortable);
				newSortable.setSortableOrder(sequenceDao.getSortOrderNexId());
				sortableDao.updateByPrimaryKey(newSortable);
			}
		}

		// 来用存储过程进行删除不用的Id及其子Id

	}

	/**
	 * 按categoryIds顺序增加或更新类别顺序号
	 * @param categoryIds
	 */
	public void sortCategory(int[] categoryIds) {
		sort(categoryIds, 0, "C"); 
	}

	/** 
	 * 按categoryId顺序增加或更新产品顺序号
	 * @param productIds
	 * @param categoryId
	 */
	public void sortProduct(int[] productIds,int categoryId) {
		sort(productIds, categoryId, "P");
	}
	
	/**
	 * 按productId顺序增加或更新品牌顺序号
	 * @param brandIds
	 * @param productId
	 */
	public void sortBrand(int[] brandIds,int productId) {
		sort(brandIds, productId, "B");
	}
}
