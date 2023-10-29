package com.springmvc.demomvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.demomvc.dto.SearchFormData;
import com.springmvc.demomvc.entity.Product;
import com.springmvc.demomvc.services.ProductService;

@Controller
// Anotasi diatas akan nge return html nya bukan json seperti @RestController
@RequestMapping("")
public class HomeController {

    @Autowired
    public ProductService productService;

    @GetMapping()
    public String sayHello(Model model) {
        String messages = "Hallo, Welcome to Spring MVC";
        model.addAttribute("msg", messages);
        model.addAttribute("searchForm", new SearchFormData());
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

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "editProduct";
    }

    @PostMapping("/update")
    public String update(Product product, Model model) {
        productService.updateProduct(product);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(SearchFormData searchFormData, Model model) {
        String messages = "Hallo, Welcome to Spring MVC";
        model.addAttribute("msg", messages);
        // Dibawah ini untuk menerima inputan dari searc form di index.html
        model.addAttribute("searchForm", searchFormData);
        // Dibawah ini untuk meng override object yang sudah diterapin sebelumnya di index.html
        model.addAttribute("products", productService.findByName(searchFormData.getKeyword()));
        return "index";
    }
}
