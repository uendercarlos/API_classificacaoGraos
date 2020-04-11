package com.example.demo.controller;

import com.example.demo.service.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Proprietario;
import com.example.demo.config.Autenticacao;
import com.example.demo.model.ProprietarioDTO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 
  @author Uender Carlos
 */
@RestController
@RequestMapping(value = "/proprietario")
public class ProprietarioController {

    @Autowired
    ProprietarioService admnistradorService;
    
    @Autowired
    public JavaMailSender emailSender;

    @RequestMapping(method = RequestMethod.POST, value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity autenticar(@RequestBody Proprietario adm) {

        Proprietario admAuth = admnistradorService.autenticarAdministrador(adm);

        if (admAuth == null || admAuth.getLogin().equals("") || admAuth.getSenha().equals("")) {
            return new ResponseEntity<>(admAuth, HttpStatus.FORBIDDEN);
        }

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(admAuth.getLogin());
        jwtBuilder.setId(""+admAuth.getId());
        jwtBuilder.claim("adm", true);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + 70 * 60 * 1000));
        jwtBuilder.signWith(Autenticacao.key);

        String token = jwtBuilder.compact();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        return new ResponseEntity<>(headers, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/cadastrarproprietario", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarAdministrador(@RequestBody Proprietario adm) {

        admnistradorService.cadastrarAdministrador(adm);

        return new ResponseEntity(HttpStatus.CREATED);

    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/recuperarsenha", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity recuperarsenha(@RequestBody Proprietario adm) {

        
       Proprietario proprietario= admnistradorService.buscaporemail(adm.getEmail());

       if(proprietario != null){
           String novasenha = "";
           
           for(int i= 0;i<6; i++){               
               novasenha= novasenha+ new Random().nextInt(9);
           }
           System.out.println("nova senha: "+novasenha);
           proprietario.setSenha(novasenha);
           admnistradorService.editarAdministrador(proprietario);
         
           //mandar email  
          
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(proprietario.getEmail()); 
        message.setSubject("recuperação de senha"); 
        message.setText(novasenha);
        emailSender.send(message);
           System.out.println("email enviado");
          
          
          
       }else{
           System.out.println("email não pertence a nenhuma conta");
                  
       }
       
        return new ResponseEntity(HttpStatus.CREATED);

    }
    
    

  
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    ResponseEntity removerAdministrador(@PathVariable Long id) {

        admnistradorService.removerAdministrador(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    
/*
    @RequestMapping(method = RequestMethod.GET, value = "/proprietario", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Proprietario> mostraAdministrador(@RequestHeader HttpHeaders headers) {

        Proprietario adm;
        try {
            adm = admnistradorService.buscaProprietarioToken(headers);

        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(adm, HttpStatus.OK);
    }

    */
    
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/proprietarios", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProprietarioDTO>> mostraTodosAdministrador() {

        List<Proprietario> adm;
        List<ProprietarioDTO> listDTO;
        try {
            adm = admnistradorService.buscaTodos();
            listDTO = new ArrayList<>(adm.size());
            for (Proprietario f : adm) {
                listDTO.add(new ProprietarioDTO(f));

            }

        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(listDTO, HttpStatus.OK);  
    }

    
    
}
