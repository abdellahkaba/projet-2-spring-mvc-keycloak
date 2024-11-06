package com.isi.mvc.service.impl;

import com.isi.mvc.dtos.ProductDTO;
import com.isi.mvc.mapper.ProductMapper;
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
    public String addProduct(ProductDTO productDTO) {
        var product = repository.save(mapper.toProduct(productDTO));
        return product.getRef();
    }
    @Override
    public List<ProductDTO> listProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::fromProduct)
                .collect(Collectors.toList());
    }
}
