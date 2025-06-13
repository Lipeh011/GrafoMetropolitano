package service;

import model.Conexao;
import model.Estacao;
import model.InstrucaoRota;
import model.ResultadoRota;

import java.util.*;

public class GrafoMetro {
    private Map<Estacao, List<Conexao>> grafo;
    private Estacao estacaoAtual;

    public GrafoMetro() {
        grafo = new HashMap<>();
    }

    public void adicionarVertice(Estacao estacao) {
        grafo.putIfAbsent(estacao, new ArrayList<>());
    }

    public void adicionarAresta(Estacao origem, Estacao destino, double distancia, double tempoMedio, String linha) {
        if (!grafo.containsKey(origem) || !grafo.containsKey(destino)) {
            throw new IllegalArgumentException("Estação não existe no grafo!");
        }
        grafo.get(origem).add(new Conexao(destino, distancia, tempoMedio, linha));
        grafo.get(destino).add(new Conexao(origem, distancia, tempoMedio, linha));
    }

    public void setEstacaoAtual(Estacao estacao) {
        this.estacaoAtual = estacao;
    }

    public Estacao getEstacaoAtual() {
        return estacaoAtual;
    }

    public List<Estacao> getVertices() {
        return new ArrayList<>(grafo.keySet());
    }

    public List<Conexao> getConexoes(Estacao estacao) {
        return grafo.getOrDefault(estacao, Collections.emptyList());
    }

    public ResultadoRota encontrarMelhorRota(Estacao destino, boolean porTempo) {
        if (estacaoAtual == null) {
            throw new IllegalStateException("Estação atual não definida!");
        }
        return encontrarMelhorRota(estacaoAtual, destino, porTempo);
    }

    private ResultadoRota encontrarMelhorRota(Estacao origem, Estacao destino, boolean porTempo) {
        Map<Estacao, Double> distancias = new HashMap<>();
        Map<Estacao, Estacao> predecessores = new HashMap<>();
        Map<Estacao, String> linhasUsadas = new HashMap<>();
        PriorityQueue<Estacao> fila = new PriorityQueue<>(
                Comparator.comparingDouble(e -> distancias.getOrDefault(e, Double.MAX_VALUE))
        );

        // Inicialização
        for (Estacao estacao : grafo.keySet()) {
            distancias.put(estacao, Double.MAX_VALUE);
        }
        distancias.put(origem, 0.0);
        linhasUsadas.put(origem, null);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Estacao atual = fila.poll();

            if (atual.equals(destino)) {
                break;
            }

            for (Conexao conexao : grafo.get(atual)) {
                Estacao vizinha = conexao.getDestino();
                double custo = porTempo ? conexao.getTempoMedio() : conexao.getDistancia();
                double novaDist = distancias.get(atual) + custo;

                if (novaDist < distancias.get(vizinha)) {
                    distancias.put(vizinha, novaDist);
                    predecessores.put(vizinha, atual);
                    linhasUsadas.put(vizinha, conexao.getLinha());
                    fila.remove(vizinha);
                    fila.add(vizinha);
                }
            }
        }

        // Reconstruir rota
        List<Estacao> caminho = new LinkedList<>();
        List<InstrucaoRota> instrucoes = new ArrayList<>();
        int baldeacoes = 0;
        String linhaAtual = null;

        Estacao atual = destino;
        while (atual != null) {
            caminho.add(0, atual);

            // Verificar baldeação
            String linhaUsada = linhasUsadas.get(atual);
            if (linhaAtual != null && !linhaAtual.equals(linhaUsada)) {
                baldeacoes++;
                instrucoes.add(0, new InstrucaoRota(
                        "BALDEAÇÃO: Mude para a " + linhaUsada + " em " + atual.getNome(),
                        atual, 0, 0
                ));
            }
            linhaAtual = linhaUsada;

            // Adicionar instrução de movimento
            if (predecessores.get(atual) != null) {
                Estacao anterior = predecessores.get(atual);
                Conexao conexao = encontrarConexao(anterior, atual);
                instrucoes.add(0, new InstrucaoRota(
                        "Siga pela " + conexao.getLinha() + " até " + atual.getNome(),
                        atual, conexao.getDistancia(), conexao.getTempoMedio()
                ));
            }

            atual = predecessores.get(atual);
        }

        double custoTotal = distancias.get(destino);
        return new ResultadoRota(caminho, instrucoes, custoTotal, baldeacoes, porTempo);
    }

    private Conexao encontrarConexao(Estacao origem, Estacao destino) {
        for (Conexao conexao : grafo.get(origem)) {
            if (conexao.getDestino().equals(destino)) {
                return conexao;
            }
        }
        return null;
    }
}