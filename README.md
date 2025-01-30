# Gestão de licenças ambientais
Essa API tem o propósito de gerenciar licenças ambientais para o setor de Qualidade e Meio Ambiente da Companhia Águas de Joinville. Os cálculos de campos e regras de negócio foram transpostos de fórmulas de macros feitas pela engenharia.

## Funcionalidades principais:
- Consultar, alterar e adicionar licenças.
- Autenticação realizada via servidor LDAP
- Calculo da situação da licença com base no tipo, licenciamento, autorização, requerimento, previsão e entre outros campos.
- Rotina diaria de calculo de todas as tarefas por agendamento
- Historico de observações
- Controle de Logs e de alterações
- Rotas protegidas por token

## Tecnologias
- **Java**
-  **Spring boot**
-  **Postgres**
-  **JWT**

## Diagrama de entidade relacional


<img src="public/entidade_relacional.png" alt="ER">


## Instalação e Configuração

### Rodar o Projeto

Clone o projeto

```bash
  git clone https://github.com/Osvaldo1408exe/licencas-ambientais.git
```

Entre no diretório do projeto

```bash
  cd licencas-ambientais
```

Instale as dependências

**Utilize o gerenciador de pacotes** `Maven`


Inicie o servidor

#### Obs.: Inicie após configurar as variáveis de ambiente

### Configurar as Variáveis de Ambiente

Para rodar esse projeto, é necessário configurar o arquivo `application.propeties` em resources, com as seguintes variáveis de ambiente:

```text
spring.datasource.url=jdbc:postgresql://localhost:5432/ecolicencas
spring.datasource.username=
spring.datasource.password=
application.JWT_SECRET=your-secret-value

```

##

![Logo](/public/logo.png)