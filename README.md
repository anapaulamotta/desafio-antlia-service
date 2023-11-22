# Desafio Antlia Service
  Backend do projeto de cadastro manual de movimentações de produtos bancário
## Tecnologias utilizadas

- Java 17
- Spring Boot 3.1.5
- H2 Database
- Hibernate
- Lombok

## Configuração 
### execução
Para executar o projeto, é necessário ter o Java 17 e o Maven instalados.

### banco de dados
O projeto utiliza o banco de dados H2 para armazenar os dados. O H2 é um banco de dados em memória, o que significa que os dados serão perdidos ao reiniciar o servidor.

Para acessar o console do H2 e visualizar os dados:

- Inicie o aplicativo Spring Boot.
- Abra um navegador da web e acesse http://localhost:8080/h2-console.
- No campo "JDBC URL", insira jdbc:h2:mem:testdb.
- No campo "User Name", insira sa.
- No campo "Password", insira password.
Clique em "Connect".
