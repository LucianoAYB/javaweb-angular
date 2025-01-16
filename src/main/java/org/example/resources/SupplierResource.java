package org.example.resources;

import org.example.entities.Supplier;
import org.example.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/suppliers")
public class SupplierResource {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> findAll(){
        return supplierService.findAllSupplier();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable Long id) {
        return supplierService.findByIdSupplier(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.insertSupplier(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> update(@PathVariable Long id, @RequestBody Supplier supplier) {
        return supplierService.findByIdSupplier(id)
                .map(existingSupplier -> {
                    supplier.setId(existingSupplier.getId());
                    return ResponseEntity.ok(supplierService.insertSupplier(supplier));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return supplierService.findByIdSupplier(id)
                .map(existingSupplier -> {
                    supplierService.deleteId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());

    }
}
