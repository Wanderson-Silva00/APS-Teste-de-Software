
package com.example.biblioteca;

public class Validacoes {
    public static boolean emailValido(String email) {
        return email != null && email.contains("@");
    }

    public static boolean senhaForte(String senha) {
        if (senha == null) return false;
        return senha.length() >= 8 &&
               senha.chars().anyMatch(Character::isUpperCase) &&
               senha.chars().anyMatch(Character::isLowerCase) &&
               senha.chars().anyMatch(Character::isDigit);
    }

    public static boolean nomeValido(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }
}
