package com.isi.mvc.service;

import com.isi.mvc.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    String addProduct(ProductDTO productDTO);
    List<ProductDTO> listProducts();
}
