# Aplicação console em Java com Spring Boot

Esse é um exemplo de uma aplicação console Java que utiliza o framework Spring Boot e a API JPA para interagir com um banco de dados PostgreSQL. Esta aplicação demonstra como configurar o Spring Boot para uma aplicação console realizar operações básicas de CRUD e conectar-se a um banco de dados PostgreSQL.

## Dependências

- Spring Data JPA SQL

(Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate)

- PostgreSQL Driver SQL

(A JDBC and R2DBC driver that allows Java programs to connect to a PostgreSQL database using standard, database independent Java code)

## Estrutura do Projeto

O projeto contém os seguintes arquivos:

- `src.main.java.cronogramas/`
  - `CronogramasApplication.java` - Classe principal do projeto SpringBoot.
  - `principal.Principal.java` - Classe principal da aplicação console.
  - `models.Cronograma.java` - Classe que representa entidade.
  - `models.Evento.java` - Classe que representa entidade.
  - `models.DiaDeSemana.java` - Enum implementodo como atributo da classe Evento.
  - `repository.CronogramaRepository.java` Interface que extende métodos JPA.
  - `repository.EventoRepository.java` - A classe Interface que extende métodos JPA.



