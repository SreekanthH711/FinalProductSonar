package com.oms.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.product.entity.SubscribedProduct;

public interface SubscribedProductRepository extends JpaRepository<SubscribedProduct, Long>{

}
