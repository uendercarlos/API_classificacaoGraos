
package com.example.demo.controller;

import com.example.demo.model.Fazenda;
import com.example.demo.service.FazendaService;
import com.example.demo.service.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Uender Carlos
 */
@RestController
public class FazendaController {
    
    @Autowired
    FazendaService enderecoservice;
    
    @Autowired
    private ProprietarioService proprietarioService;
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/cadastrarendereco", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarEndereco(@RequestBody Fazenda end) {
        
        enderecoservice.cadastrarEndereco(end);

        return new ResponseEntity(HttpStatus.CREATED);

    }
    
    
      @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/editaendereco")
    public ResponseEntity editarEndereco(@RequestBody Fazenda end){
        enderecoservice.editarEndereco(end);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/endereco/{id}")
    public ResponseEntity removerEndereco(@PathVariable Long id){
        
        System.out.println("id do produto: " + id);
        enderecoservice.removerEndereco(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }
}
    
    
    
    
