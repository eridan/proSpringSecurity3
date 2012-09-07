package spring.security.prospring3.dao;

import java.util.Collection;

import org.springframework.security.access.prepost.PreFilter;
import spring.security.prospring3.data.Category;
import spring.security.prospring3.data.Item;


public interface IProductDao {

	/**
	 * Get all categories the user has access to.
	 * 
	 * @return the list of available categories
	 */
	Collection<Category> getCategories();

	/**
	 * Finds the category with the given name.
	 * @param name the name of the category to find.
	 * @return the matching category, or null
	 */
	Category getCategoryByName(String name);

	/**
	 * Filter the categories by security constraints.
	 * @param categories the categories to filter
	 * @return the filtered collection
	 */
	// Ch 5 @PreFilter
	@PreFilter("(!filterObject.customersOnly) or (filterObject.customersOnly and hasRole('ROLE_ADMIN'))")
	public Collection<Category> filterCategories(Collection<Category> categories);
	
	public Collection<Item> getItemsByCategory(Category cat);
}