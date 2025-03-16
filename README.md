## Projeto Eucomida

### Descrição do Projeto
O projeto Eucomida é uma aplicação backend desenvolvida em Java utilizando o framework Spring Boot. A aplicação fornece uma API RESTful para gerenciar usuários, produtos e pedidos. A autenticação e autorização são gerenciadas usando JWT (JSON Web Token).

### Como Executar
1. **Clone o repositório**:
   ```bash
   git clone https://github.com/netojakui/estudos.git
   cd estudos
   ```

2. **Execute a aplicação usando Docker**:
  - Certifique-se de ter o Docker e o Docker Compose instalados.
  - Execute o comando abaixo para iniciar a aplicação e o banco de dados:
    ```bash
    docker build -t eucomida-app .
    docker-compose up
    ```

3. **Acesse a documentação da API**:
  - A documentação da API estará disponível em `http://localhost:8080/swagger-ui/`.

### Arquitetura do Projeto

#### Tecnologias e Frameworks Utilizados no Backend
- **Linguagem de Programação**: Java
- **Framework**: Spring Boot
- **Gerenciamento de Dependências**: Maven
- **Documentação da API**: Springdoc OpenAPI (Swagger)
- **Banco de Dados**: PostgreSQL
- **Segurança**: Spring Security com JWT (JSON Web Token)

#### Estrutura do Banco de Dados
O banco de dados utilizado é relacional (PostgreSQL). A estrutura das tabelas é a seguinte:

- **users**: Armazena informações dos usuários.
  - `id` (BIGINT, PK)
  - `username` (VARCHAR)
  - `password` (VARCHAR)
  - `email` (VARCHAR)
  - `role_id` (BIGINT, FK para `roles`)

- **roles**: Armazena os papéis dos usuários.
  - `id` (BIGINT, PK)
  - `name` (VARCHAR)

- **products**: Armazena informações dos produtos.
  - `id` (BIGINT, PK)
  - `name` (VARCHAR)
  - `description` (TEXT)
  - `value` (DECIMAL)

- **orders**: Armazena informações dos pedidos.
  - `id` (BIGINT, PK)
  - `descricao` (VARCHAR)
  - `user_id` (BIGINT, FK para `users`)
  - `product_id` (BIGINT, FK para `products`)
  - `status` (INT)
  - `delivery_fee` (DECIMAL)
  - `delivery_fee_part_person` (DECIMAL)
  - `product_value` (DECIMAL)

### Funcionalidades Principais
- **Cadastro de Usuários**: Permite que novos usuários se registrem no sistema.
- **Autenticação e Autorização**: Garante que apenas usuários autenticados possam acessar determinadas funcionalidades.
- **Cadastro e Gerenciamento de Produtos**: Restaurantes podem adicionar, atualizar e remover produtos do seu cardápio.
- **Realização de Pedidos**: Clientes podem navegar pelos produtos e realizar pedidos.
- **Gerenciamento de Pedidos**: Restaurantes podem visualizar e atualizar o status dos pedidos recebidos.

### Endpoints e Fluxo de Autenticação
A aplicação expõe os seguintes endpoints principais:

- `/auth/register`: Endpoint para registro de novos usuários.
- `/auth/login`: Endpoint para autenticação de usuários e geração de tokens JWT.
- `/products`: Endpoint para gerenciamento de produtos (CRUD).
- `/orders`: Endpoint para criação e gerenciamento de pedidos.

O fluxo de autenticação utiliza JSON Web Tokens (JWT). Após o login bem-sucedido, o usuário recebe um token JWT que deve ser enviado no cabeçalho das requisições subsequentes para acessar endpoints protegidos.

### Banco de Dados e Modelo de Dados
O sistema utiliza o banco de dados postgreSQL durante o desenvolvimento. As principais entidades do modelo de dados são:

- **User**: Representa os usuários do sistema, contendo informações como ID, username, password e roles.
- **Product**: Representa os produtos disponíveis nos restaurantes, com atributos como ID, nome, descrição e preço.
- **Order**: Representa os pedidos realizados pelos clientes, contendo informações sobre o cliente, produtos solicitados e status do pedido.

### Guia de Instalação e Execução
Para executar o projeto localmente:

**Pré-requisitos**:
- Java Development Kit (JDK) 17 ou superior.
- Maven instalado.

**Clonar o repositório**:
```bash
git clone https://github.com/netojakui/estudos.git
cd estudos/eucomida1
```

**Compilar e executar a aplicação**:
```bash
mvn spring-boot:run
```
A aplicação estará disponível em `http://localhost:8080`.

### Possíveis Melhorias e Próximos Passos
- **Validação e Tratamento de Erros**: Aprimorar as validações de entrada e implementar um tratamento de erros consistente para melhorar a robustez da aplicação.
- **Documentação de API**: Utilizar ferramentas como Swagger para gerar documentação interativa da API, facilitando o entendimento e uso por desenvolvedores externos.
- **Testes Automatizados**: Desenvolver testes unitários e de integração para garantir a qualidade e confiabilidade do código.
- **Interface de Usuário**: Desenvolver uma interface web ou mobile para interação dos usuários finais com o sistema.

- **Cadastro de Restaurantes e Estabelecimentos
  Funcionalidade: Permite que os restaurantes se cadastrem e apresentem seus menus, horários de funcionamento, e informações de contato.
  Diferenciação: Ofereça uma interface ainda mais simples para cadastramento de novos restaurantes e opções de personalização (fotos de pratos, menus interativos, promoções).

- **Busca e Filtragem de Restaurantes
  Funcionalidade: Os usuários podem buscar restaurantes por tipo de comida (ex. pizza, sushi, fast food) e também aplicar filtros como avaliações, tempo de entrega e distância.
  Diferenciação: Implementar filtros avançados, como alimentos saudáveis, opções veganas/vegetarianas, e até filtros baseados em dietas específicas (low carb, sem glúten, etc.).

- **Sistema de Avaliações e Comentários
  Funcionalidade: Os usuários podem avaliar os restaurantes e os pratos, ajudando outros consumidores a tomar decisões.
  Diferenciação: Crie um sistema de "créditos de feedback", onde os usuários podem acumular pontos e ganhar recompensas (descontos, brindes) por deixar avaliações.

- **Carrinho de Compras e Checkout
  Funcionalidade: Após escolher os itens, o usuário pode adicionar ao carrinho e realizar o pagamento.
  Diferenciação: Ofereça diferentes opções de pagamento, como carteiras digitais, criptomoedas ou até "pagar depois" (como em alguns aplicativos de crédito).

- **Rastreamento de Pedido em Tempo Real
  Funcionalidade: Os usuários podem acompanhar a preparação e o tempo estimado para entrega do pedido em tempo real.
  Diferenciação: Ofereça funcionalidades como "visão em 3D do trajeto" ou vídeos ao vivo do preparo dos alimentos (para criar uma experiência mais interativa e transparente).

- **Promoções e Cupons de Desconto
  Funcionalidade: Oferecer cupons e promoções personalizadas com base no histórico de compras.
  Diferenciação: Use algoritmos de recomendação para criar promoções hiperpersonalizadas e ofertas dinâmicas baseadas em geolocalização e tempo real (ex. descontos em restaurantes próximos durante horários de baixa demanda).

- **Geolocalização
  Funcionalidade: Usa a localização do usuário para mostrar restaurantes próximos e estimar o tempo de entrega.
  Diferenciação: Use recursos de geolocalização para oferecer promoções baseadas em localização (ex. "desconto de 10% em restaurantes ao seu redor") ou até "mapeamento de preferências" (descubra novos restaurantes próximos com base nas suas escolhas anteriores).

- **Entrega
  Funcionalidade: A plataforma organiza a entrega por meio de motoristas parceiros ou diretamente com os restaurantes.
  Diferenciação: Ofereça integração com entregadores autônomos (ex. drones, robôs) ou entrega de pacotes compartilhados, onde um entregador leva mais de um pedido por vez, reduzindo custos de logística e aumentando a eficiência.

- **Histórico de Pedidos e Recomendações
  Funcionalidade: Histórico de pedidos passados, com opções de repetir facilmente o pedido.
  Diferenciação: Ofereça recomendações baseadas em preferências alimentares ou até sugestões de novos pratos com base em hábitos alimentares e saúde.

- **Funcionalidades Extras para Atração de Clientes e Restaurantes:

- **Assinaturas de Refeições ou Planos de Refeição
        Ofereça planos de assinatura, onde os usuários podem pagar um valor mensal para receber refeições diárias ou semanais, com um preço fixo e descontos exclusivos.
        Isso cria fidelização, permitindo ao usuário não precisar pensar nos pedidos, apenas desfrutar de uma refeição diária.

- **Programas de Fidelidade
        Crie um sistema de pontos onde os usuários acumulam pontos a cada compra e podem trocá-los por descontos ou produtos grátis.
        Diferenciação: Ofereça um programa de "fidelidade social" onde o usuário acumula pontos não apenas pelas compras, mas também por convidar amigos ou compartilhar promoções nas redes sociais.

- **Menu Digital Personalizado com IA
        Um menu dinâmico que muda conforme as preferências do usuário, histórico de pedidos e até seu humor ou condição física (se conectado a apps de saúde).
        Pode incluir sugestões baseadas na inteligência artificial, como "se você gostou de X, você também vai adorar Y".

- **Parcerias e Integrações com Supermercados ou Mercados Locais
        Além de entregar refeições, que tal permitir que o usuário compre ingredientes frescos e receba também junto com o pedido? Por exemplo, "compra um lanche e leve uma garrafinha de suco ou fruta fresca do mercado".
        Integração com produtores locais e supermercados para criar uma plataforma completa de entrega de alimentos.

- **Entrega Mais Rápida
        Concentre-se em oferecer entregas ultra-rápidas para aqueles que querem suas refeições rapidamente. Utilize entregadores em áreas de alta densidade, com um modelo "ultra-express" (ex: entrega dentro de 15 minutos).
        Pode criar zonas de entrega rápida (áreas com maior concentração de pedidos, para garantir rapidez).

- **Entrega de Alimentos Saudáveis e Funcionais
        Focar em um nicho de alimentos saudáveis, opções funcionais (ex. smoothies, sucos detox, snacks fitness) ou até delivery de refeições para dietas específicas (como paleo, keto, vegan, sem glúten).
        Diferencie-se ao garantir que o cardápio seja curado com opções realmente saudáveis, e ofereça um plano de saúde, com nutricionistas podendo montar planos alimentares personalizados.

- **Apoio a Restaurantes Locais e Menos Conhecidos
        Dê destaque a pequenos restaurantes locais e estabelecimentos independentes para criar um apelo emocional e de apoio à economia local.
        Funcionalidade de curadoria: Usuários podem escolher apoiar negócios locais ou de comunidades específicas (ex. restaurante de bairro, culinária artesanal, etc.).

- **Interface Intuitiva e Personalizada
        Garanta que a experiência do usuário seja fluida e intuitiva, com uma interface simples, mas bem organizada.
        Gamificação: Use gamificação para engajar os usuários. Pode ser algo como "desafios de pedidos", onde o usuário ganha prêmios por realizar certas ações ou atingir metas (ex: pedir em 5 restaurantes diferentes na semana).

- **Outras Dicas Importantes:

    Facilidade de uso: O eucomida tem que ser bastante fácil de usar, então seu app também deve ser intuitivo e simples.
    Suporte ao cliente eficiente: Suporte rápido e direto, seja por chat, ligações ou e-mail. Problemas de pedidos e entregas precisam ser resolvidos com agilidade.
    Design e Experiência do Usuário (UX): Focar em um design agradável, rápido e responsivo, além de não sobrecarregar o usuário com opções demais.
    Integrações com plataformas de pagamento: Ofereça diferentes formas de pagamento (cartão de crédito, Pix, carteiras digitais, etc.).


### Considerações Finais
O projeto Eucomida estabelece uma base sólida para um sistema de delivery de comida, utilizando tecnologias modernas e boas práticas de desenvolvimento. Com as melhorias sugeridas, o sistema poderá evoluir para uma solução completa e pronta para produção, atendendo às necessidades de clientes e restaurantes de forma eficiente.
