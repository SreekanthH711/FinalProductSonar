package com.oms.product.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.product.dto.SubscribedProductDTO;
import com.oms.product.entity.SubscribedProduct;
import com.oms.product.repository.SubscribedProductRepository;

@Service
public class SubscribedProductService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	SubscribedProductRepository subProdRepo;
	
	public SubscribedProductDTO getSubscriptionById(long subId) throws Exception {
		logger.info("======Subscriptions details : {}======", subId);
		SubscribedProductDTO subProdDTO = null;
		Optional<SubscribedProduct> optSubProduct = subProdRepo.findById(subId);
		if (!optSubProduct.isPresent()) {
			throw new Exception("Subscription.NOT_FOUND");
		}
		SubscribedProduct subProduct = optSubProduct.get();
		subProdDTO = SubscribedProductDTO.valueOf(subProduct);
	
		return subProdDTO;

	}
	
	public Integer addSubscription(SubscribedProductDTO subProdDTO) {
		logger.info("======Subscription Request for data {}======", subProdDTO);
		
		SubscribedProduct subProduct = subProdDTO.createEntity();
		subProdRepo.save(subProduct);
		return (int)subProduct.getSubId();
	}
	
}
