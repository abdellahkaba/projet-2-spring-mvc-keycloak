package com.isi.mvc.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private Integer id;
    private String ref;
    private String name;
}
