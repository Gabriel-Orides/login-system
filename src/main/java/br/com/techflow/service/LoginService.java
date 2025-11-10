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

    public boolean fazerLogin(String username, String password) {
        UsuarioDatabase db = dao.carregar();

        for (Usuario u : db.getUsuarios()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true; // Login com sucesso
            }
        }
        return false; // Falha no login
    }

    public boolean atualizarSenha(String username, String senhaAntiga, String senhaNova) {
        UsuarioDatabase db = dao.carregar();
        boolean atualizado = false;

        for (Usuario u : db.getUsuarios()) {
            // Encontra o usuário e verifica se a senha antiga está correta
            if (u.getUsername().equals(username) && u.getPassword().equals(senhaAntiga)) {
                u.setPassword(senhaNova); // Atualiza a senha no objeto
                atualizado = true;
                break; // Para o loop
            }
        }

        if (atualizado) {
            dao.salvar(db); // Salva o banco de dados inteiro com a senha nova
        }

        return atualizado;
    }

    public boolean deletarUsuario(String username, String password) {
        UsuarioDatabase db = dao.carregar();

        // Usa o método 'removeIf' da lista, que é limpo e eficiente
        // Ele remove o item da lista se a condição for verdadeira
        boolean removido = db.getUsuarios().removeIf(
                usuario -> usuario.getUsername().equals(username) && usuario.getPassword().equals(password)
        );

        if (removido) {
            dao.salvar(db); // Salva o banco de dados sem o usuário
        }

        return removido;
    }

}