
package com.example.demo.model;

/**
 *
 * @author Uender Carlos
 */



public class ProprietarioDTO {
    

    private Long id;
    private Fazenda endereco;
    private String nome;
    private String telefone;
    private String cnpj;
    private String email;

//Getters and Setters

    public ProprietarioDTO(Proprietario proprietario) {
        this.id = proprietario.getId();
        this.endereco = proprietario.getFazenda();
        this.nome = proprietario.getNome();
        this.telefone = proprietario.getTelefone();
        this.cnpj = proprietario.getCnpj();
        this.email = proprietario.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fazenda getEndereco() {
        return endereco;
    }

    public void setEndereco(Fazenda endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
}


