package com.springmvc.demomvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.demomvc.entity.Product;
import com.springmvc.demomvc.repo.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    // method findAll() nge return iterable jadi harus Iterable tipe data nya
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public void deleteById(long id) {
        productRepo.deleteById(id);
    }

    // mengambil data satu row
    public Optional<Product> findById(long id) {
        return productRepo.findById(id);
    }

    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    public List<Product> findByName(String keyword) {
        return productRepo.findByNameContains(keyword);

    }

}
