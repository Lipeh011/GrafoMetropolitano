#  Simulador de Rotas do Metrô de São Paulo

Este projeto é uma aplicação Java que simula o funcionamento da rede de metrô da cidade de São Paulo. Ele permite calcular a melhor rota entre duas estações com base em tempo ou distância, considerando possíveis baldeações entre linhas. Também armazena o histórico das rotas calculadas.

---

# Como funciona
![Metro SP em grafos](https://cdn.discordapp.com/attachments/1250289117909090375/1383090327484891216/image.png?ex=684d86be&is=684c353e&hm=ceea53114c3638c05f66a4e9c3e4b27eadf2966581a7cf0b7c932ed73d56aec6&)

- Vértices (nós) → Representam as estações do metrô.
- Arestas (ligações) → Representam as conexões diretas entre estações.
- Pesos nas arestas → Definem o tempo ou distância entre estações (dependendo do modo de cálculo).
- Vértices compartilhados por mais de uma linha representam estações de baldeação (troca de linha).
- A estrutura usa grafos não direcionados e ponderados.
- Algoritmo de Dijkstra é aplicado para encontrar a rota mais curta (tempo/distância) entre duas estações.


## Tecnologias e Conceitos Utilizados

- **Linguagem:** Java (100% puro)
- **Paradigma:** Programação orientada a objetos
- **Estrutura de dados:** Grafo direcionado e ponderado
- **Algoritmo de caminho mínimo:** Dijkstra
- **Design modular:** Separação em `model`, `service` e `app`
- **Armazenamento em memória:** Histórico de rotas

---

## Funcionalidades

- Criação de estações e conexões entre elas
- Cálculo da melhor rota entre duas estações (tempo ou distância)
- Geração de instruções detalhadas de trajeto
- Armazenamento do histórico de buscas realizadas
- Modularização limpa e expansível

---

## Como Funciona

1. **Construção do Grafo:**  
   O sistema inicia criando manualmente um grafo de estações e conexões com dados aproximados de tempo e distância.

2. **Cálculo de Rota:**  
   Ao solicitar uma rota entre duas estações, o sistema utiliza o **algoritmo de Dijkstra** para calcular o menor caminho possível.

3. **Instruções de Viagem:**  
   Gera mensagens detalhadas para guiar o usuário entre as linhas e baldeações necessárias.

4. **Histórico:**  
   O resultado de cada rota é armazenado para consultas futuras.

---

## Saida De Dados

![Saida de dados](https://cdn.discordapp.com/attachments/1250289117909090375/1383099560703954974/Sem_titulo.png?ex=6856c9d8&is=68557858&hm=848484cdbfce5ec79a3488478d3045c9a48f0e438988610701a5ecf4f87f0474&)

---

## Como Executar o Projeto

1. Clone o repositório:
   git clone https//github.com/Lipeh011/GrafoMetropolitano.git
   
2. cd GrafoMetropolitano-main
   
4. Compile os arquivos **.java**
   
5. Rode a aplicação:
   java app.App

---


## Melhorias Futuras

- Interface gráfica com JavaFX ou aplicação mobile com React Native
- Armazenamento em banco de dados (SQLite, PostgreSQL)
- Visualização gráfica do trajeto
- API RESTful para uso em aplicações externas
- Suporte a mais critérios de otimização (evitar baldeações, por exemplo)

---

## Aprendizados
Durante o desenvolvimento deste projeto, aprofundei meu entendimento em:

- Estruturas de dados complexas, como grafos orientados e ponderados;
- Algoritmo de Dijkstra, implementando na unha e adaptando para múltiplos critérios (tempo e distância);
- Boas práticas de modularização, com separação clara entre camadas de model, service e app;
- A importância de um código limpo e reutilizável, pensando em expansibilidade futura;
- Uso de orientação a objetos de forma prática, além do que é mostrado nos livros e aulas.
- Esse projeto consolidou meus conhecimentos teóricos e me deu visão prática de como simular um sistema real, com múltiplas variáveis e decisões envolvidas.

---

