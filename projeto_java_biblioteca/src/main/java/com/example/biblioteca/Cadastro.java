
package com.example.biblioteca;

import java.util.HashSet;
import java.util.Set;

public class Cadastro {
    private static final Set<Usuario> USUARIOS = new HashSet<>();

    public static Usuario cadastrarUsuario(String nome, String email, String senha) {
        Usuario u = new Usuario(nome, email, senha);
        if (USUARIOS.contains(u)) return null;
        USUARIOS.add(u);
        return u;
    }

    public static boolean atualizarUsuario(Usuario u, String nome, String email, String senha) {
        if (!USUARIOS.contains(u)) return false;
        u.setNome(nome);
        u.setEmail(email);
        u.setSenha(senha);
        return true;
    }

    public static boolean excluirUsuario(Usuario u) {
        return USUARIOS.remove(u);
    }

    /** Altera apenas um campo se existir */
    public static boolean alterarParcial(Usuario u, String field, String value) {
        if (!USUARIOS.contains(u)) return false;
        switch (field) {
            case "nome": u.setNome(value); return true;
            case "email": u.setEmail(value); return true;
            case "senha": u.setSenha(value); return true;
            default: return false;
        }
    }

    public static String cadastroFunc0() { return "CADASTRO_0"; }
    public static String cadastroFunc1() { return "CADASTRO_1"; }
}
