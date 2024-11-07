package com.isi.mvc.service.impl;

import com.isi.mvc.dtos.ProductDTO;
import com.isi.mvc.exception.NameConflictException;
import com.isi.mvc.mapper.ProductMapper;
import com.isi.mvc.model.Product;
import com.isi.mvc.repository.ProductRepository;
import com.isi.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    @Override
    public Product addProduct(ProductDTO productDTO) {
        if (repository.findByName(productDTO.getName()).isPresent()){
            throw new NameConflictException("Ce nom du produit existe deja" + productDTO.getName());
        }
        return repository.save(mapper.toProduct(productDTO));
    }
    @Override
    public List<ProductDTO> listProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::fromProduct)
                .collect(Collectors.toList());
    }
}
