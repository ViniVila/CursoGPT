<div style="background-color:#0d1117;color:#e6edf3;padding:25px;border-radius:10px;font-family:monospace">

# 📋 Cadastro de Clientes em Java (Swing)

Projeto desenvolvido para o **Curso de GPT aplicado ao desenvolvimento**, demonstrando como utilizar IA para gerar e evoluir código em **Java com interface gráfica (Swing)**.

O repositório apresenta **duas versões do mesmo sistema**:

1️⃣ **Versão Inicial (Básica)**
2️⃣ **Versão Evoluída (Avançada)**

O objetivo é mostrar **como o código pode evoluir com melhorias progressivas utilizando prompts mais avançados**.

---

# 🧩 Versão 1 — Formulário Básico

A primeira versão apresenta um **formulário simples de cadastro de clientes**, ideal para quem está começando com **Java Swing**.

### Funcionalidades

* Campos de cadastro:

  * Nome
  * E-mail
  * Telefone
  * CPF

* Botões:

  * **Salvar** → Exibe os dados em um `JOptionPane`
  * **Limpar** → Apaga todos os campos

### Conceitos Demonstrados

* Interface gráfica com **Swing**
* Uso de **JFrame**
* Componentes **JLabel, JTextField e JButton**
* Organização com **GridBagLayout**
* Eventos com **ActionListener**
* Exibição de mensagens com **JOptionPane**

---

# 🚀 Versão 2 — Sistema Evoluído

A segunda versão demonstra **uma evolução do projeto**, adicionando recursos mais próximos de aplicações reais.

### Melhorias Implementadas

✔ **Validação de CPF**
O sistema verifica se o CPF digitado é válido utilizando o cálculo dos **dígitos verificadores**.

✔ **Máscara de Telefone**
Utilização de `MaskFormatter` para garantir o formato correto do telefone:

```
(11) 91234-5678
```

✔ **Persistência de Dados em Arquivo**

Os dados cadastrados passam a ser salvos em um arquivo:

```
clientes.txt
```

Exemplo de conteúdo do arquivo:

```
Nome: João Silva
Email: joao@email.com
Telefone: (11) 99999-9999
CPF: 12345678909
---------------------------
```

---

# 🧠 Conceitos Aprendidos no Projeto

Este projeto demonstra diversos conceitos importantes da programação Java:

* Criação de **interfaces gráficas**
* Manipulação de **eventos**
* **Validação de dados**
* Uso de **máscaras de entrada**
* **Persistência em arquivos**
* Estrutura de aplicações Java desktop

---

# ⚙️ Tecnologias Utilizadas

* **Java**
* **Swing (Java GUI)**
* **GridBagLayout**
* **IntelliJ IDEA**

---

# 📂 Estrutura do Projeto

```
CadastroClientes.java
CadastroClientesAvancado.java
clientes.txt
README.md
```

---

# ⚙️ Como Executar o Projeto

### 1️⃣ Pré-requisitos

Instale os seguintes softwares:

* **Java JDK 8 ou superior**
* **IntelliJ IDEA** (ou outra IDE Java)

---

### 2️⃣ Clonar o repositório

```
git clone https://github.com/seu-usuario/cadastro-clientes-java.git
```

---

### 3️⃣ Abrir o projeto

1. Abra o **IntelliJ IDEA**
2. Clique em **Open**
3. Selecione a pasta do projeto

---

### 4️⃣ Executar

Abra um dos arquivos:

```
CadastroClientes.java
```

ou

```
CadastroClientesAvancado.java
```

Clique em **Run ▶** para executar o sistema.

---

# 🎯 Objetivo Educacional

Este projeto foi criado para demonstrar como **prompts bem estruturados podem gerar código funcional em Java**, permitindo que estudantes e desenvolvedores aprendam a **utilizar IA como ferramenta de apoio no desenvolvimento de software**.

---

# 🤖 Curso de GPT

Este repositório faz parte de um **exercício prático do curso de GPT**, onde o objetivo é:

* Criar prompts eficientes
* Gerar código automaticamente
* Evoluir aplicações com melhorias progressivas

---

✍️ Desenvolvido para fins educacionais.

</div>
