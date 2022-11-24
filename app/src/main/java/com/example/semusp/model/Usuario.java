package com.example.semusp.model;

public class Usuario {
    private String idUsuario;
    private String Nome;
    private String Email;
    private String Telefone;
    private String Endereco;
    private String CPF;
    private String senha;

    public Usuario(String nome, String email, String telefone, String endereco, String CPF, String senha) {
        Nome = nome;
        Email = email;
        Telefone = telefone;
        Endereco = endereco;
        this.CPF = CPF;
        this.senha = senha;
    }

    public Usuario() {
    }


    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
