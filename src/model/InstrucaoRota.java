package model;

public class InstrucaoRota {
    private String instrucao;
    private Estacao estacao;
    private double distancia; // em metros
    private double tempo;     // em minutos

    public InstrucaoRota(String instrucao, Estacao estacao, double distancia, double tempo) {
        this.instrucao = instrucao;
        this.estacao = estacao;
        this.distancia = distancia;
        this.tempo = tempo;
    }

    // Getters
    public String getInstrucao() { return instrucao; }
    public Estacao getEstacao() { return estacao; }
    public double getDistancia() { return distancia; }
    public double getTempo() { return tempo; }

    @Override
    public String toString() {
        return instrucao + (distancia > 0 ?
                String.format(" (%.1f km, %.0f min)", distancia/1000, tempo) : "");
    }
}