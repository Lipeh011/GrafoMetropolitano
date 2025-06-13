package service;

import model.Estacao;

public class APITransporte {
    private static final String BASE_URL = "http://api.olhovivo.sptrans.com.br/v2.1.";

    public static double obterTempoReal(Estacao origem, Estacao destino) {
        try {
            // Aqui retornamos um valor fixo para simplificar
            return 10.0; // 10 minutos
        } catch (Exception e) {
            System.err.println("Erro na API: " + e.getMessage());
            // Fallback: 30 km/h de velocidade média
            double distancia = CalculadoraDistancia.calcularDistancia(
                    origem.getLatitude(), origem.getLongitude(),
                    destino.getLatitude(), destino.getLongitude()
            );
            return (distancia / 1000) / 30 * 60;
        }
    }
}