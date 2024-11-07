package com.isi.mvc.dtos;


import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private Integer id;
    @NotEmpty(message = "la reference du produit est requise")
    private String ref;
    @NotEmpty(message = "Le nom de produit est requis")
    private String name;
}
