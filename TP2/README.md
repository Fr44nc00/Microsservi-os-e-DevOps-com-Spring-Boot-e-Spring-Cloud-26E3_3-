# Microsserviços e DevOps com Spring Boot e Kubernetes
## Arquitetura Proposta
### Visão Geral
O sistema consiste em uma Loja Virtual desenvolvida utilizando uma arquitetura baseada em microsserviços.
O objetivo é demonstrar, de forma progressiva, a evolução de uma aplicação desde a execução em containers Docker até sua orquestração no Kubernetes.

A aplicação inicial será composta por dois microsserviços independentes, cada um responsável por um domínio específico do negócio, permitindo escalabilidade e separação de responsabilidades.

---

## Microsserviços
### product-service
Responsabilidade: Gerenciar os produtos disponíveis na loja.

### Principais dados manipulados:
Produto (nome, descrição, preço, estoque)

### Principais funcionalidades:

1. Cadastro de produtos
2. Consulta de produtos
3. Atualização de informações de produtos
4. Remoção de produtos
5. Busca por nome e faixa de preço

### Banco de dados: H2 (Relacional)
Justificativa: Os dados de produtos possuem estrutura rígida e relacional, sendo adequados para um banco relacional simples.

---

### order-service
Responsabilidade: Gerenciar os pedidos realizados pelos clientes.

### Principais dados manipulados:
Pedido (itens, quantidade, valor total, status)

Principais funcionalidades:

1. Criação de pedidos
2. Consulta de pedidos
3. Atualização de status de pedidos
4. Remoção de pedidos
5. Consulta de histórico de pedidos

### Banco de dados: H2 (Relacional)
Justificativa: Os dados de pedidos possuem estrutura bem definida e relacionamentos diretos com produtos, sendo adequados para um banco relacional.

---

## Objetivo do Projeto
Demonstrar:

1. Diferença entre máquina virtual e container
2. Utilização do Docker
3. Containers executando microsserviços
4. Comunicação entre containers
5. Uso do Docker Compose
6. Migração para Kubernetes
7. Deploy de aplicações Spring Boot
8. Service Discovery
9. Balanceamento de carga
