package com.isi.mvc.controller;


import com.isi.mvc.dtos.ProductDTO;
import com.isi.mvc.model.Product;
import com.isi.mvc.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service ;
    @PostMapping("/product-create")
    public String addProduct(
           @Valid @ModelAttribute("product") ProductDTO productDTO,
           BindingResult bindingResult,
           Model model
    )
    {
        if (bindingResult.hasErrors()){
            model.addAttribute("product",productDTO);
            return "product-create";
        }
        service.addProduct(productDTO);
        return "redirect:/index";
    }

    @GetMapping("/product-create")
    public String formProduct (Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-create" ;
    }

    @GetMapping("/index")
    public String listProducts (Model model) {
        List<ProductDTO> products = service.listProducts();
        model.addAttribute("products", products);
        return "listProducts";
    }

}
