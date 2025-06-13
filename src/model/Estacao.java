package model;

import java.util.Objects;

public class Estacao {
    private String nome;
    private String linha;
    private double latitude;
    private double longitude;
    private boolean acessivelCadeirante;
    private boolean elevador;
    private boolean banheiroAcessivel;
    private boolean sinalizacaoBraille;

    public Estacao(String nome, String linha, double latitude, double longitude) {
        this.nome = nome;
        this.linha = linha;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getLinha() { return linha; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public boolean isAcessivelCadeirante() { return acessivelCadeirante; }
    public void setAcessivelCadeirante(boolean acessivelCadeirante) { this.acessivelCadeirante = acessivelCadeirante; }
    public boolean isElevador() { return elevador; }
    public void setElevador(boolean elevador) { this.elevador = elevador; }
    public boolean isBanheiroAcessivel() { return banheiroAcessivel; }
    public void setBanheiroAcessivel(boolean banheiroAcessivel) { this.banheiroAcessivel = banheiroAcessivel; }
    public boolean isSinalizacaoBraille() { return sinalizacaoBraille; }
    public void setSinalizacaoBraille(boolean sinalizacaoBraille) { this.sinalizacaoBraille = sinalizacaoBraille; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estacao estacao = (Estacao) o;
        return Objects.equals(nome, estacao.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return nome + " (" + linha + ")";
    }
}