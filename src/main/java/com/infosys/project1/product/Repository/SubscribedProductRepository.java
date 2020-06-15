package com.infosys.project1.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.project1.product.Entity.ProductEntity;

public interface SubscribedProductRepository extends JpaRepository<ProductEntity, Integer>{

}
