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

Uma ferramenta APIRest utilizada no auxílio da gestão de contas e lançamentos financeiros de um usuário que atenda as seguintes demandas:

- Cadastro de Usuário - com campos de Login, Senha, Nome e CPF.
- Ao realizar o cadastro, criar uma conta com saldo zero.
- Cadastro de Plano de Contas - finalidade das Receitas, Despesas e Transferências.
- Realizar transferências para outros usuários.
- Registro de lançamentos de receitas, despesas e transferências contendo: Data de Lançamento, Conta, Plano de Conta, Valor e Descrição. Em caso de transferência entre contas precisa informar a conta de destino.
- Extrato dos Lançamentos por Conta e Período de Datas inicial e final - Dashboard.
- Gestão de Saldo das Contas.
- Disponibilizar o serviço de autenticação e autorização para usuários.

--------------------------------------------------

## Estrutura do Projeto

A documentação da API está hospedada no Swagger e se encontra disponível [aqui](https://accountbank-api.herokuapp.com/swagger-ui.html).<br><br>

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
 ┃ ┃ ┣ 📜UsuarioService.java
```
--------------------------------------------------


