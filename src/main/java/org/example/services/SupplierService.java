package org.example.services;

import org.example.entities.Supplier;
import org.example.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    public SupplierRepository supplierRepository;

//buscar todos fornecedores
    public List<Supplier> findAllSupplier(){
        return supplierRepository.findAll();
    }

    //buscar por id

    public Optional<Supplier> findByIdSupplier(Long id){
        return supplierRepository.findById(id);
    }
    //inserir por fornecedor
    public Supplier insertSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }
    //deletar
    public void deleteId(Long id){
        supplierRepository.deleteById(id);
    }
}
