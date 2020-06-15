package com.infosys.project1.product.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.project1.product.DTO.ProductDTO;
import com.infosys.project1.product.DTO.SubscribedProductDTO;
import com.infosys.project1.product.Service.ProductService;


@RestController
@EnableAutoConfiguration
@CrossOrigin
public class ProductController {
		
@Autowired
public ProductService productservice;
		
	
Logger logger = LoggerFactory.getLogger(this.getClass());
		@GetMapping(value="/products",  produces = MediaType.APPLICATION_JSON_VALUE)
		public List<ProductDTO> getproducts() {
		List<ProductDTO> productDto=productservice.getproducts();
		return productDto;
		}
//		@GetMapping(value="/subscribedproducts",  produces = MediaType.APPLICATION_JSON_VALUE)
//		public List<ProductDTO> getsubcribedproducts() {
//		List<SubscribedProductDTO> subscribedproductDto=productservice.getsubscribedproducts();
//		return subscribedproductDto;
//		}
		@GetMapping(value="/products/category/{category}",   produces  = MediaType.APPLICATION_JSON_VALUE)
		public List<ProductDTO> getproductsOnCategory(@PathVariable String category) {
		List<ProductDTO> productDto=productservice.getproductsOnCategory(category);
		return productDto;
		}
		@GetMapping(value="/products/name/{productname}",   produces  = MediaType.APPLICATION_JSON_VALUE)
		public List<ProductDTO> getproductsOnName(@PathVariable String productname) {
		List<ProductDTO> productDto=productservice.getProductsOnName(productname);
		return productDto;
		}
		@GetMapping(value="/products/productid/{prodid}",   produces  = MediaType.APPLICATION_JSON_VALUE)
		public ProductDTO getproductsOnId(@PathVariable Integer prodid) {
		ProductDTO productDto=productservice.getProductsOnId(prodid);
		return productDto;
		}
		@PostMapping(value="/add/products",   consumes  = MediaType.APPLICATION_JSON_VALUE)
		public String addproducts(@RequestBody ProductDTO productdto) {
		try {
			productservice.addproducts(productdto);
			return "Products Added successfully!";
		} catch (Exception e) {
			return "Unable to add products!";
		}}
		@DeleteMapping(value="/delete/products/{prodid}", consumes= MediaType.APPLICATION_JSON_VALUE)
		public String deleteproducts(@PathVariable Integer prodid) {
			logger.info("Request for order removal by buyer {}", prodid);
			productservice.deleteproducts(prodid);
			return "Deleted successfully";
		

}}
