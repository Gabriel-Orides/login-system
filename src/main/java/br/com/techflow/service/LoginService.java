package br.com.techflow.service;

import br.com.techflow.model.Usuario;
import br.com.techflow.model.UsuarioDatabase;
import br.com.techflow.persistence.UsuarioDAO;

public class LoginService {

    private UsuarioDAO dao;

    public LoginService() {
        this.dao = new UsuarioDAO();
    }

    /**
     * Tenta registrar um novo usuário.
     */
    public boolean registrar(String username, String password) {
        UsuarioDatabase db = dao.carregar();

        // Verifica se o usuário já existe
        for (Usuario u : db.getUsuarios()) {
            if (u.getUsername().equals(username)) {
                return false; // Usuário já existe
            }
        }

        // Se não existe, cria e salva
        Usuario novoUsuario = new Usuario(username, password);
        db.addUsuario(novoUsuario);
        dao.salvar(db);
        return true;
    }


}