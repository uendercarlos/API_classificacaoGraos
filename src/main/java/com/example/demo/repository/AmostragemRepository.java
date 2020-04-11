
package com.example.demo.repository;

//import com.example.demo.model.Categoria;
import com.example.demo.model.Amostragem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yuequan.jpa.soft.delete.repository.SoftDelete;

/*
 
  @author Uender Carlos
 */

public interface AmostragemRepository extends JpaRepository<Amostragem, Long> {
   
}
