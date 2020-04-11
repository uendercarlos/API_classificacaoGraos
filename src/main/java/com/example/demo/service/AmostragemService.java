
package com.example.demo.service;

import com.example.demo.model.Amostragem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.AmostragemRepository;

/*
 
  @author Uender Carlos
 */
@Service
public class AmostragemService {
    
     @Autowired   
    AmostragemRepository produtoRepository;
    
    public Amostragem cadastrarAmostragem(Amostragem pro) {
       return produtoRepository.save(pro);
    }

    public Amostragem alterarAmostragem(Amostragem pro) {
       return produtoRepository.save(pro);
    }

    public void desabilitarAmostragem(Long id) {
        produtoRepository.deleteById(id);
    }

    public Amostragem consultarAmostragem(Long id) {
        return produtoRepository.findById(id).get();
    }
    
    public List<Amostragem> buscaTodosProdutos(){
        return produtoRepository.findAll();
        
    }
  
    
    
     
     
     
}
