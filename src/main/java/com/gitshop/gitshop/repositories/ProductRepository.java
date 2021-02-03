package com.gitshop.gitshop.repositories;

import com.gitshop.gitshop.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findProductByTitleContainingIgnoreCase(String title);

    List<Product> findProductByDescriptionContainingIgnoreCase(String keyWord);


    List<Product> findProductByCategorie(String categorie);

    List<Product> findProductByCategorieContainingIgnoreCase(String categorie);

    Optional<Product> findById(Long id);
}
