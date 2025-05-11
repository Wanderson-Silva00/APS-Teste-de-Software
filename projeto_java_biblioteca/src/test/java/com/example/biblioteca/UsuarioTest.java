package com.example.biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void testConstrutorEGetters() {
        Usuario u = new Usuario("João", "joao@empresa.com", "senha123");
        assertEquals("João", u.getNome());
        assertEquals("joao@empresa.com", u.getEmail());
        assertEquals("senha123", u.getSenha());
    }

    @Test
    void testSetters() {
        Usuario u = new Usuario("Maria", "maria@empresa.com", "abc");
        u.setNome("Maria Silva");
        u.setEmail("maria.silva@empresa.com");
        u.setSenha("novaSenha");

        assertEquals("Maria Silva", u.getNome());
        assertEquals("maria.silva@empresa.com", u.getEmail());
        assertEquals("novaSenha", u.getSenha());
    }

    @Test
    void testEqualsTrue() {
        Usuario u1 = new Usuario("Carlos", "carlos@empresa.com", "123");
        Usuario u2 = new Usuario("Outro Nome", "carlos@empresa.com", "outraSenha");

        assertEquals(u1, u2);
    }

    @Test
    void testEqualsFalse() {
        Usuario u1 = new Usuario("Carlos", "carlos@empresa.com", "123");
        Usuario u2 = new Usuario("Carlos", "carlos2@empresa.com", "123");

        assertNotEquals(u1, u2); // emails diferentes → objetos diferentes
    }

    @Test
    void testHashCodeConsistenteComEquals() {
        Usuario u1 = new Usuario("Ana", "ana@empresa.com", "senha1");
        Usuario u2 = new Usuario("Outra", "ana@empresa.com", "senha2");

        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void testEqualsComObjetoDiferente() {
        Usuario u = new Usuario("Lucas", "lucas@empresa.com", "123");
        assertNotEquals(u, "lucas@empresa.com");
    }

    @Test
    void testEqualsComNull() {
        Usuario u = new Usuario("Pedro", "pedro@empresa.com", "abc");
        assertNotEquals(u, null);
    }

    @Test
    void testEqualsComMesmoObjeto(){
        Usuario u = new Usuario("Pedro", "pedro@empresa.com", "abc");
        assertEquals(u, u);


    }
}
