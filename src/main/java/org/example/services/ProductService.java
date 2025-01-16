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

    //buscar todos fornecedores
    public List<Product> findAllSupplier(){
        return productRepository.findAll();
    }

    //buscar por id
    public Optional<Product> findByIdSupplier(Long id){
        return productRepository.findById(id);
    }
    //inserir por fornecedor
    public Product insertSupplier(Product supplier){
        return productRepository.save(supplier);
    }
    //deletar
    public void deleteId(Long id){
        productRepository.deleteById(id);
    }
}
