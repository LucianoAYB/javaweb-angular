package org.example.resources;

import org.example.entities.Client;
import org.example.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> findAll(){
        return clientService.findAllClient();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return clientService.findByIdClient(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Client create(@RequestBody Client product) {
        return clientService.insertClient(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client product) {
        return clientService.findById(id)
                .map(existingClient -> {
                    product.setId(existingClient.getId());
                    return ResponseEntity.ok(clientService.insertClient(product));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return clientService.findById(id)
                .map(existingClient -> {
                    clientService.deleteId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());

    }
}
