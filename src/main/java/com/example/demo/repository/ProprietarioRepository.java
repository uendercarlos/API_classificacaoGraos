
package com.example.demo.repository;

import com.example.demo.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yuequan.jpa.soft.delete.repository.SoftDelete;

/*
 
  @author Uender Carlos
 */

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

    public Proprietario findByLoginAndSenha(@Param("login")String email,@Param("senha")String senha);
     
    
    public Proprietario findByEmail(@Param("email")String email);
    
   
   
}
