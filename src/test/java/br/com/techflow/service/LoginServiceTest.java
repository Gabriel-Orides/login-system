package br.com.techflow.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import br.com.techflow.service.LoginService;

public class LoginServiceTest {

    private LoginService service;
    private static final String FILE_PATH = "usuarios.xml";

    @BeforeEach
    public void setUp() {
        File dbFile = new File(FILE_PATH);
        if (dbFile.exists()) {
            dbFile.delete();
        }
        service = new LoginService();
    }

    @Test
    public void testRegistrarUsuarioComSucesso() {
        // Ação
        boolean resultado = service.registrar("usuario1", "senha123", "User One", "Test");

        // Verificação
        assertTrue(resultado, "O registro de um novo usuário deve retornar verdadeiro.");
    }

    @Test
    public void testRegistrarUsuarioDuplicado() {
        // Preparação
        service.registrar("usuario1", "senha123", "User One", "Test");

        // Ação - AGORA COM 4 ARGUMENTOS
        boolean resultado = service.registrar("usuario1", "outraSenha", "User Two", "Test");

        // Verificação
        assertFalse(resultado, "O registro de um usuário duplicado deve retornar falso.");
    }

    @Test
    public void testFazerLoginComSucesso() {
        // Preparação
        service.registrar("usuario1", "senha123", "Test User", "QA");

        // Ação
        boolean resultado = service.fazerLogin("usuario1", "senha123");

        // Verificação
        assertTrue(resultado, "O login com credenciais corretas deve retornar verdadeiro.");
    }

    @Test
    public void testFazerLoginComSenhaErrada() {
        // Preparação
        service.registrar("usuario1", "senha123", "Test User", "QA");

        // Ação
        boolean resultado = service.fazerLogin("usuario1", "senhaErrada");

        // Verificação
        assertFalse(resultado, "O login com senha incorreta deve retornar falso.");
    }

    @Test
    public void testAtualizarSenhaComSucesso() {
        // Preparação
        service.registrar("user", "senhaAntiga", "Update User", "Dev");

        // Ação
        boolean resultado = service.atualizarSenha("user", "senhaAntiga", "senhaNova");

        // Verificação
        assertTrue(resultado, "A atualização de senha deve retornar verdadeiro.");

        // Verificação extra
        assertTrue(service.fazerLogin("user", "senhaNova"), "Login com senha nova deve funcionar.");
    }

    @Test
    public void testDeletarUsuarioComSucesso() {
        // Preparação
        service.registrar("userParaDeletar", "senha", "Delete User", "Ops");

        // Ação
        boolean resultado = service.deletarUsuario("userParaDeletar", "senha");

        // Verificação
        assertTrue(resultado, "Deletar usuário deve retornar verdadeiro.");

        // Verificação extra
        assertFalse(service.fazerLogin("userParaDeletar", "senha"), "Login com usuário deletado deve falhar.");
    }
}