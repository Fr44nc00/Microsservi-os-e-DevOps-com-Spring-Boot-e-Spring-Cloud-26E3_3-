# Microsservi-os-e-DevOps-com-Spring-Boot-e-Spring-Cloud-26E3_3-

## Arquitetura Proposta

### Visão Geral
O sistema consiste em uma Loja de Videogames desenvolvida utilizando uma arquitetura baseada em microsserviços. A aplicação tem como objetivo permitir o gerenciamento de usuários, catálogo de jogos, compras e histórico de operações, promovendo escalabilidade, separação de responsabilidades e independência entre os serviços.

A arquitetura foi projetada para que cada microsserviço seja responsável por um domínio específico do negócio, possuindo seus próprios dados e podendo evoluir independentemente dos demais serviços.

Além disso, a solução utiliza um Discovery Server para descoberta de serviços, um API Gateway como ponto único de entrada e um banco de dados não relacional para armazenamento de históricos de eventos.

---

## Microsserviços

### usuario-service

Responsabilidade: Gerenciamento de usuários do sistema.

Principais dados manipulados:

1. Usuário
2. Tipo de Usuário

Principais funcionalidades:

1. Cadastro de usuários
2. Consulta de usuários
3. Atualização de usuários
4. Remoção de usuários
5. Busca por nome, e-mail e tipo

Banco de dados: H2 (Relacional)

Justificativa: Os dados de usuários possuem estrutura rígida e altamente relacional, sendo adequados para um banco relacional.

---

### jogo-service

Responsabilidade: Gerenciamento do catálogo de jogos.

Principais dados manipulados:

1. Jogo
2. Plataforma

Principais funcionalidades:

1. Cadastro de jogos
2. Consulta de jogos
3. Atualização de jogos
4. Remoção de jogos
5. Busca por título, plataforma e faixa de preço

Banco de dados: H2 (Relacional)

Justificativa: Os dados do catálogo possuem estrutura bem definida, relacionamentos simples e necessidade de consultas tradicionais.

---

### compra-service

Responsabilidade: Processamento e gerenciamento das compras realizadas pelos usuários.

Principais dados manipulados:

1. Compra

Principais funcionalidades:

1. Criação de compras
2. Consulta de compras
3. Cálculo do valor total
4. Consulta de histórico de compras

Banco de dados: H2 (Relacional)

Dependências:

1. usuario-service
2. jogo-service
3. historico-service

Justificativa: Centraliza as regras de negócio relacionadas ao processo de compra.

---

### historico-service

Responsabilidade: Armazenar eventos e histórico das operações realizadas no sistema.

Principais dados manipulados:

1. Registro de compras
2. Eventos do sistema
3. Logs de auditoria

Banco de dados: MongoDB (Não Relacional)

Justificativa: O histórico de eventos possui estrutura flexível e pode crescer rapidamente ao longo do tempo. O MongoDB permite armazenar documentos sem necessidade de esquema rígido, facilitando a evolução dos registros e consultas por eventos.

---

## Banco de Dados Não Relacional

Microsserviço responsável: historico-service

Banco utilizado: MongoDB

### Justificativa Técnica

O histórico de eventos não exige relacionamentos complexos entre tabelas e pode apresentar diferentes formatos de registro ao longo da evolução do sistema.

O MongoDB permite:

1. Armazenar documentos flexíveis;
2. Evoluir o modelo sem migrações complexas;
3. Registrar eventos de auditoria de forma eficiente;
4. Consultar históricos por usuário, compra ou período.

### Operações favorecidas

1. Consulta de eventos por usuário;
2. Consulta de eventos por compra;
3. Consulta por período de tempo;
4. Armazenamento de registros com estruturas variáveis.

---

## Discovery Server

A arquitetura utiliza o Eureka Server como mecanismo de descoberta de serviços.

Suas responsabilidades são:

1. Registrar microsserviços automaticamente;
2. Permitir descoberta dinâmica dos serviços;
3. Facilitar a comunicação utilizando nomes lógicos;
4. Evitar dependência direta de endereços e portas.

Serviços registrados:

1. usuario-service
2. jogo-service
3. compra-service
4. historico-service
5. gateway-service

---

## API Gateway

A arquitetura utiliza um API Gateway como ponto único de entrada para as requisições externas.

O Gateway é responsável por:

1. Receber as chamadas do front-end;
2. Encaminhar as requisições para o microsserviço correto;
3. Integrar-se ao Eureka Server;
4. Centralizar o acesso à aplicação.

### Rotas previstas

/api/usuarios/**  -> usuario-service

/api/jogos/**     -> jogo-service

/api/compras/**   -> compra-service

/api/historico/** -> historico-service

---

## Resiliência

A comunicação entre o compra-service e o historico-service utilizará mecanismos de resiliência.

### Problema

O serviço de histórico pode estar indisponível ou responder lentamente.

### Solução

Implementação de:
1. Circuit Breaker
2. Fallback

### Comportamento esperado

Mesmo que o historico-service esteja indisponível, a compra deverá ser concluída normalmente.

Nesse cenário, o sistema registra uma resposta alternativa informando que o histórico será processado posteriormente, evitando falhas em cascata.

---

## Diagrama Geral da Arquitetura

``` mermaid
flowchart LR

    FE[Front-end]

    GW[API Gateway]

    EU[Eureka Server]

    US[usuario-service]
    JS[jogo-service]
    CS[compra-service]
    HS[historico-service]

    DBU["(H2 Usuarios)"]
    DBJ["(H2 Jogos)"]
    DBC["(H2 Compras)"]
    DBH["(MongoDB Historico)"]

    FE --> GW

    GW --> US
    GW --> JS
    GW --> CS
    GW --> HS

    US --> EU
    JS --> EU
    CS --> EU
    HS --> EU
    GW --> EU

    CS --> US
    CS --> JS
    CS --> HS

    US --> DBU
    JS --> DBJ
    CS --> DBC
    HS --> DBH
```
