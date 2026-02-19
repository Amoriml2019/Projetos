## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

---

## Jogo da Velha (Tic-Tac-Toe)

Este projeto inclui um simples jogo da velha na classe `App`. Siga as instruções abaixo para compilar e gerar um **arquivo executável (JAR)**:

1. Abra um terminal na raiz do projeto.
2. Compile o código fonte:
   ```bash
   javac -d bin src/App.java
   ```
3. Crie o JAR com ponto de entrada `App`:
   ```bash
   jar cfe JogoDaVelha.jar App -C bin .
   ```
4. Execute o jogo usando o JAR:
   ```bash
   java -jar JogoDaVelha.jar
   ```

Você também pode executar diretamente sem empacotar:

```bash
java -cp bin App
```

Divirta-se jogando!
