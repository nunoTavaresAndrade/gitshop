package com.gitshop.gitshop.services.product;


import com.gitshop.gitshop.models.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);

    void deleteById(Long id);

    Product findById(Long id);

    List<Product> findAll();


    List<Product>findAllByCategorie(String categorie);

    List<Product>findAllByCategorieContaing(String categorie);

    List<Product> findProductByDescription(String keyWord);

    List<Product> findProductByKeyWord(String keyWord);

    List<Product> findProductByTitle(String name);
}
