package com.zepto.product.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zepto.product.category.entity.Category;

public interface ProductCategoryRepository extends CrudRepository<Category, Integer>{
	/*
	@EntityGraph(attributePaths = "products")
	public Iterable<Category> findAll();
	*/
	
//	@Query("select distinct c from Category c join fetch c.products") 
//	public Iterable<Category> findall(); -->We can not use Iterable with join fetch
	
	@Query("select distinct c from Category c join fetch c.products")
	public List<Category> findAll();
}


/*(N+1) problem N is child and 1 is parent 
Hibernate: select c1_0.id,c1_0.category_name,c1_0.description,c1_0.status from category c1_0
Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.status from product p1_0 where p1_0.category_id=?
Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.status from product p1_0 where p1_0.category_id=?
Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.status from product p1_0 where p1_0.category_id=?
Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.status from product p1_0 where p1_0.category_id=?
Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.status from product p1_0 where p1_0.category_id=?
Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.status from product p1_0 where p1_0.category_id=?
Product Name: Mouse
Product Id: 1
Product Name: Laptop
Product Id: 2
Product Name: Mouse2
Product Id: 53
Product Name: 
Product Id: 52
Product Name: Powder
Product Id: 102
Product Name: Transformer
Product Id: 152
*/


/* Solution of N+1 problem
Hibernate: select distinct c1_0.id,c1_0.category_name,c1_0.description,p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.status,c1_0.status from category c1_0 join product p1_0 on c1_0.id=p1_0.category_id
Product Name: Mouse
Product Id: 1
Product Name: Laptop
Product Id: 2
Product Name: Mouse2
Product Id: 53
Product Name: 
Product Id: 52
Product Name: Powder
Product Id: 102
Product Name: Transformer
Product Id: 152
*/