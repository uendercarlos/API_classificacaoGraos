
package com.example.demo.service;

import com.example.demo.config.Autenticacao;
import com.example.demo.model.Proprietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpHeaders;
import com.example.demo.repository.AmostragemRepository;
import com.example.demo.repository.ProprietarioRepository;

/**
 *
 * @author Uender Carlos
 */
@Service
public class ProprietarioService {

    @Autowired
    ProprietarioRepository administradorRepository;
    
     @Autowired
     AmostragemRepository produtoRepository;

    public ProprietarioService() {
    }

    public Proprietario autenticarAdministrador(Proprietario adm) {
        return administradorRepository.findByLoginAndSenha(adm.getLogin(), adm.getSenha());

    }

    public void cadastrarAdministrador(Proprietario adm) {
        administradorRepository.save(adm);
    }

    public void editarAdministrador(Proprietario adm) {
        administradorRepository.save(adm);
      
    }
    
    public void removerAdministrador(Long id) {
        administradorRepository.deleteById(id);
      
    }

    public Proprietario buscaAdministrador(Long id) {
        return administradorRepository.findById(id).get();
    }

    public java.util.List<Proprietario> buscaTodos() {

        return  administradorRepository.findAll();

   
    }

   
    
    public Proprietario buscaporemail(String email) {
        return administradorRepository.findByEmail(email);
    }
   
    public Proprietario buscaProprietarioToken(HttpHeaders header) throws Exception {
        try{
            String token;
            
            token = header.get("Authorization").get(0);
            
            if (token.isEmpty()){
                
                throw new Exception("token vazio");
                
            }
             token = token.substring(7);
           
             Claims c = Jwts.parser()
                     .setSigningKey(Autenticacao.key)
                     .parseClaimsJws(token)
                     .getBody();
             
             Long idProprietario = Long.parseLong(c.getId().toString());
             
             Proprietario proprietario = buscaAdministrador(idProprietario);
             if (proprietario==null){
                 
                 throw new Exception();
             }
             return proprietario;
             
        }
        
        catch(Exception e){
            
            
            System.out.println("Não foi possivel obter o token");
            throw new Exception("aaa");
    }
    
  
    
}
    
    
}