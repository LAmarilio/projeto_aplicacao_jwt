# Projeto Aplicação JWT

Descrição
1. Projeto Spring Boot que implementa autenticação via JWT e gerenciamento de usuários.
2. Estrutura principal do código em `src/main/java/com/example/demo/`.
3. Inicialização do schema/dados em `db.config/init.sql`.

Tecnologias
1. Java (versão 17+ recomendada)
2. Spring Boot
3. Maven (wrapper disponível)
4. JWT para autenticação
5. Banco de dados configurável (script de inicialização em `db.config/init.sql`)
6. Docker / Docker Compose (opcional)

Estrutura relevante
1. `src/main/java/com/example/demo/controller/` — controladores (ex.: `UserController`)
2. `src/main/java/com/example/demo/dto/` — objetos de transferência (ex.: `LoginRequest`, `UserRequest`)
3. `src/main/java/com/example/demo/model/` — entidades (ex.: `User`, `Role`)
4. `src/main/java/com/example/demo/repository/` — repositórios
5. `src/main/java/com/example/demo/service/` — lógica de negócio (`UserService`)
6. `src/main/java/com/example/demo/security/` — JWT e configuração de segurança (`JwtUtil`, `SecurityConfig`)
7. `src/main/resources/application.yml` e `src/main/resources/application.properties` — configurações da aplicação
8. `db.config/init.sql` — script SQL de inicialização
9. `Dockerfile` e `docker-compose.yml` — opções de containerização

Como executar (Windows)
1. Executar com o wrapper do Maven:
   - `.\mvnw.cmd spring-boot:run`
2. Gerar o jar e executar:
   - `.\mvnw.cmd clean package`
   - `java -jar target\<seu-artifact>.jar`
3. Com Docker Compose:
   - `docker-compose up --build`

Testes
1. Executar testes unitários:
   - `.\mvnw.cmd test`
2. Estrutura de testes em `src/test/java/com/example/demo/`

Configuração
1. Verificar e ajustar conexões de banco em `src/main/resources/application.yml` ou `application.properties`.
2. O comportamento de segurança e chaves JWT estão em `src/main/java/com/example/demo/security/`.
3. O script `db.config/init.sql` é usado para popular/criar tabelas iniciais.

Endpoints e DTOs
1. Os endpoints relacionados a autenticação e usuários estão no controlador `UserController` em `src/main/java/com/example/demo/controller/`.
2. Consulte os DTOs em `src/main/java/com/example/demo/dto/` para payloads de requisição/resposta (ex.: `LoginRequest`, `LoginResponse`, `UserRequest`, `UserResponse`).

Dicas rápidas de depuração
1. Consultar logs de inicialização para problemas de conexão com o banco.
2. Confirmar valores em `application.yml`/`application.properties` antes de subir containers.
3. Verificar `JwtUtil` se ocorrerem falhas de autenticação.

Manutenção
1. Para adicionar novos endpoints, criar DTOs em `dto/`, lógica em `service/` e expor em `controller/`.
2. Seguir convenções já presentes para tratamento de exceções (`handler/`) e validação.

Arquivo sugerido
1. Salvar este conteúdo em `README.md` na raiz do projeto.

Licença
1. Adicionar arquivo `LICENSE` conforme necessário.
