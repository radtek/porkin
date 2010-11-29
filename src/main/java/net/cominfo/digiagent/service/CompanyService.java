package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;

import net.cominfo.digiagent.persistence.dao.CityDao;
import net.cominfo.digiagent.persistence.dao.ProductBrandDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.dao.SupplierDao;
import net.cominfo.digiagent.persistence.dao.SupplierProductDao;
import net.cominfo.digiagent.persistence.dao.UserDao;
import net.cominfo.digiagent.persistence.domain.City;
import net.cominfo.digiagent.persistence.domain.CityCriteria;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.persistence.domain.ProductBrandCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierProduct;
import net.cominfo.digiagent.persistence.domain.SupplierProductCriteria;
import net.cominfo.digiagent.persistence.domain.SupplierWithBLOBs;
import net.cominfo.digiagent.persistence.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private SupplierDao supplierDao;

	@Autowired
	private CityDao cityDao;

	@Autowired
	private ProductBrandDao productBrandDao;

	@Autowired
	private SupplierProductDao supplierProductDao;

	public User getUserById(Integer userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	public boolean validateUser(Integer userId, String password) {
		boolean result = false;
		User user = userDao.selectByPrimaryKey(userId);
		result = user.getUserPassword().equals(password);
		return result;
	}

	public void changePassword(Integer userId, String password) {
		User user = userDao.selectByPrimaryKey(userId);
		user.setUserPassword(password);
		user.setLastupdatedBy(user.getUserName());
		user.setLastupdatedDate(new Date());
		userDao.updateByPrimaryKey(user);
	}

	public void changeEmail(Integer userId, String email) {
		User user = userDao.selectByPrimaryKey(userId);
		user.setUserEmail(email);
		user.setLastupdatedBy(user.getUserName());
		user.setLastupdatedDate(new Date());
		userDao.updateByPrimaryKey(user);
	}

	public SupplierWithBLOBs getCompanyByUserId(Integer userId) {
		SupplierWithBLOBs result = null;
		SupplierCriteria supplierCriteria = new SupplierCriteria();
		supplierCriteria.createCriteria().andUserIdEqualTo(userId);
		List<SupplierWithBLOBs> supplirList = supplierDao
				.selectByExampleWithBLOBs(supplierCriteria);
		if (supplirList != null && supplirList.size() > 0) {
			result = supplirList.get(0);
		}
		return result;
	}

	public void updateSupplier(SupplierWithBLOBs supplier) {
		supplierDao.updateByPrimaryKey(supplier);
	}

	public SupplierWithBLOBs createDefaulutSupplier(Integer userId,
			String userName) {

		SupplierWithBLOBs supplier = new SupplierWithBLOBs();
		supplier.setSupplierId(sequenceDao.getSupplierNexId());
		supplier.setSupplierAccess(0);
		supplier.setSupplierAddress(" ");
		supplier.setSupplierContactname(" ");
		supplier.setSupplierDescription(" ");
		supplier.setSupplierFax(" ");
		supplier.setSupplierImage(new byte[] { 0, 0 });
		supplier.setSupplierMobile(" ");
		supplier.setSupplierName(" ");
		supplier.setSupplierScore(0);
		supplier.setSupplierTelephone(" ");
		supplier.setSupplierZip(" ");

		supplier.setCityId(1);
		supplier.setCreatedBy(userName);
		supplier.setCreatedDate(new Date());
		supplier.setLastupdatedBy(userName);
		supplier.setLastupdatedDate(new Date());
		supplier.setActiveFlag("Y");
		supplier.setUserId(userId);

		supplierDao.insert(supplier);

		return supplier;
	}

	public List<City> getAllCity() {
		CityCriteria example = new CityCriteria();
		example.createCriteria();
		return cityDao.selectByExample(example);

	}

	public void applySupplier(Integer supplierId, Integer brandId,
			Integer productId, String userName) {
		ProductBrandCriteria productBrandCriteria = new ProductBrandCriteria();
		productBrandCriteria.createCriteria().andBrandIdEqualTo(brandId)
				.andProductIdEqualTo(productId);
		List<ProductBrand> productBrandbList = productBrandDao
				.selectByExample(productBrandCriteria);
		ProductBrand productBrand = null;
		if (productBrandbList != null && productBrandbList.size() > 0) {
			productBrand = productBrandbList.get(0);
		} else {
			productBrand = new ProductBrand();
			productBrand.setProductbrandId(sequenceDao.getProductbrandNexId());
			productBrand.setBrandId(brandId);
			productBrand.setProductId(productId);
			productBrand.setCreatedBy(userName);
			productBrand.setCreatedDate(new Date());
			productBrand.setLastupdatedBy(userName);
			productBrand.setLastupdatedDate(new Date());
			productBrand.setActiveFlag("Y");
			productBrandDao.insert(productBrand);
		}
		int productBrandId = productBrand.getProductbrandId();
		SupplierProductCriteria supplierProductCriteria = new SupplierProductCriteria();
		supplierProductCriteria.createCriteria().andSupplierIdEqualTo(
				supplierId).andProductbrandIdEqualTo(productBrandId);
		
		int supplierProductCount = supplierProductDao.countByExample(supplierProductCriteria);
		if (supplierProductCount<=0) {
			SupplierProduct supplierProduct = new SupplierProduct();
			supplierProduct.setProductbrandId(productBrandId);
			supplierProduct.setSupplierId(supplierId);
			supplierProduct.setCreateDate(new Date());
			supplierProductDao.insert(supplierProduct);
		}
	}

}
