package spring.security.prospring3.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.security.prospring3.dao.IProductDao;
import spring.security.prospring3.data.Category;
import spring.security.prospring3.data.Item;


@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductDao productDao;
	
	@Override
	public Collection<Category> getCategories() {
		// Ch 5 @PostFilter
//		return productDao.getCategories();
		// Ch 5 @PreFilter
		Collection<Category> unfilteredCategories = productDao.getCategories();
		return productDao.filterCategories(unfilteredCategories);
	}

	@Override
	public Category getCategoryByName(String name) {
		return productDao.getCategoryByName(name);
	}

	@Override
	public Collection<Item> getItemsByCategory(Category cat) {
		return productDao.getItemsByCategory(cat);
	}

}
