package com.infosys.project1.product.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.project1.product.Entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{


}