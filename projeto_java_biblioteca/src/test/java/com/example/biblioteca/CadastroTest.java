package com.example.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CadastroTest {

    @AfterEach
    void limparUsuarios() {
        // Simula reset do conjunto estático — em produção, evite isso.
        Cadastro.excluirUsuario(new Usuario("Dummy", "joao@empresa.com", "Senha123"));
        Cadastro.excluirUsuario(new Usuario("Dummy", "maria@empresa.com", "Senha123"));
        Cadastro.excluirUsuario(new Usuario("Dummy", "carlos@empresa.com", "123"));
        Cadastro.excluirUsuario(new Usuario("Novo", "novo@empresa.com", "nova"));
        Cadastro.excluirUsuario(new Usuario("Alterar", "alterar@empresa.com", "antiga"));
    }

    @Test
    void testCadastrarUsuarioValido() {
        Usuario u = Cadastro.cadastrarUsuario("João", "joao@empresa.com", "Senha123");
        assertNotNull(u);
        assertEquals("joao@empresa.com", u.getEmail());
    }

    @Test
    void testCadastrarUsuarioDuplicado() {
        Usuario u1 = Cadastro.cadastrarUsuario("Maria", "maria@empresa.com", "Senha123");
        assertNotNull(u1);
        Usuario u2 = Cadastro.cadastrarUsuario("Maria", "maria@empresa.com", "Senha123");
        assertNull(u2); // não pode cadastrar duplicado
    }

    @Test
    void testAtualizarUsuarioExistente() {
        Usuario u = Cadastro.cadastrarUsuario("Carlos", "carlos@empresa.com", "123");
        boolean atualizado = Cadastro.atualizarUsuario(u, "Carlos A.", "carlos@empresa.com", "456");
        assertTrue(atualizado);
        assertEquals("Carlos A.", u.getNome());
        assertEquals("456", u.getSenha());
    }

    @Test
    void testAtualizarUsuarioInexistente() {
        Usuario u = new Usuario("Fake", "fake@empresa.com", "x");
        boolean result = Cadastro.atualizarUsuario(u, "Novo", "novo@empresa.com", "nova");
        assertFalse(result);
    }

    @Test
    void testExcluirUsuario() {
        Usuario u = Cadastro.cadastrarUsuario("Maria", "maria@empresa.com", "Senha123");
        assertTrue(Cadastro.excluirUsuario(u));
        assertFalse(Cadastro.excluirUsuario(u)); // já excluído
    }

    @Test
    void testExcluirUsuarioInexistente() {
        Usuario u = new Usuario("Carlos", "carlos@empresa.com", "123");
        assertFalse(Cadastro.excluirUsuario(u));
    }

    @Test
    void testAlterarParcialNome() {
        Usuario u = Cadastro.cadastrarUsuario("João", "joao@empresa.com", "Senha123");
        boolean result = Cadastro.alterarParcial(u, "nome", "João da Silva");
        assertTrue(result);
        assertEquals("João da Silva", u.getNome());
    }

    @Test
    void testAlterarParcialEmail() {
        Usuario u = Cadastro.cadastrarUsuario("Maria", "maria@empresa.com", "Senha123");
        boolean result = Cadastro.alterarParcial(u, "email", "nova@empresa.com");
        assertTrue(result);
        assertEquals("nova@empresa.com", u.getEmail());
    }

    @Test
    void testAlterarParcialSenha() {
        Usuario u = Cadastro.cadastrarUsuario("Carlos", "carlos@empresa.com", "123");
        boolean result = Cadastro.alterarParcial(u, "senha", "novaSenha");
        assertTrue(result);
        assertEquals("novaSenha", u.getSenha());
    }

    @Test
    void testAlterarParcialCampoInvalido() {
        Usuario u = Cadastro.cadastrarUsuario("Carlos", "carlos@empresa.com", "123");
        boolean result = Cadastro.alterarParcial(u, "telefone", "99999");
        assertFalse(result);
    }

    @Test
    void testAlterarParcialUsuarioInexistente() {
        Usuario u = new Usuario("Fake", "fake@empresa.com", "senha");
        boolean result = Cadastro.alterarParcial(u, "nome", "Novo Nome");
        assertFalse(result);
    }

    @Test
    void testCadastroFunc0() {
        assertEquals("CADASTRO_0", Cadastro.cadastroFunc0());
    }

    @Test
    void testCadastroFunc1() {
        assertEquals("CADASTRO_1", Cadastro.cadastroFunc1());
    }
}
