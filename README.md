# 📚 Biblioteca - Sistema de Cadastro de Usuários

Projeto Java que implementa um sistema simples de cadastro de usuários. As funcionalidades incluem:

- Cadastro de usuário
- Atualização de dados
- Exclusão de usuário
- Alteração parcial de atributos
- Testes unitários com JUnit 5

---

## ✅ Requisitos

- Java 17 ou superior
- Maven 3.8 ou superior
- (Opcional) IDE como IntelliJ IDEA, Eclipse ou VSCode

---

## 🚀 Como Executar os Testes

### Usando Maven

Abra o terminal na raiz do projeto e execute:


mvn test

---
##  Usando o IntelliJ
1. Faça o download ou clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```
2. Abra o projeto no IntelliJ IDEA com File > Open... e selecione a pasta raiz do projeto.

3. Vá em File > Project Structure > Project

4. Navegue até o diretório de testes:

```bash
src/test/java/com/example/biblioteca/
```

Para cada classe de teste (ex: CadastroTest, UsuarioTest):
Abra a classe no editor

Clique com o botão direito do mouse sobre o nome da classe ou de um método de teste
Escolha Run 'NomeDoTeste' with Coverage para executar os testes com análise de cobertura
O IntelliJ mostrará:

Os resultados dos testes (verdes = sucesso, vermelhos = falha)
A cobertura de código em porcentagem, diretamente no editor (linhas destacadas)
