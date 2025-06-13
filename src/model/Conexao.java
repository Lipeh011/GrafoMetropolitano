package model;

public class Conexao {
    private Estacao destino;
    private double distancia; // em metros
    private double tempoMedio; // em minutos
    private String linha;

    public Conexao(Estacao destino, double distancia, double tempoMedio, String linha) {
        this.destino = destino;
        this.distancia = distancia;
        this.tempoMedio = tempoMedio;
        this.linha = linha;
    }

    // Getters
    public Estacao getDestino() { return destino; }
    public double getDistancia() { return distancia; }
    public double getTempoMedio() { return tempoMedio; }
    public String getLinha() { return linha; }


}