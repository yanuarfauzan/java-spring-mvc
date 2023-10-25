package com.springmvc.demomvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.demomvc.entity.Product;
import com.springmvc.demomvc.services.ProductService;

@Controller
// Anotasi diatas akan nge return html nya bukan json seperti @RestController
@RequestMapping("")
public class HomeController {

    @Autowired
    public ProductService productService;

    @GetMapping
    public String sayHello(Model model) {
        String messages = "Hallo, Welcome to Spring MVC";
        model.addAttribute("msg", messages);
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/addProduct")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        productService.deleteById(id);
        return "redirect:/";
    }
}
