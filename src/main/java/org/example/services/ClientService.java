package org.example.services;

import org.example.entities.Client;
import org.example.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    public ClientRepository clientRepository;

    //buscar todos fornecedores
    public List<Client> findAllClient(){
        return clientRepository.findAll();
    }

    //buscar por id
    public Optional<Client> findByIdClient(Long id){
        return clientRepository.findById(id);
    }
    //inserir por fornecedor
    public Client insertClient(Client client){
        return clientRepository.save(client);
    }
    //deletar
    public void deleteId(Long id){
        clientRepository.deleteById(id);
    }
}
