# Máquina de Caça‑Níquel (JavaFX)

Este repositório contém uma aplicação simples de **máquina de caça‑níquel** construída com JavaFX. A intenção é demonstrar
um projeto Java modularizado que pode ser empacotado como executável para Windows, macOS ou Linux.

---

## Estrutura do projeto

O projeto utiliza layout padrão do Maven:

```
root
├─ pom.xml
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ com/cacaniquel (código fonte)
   │  └─ resources
   │     └─ MainView.fxml (layout FXML)
   └─ test (não usado neste exemplo)
```

O pacote base é `com.cacaniquel`.

---

## Construção e execução

Você precisa do JDK 17+ e do **Maven** instalados. Os módulos JavaFX são trazidos via dependências no `pom.xml`.

1. **Compilar e rodar** durante o desenvolvimento:

   ```bash
   mvn clean javafx:run
   ```

   Isso abre a janela com três "roletas" e um botão Girar. Se os três símbolos coincidirem você ganha!

2. **Gerar um JAR executável**:

   ```bash
   mvn clean package
   ```

   O artefato fica em `target/cacaniquel-1.0.0.jar`.

---

## Empacotamento como executável

O plugin `javafx-maven-plugin` suporta **jlink** e **jpackage**. O exemplo abaixo cria uma imagem customizada
com runtime mínimo:

```bash
mvn clean javafx:jlink
```

O runtime é produzido em `target/jlink-image`. Para gerar um instalador nativo use:

```bash
mvn clean javafx:jpackage -DappName=Cacaniquel -Dvendor="SeuNome" \
          -DmainJar=target/cacaniquel-1.0.0.jar
```

> Certifique‑se de estar utilizando o JDK que contém o `jpackage` (OpenJDK 18+ ou Oracle 17+). Ajuste parâmetros
> conforme necessário para adicionar ícones, descrições, etc.

---

## Desenvolvimento

- Código principal em `com.cacaniquel.App` (classe JavaFX).
- `com.cacaniquel.Controller` contém a lógica de giro.
- Layout FXML em `src/main/resources/MainView.fxml`.

Sinta‑se livre para estender o jogo — adicionar trilha sonora, animações, apostas, etc.

---

## Dependências

As dependências estão gerenciadas pelo Maven; não há bibliotecas externas além do JavaFX.

---

**Boa diversão!**

