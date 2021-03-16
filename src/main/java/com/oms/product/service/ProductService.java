package com.oms.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;

import com.oms.product.dto.ProductDTO;
import com.oms.product.entity.Product;
import com.oms.product.repository.ProductRepository;
import com.oms.product.validator.Validator;

@Service
public class ProductService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductRepository prodRepo;
	
	public List<ProductDTO> getAllProducts() {

		List<Product> products = prodRepo.findAll();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

		for (Product prod : products) {
			ProductDTO productDTO = ProductDTO.valueOf(prod);
			productDTOs.add(productDTO);
		}

		logger.info("======Product details : {}======", productDTOs);
		return productDTOs;
	}
	
	public ProductDTO getProductById(long prodId) throws Exception {
		logger.info("======Product details : {}======", prodId);
		ProductDTO prodDTO = null;
		Optional<Product> optProduct = prodRepo.findById(prodId);
		if (!optProduct.isPresent()) {
			throw new Exception("Product.NOT_FOUND");
		}
		Product product = optProduct.get();
		prodDTO = ProductDTO.valueOf(product);
	
		return prodDTO;

	}
	
	public ProductDTO getProductByName(String name) throws Exception {
		logger.info("======Product Name : {}======", name);
		ProductDTO prodDTO = null;
		Optional<Product> optProduct = prodRepo.findByProductName(name);
		if (!optProduct.isPresent()) {
			throw new Exception("Name.NOT_FOUND");
		}
		Product product = optProduct.get();
		prodDTO = ProductDTO.valueOf(product);
		
		return prodDTO;

	}
	
	public List<ProductDTO> getProductByCategory(String category) throws Exception {
		logger.info("======Product Category : {}======", category);
		
		List<ProductDTO> prodDTOByCategory = new ArrayList<ProductDTO>();
		List<Product> productsByCategory = prodRepo.findByCategory(category);
		
		if (productsByCategory.isEmpty()) {
			throw new Exception("Category.NOT_FOUND");
		}
		for(Product product : productsByCategory) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			prodDTOByCategory.add(productDTO);		
		}
		return prodDTOByCategory;

	}
	
	public void addProduct(Long sellerId, ProductDTO prodDTO) throws Exception {
		logger.info("======Product Creation Request for data {}======", prodDTO);
		
		if(!Validator.validateName(prodDTO.getProductName())) {
			throw new Exception("ProductValidator.INVALID_NAME");
		}
		else if(!Validator.validatePrice(prodDTO.getPrice())) {
			throw new Exception("ProductValidator.INVALID_PRICE");
		}
		else if(!Validator.validateStock(prodDTO.getStock())) {
			throw new Exception("ProductValidator.INVALID_STOCK");
		}
		else if(!Validator.validateImage(prodDTO.getImage())) {
			throw new Exception("ProductValidator.INVALID_IMAGE");
		}
		else if(!Validator.validateDescription(prodDTO.getDescription())) {
			throw new Exception("ProductValidator.INVALID_DESCRIPTION");
		}
		
		Product product = prodDTO.createProduct();
		
		prodRepo.save(product);
	}
	
	public void deleteProductById(Long productId) throws Exception {
		logger.info("======Product Deletion Request for product with ID{}======", productId);
		Optional<Product> optProduct = prodRepo.findById(productId);
		if (!optProduct.isPresent()) {
			throw new Exception("Product.NOT_FOUND");
		}
		
		prodRepo.deleteById(productId);
	}
	
	public ProductDTO updateStock(Long productId, Integer quantity) throws Exception {
		logger.info("======Product Stock Updation Request for product with ID{}======", productId);
		//Long stock = new Long(quantity);
		Product existingProduct = null;
		Optional<Product> optProduct = prodRepo.findById(productId);
		if (!optProduct.isPresent()) {
			throw new Exception("Product.NOT_FOUND");
		}
		existingProduct = optProduct.get();
		existingProduct.setStock(quantity);
		prodRepo.save(existingProduct);
		
		return ProductDTO.valueOf(existingProduct);
	}
}
