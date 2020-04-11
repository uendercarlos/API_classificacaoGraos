
package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 *
 * @author Uender Carlos
 */
@Entity
public class Amostragem implements Serializable{
    
    private Long id;
    private String grao;
    private double massa_amostra;
    private double umidade;
    private double impureza;
    private double esverdeados;
    private double partidos;
    private Proprietario proprietario;
    private double peso_liquido;
    private double peso_bruto;
    private double total_descontos;
    
       

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 
   
    public String getGrao() {
        return grao;
    }

    public void setGrao(String grao) {
        this.grao = grao;
    }

    public double getPeso_liquido() {
        return peso_liquido;
    }

    public void setPeso_liquido(double peso_liquido) {
        this.peso_liquido = peso_liquido;
    }

    public double getPeso_bruto() {
        return peso_bruto;
    }

    public void setPeso_bruto(double peso_bruto) {
        this.peso_bruto = peso_bruto;
    }
    
    public double getMassa_amostra() {
        return massa_amostra;
    }

    public void setMassa_amostra(double massa_amostra) {
        this.massa_amostra = massa_amostra;
    }

    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public double getImpureza() {
        return impureza;
    }

    public void setImpureza(double impureza) {
        this.impureza = impureza;
    }

    public double getEsverdeados() {
        return esverdeados;
    }

    public void setEsverdeados(double esverdeados) {
        this.esverdeados = esverdeados;
    }

    public double getPartidos() {
        return partidos;
    }

    public void setPartidos(double partidos) {
        this.partidos = partidos;
    }

    public double getTotal_descontos() {
        return total_descontos;
    }

    public void setTotal_descontos(double total_descontos) {
        this.total_descontos = total_descontos;
    }
    
    
  
    
    
    @OneToOne(cascade={ CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE })
    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
    
   
   
    
    
    
}
