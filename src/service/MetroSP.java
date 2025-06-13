package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class MetroSP {
    private GrafoMetro grafoMetro = new GrafoMetro();
    private GerenciadorHistorico historico = new GerenciadorHistorico();

    public MetroSP() {
        inicializarRedeMetro();
    }

    private void inicializarRedeMetro() {
        // Criar estações com coordenadas aproximadas
        Estacao paraiso = new Estacao("Paraíso", "Linha 1-Azul", -23.574, -46.640);
        Estacao vergueiro = new Estacao("Vergueiro", "Linha 1-Azul", -23.578, -46.635);
        Estacao saoJoaquim = new Estacao("São Joaquim", "Linha 1-Azul", -23.582, -46.632);
        Estacao japaoLiberdade = new Estacao("Japão-Liberdade", "Linha 1-Azul", -23.561, -46.635);
        Estacao saoBento = new Estacao("São Bento", "Linha 1-Azul", -23.545, -46.634);
        Estacao luz = new Estacao("Luz", "Linha 1-Azul", -23.535, -46.633);
        Estacao brigadeiro = new Estacao("Brigadeiro", "Linha 2-Verde", -23.569, -46.645);
        Estacao trianonMasp = new Estacao("Trianon-Masp", "Linha 2-Verde", -23.561, -46.655);
        Estacao consolacao = new Estacao("Consolação", "Linha 2-Verde", -23.555, -46.660);
        Estacao clinicas = new Estacao("Clínicas", "Linha 2-Verde", -23.550, -46.670);
        Estacao anaRosa = new Estacao("Ana Rosa", "Linha 2-Verde", -23.587, -46.632);
        Estacao vilaMariana = new Estacao("Vila Mariana", "Linha 1-Azul", -23.589, -46.638);

        // Adicionar estações
        grafoMetro.adicionarVertice(paraiso);
        grafoMetro.adicionarVertice(vergueiro);
        grafoMetro.adicionarVertice(saoJoaquim);
        grafoMetro.adicionarVertice(japaoLiberdade);
        grafoMetro.adicionarVertice(saoBento);
        grafoMetro.adicionarVertice(luz);
        grafoMetro.adicionarVertice(brigadeiro);
        grafoMetro.adicionarVertice(trianonMasp);
        grafoMetro.adicionarVertice(consolacao);
        grafoMetro.adicionarVertice(clinicas);
        grafoMetro.adicionarVertice(anaRosa);
        grafoMetro.adicionarVertice(vilaMariana);

        // Adicionar conexões com distâncias e tempos médios
        // Linha 1-Azul
        grafoMetro.adicionarAresta(paraiso, vergueiro, 850, 2, "Linha 1-Azul");
        grafoMetro.adicionarAresta(vergueiro, saoJoaquim, 950, 3, "Linha 1-Azul");
        grafoMetro.adicionarAresta(saoJoaquim, japaoLiberdade, 700, 2, "Linha 1-Azul");
        grafoMetro.adicionarAresta(japaoLiberdade, saoBento, 1100, 4, "Linha 1-Azul");
        grafoMetro.adicionarAresta(saoBento, luz, 800, 3, "Linha 1-Azul");
        grafoMetro.adicionarAresta(anaRosa, vilaMariana, 1200, 4, "Linha 1-Azul");
        grafoMetro.adicionarAresta(vilaMariana, paraiso, 1800, 6, "Linha 1-Azul");

        // Linha 2-Verde
        grafoMetro.adicionarAresta(paraiso, brigadeiro, 600, 2, "Linha 2-Verde");
        grafoMetro.adicionarAresta(brigadeiro, trianonMasp, 750, 3, "Linha 2-Verde");
        grafoMetro.adicionarAresta(trianonMasp, consolacao, 900, 3, "Linha 2-Verde");
        grafoMetro.adicionarAresta(consolacao, clinicas, 850, 3, "Linha 2-Verde");
        grafoMetro.adicionarAresta(anaRosa, paraiso, 2200, 7, "Linha 2-Verde");
    }

    public ResultadoRota encontrarMelhorRota(Estacao destino, boolean porTempo) {
        return grafoMetro.encontrarMelhorRota(destino, porTempo);
    }

    public void definirEstacaoAtual(Estacao estacao) {
        grafoMetro.setEstacaoAtual(estacao);
    }

    public Estacao getEstacaoPorNome(String nome) {
        for (Estacao estacao : grafoMetro.getVertices()) {
            if (estacao.getNome().equalsIgnoreCase(nome)) {
                return estacao;
            }
        }
        return null;
    }

    public List<Estacao> getTodasEstacoes() {
        return grafoMetro.getVertices();
    }
}