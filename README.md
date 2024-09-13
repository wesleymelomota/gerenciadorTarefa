
# Sistema de Gerenciamento de Tarefas

Este é um sistema de gerenciamento de tarefas que permite aos usuários criar e gerenciar listas de tarefas, adicionar, editar, remover e destacar itens dentro dessas listas.


## Funcionalidades

- Criação de Listas: Crie listas de tarefas para organizar suas atividades.
- Gerenciamento de Itens: Adicione, edite, remova e destaque itens dentro das listas.
- Ordenação e Destaque: Itens destacados são priorizados na visualização.
- Persistência de Dados: As listas e itens são armazenados de forma persistente.
- API REST: A aplicação expõe uma API para operações CRUD.
- Interface Angular: Interface web construída com Angular 9 para interação com a API.


## Requisitos

- Java 21
- Maven 3.6+
- Banco H2 (ou qualquer banco de dados compatível com JPA/Hibernate)
## API Endpoints
- GET api/listas: Retorna todas as listas.

- GET api/listas/{id}: Retorna uma lista específica pelo ID.

- POST api/listas: Cria uma nova lista.

- PUT api/item/{id}: Atualiza um item pelo ID.

- DELETE api/listas/{id}: Remove uma lista pelo ID.

- GET api/listas/{id}/itens: Retorna todos os itens de uma lista específica.

- POST api/item/{idList}: Adiciona um novo item à lista.

- DELETE api/item/{id}: Remove um item pelo ID.
