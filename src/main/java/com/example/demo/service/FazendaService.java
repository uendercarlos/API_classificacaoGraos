
package com.example.demo.service;

import com.example.demo.model.Fazenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.FazendaRepository;

/**
 *
 * @author Uender Carlos
 */
@Service
public class FazendaService {
    
    @Autowired 
    FazendaRepository enderecorepository;
    
     public void cadastrarEndereco(Fazenda end) {
        enderecorepository.save(end);
    }

    public void editarEndereco(Fazenda end) {
        enderecorepository.save(end);
    }

    public void removerEndereco(Long id) {
        enderecorepository.deleteById(id);
    }

    
}
