package com.springmvc.demomvc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springmvc.demomvc.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
 
    List<Product> findByNameContains(String keyword);
}
