package model;

import java.util.ArrayList;
import java.util.List;

public class ResultadoRota {
    private List<Estacao> caminho;
    private List<InstrucaoRota> instrucoes;
    private double custoTotal;
    private int baldeacoes;
    private boolean porTempo;
    private double distanciaTotal;

    public ResultadoRota(List<Estacao> caminho, List<InstrucaoRota> instrucoes,
                         double custoTotal, int baldeacoes, boolean porTempo) {
        this.caminho = caminho;
        this.instrucoes = instrucoes;
        this.custoTotal = custoTotal;
        this.baldeacoes = baldeacoes;
        this.porTempo = porTempo;
        this.distanciaTotal = calcularDistanciaTotal();
    }

    private double calcularDistanciaTotal() {
        double total = 0;
        for (InstrucaoRota instrucao : instrucoes) {
            total += instrucao.getDistancia();
        }
        return total;
    }

    // Getters
    public List<Estacao> getCaminho() { return caminho; }
    public List<InstrucaoRota> getInstrucoes() { return instrucoes; }
    public double getCustoTotal() { return custoTotal; }
    public int getBaldeacoes() { return baldeacoes; }
    public boolean isPorTempo() { return porTempo; }
    public double getDistanciaTotal() { return distanciaTotal; }

    public String getResumo() {
        return String.format("Rota com %d estações (%d baldeações): %.1f %s",
                caminho.size(), baldeacoes,
                porTempo ? custoTotal : distanciaTotal/1000,
                porTempo ? "minutos" : "km");
    }

    public String getInformacoesAcessibilidade() {
        StringBuilder info = new StringBuilder();
        for (Estacao estacao : caminho) {
            if (estacao.isAcessivelCadeirante() || estacao.isElevador() ||
                    estacao.isBanheiroAcessivel() || estacao.isSinalizacaoBraille()) {

                info.append("\n ").append(estacao.getNome()).append(": ");
                List<String> recursos = new ArrayList<>();

                if (estacao.isAcessivelCadeirante()) recursos.add("Acesso para cadeirantes");
                if (estacao.isElevador()) recursos.add("Elevador");
                if (estacao.isBanheiroAcessivel()) recursos.add("Banheiro acessível");
                if (estacao.isSinalizacaoBraille()) recursos.add("Sinalização em Braille");

                info.append(String.join(", ", recursos));
            }
        }
        return info.toString();
    }
}
