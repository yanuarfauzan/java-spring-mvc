package com.springmvc.demomvc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springmvc.demomvc.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    // The righname query ( spring jpa automatis akan langsung tahu dari nama function nya )
    List<Product> findByNameContains(String keyword);
}
