package com.swish.product.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swish.product.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

	public void findByStatus(String name);
 
	
	@Query("select pi from ProductEntity pi where name=:name and status=:status")
	public ProductEntity findByNameAndStatus(@Param("name") String productName, @Param("status") String productStatus); 
}
