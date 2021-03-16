package com.oms.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Optional<Product> findByProductName(String name);

	List<Product> findByCategory(String category);

}
