package br.com.techflow.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;


import br.com.techflow.service.LoginService;

public class LoginServiceTest {

    private LoginService service;
    private static final String FILE_PATH = "usuarios.xml";

    /**
     * Este método roda ANTES de cada teste (@Test).
     * Ele garante que o arquivo de banco de dados seja deletado,
     * para que cada teste comece com um "banco limpo".
     */
    @BeforeEach
    public void setUp() {
        // Deleta o arquivo de banco de dados para garantir um estado limpo
        File dbFile = new File(FILE_PATH);
        if (dbFile.exists()) {
            dbFile.delete();
        }

        // Inicializa o serviço
        service = new LoginService();
    }

    @Test
    public void testRegistrarUsuarioComSucesso() {
        // Ação
        boolean resultado = service.registrar("usuario1", "senha123");

        // Verificação (Assert)
        assertTrue(resultado, "O registro de um novo usuário deve retornar verdadeiro.");
    }

    @Test
    public void testRegistrarUsuarioDuplicado() {
        // Preparação
        service.registrar("usuario1", "senha123"); // Registra pela primeira vez

        // Ação
        boolean resultado = service.registrar("usuario1", "outraSenha"); // Tenta registrar de novo

        // Verificação
        assertFalse(resultado, "O registro de um usuário duplicado deve retornar falso.");
    }

    @Test
    public void testFazerLoginComSucesso() {
        // Preparação
        service.registrar("usuario1", "senha123");

        // Ação
        boolean resultado = service.fazerLogin("usuario1", "senha123");

        // Verificação
        assertTrue(resultado, "O login com credenciais corretas deve retornar verdadeiro.");
    }

    @Test
    public void testFazerLoginComSenhaErrada() {
        // Preparação
        service.registrar("usuario1", "senha123");

        // Ação
        boolean resultado = service.fazerLogin("usuario1", "senhaErrada");

        // Verificação
        assertFalse(resultado, "O login com senha incorreta deve retornar falso.");
    }

    @Test
    public void testAtualizarSenhaComSucesso() {
        // Preparação
        service.registrar("user", "senhaAntiga");

        // Ação
        boolean resultado = service.atualizarSenha("user", "senhaAntiga", "senhaNova");

        // Verificação
        assertTrue(resultado, "A atualização de senha deve retornar verdadeiro.");

        // Verificação extra: login com a senha nova deve funcionar
        assertTrue(service.fazerLogin("user", "senhaNova"), "Login com senha nova deve funcionar.");
    }

    @Test
    public void testDeletarUsuarioComSucesso() {
        // Preparação
        service.registrar("userParaDeletar", "senha");

        // Ação
        boolean resultado = service.deletarUsuario("userParaDeletar", "senha");

        // Verificação
        assertTrue(resultado, "Deletar usuário deve retornar verdadeiro.");

        // Verificação extra: login com o usuário deletado deve falhar
        assertFalse(service.fazerLogin("userParaDeletar", "senha"), "Login com usuário deletado deve falhar.");
    }
}
