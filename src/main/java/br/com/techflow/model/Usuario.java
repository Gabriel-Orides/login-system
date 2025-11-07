package br.com.techflow.model;

import jakarta.xml.bind.annotation.XmlElement;

// Não precisamos de @XmlRootElement aqui, pois ela será parte de uma lista
public class Usuario {

    private String username;
    private String password;

    // Construtor vazio é OBRIGATÓRIO para JAXB
    public Usuario() {
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}