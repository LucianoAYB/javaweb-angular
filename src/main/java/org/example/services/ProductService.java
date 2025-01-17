package org.example.services;

import org.example.entities.Product;
import org.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    //buscar por id
    public Optional<Product> findByIdProduct(Long id){
        return productRepository.findById(id);
    }

    public Product insertProduct(Product product){
        return productRepository.save(product);
    }

    public Product atualizar(Long id, Product updatedProduct){
        return productRepository.findById(id).map(produto -> {
            produto.setProductName(updatedProduct.getProductName());
            produto.setProductValue(updatedProduct.getProductValue());
            produto.setSupplier(updatedProduct.getSupplier());
            return productRepository.save(produto);
        }).orElseThrow(() ->new RuntimeException("Product não encontrado em ID: " +id));
    }


    //deletar
    public void deleteId(Long id){
        productRepository.deleteById(id);
    }
}
