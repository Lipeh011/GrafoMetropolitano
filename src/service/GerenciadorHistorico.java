package service;

import model.HistoricoRota;
import model.ResultadoRota;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorHistorico {
    private static final int MAX_HISTORICO = 10;
    private List<HistoricoRota> historico = new ArrayList<>();

    public void adicionarRota(ResultadoRota resultado) {
        HistoricoRota registro = new HistoricoRota();
        registro.setOrigem(resultado.getCaminho().get(0));
        registro.setDestino(resultado.getCaminho().get(resultado.getCaminho().size()-1));
        registro.setDataHora(java.time.LocalDateTime.now());
        registro.setBaldeacoes(resultado.getBaldeacoes());
        registro.setTempoTotal(resultado.getCustoTotal());
        registro.setDistanciaTotal(resultado.getDistanciaTotal());

        historico.add(0, registro);

        if (historico.size() > MAX_HISTORICO) {
            historico.remove(historico.size()-1);
        }
    }

    public List<HistoricoRota> getHistorico() {
        return new ArrayList<>(historico);
    }
}