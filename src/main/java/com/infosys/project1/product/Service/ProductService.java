package com.infosys.project1.product.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.infosys.project1.product.DTO.ProductDTO;
import com.infosys.project1.product.DTO.SubscribedProductDTO;
import com.infosys.project1.product.Entity.ProductEntity;
import com.infosys.project1.product.Entity.SubscribedProductEntity;
import com.infosys.project1.product.Repository.ProductRepository;
import com.infosys.project1.product.Repository.SubscribedProductRepository;
import com.infosys.project1.product.Validator.ProductValidator;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	SubscribedProductRepository subprod;
	
	public List<ProductDTO> getproducts(){
		List<ProductEntity> product= productRepository.findAll();
		List<ProductDTO> productDTO= new ArrayList<ProductDTO>();
		for(ProductEntity p1: product) {
			ProductDTO product1= ProductDTO.valueof(p1);
			productDTO.add(product1);
		}
		return productDTO;
}
	
//	public List<SubscribedProductDTO> getsubscribedproducts() {
//		List<SubscribedProductEntity> product= subprod.findById();
//		List<SubscribedProductDTO> productDTO= new ArrayList<SubscribedProductDTO>();
//		for(SubscribedProductEntity p1: product) {
//			SubscribedProductDTO product1= SubscribedProductDTO.valueof(p1);
//			productDTO.add(product1);
//		}
//		return productDTO;
//}
		

	public List<ProductDTO> getproductsOnCategory(String category) {
		List<ProductEntity> product= productRepository.findAll();
		List<ProductDTO> productDTO= new ArrayList<ProductDTO>();
		for(ProductEntity p1: product) {
			if(category.equals(p1.getCategory())){	
			ProductDTO product1= ProductDTO.valueof(p1);
			productDTO.add(product1);
		}}
		return productDTO;
		
}
		
		public List<ProductDTO> getProductsOnName(String productname) {
		List<ProductEntity> product= productRepository.findAll();
		List<ProductDTO> productDTO= new ArrayList<ProductDTO>();
		for(ProductEntity p1: product) {
			if(productname.equals(p1.getProductName())){	
			ProductDTO product1= ProductDTO.valueof(p1);
			productDTO.add(product1);
		}}
		return productDTO;
		
}

		public ProductDTO getProductsOnId(Integer prodid) {
			ProductDTO product1 = null;
			Optional<ProductEntity> product= productRepository.findById(prodid);
			if(product.isPresent()) {
//			ProductDTO productDTO= new ProductDTO();
			if(prodid.equals(product.get().getProdid())) {
				product1= ProductDTO.valueon(product);
				
		}}return product1;}

		public void addproducts(ProductDTO productdto) throws Exception{
			ProductValidator.ProdValidate(productdto);
			ProductEntity pe=productdto.createEntity();
			productRepository.save(pe);
			
		}
		
		public void deleteproducts(Integer prodid) {
			productRepository.deleteById(prodid);
			}

		
		}


			