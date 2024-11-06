package com.isi.mvc.controller;


import com.isi.mvc.dtos.ProductDTO;
import com.isi.mvc.model.Product;
import com.isi.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service ;
    @PostMapping(path = "/save")
    public String addProduct(Model model, ProductDTO productDTO) {
        String productRef = service.addProduct(productDTO);
        model.addAttribute("message", "Produit ajouté avec succès ! Référence : " + productRef);
        return "redirect:/product/index";
    }

    @GetMapping("/formProduct")
    public String formProduct (Model model) {
        model.addAttribute("product",new Product());
        return "formProduct" ;
    }

    @GetMapping(path = "/index")
    public String listProducts (Model model) {
        List<ProductDTO> products = service.listProducts();
        model.addAttribute("products", products);
        return "listProducts";
    }

}
