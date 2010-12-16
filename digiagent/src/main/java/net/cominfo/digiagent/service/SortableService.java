package net.cominfo.digiagent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CategoryDao;
import net.cominfo.digiagent.persistence.dao.ProductBrandDao;
import net.cominfo.digiagent.persistence.dao.ProductDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.dao.SortableDao;
import net.cominfo.digiagent.persistence.dao.SupplierProductDao;
import net.cominfo.digiagent.persistence.domain.Category;
import net.cominfo.digiagent.persistence.domain.CategoryCriteria;
import net.cominfo.digiagent.persistence.domain.Product;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.persistence.domain.ProductBrandCriteria;
import net.cominfo.digiagent.persistence.domain.ProductCriteria;
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

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductBrandDao productBrandDao;

	@Autowired
	private SupplierProductDao supplierProductDao;

	/**
	 * 类型标志位枚举
	 * 
	 */
	public enum TypeFlag {
		Category("C") {
			@Override
			public TypeFlag parent() {
				return null;
			}
		},
		Product("P") {
			@Override
			public TypeFlag parent() {
				return Category;
			}
		},
		Brand("B") {
			@Override
			public TypeFlag parent() {
				return Product;
			}
		},
		Supplier("S") {
			@Override
			public TypeFlag parent() {
				return Brand;
			}
		};

		private String flag;

		public String getFlag() {
			return flag;
		}

		private TypeFlag(String flag) {
			this.flag = flag;
		}

		// 找到上级标志位
		public abstract TypeFlag parent();
	}

	/**
	 * 对Sortable表进行初始化
	 */
	@SuppressWarnings("unchecked")
	public void reset() {
		sequenceDao.resetSortable();
		sequenceDao.resetSortOrder();
		sortableDao.cleanAll();

		// 将类别信息导入Sortable表
		CategoryCriteria categoryCriteria = new CategoryCriteria();
		categoryCriteria.createCriteria();
		List<Category> categoryList = categoryDao
				.selectByExample(categoryCriteria);
		if (categoryList != null && categoryList.size() > 0) {
			for (Category c : categoryList) {
				insertSortable(c.getCategoryId(), null, TypeFlag.Category
						.getFlag());
			}
		}

		// 将产品信息导入Sortable表
		ProductCriteria productCriteria = new ProductCriteria();
		productCriteria.createCriteria();
		List<Product> productList = productDao.selectByExample(productCriteria);
		for (Product p : productList) {
			rebuild(p.getProductId(), p.getCategoryId(), TypeFlag.Product);
		}

		// 将品牌信息导入Sortable表
		ProductBrandCriteria productBrandCriteria = new ProductBrandCriteria();
		productBrandCriteria.createCriteria();
		List<ProductBrand> productBrandList = productBrandDao
				.selectByExample(productBrandCriteria);
		for (ProductBrand pb : productBrandList) {
			rebuild(pb.getBrandId(), pb.getProductId(), TypeFlag.Brand);
		}

		// 将供应商信息导入Sortable表
		List<Map> brandSupplierList = supplierProductDao.getAllBrandSupplier();
		for (Map bs : brandSupplierList) {
			Integer brandId = (Integer) bs.get("brandId");
			Integer supplierId = (Integer) bs.get("supplierId");
			rebuild(supplierId, brandId, TypeFlag.Supplier);
		}
	}

	/**
	 * 将重建Sortable表,用sortKey,父级sortKey和类型
	 * 
	 * @param sortKey
	 *            ,可能为productId,brandId, supplierId
	 * @param parentSortKey
	 *            ,相应的父级sortKey
	 * @param type
	 */
	public void rebuild(Integer sortKey, Integer parentSortKey,
			TypeFlag typeFlag) {
		SortableCriteria parentCriteria = new SortableCriteria();
		parentCriteria.createCriteria().andSortableTypeEqualTo(
				typeFlag.parent().getFlag()).andSortableKeyEqualTo(
				parentSortKey);
		List<Sortable> sortableList = sortableDao
				.selectByExample(parentCriteria);
		if (sortableList != null & sortableList.size() > 0) {
			Sortable parent = sortableList.get(0);
			Integer parentId = parent.getSortableId();
			insertSortable(sortKey, parentId, typeFlag.getFlag());
		}
	}

	/**
	 * 插入sortable对象
	 * 
	 * @param sortKey
	 * @param parentId
	 * @param type
	 */
	public void insertSortable(Integer sortKey, Integer parentId, String type) {
		Sortable sortable = new Sortable();
		sortable.setSortableId(sequenceDao.getSortableNexId());
		sortable.setSortableKey(sortKey);
		sortable.setSortableOrder(sequenceDao.getSortOrderNexId());
		sortable.setSortableType(type);
		sortable.setParentId(parentId);
		sortableDao.insert(sortable);
	}

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
			for (Sortable temp : sortableList) {
				if (temp.getSortableKey().intValue() == key) {
					result = temp;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 删除sortableList中指定的Sortalbe对象
	 * 
	 * @param sortableList
	 * @param key
	 * @return
	 */
	private List<Sortable> removeSortable(List<Sortable> sortableList,
			Sortable existSortable) {
		List<Sortable> result = new ArrayList<Sortable>();
		if ((sortableList != null & sortableList.size() > 0)
				&& existSortable != null) {
			int key = existSortable.getSortableKey();
			for (Sortable temp : sortableList) {
				if (temp.getSortableKey().intValue() != key) {
					result.add(temp);
				}
			}
		}
		return result;
	}

	/**
	 * 查找sortKey的主键
	 * 
	 * @param sortKey
	 * @param type
	 * @return
	 */
	private int getParentId(int parentSortKey, String type) {
		int result = 0;
		SortableCriteria criteria = new SortableCriteria();
		criteria.createCriteria().andSortableTypeEqualTo(type)
				.andSortableKeyEqualTo(parentSortKey);
		List<Sortable> sortableList = sortableDao.selectByExample(criteria);
		if (sortableList != null & sortableList.size() > 0) {
			result = sortableList.get(0).getSortableId();
		}
		return result;
	}

	/**
	 * 通用的重排序方法
	 * 
	 * @param childIds
	 *            排好序的子ID的数组
	 * @param rootId
	 *            父ID
	 * @param type
	 *            类型
	 */
	private void sort(int[] sortableKeyList, int Pid, String type) {

		// 查找现存的顺序
		Integer parentId = null;
		SortableCriteria criteria = new SortableCriteria();
		if (Pid > 0) {
			criteria.createCriteria().andSortableTypeEqualTo(type)
					.andParentIdEqualTo(Pid);
			parentId = new Integer(Pid);
		} else {
			criteria.createCriteria().andSortableTypeEqualTo(type);
		}

		List<Sortable> sortableList = sortableDao.selectByExample(criteria);

		// 增加或更新顺序
		Sortable existSortable = null;
		Sortable newSortable = null;
		for (int sortableKey : sortableKeyList) {
			existSortable = getSortableByKey(sortableList, sortableKey);

			// 新增类别顺序
			if (existSortable == null) {
				newSortable = new Sortable();
				newSortable.setSortableId(sequenceDao.getSortableNexId());
				newSortable.setSortableKey(sortableKey);
				newSortable.setSortableOrder(sequenceDao.getSortOrderNexId());
				newSortable.setSortableType(type);
				newSortable.setParentId(parentId);
				sortableDao.insert(newSortable);
			}
			// 更新类别顺序
			else {
				sortableList = removeSortable(sortableList, existSortable);
				existSortable.setSortableOrder(sequenceDao.getSortOrderNexId());
				sortableDao.updateByPrimaryKey(existSortable);
			}
		}

		// 来用存储过程进行删除不用的Id及其子Id
		for (Sortable sortable : sortableList) {
			Integer sortableId = sortable.getSortableId();
			sortableDao.deleteByPrimaryKey(sortableId);
		}

	}

	/**
	 * 按categoryIds顺序增加或更新类别顺序号
	 * 
	 * @param categoryIds
	 */
	public void sortCategory(int[] categoryIds) {
		sort(categoryIds, 0, TypeFlag.Category.getFlag());
	}

	/**
	 * 按categoryId顺序增加或更新产品顺序号
	 * 
	 * @param productIds
	 * @param categoryId
	 */
	public void sortProduct(int[] productIds, int categoryId) {
		int parentId = getParentId(categoryId, TypeFlag.Category.getFlag());
		sort(productIds, parentId, TypeFlag.Product.getFlag());
	}

	/**
	 * 按productId顺序增加或更新品牌顺序号
	 * 
	 * @param brandIds
	 * @param productId
	 */
	public void sortBrand(int[] brandIds, int productId) {
		int parentId = getParentId(productId, TypeFlag.Product.getFlag());
		sort(brandIds, parentId, TypeFlag.Brand.getFlag());
	}

	/**
	 * 按brandId顺序增加或更新供应商顺序号
	 * 
	 * @param brandIds
	 * @param productId
	 */
	public void sortSupplier(int[] supplierIds, int brandId) {
		int parentId = getParentId(brandId, TypeFlag.Brand.getFlag());
		sort(supplierIds, parentId, TypeFlag.Supplier.getFlag());
	}

	public List<Integer> getAllChild(Integer rootId) {
		return sortableDao.getAllChildId(rootId);
	}
}
