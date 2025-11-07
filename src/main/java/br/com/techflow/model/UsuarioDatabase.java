package br.com.techflow.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "database")
public class UsuarioDatabase {

    private List<Usuario> usuarios;

    public UsuarioDatabase() {
        this.usuarios = new ArrayList<>();
    }

    @XmlElement(name = "usuario")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    // Método auxiliar para adicionar um usuário
    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}