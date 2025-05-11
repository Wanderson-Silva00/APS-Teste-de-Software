package com.example.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidacoesTest {

    // ----------- emailValido() -----------
    @Test
    void testEmailValidoComEmailCorreto() {
        assertTrue(Validacoes.emailValido("usuario@dominio.com"));
    }

    @Test
    void testEmailValidoSemArroba() {
        assertFalse(Validacoes.emailValido("usuariodominio.com"));
    }

    @Test
    void testEmailValidoComNull() {
        assertFalse(Validacoes.emailValido(null));
    }

    // ----------- senhaForte() -----------
    @Test
    void testSenhaForteValida() {
        assertTrue(Validacoes.senhaForte("Senha123"));
    }

    @Test
    void testSenhaForteCurta() {
        assertFalse(Validacoes.senhaForte("Ab1")); // Muito curta
    }

    @Test
    void testSenhaForteSemMaiuscula() {
        assertFalse(Validacoes.senhaForte("senha123"));
    }

    @Test
    void testSenhaForteSemMinuscula() {
        assertFalse(Validacoes.senhaForte("SENHA123"));
    }

    @Test
    void testSenhaForteSemNumero() {
        assertFalse(Validacoes.senhaForte("SenhaTeste"));
    }

    @Test
    void testSenhaForteComNull() {
        assertFalse(Validacoes.senhaForte(null));
    }

    // ----------- nomeValido() -----------
    @Test
    void testNomeValidoComNomeCorreto() {
        assertTrue(Validacoes.nomeValido("Maria"));
    }

    @Test
    void testNomeValidoComEspacos() {
        assertFalse(Validacoes.nomeValido("   "));
    }

    @Test
    void testNomeValidoComNull() {
        assertFalse(Validacoes.nomeValido(null));
    }
}