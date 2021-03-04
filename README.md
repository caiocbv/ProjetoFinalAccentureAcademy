# Projeto Final Accademia Accenture 2.0 - API Java

Esse é o projeto final do curso intensivo de desenvolvimento Backend em Java, com duração de três semanas.<br> Consiste em criar uma solução de Bank Line para realizar transações de Crédito, Débito e Transferência.
<br><br>
Uma parceria da [Gama Academy](https://www.gama.academy/) com a [Accenture](https://www.accenture.com/br-pt).

![Fork](image/img_gama.jpg)

### Composição do grupo Behind The Lines

- [Caio Bezerra](https://www.linkedin.com/in/caiobezerraviana/) 
- [Guilherme Torato](https://www.linkedin.com/in/guilherme-roberto-torato-20632516b/)
- [Maxsuel Medeiros](https://www.linkedin.com/in/maxsuel-silva-medeiros-56a533181/)
- [Patrícia Souza](https://www.linkedin.com/in/patriciasouzas/)

--------------------------------------------------

## Objetivo:

Desenvolver ferramenta APIRest utilizada no auxílio da gestão de contas e lançamentos financeiros de um usuário que atenda as seguintes demandas:

- Cadastro de Usuário - com campos de Login, Senha, Nome e CPF.
- Ao realizar o cadastro, criar uma conta com saldo zero.
- Cadastro de Plano de Contas - finalidade das Receitas, Despesas e Transferências.
- Realizar transferências para outros usuários.
- Registro de lançamentos de receitas, despesas e transferências contendo: Data de Lançamento, Conta, Plano de Conta, Valor e Descrição. Em caso de transferência entre contas precisa informar a conta de destino.
- Extrato dos Lançamentos por Conta e Período de Datas inicial e final - Dashboard.
- Gestão de Saldo das Contas.
- Disponibilizar o serviço de autenticação e autorização para usuários.

--------------------------------------------------

## Tecnologias Utilizadas

- Linguagem Java versão 11
- Spring Boot 2.4.3
- IDE Eclipse modificada para o framework Spring Boot(Spring Tools Suite)
- Hibernate Validator 6.1.5 para validações de dados
- Persistência de dados no MySQL

## Estrutura do Projeto

A estrutura está dividida de acordo com a funcionalidade de cada pacote:
- config: configurações de segurança do Spring Security e JWT
- controllers: configurações das requisições da API com seus respectivos endpoints
- exceptions: definição das exceções
- dto: se encontram as classes que serão consumidas
- enums: estão enumeradas os tipos de movimentação
- model: definição das classes dos objetos utilizados
- repositories: onde estão os JPA para acessar os dados do DB
- services: onde se encontram as regras de negócios para manipulação do Model
<br>

```jsx
📦src/main/java
 ┣ 📂com.projeto.accenture
 ┃ ┗ 📜ProjetoFinalAccentureApplication.java
 ┃ ┣ 📂config
 ┃ ┃ ┣ 📜DevConfig.java
 ┃ ┃ ┣ 📜JWTAuthorizationFilter.java
 ┃ ┃ ┣ 📜JWTConstants.java
 ┃ ┃ ┣ 📜SecurityConfig.java
 ┃ ┃ ┣ 📜SwaggerConfig.java
 ┃ ┃ ┗ 📜TestConfig.java
 ┃ ┣ 📂 controllers
 ┃ ┃ ┣ 📂exceptions
 ┃ ┃ ┃ ┣ 📜FieldMessage.java
 ┃ ┃ ┃ ┣ 📜ResourceExceptionHandler.java
 ┃ ┃ ┃ ┣ 📜StandardError.java
 ┃ ┃ ┃ ┗ 📜ValidationError.java
 ┃ ┃ ┣ 📜LancamentoController.java
 ┃ ┃ ┣ 📜LoginController.java
 ┃ ┃ ┗ 📜UsuarioController.java
 ┃ ┣ 📂dto
 ┃ ┃ ┣ 📜ContaDTO.java
 ┃ ┃ ┣ 📜DashboardDTO.java
 ┃ ┃ ┣ 📜LancamentoDTO.java
 ┃ ┃ ┣ 📜LoginDTO.java
 ┃ ┃ ┣ 📜PlanoContaDTO.java
 ┃ ┃ ┣ 📜SessaoDTO.java
 ┃ ┃ ┗ 📜UsuarioDTO.java
 ┃ ┣ 📂helpers
 ┃ ┃ ┗ 📜Helper.java
 ┃ ┣ 📂model
 ┃ ┃ ┣ 📂enums
 ┃ ┃ ┃ ┗ 📜TipoMovimento.java
 ┃ ┃ ┣ 📜Conta.java
 ┃ ┃ ┣ 📜Lancamento.java
 ┃ ┃ ┣ 📜PlanosDeConta.java
 ┃ ┃ ┗ 📜Usuario.java
 ┃ ┣ 📂repositories
 ┃ ┃ ┣ 📜IContaRepository.java
 ┃ ┃ ┣ 📜ILancamentoRepository.java
 ┃ ┃ ┣ 📜IPlanoDeContaRepository.java
 ┃ ┃ ┗ 📜IUsuarioRepository.java
 ┃ ┣ 📂services
 ┃ ┃ ┣ 📂exceptions
 ┃ ┃ ┃ ┣ 📜AuthorizationException.java
 ┃ ┃ ┃ ┣ 📜DataIntegrityException.java
 ┃ ┃ ┃ ┗ 📜ObjectNotFoundException.java
 ┃ ┃ ┣ 📜LancamentoService.java
 ┃ ┃ ┣ 📜LoginService.java
 ┃ ┃ ┣ 📜PlanoContaService.java
 ┗ ┗ ┗ 📜UsuarioService.java
```
--------------------------------------------------

## Funcionalidades

Abaixo algumas funcionalidades da API. Os exemplos foram todos realizados como teste no [Swagger](https://accountbank-api.herokuapp.com/swagger-ui.html).

### I. Criando usuário

Para inserir novo usuário deve ser feita uma requisição post em json como o exemplo abaixo:

```
{
  "cpf": "123456789",
  "login": "patricia",
  "nome": "Patrícia",
  "senha": "000000"
}
```

Após executar, retornará o usuário criado, com o ID gerado automaticamente e com senha criptografada. Consumindo o endpoint corretamente como no exemplo a seguir:

![Fork](image/post-usuario.jpg)
<br>

### II. Realizando Login

Para o login é necessário passar os dados de login e senha em json na requisição post:

```
{
  "login": "patricia",
  "senha": "000000"
}
```

Após executar, retornará o login realizado com sucesso e a criação de token de forma automatizada. Consumindo o endpoint de login corretamente:

![Fork](image/login-usuario.jpg)