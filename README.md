# Projeto Microsserviços em Java com Spring Boot

## Descrição
Este projeto desenvolvido por **Marcello Vieira Mueno** é um microsserviço em Java utilizando Spring Boot. A aplicação é projetada para ser altamente escalável e resiliente, incorporando uma variedade de tecnologias e padrões de design 
modernos, além de estar preparada para monitoramento e deploy em ambientes de produção.

## Tecnologias Utilizadas

- **Java + Spring Boot REST API**: A base do projeto, proporcionando uma estrutura robusta para o desenvolvimento de APIs RESTful.
- **Webflux**: Utilizado para construção de APIs reativas, permitindo a manipulação de fluxos de dados de forma não-bloqueante.
- **RabbitMQ**: Implementação de filas para comunicação assíncrona entre serviços.
- **Swagger**: Documentação automática da API, facilitando o entendimento e o uso da mesma por outros desenvolvedores.
- **Prometheus**: Monitoramento da aplicação, com coleta de métricas em tempo real.
- **Jaeger**: Ferramenta para rastreamento de transações distribuídas, ajudando a monitorar a performance e o fluxo de dados entre microserviços.
- **Padrão Observer**: Implementado para facilitar a extensão do sistema com novas funcionalidades sem a necessidade de alterar o código existente.
- **Docker**: Contêinerização da aplicação, facilitando o deploy e a gestão de ambientes de desenvolvimento e produção.
- **Testes Unitários**: Garantia de qualidade do código com cobertura de testes.
- **Deploy na AWS (S3 e EC2)**: Deploy da aplicação utilizando AWS S3 para armazenamento de arquivos estáticos e AWS EC2 para a execução da aplicação.

## Como Executar Localmente

1. Clone o repositório.
   ```bash
   git clone https://github.com/marcellovieira/meu-projeto.git
