package model;

import java.time.LocalDateTime;

public class HistoricoRota {
    private Estacao origem;
    private Estacao destino;
    private LocalDateTime dataHora;
    private int baldeacoes;
    private double tempoTotal;
    private double distanciaTotal;

    // Getters e Setters
    public Estacao getOrigem() { return origem; }
    public void setOrigem(Estacao origem) { this.origem = origem; }
    public Estacao getDestino() { return destino; }
    public void setDestino(Estacao destino) { this.destino = destino; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public int getBaldeacoes() { return baldeacoes; }
    public void setBaldeacoes(int baldeacoes) { this.baldeacoes = baldeacoes; }
    public double getTempoTotal() { return tempoTotal; }
    public void setTempoTotal(double tempoTotal) { this.tempoTotal = tempoTotal; }
    public double getDistanciaTotal() { return distanciaTotal; }
    public void setDistanciaTotal(double distanciaTotal) { this.distanciaTotal = distanciaTotal; }
}