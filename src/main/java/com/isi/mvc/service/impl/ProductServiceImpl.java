package com.isi.mvc.service.impl;

import com.isi.mvc.repository.ProductRepository;
import com.isi.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
}
