package br.com.techflow.model;

import jakarta.xml.bind.annotation.XmlElement;

// Não precisamos de @XmlRootElement aqui, pois ela será parte de uma lista
public class Usuario {

    private String username;
    private String password;
    private String fullName; // NOVO

    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlElement
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String department; // NOVO

    // Construtor vazio (obrigatório para JAXB)
    public Usuario() { }

    // Construtor atualizado
    public Usuario(String username, String password, String fullName, String department) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.department = department;
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