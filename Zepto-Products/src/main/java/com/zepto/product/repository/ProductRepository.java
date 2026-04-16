package com.zepto.product.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zepto.product.entity.ProductEntity;
import com.zepto.product.service.IProductService;

// responsible for data base interaction(CRUD --> Create Update Read and Delete) 
@Repository
public class ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public String uploadProduct(String input, String status) {

		String productId = java.util.UUID.nameUUIDFromBytes(input.getBytes()).toString().replace("-", "")
				.substring(0, 4).toUpperCase();

		// this object will be inserted as a record in the table
		ProductEntity product = new ProductEntity(productId, input, status);

		int prodId = (int) sessionFactory.getCurrentSession().save(product); // Create record in the table

		return prodId + "";
	}

	public String getProductAndCheckStatus(int productId) {
		
		ProductEntity response = sessionFactory.getCurrentSession().get(ProductEntity.class, productId); // Single Record
		
		Query<ProductEntity> allRecordsQuery = sessionFactory.getCurrentSession().createQuery("from ProductEntity", ProductEntity.class); // multiple Record
		
		List<ProductEntity> result = allRecordsQuery.list();
        
		for(ProductEntity entity : result)
		{
			System.out.println(entity.getId());
			System.out.println(entity.getStatus());
		}
		
		String status = response.getStatus();
		return status;
	}
	
//	public List<ProductEntity> getAllProducts() {
//	    return sessionFactory.getCurrentSession()
//	            .createQuery("from ProductEntity", ProductEntity.class)
//	            .list();
//	}
	
	public List<ProductEntity> getProductsWithPagination(int page, int size) {

	    return sessionFactory.getCurrentSession()
	            .createQuery("from ProductEntity", ProductEntity.class)
	            .setFirstResult((page - 1) * size)   // start index
	            .setMaxResults(size)                // limit
	            .list();
	}
	
	public void updateProductStatus(int productId, String newStatus) {
	    ProductEntity product = sessionFactory.getCurrentSession()
	            .get(ProductEntity.class, productId);

	    if (product != null) {
	        product.setStatus(newStatus);
	        sessionFactory.getCurrentSession().update(product);
	    }
	}
	
	public void deleteProduct(int productId) {
	    ProductEntity product = sessionFactory.getCurrentSession()
	            .get(ProductEntity.class, productId);

	    if (product != null) {
	        sessionFactory.getCurrentSession().delete(product);
	    }
	}
}