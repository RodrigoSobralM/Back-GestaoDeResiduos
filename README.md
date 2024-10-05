
# Gestão de Resíduos

Este projeto é um sistema de gestão de resíduos sólidos desenvolvido com Java 22 e Spring Boot 3.3.2, utilizando o MongoDB como banco de dados. O objetivo é proporcionar um sistema que facilite a automação da coleta de lixo, rastreamento de caminhões e notificação de moradores sobre a coleta de resíduos.


## Funcionalidades

- **Agendamento de Coletas:** Os moradores podem visualizar os dias de coleta de resíduos na sua área e ser notificados automaticamente.
- **Rastreamento de Caminhões:** O sistema permite monitorar a localização atual dos caminhões de coleta e o status de manutenção.
- **Gerenciamento de Moradores:** Notificações de coleta são enviadas com base na área de coleta de cada morador.
- **Relatórios:** Geração de relatórios sobre a quantidade total de resíduos coletados e a separação entre resíduos orgânicos e recicláveis.


## Stack utilizada

- Java 22
- Spring Boot 3.3.2
- MongoDB (via Spring Data MongoDB)
- Lombok para geração de código boilerplate
- Docker (opcional) para execução do MongoDB


## Rodando localmente

**Pré-requisitos**

- JDK 22 ou superior
- Maven 3.x
- MongoDB instalado localmente ou utilizando Docker

**Executando o MongoDB com Docker**

Se você não tiver o MongoDB instalado localmente, pode executá-lo com Docker:
```bash
  docker run -d -p 27017:27017 --name gestao-residuos-mongo mongo
```
**Executando o Projeto**
1. Clone o repositório:

```bash
    https://github.com/RodrigoSobralM/Back-GestaoDeResiduos
    cd GestaoDeResiduos
```
2. Compile o projeto e baixe as dependências:

```bash
  mvn clean install
```

3. Execute a aplicação:

```bash
  mvn spring-boot:run
```
A aplicação estará disponível em http://localhost:8080.


## Documentação da API

#### Cadastrar agendamentos, caminhões, moradores, relatórios e resíduos.

```http
  POST /agendamento/cadastrar
```
```http
  POST /caminhao/cadastrar
```
```http
  POST /morador/cadastrar
```
```http
  POST /relatorio/cadastrar
```
```http
  POST /residuo/cadastrar
```

#### Buscar agendamentos, caminhões, moradores, relatórios e resíduos. 

```http
  GET /agendamento/buscar
```
```http
  GET /caminhao/buscar
```
```http
  GET /morador/buscar
```
```http
  GET /relatorio/buscar
```
```http
  GET /residuo/buscar
```
Retorna uma lista de todos os agendamentos, caminhões, moradores, relatórios e resíduos cadastrados.

#### Busca um item de agendamentos, caminhões, moradores, relatórios e resíduos.

```http
  GET /agendamento/buscar/{id}
```
```http
  GET /caminhao/buscar/{id}
```
```http
  GET /morador/buscar/{id}
```
```http
  GET /relatorio/buscar/{id}
```
```http
  GET /residuo/buscar/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |

#### Deletar agendamentos, caminhões, moradores, relatórios e resíduos.

```http
  DELETE /agendamento/deletar/{id}
```
```http
  DELETE /caminhao/deletar/{id}
```
```http
  DELETE /morador/deletar/{id}
```
```http
  DELETE /relatorio/deletar/{id}
```
```http
  DELETE /residuo/deletar/{id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |

#### Atualzar agendamentos, caminhões, moradores, relatórios e resíduos.

```http
  PUT /agendamento/atualizar
```
```http
  PUT /caminhao/atualizar
```
```http
  PUT /morador/atualizar
```
```http
  PUT /relatorio/atualizar
```
```http
  PUT /residuo/atualizar
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `agendamento`      | `string` | **Obrigatório**. Os dados atualizados do agendamento |
| `caminhao`      | `string` | **Obrigatório**. Os dados atualizados do caminhao |
| `morador`      | `string` | **Obrigatório**. Os dados atualizados do morador |
| `relatorio`      | `string` | **Obrigatório**. Os dados atualizados do relatorio |
| `residuo`      | `string` | **Obrigatório**. Os dados atualizados do residuo |

## Contribuindo

Sinta-se à vontade para contribuir com o projeto. Para isso, siga os seguintes passos:

- Faça um fork do projeto.
- Crie uma nova branch: `git checkout -b minha-nova-feature`.
- Faça suas alterações e commit: `git commit -m 'Adiciona nova feature'`.
- Envie suas alterações para o repositório: `git push origin minha-nova-feature`.
- Abra um Pull Request.



## Licença

Este projeto está licenciado sob a MIT License. Consulte o arquivo [LICENSE](https://choosealicense.com/licenses/mit/) para mais detalhes.

