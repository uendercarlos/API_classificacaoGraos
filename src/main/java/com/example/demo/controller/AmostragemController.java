
package com.example.demo.controller;

import com.example.demo.model.Proprietario;
import com.example.demo.model.Amostragem;
import com.example.demo.service.ProprietarioService;
import com.example.demo.service.AmostragemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 
  @author Uender Carlos
 */

@RestController
@RequestMapping(value = "/")
public class AmostragemController {
    
    @Autowired
    private AmostragemService produtoService;
    
    @Autowired
    private ProprietarioService proprietarioService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/amostragem")
    public ResponseEntity cadastrarProduto(@RequestBody Amostragem produto, @RequestHeader HttpHeaders headers){
       
        try {
         
            produto.setProprietario(proprietarioService.buscaProprietarioToken(headers));
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        produtoService.cadastrarAmostragem(produto);
        
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
   
    @RequestMapping(method = RequestMethod.GET, value = "/amostragem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Amostragem> mostrarProduto(@PathVariable Long id, @RequestHeader HttpHeaders headers){
        
        
        
        Amostragem produto = produtoService.consultarAmostragem(id);
        
        return new ResponseEntity(produto, HttpStatus.OK);
    }
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/amostragens", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Amostragem> mostrarTodosProduto(){
        List<Amostragem> produtos = produtoService.buscaTodosProdutos();
        
        return new ResponseEntity(produtos, HttpStatus.OK);
    }
    
    
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/amostragem")
    public ResponseEntity editaProduto(@RequestBody Amostragem produto, @RequestHeader HttpHeaders headers){
        
        try{
            produto.setProprietario(proprietarioService.buscaProprietarioToken(headers));     
        }catch(Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        
        produtoService.alterarAmostragem(produto);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    
    
    
    @RequestMapping(method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/amostragem/{id}")
    public ResponseEntity excluirProduto(@PathVariable Long id, @RequestHeader HttpHeaders headers){
        
        Proprietario adm;
          try {
         
            adm = proprietarioService.buscaProprietarioToken(headers);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
          
        produtoService.desabilitarAmostragem(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }
}
