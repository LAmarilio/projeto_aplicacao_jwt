# Projeto Aplicação JWT

## Descrição

1. Projeto Spring Boot que implementa autenticação via JWT e gerenciamento de usuários.
2. Estrutura principal do código em `src/main/java/com/example/demo/`.
3. Inicialização do schema/dados em `db.config/init.sql`.

## Tecnologias

1. Java (versão 17+ recomendada)
2. Spring Boot
3. Maven (wrapper disponível)
4. JWT para autenticação
5. Banco de dados configurável (script de inicialização em `db.config/init.sql`)
6. Docker / Docker Compose (opcional)

## Estrutura relevante

1. `src/main/java/com/example/demo/controller/` — controladores (ex.: `UserController`)
2. `src/main/java/com/example/demo/dto/` — objetos de transferência (ex.: `LoginRequest`, `UserRequest`)
3. `src/main/java/com/example/demo/model/` — entidades (ex.: `User`, `Role`)
4. `src/main/java/com/example/demo/repository/` — repositórios
5. `src/main/java/com/example/demo/service/` — lógica de negócio (`UserService`)
6. `src/main/java/com/example/demo/security/` — JWT e configuração de segurança (`JwtUtil`, `SecurityConfig`)
7. `db.config/init.sql` — script SQL de inicialização
8. `Dockerfile` e `docker-compose.yml` — opções de containerização

## Como executar (Necessário ter Docker instalado)

1. Clone o repositório:
   ```bash
   git clone https://github.com/LAmarilio/projeto_aplicacao_jwt.git
   cd projeto_aplicacao_jwt
   ```

2. Execute no terminal dentro da pasta projeto_aplicacao_jwt:
   ```bash
   docker-compose up --build -d
   ```

3. **Verificar se tudo está funcionando**
   ```bash
   docker-compose ps
   ```

A aplicação estará disponível em: `http://localhost:8080`

## Endpoints e DTOs

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/api/register` | Criar novo usuário |
| POST | `/api/login` | Realizar login e receber o token jwt |
| POST | `/api/authConfirm` | Confirmar token jwt |

**Exemplo - Registrar usuário:**
```json
POST /api/register
{
  "fullName": "João Silva",
  "email": "joao@email.com",
  "password": "senha123",
  "role": "USER" or "ADMIN"
}
```

**Exemplo - Realizar Login:**
```json
POST /api/login
{
  "email": "joao@email.com",
  "password": "senha123",
}
```

**Exemplo - Autenticar token:**
```json
POST /api/authConfirm
Header: {
   Authorization: seu_token_aqui
}
```
