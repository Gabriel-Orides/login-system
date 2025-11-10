# Sistema de Gerenciamento de Tarefas (TechFlow)

> Backend para o sistema de gerenciamento de tarefas da TechFlow Solutions, focado na gestão de usuários.

Este projeto é um sistema de backend desenvolvido como parte da disciplina de Engenharia de Software. O objetivo é simular um ciclo de desenvolvimento ágil completo, desde o planejamento até a integração contínua, para atender a uma startup de logística fictícia.

O sistema atual foca no **módulo de autenticação e gerenciamento de usuários**, implementando um ciclo CRUD completo com persistência de dados em XML.

## ✨ Funcionalidades Principais

Este sistema fornece um conjunto completo de operações CRUD para a entidade `Usuario`:

* ✅ **Create**: Registro de novos usuários no sistema.
* 🔍 **Read**: Autenticação de usuários (login) através da verificação de credenciais.
* 🔄 **Update**: Permite que um usuário existente atualize sua senha (requer a senha antiga para verificação).
* ❌ **Delete**: Permite que um usuário delete sua própria conta (requer a senha para confirmação).
* 💾 **Persistência**: Os dados dos usuários são salvos e lidos de um arquivo local `usuarios.xml` usando a tecnologia JAXB para serialização.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Build/Dependências:** Apache Maven
* **Persistência:** JAXB (Jakarta XML Binding) para serialização e desserialização de objetos Java para XML.
* **Testes:** JUnit 5 (Jupiter) para testes unitários automatizados.
* **CI/CD:** GitHub Actions para integração contínua e execução automática de testes.
* **Packaging:** Maven Shade Plugin para criar um "fat jar" executável.

## 🚀 Como Executar o Projeto

Existem duas maneiras de executar o projeto: utilizando o executável `.jar` ou compilando o código-fonte.

### 1. Executando o `.jar` (Recomendado)

O projeto é empacotado como um "fat jar" que contém todas as dependências necessárias.

**Pré-requisitos:**
* Ter o **Java 17 (ou superior)** instalado em sua máquina.

**Passos:**
1.  Baixe o arquivo `.jar` (ex: `projeto-logistica-1.0.jar`) da [aba "Releases"](./) deste repositório (ou da pasta `target/` se você compilou o projeto).
2.  Abra um terminal ou prompt de comando.
3.  Navegue até a pasta onde o arquivo `.jar` foi baixado.
4.  Execute o seguinte comando:

    ```bash
    java -jar login-system-1-x-x.jar
    # Ex: java -jar projeto-logistica-1.0.0.jar
    ```
5.  O menu interativo do sistema aparecerá no seu terminal.

### 2. Compilando do Código-Fonte

Se preferir, você pode compilar o projeto do zero.

**Pré-requisitos:**
* Ter o **Java 17 (JDK)** instalado.
* Ter o **Apache Maven** instalado.

**Passos:**
1.  Clone este repositório: `git clone https://github.com/Gabriel-Orides/login-system`
2.  Navegue até a pasta raiz do projeto: `cd login-system`
3.  Execute o comando do Maven para limpar, testar e empacotar:

    ```bash
    mvn clean package
    ```
4.  Após a conclusão, o `.jar` executável estará na pasta `target/`.
5.  Siga os passos da seção "Executando o .jar" para rodar o arquivo.

## 🧪 Testes e Qualidade

O projeto possui uma suíte de testes unitários para o `LoginService`, cobrindo todos os cenários do CRUD (criação, falha na criação, login, falha no login, atualização e deleção).

* **Rodar Testes Localmente:**
    ```bash
    mvn test
    ```
* **Integração Contínua (CI):** Um pipeline de CI foi configurado usando **GitHub Actions** (`.github/workflows/maven.yml`). Ele é acionado a cada `push` ou `pull request` para a branch `main`, garantindo que os testes passem antes de integrar novas mudanças.
