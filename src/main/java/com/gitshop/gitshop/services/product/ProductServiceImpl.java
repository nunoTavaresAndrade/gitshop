package com.gitshop.gitshop.services.product;


import com.gitshop.gitshop.models.Product;
import com.gitshop.gitshop.repositories.ProductRepository;
import javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void save(Product product) {
         productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return  productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> findProductByTitle(String title) {
        return  productRepository.findProductByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Product>findAllByCategorie(String categorie){
        return productRepository.findProductByCategorie(categorie);
    }

    @Override
    public List<Product> findAllByCategorieContaing(String categorie) {
        return productRepository.findProductByCategorieContainingIgnoreCase(categorie);
    }

    @Override
    public List<Product> findProductByDescription(String keyWord) {
        return productRepository.findProductByDescriptionContainingIgnoreCase(keyWord);
    }

    @Override
    public List<Product> findProductByKeyWord(String keyWord) {
        List<Product> foundByTitle = productRepository.findProductByTitleContainingIgnoreCase(keyWord);
        List<Product> foundByDescription = productRepository.findProductByDescriptionContainingIgnoreCase(keyWord);
        List<Product> foundByCategorie = productRepository.findProductByCategorieContainingIgnoreCase(keyWord);
        foundByTitle.removeAll(foundByDescription);
        foundByTitle.addAll(foundByDescription);
        foundByTitle.removeAll(foundByCategorie);
        foundByTitle.addAll(foundByCategorie);

        return foundByTitle;
    }
}